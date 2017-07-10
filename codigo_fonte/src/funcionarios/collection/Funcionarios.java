package funcionarios.collection;

import dao.IFabricaAbstrata;
import factoryMethodDinamico.FabricaDAO;
import java.util.Iterator;
import java.util.TreeSet;
import funcionarios.model.Funcionario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observado;
import observer.Observador;
import dao.IFuncionarioDAO;

public final class Funcionarios implements Observado {

    private TreeSet<Funcionario> funcionarios = null;
    private static Funcionarios INSTANCE = null;
    private ArrayList<Observador> observadores = null;
    private Funcionario funcionarioSelecionado;
    private IFabricaAbstrata fabrica;
    private IFuncionarioDAO dao;

    private Funcionarios() {
        try {

            this.fabrica = FabricaDAO.getInstance().create();
            this.dao = this.fabrica.criaFabricaFuncionario();

            this.funcionarios = this.dao.getAll();

        } catch (Exception ex) {
            Logger.getLogger(Funcionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.observadores = new ArrayList<>();

    }

    public static Funcionarios getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Funcionarios();
        }

        return INSTANCE;
    }

    public void add(Funcionario f) throws Exception {

        this.dao.inserir(f);

        notificar();

    }
    
    public void atualizarStatus(Funcionario f) throws Exception{
        this.dao.atualizarStatus(f);
        
        notificar();
    }

    public void editarFuncionario(Collection<Funcionario> c, Funcionario f) throws Exception {

        this.dao.editarFuncionario(c, f);

        notificar();

    }
    
    public void removerFuncionario(Collection<Funcionario> c, Funcionario f) throws Exception{
        this.dao.removerFuncionario(c, f);
        
        notificar();
    }

    public TreeSet<Funcionario> getTreeSet() throws Exception {
        return funcionarios;
    }

    public Iterator<Funcionario> iterator() {
        return this.funcionarios.iterator();
    }

    @Override
    public void addObservador(Observador o) {
        if (!this.observadores.contains(o)) {
            this.observadores.add(o);
        }
    }

    @Override
    public void removerObservador(Observador o) {
        this.observadores.remove(o);
    }

    @Override
    public void notificar() {
        for (Observador o : this.observadores) {

            o.update();

        }
    }

    public Funcionario getFuncionarioSelecionado() {
        return funcionarioSelecionado;
    }

    public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
        this.funcionarioSelecionado = funcionarioSelecionado;
    }

    public Funcionario getFuncionarioByNome(String nome) {
        try {

            for (Funcionario f : this.dao.getAll()) {
                if (f.getNome().equalsIgnoreCase(nome)) {
                    return f;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Funcionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
