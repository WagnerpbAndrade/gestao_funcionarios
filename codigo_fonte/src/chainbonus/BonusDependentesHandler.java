package chainbonus;

import model.AbstractFuncionario;

/**
 *
 * @author wagner
 */
public class BonusDependentesHandler implements ITratador {

    private AbstractFuncionario funcionario;

    public BonusDependentesHandler(AbstractFuncionario funcionario) {
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
