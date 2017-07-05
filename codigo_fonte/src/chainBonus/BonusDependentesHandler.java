package chainBonus;

import memento.Funcionario;

/**
 *
 * @author wagner
 */
public class BonusDependentesHandler implements ITratador {

    private Funcionario funcionario;

    public BonusDependentesHandler(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean aceitar() {
        if (!this.funcionario.getBonus().contains("Dependentes") || this.funcionario.getBonus().contains("Dependentes")) {
            return true;
        }

        return false;
    }

    @Override
    public void tratar() {

        double salarioComBonus = funcionario.getSalarioComBonus();

        if (this.funcionario.getNumeroDependentes() > 0) {
            salarioComBonus += this.funcionario.getNumeroDependentes() * 96;

            this.funcionario.setSalarioComBonus(salarioComBonus);
            this.funcionario.getBonus().add("Dependentes");
        }
    }

}
