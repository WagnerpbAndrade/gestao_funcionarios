package memento;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Funcionario implements Comparable<Funcionario> {

    private int id;
    private String nome;
    private String telefone;
    private double salarioBase;
    private double salarioComBonus;
    private String cargo;
    private String regiao;
    private int assiduidade;
    private int numeroDependentes;
    private DecimalFormat df;
    private ArrayList<String> bonus;

    public Funcionario(String pNome, String pTelefone, double salario, double salarioComBonus, String cargo, String regiao, String bonus, int assiduidade, int numeroDependentes) {
        this.df = new DecimalFormat("0.00");
        this.id = 0;
        this.bonus = new ArrayList<>();
        this.nome = pNome;
        this.telefone = pTelefone;
        this.salarioBase = salario;
        this.salarioComBonus = salarioComBonus;
        this.cargo = cargo;
        this.regiao = regiao;
        this.bonus.add(bonus);
        this.assiduidade = assiduidade;
        this.numeroDependentes = numeroDependentes;
    }

    public Funcionario(String pNome, String pTelefone, double salario, double salarioComBonus, String cargo, String regiao, ArrayList<String> bonus, int assiduidade, int numeroDependentes) {
        this.df = new DecimalFormat("0.00");
        this.bonus = new ArrayList<>();
        this.nome = pNome;
        this.telefone = pTelefone;
        this.salarioBase = salario;
        this.salarioComBonus = salarioComBonus;
        this.cargo = cargo;
        this.regiao = regiao;
        this.bonus = bonus;
        this.assiduidade = assiduidade;
        this.numeroDependentes = numeroDependentes;
    }
    
    public Funcionario(int id, String pNome, String pTelefone, double salario, double salarioComBonus, String cargo, String regiao, ArrayList<String> bonus, int assiduidade, int numeroDependentes) {
        this.df = new DecimalFormat("0.00");
        this.id = id;
        this.bonus = new ArrayList<>();
        this.nome = pNome;
        this.telefone = pTelefone;
        this.salarioBase = salario;
        this.salarioComBonus = salarioComBonus;
        this.cargo = cargo;
        this.regiao = regiao;
        this.bonus = bonus;
        this.assiduidade = assiduidade;
        this.numeroDependentes = numeroDependentes;
    }
    
    public FuncionarioMemento getMemento(){
        return new FuncionarioMemento(id, nome, telefone, salarioBase, salarioComBonus, cargo, regiao, assiduidade, numeroDependentes, bonus);
    }
    
    public void restaurar(FuncionarioMemento memento){
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
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public String getCargo() {
        return cargo;
    }

    public String getRegiao() {
        return regiao;
    }

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
