package chainBonus;

import memento.Funcionario;

/**
 *
 * @author wagner
 */
public class BonusAssiduidadeHandler implements ITratador {

    private Funcionario funcionario;

    public BonusAssiduidadeHandler(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean aceitar() {
        if (!this.funcionario.getBonus().contains("Assiduidade") || this.funcionario.getBonus().contains("Assiduidade")) {
            return true;
        }

        return false;
    }

    @Override
    public void tratar() {

        double salarioBase = funcionario.getSalarioBase();
        double salarioComBonus = funcionario.getSalarioComBonus();

        if (this.funcionario.getAssiduidade() <= 0) {

            salarioComBonus += (salarioBase * 0.05);

            if (!this.funcionario.getBonus().contains("Assiduidade")) {
                this.funcionario.getBonus().add("Assiduidade");
            }

        } else if (this.funcionario.getAssiduidade() <= 5) {

            salarioComBonus += (salarioBase * 0.02);

            if (!this.funcionario.getBonus().contains("Assiduidade")) {
                this.funcionario.getBonus().add("Assiduidade");
            }

        }

        this.funcionario.setSalarioComBonus(salarioComBonus);

    }

}
