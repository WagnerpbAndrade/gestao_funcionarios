package funcionarios.model;

import java.util.ArrayList;

public class Funcionario extends AbstractFuncionario implements Comparable<AbstractFuncionario> {

    

    public Funcionario(String pNome, String pTelefone, double salario, double salarioComBonus, String cargo, String regiao, String bonus, int assiduidade, int numeroDependentes) {
        super(pNome, pTelefone, salario, salarioComBonus, cargo, regiao, bonus, assiduidade, numeroDependentes);
    }

    public Funcionario(String pNome, String pTelefone, double salario, double salarioComBonus, String cargo, String regiao, ArrayList<String> bonus, int assiduidade, int numeroDependentes) {
        super(pNome, pTelefone, salario, salarioComBonus, cargo, regiao, bonus, assiduidade, numeroDependentes);
    }
    
    public Funcionario(int id, String pNome, String pTelefone, double salario, double salarioComBonus, String cargo, String regiao, ArrayList<String> bonus, int assiduidade, int numeroDependentes) {
        super(id, pNome, pTelefone, salario, salarioComBonus, cargo, regiao, bonus, assiduidade, numeroDependentes);
    }
    
    @Override
    public FuncionarioMemento getMemento(){
        return new FuncionarioMemento(id, nome, telefone, salarioBase, salarioComBonus, cargo, regiao, assiduidade, numeroDependentes, bonus);
    }
    
    public AbstractFuncionario restaurar(FuncionarioMemento memento){
        this.id = memento.getId();
        this.nome = memento.getNome();
        this.telefone = memento.getTelefone();
        this.salarioBase = memento.getSalarioBase();
        this.salarioComBonus = memento.getSalarioComBonus();
        this.cargo = memento.getCargo();
        this.regiao = memento.getRegiao();
        this.assiduidade = memento.getAssiduidade();
        this.numeroDependentes = memento.getNumeroDependentes();
        this.bonus = memento.getBonus();
        
        return this;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public String getCargo() {
        return cargo;
    }

    @Override
    public String getRegiao() {
        return regiao;
    }

    @Override
    public double getSalarioComBonus() {
        return salarioComBonus;
    }

    public void setSalarioComBonus(double salarioComBonus) {
        this.salarioComBonus = salarioComBonus;
    }

    public ArrayList<String> getBonus() {
        return bonus;
    }

    public int getAssiduidade() {
        return assiduidade;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    @Override
    public String toString() {
        return nome + "," + telefone + "," + salarioBase + "," + salarioComBonus + "," + cargo + "," + regiao + "," + assiduidade + "," + numeroDependentes + "," + bonus;
    }

    public int compareTo(Funcionario o) {
        return nome.compareTo(o.nome);
    }
}
