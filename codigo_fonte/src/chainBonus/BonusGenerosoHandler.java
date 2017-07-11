package chainBonus;

import model.AbstractFuncionario;

/**
 *
 * @author wagner
 */
public class BonusGenerosoHandler implements ITratador{

    private AbstractFuncionario funcionario;
    
    public BonusGenerosoHandler(AbstractFuncionario funcionario) {
        this.funcionario = funcionario;
    }   
    
    @Override
    public boolean aceitar() {
        if(this.funcionario.getBonus().contains("Generoso"))
            return true;
        
        return false;
    }

    @Override
    public void tratar() {
        double salarioBase = funcionario.getSalarioBase();
        double salarioComBonus = funcionario.getSalarioComBonus();
        
        salarioComBonus += (salarioBase*0.1);
        this.funcionario.setSalarioComBonus(salarioComBonus);
    }
    
}
