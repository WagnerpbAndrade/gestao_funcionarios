package memento;

import java.util.ArrayList;

/**
 *
 * @author Wagner Andrade
 */
public class FuncionarioMemento {
    private int id;
    private String nome;
    private String telefone;
    private double salarioBase;
    private double salarioComBonus;
    private String cargo;
    private String regiao;
    private int assiduidade;
    private int numeroDependentes;
    private ArrayList<String> bonus;

    FuncionarioMemento(int id, String nome, String telefone, double salarioBase, double salarioComBonus, String cargo, String regiao, int assiduidade, int numeroDependentes, ArrayList<String> bonus) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.salarioBase = salarioBase;
        this.salarioComBonus = salarioComBonus;
        this.cargo = cargo;
        this.regiao = regiao;
        this.assiduidade = assiduidade;
        this.numeroDependentes = numeroDependentes;
        this.bonus = bonus;
    }

    int getId() {
        return id;
    }

    String getNome() {
        return nome;
    }

    String getTelefone() {
        return telefone;
    }

    double getSalarioBase() {
        return salarioBase;
    }

    double getSalarioComBonus() {
        return salarioComBonus;
    }

    String getCargo() {
        return cargo;
    }

    String getRegiao() {
        return regiao;
    }

    int getAssiduidade() {
        return assiduidade;
    }

    int getNumeroDependentes() {
        return numeroDependentes;
    }

    ArrayList<String> getBonus() {
        return bonus;
    }
    
    
}
