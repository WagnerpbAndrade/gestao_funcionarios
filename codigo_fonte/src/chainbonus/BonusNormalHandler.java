package chainbonus;

import model.AbstractFuncionario;

/**
 *
 * @author wagner
 */
public class BonusNormalHandler implements ITratador{

    private AbstractFuncionario funcionario;
    
    public BonusNormalHandler(AbstractFuncionario funcionario) {
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
