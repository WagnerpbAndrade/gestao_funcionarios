package collection;

import model.AbstractFuncionario;
import dao.IFabricaAbstrata;
import factorymethoddinamico.FabricaDAO;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observado;
import observer.Observador;
import dao.IFuncionarioDAO;

public final class Funcionarios implements Observado {

    private TreeSet<AbstractFuncionario> funcionarios = null;
    private static Funcionarios INSTANCE = null;
    private ArrayList<Observador> observadores = null;
    private AbstractFuncionario funcionarioSelecionado;
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

    public void add(AbstractFuncionario f) throws Exception {

        this.dao.inserir(f);

        notificar();

    }
    
    public void atualizarStatus(AbstractFuncionario f) throws Exception{
        this.dao.atualizarStatus(f);
        
        notificar();
    }

    public void editarFuncionario(Collection<AbstractFuncionario> c, AbstractFuncionario f) throws Exception {

        this.dao.editarFuncionario(c, f);

        notificar();

    }
    
    public void removerFuncionario(Collection<AbstractFuncionario> c, AbstractFuncionario f) throws Exception{
        this.dao.removerFuncionario(c, f);
        
        notificar();
    }

    public TreeSet<AbstractFuncionario> getTreeSet() throws Exception {        
        return funcionarios;
    }

    public Iterator<AbstractFuncionario> iterator() {
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

    public AbstractFuncionario getFuncionarioSelecionado() {
        return funcionarioSelecionado;
    }

    public void setFuncionarioSelecionado(AbstractFuncionario funcionarioSelecionado) {
        this.funcionarioSelecionado = funcionarioSelecionado;
    }

    public AbstractFuncionario getFuncionarioByNome(String nome) {
        try {

            for (AbstractFuncionario f : this.dao.getAll()) {
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
