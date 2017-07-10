package dao;

import funcionarios.model.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class AbstractFuncionario implements Comparable<AbstractFuncionario> {

    public int id;
    public String nome;
    public String telefone;
    public double salarioBase;
    public double salarioComBonus;
    public String cargo;
    public String regiao;
    public int assiduidade;
    public int numeroDependentes;
    public DecimalFormat df;
    public ArrayList<String> bonus;

    public AbstractFuncionario(String pNome, String pTelefone, double salario, double salarioComBonus, String cargo, String regiao, String bonus, int assiduidade, int numeroDependentes) {
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

    public AbstractFuncionario(String pNome, String pTelefone, double salario, double salarioComBonus, String cargo, String regiao, ArrayList<String> bonus, int assiduidade, int numeroDependentes) {
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
    
    public AbstractFuncionario(int id, String pNome, String pTelefone, double salario, double salarioComBonus, String cargo, String regiao, ArrayList<String> bonus, int assiduidade, int numeroDependentes) {
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

    public int compareTo(AbstractFuncionario o) {
        return nome.compareTo(o.nome);
    }
}
