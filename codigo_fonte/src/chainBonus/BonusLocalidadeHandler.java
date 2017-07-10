package chainBonus;

import funcionarios.model.Funcionario;

/**
 *
 * @author wagner
 */
public class BonusLocalidadeHandler implements ITratador {

    private Funcionario funcionario;

    public BonusLocalidadeHandler(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean aceitar() {
        if (!this.funcionario.getBonus().contains("Localidade") || this.funcionario.getBonus().contains("Localidade")) {
            return true;
        }

        return false;
    }

    @Override
    public void tratar() {
        double salarioBase = funcionario.getSalarioBase();
        double salarioComBonus = funcionario.getSalarioComBonus();

        if (this.funcionario.getRegiao().equals("Brasil")) {

            salarioComBonus += (salarioBase * 0.05);
            if (!this.funcionario.getBonus().contains("Localidade")) {
                this.funcionario.getBonus().add("Localidade");
            }

        } else if (this.funcionario.getRegiao().equals("Caribe")) {

            salarioComBonus += (salarioBase * 0.0);

        } else if (this.funcionario.getRegiao().equals("Síria")) {

            salarioComBonus += (salarioBase * 10);

            if (!this.funcionario.getBonus().contains("Localidade")) {
                this.funcionario.getBonus().add("Localidade");
            }
        }

        this.funcionario.setSalarioComBonus(salarioComBonus);
    }
}
