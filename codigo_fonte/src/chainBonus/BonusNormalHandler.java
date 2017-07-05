package chainBonus;

import memento.Funcionario;

/**
 *
 * @author wagner
 */
public class BonusNormalHandler implements ITratador{

    private Funcionario funcionario;
    
    public BonusNormalHandler(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    

    @Override
    public boolean aceitar() {
        if(this.funcionario.getBonus().contains("Normal"))
            return true;
        
        return false;
    }

    @Override
    public void tratar() {
        
        double salarioBase = funcionario.getSalarioBase();
        double salarioComBonus = funcionario.getSalarioComBonus();
        
        salarioComBonus += (salarioBase*0.05);
        this.funcionario.setSalarioComBonus(salarioComBonus);
    }
    
}
