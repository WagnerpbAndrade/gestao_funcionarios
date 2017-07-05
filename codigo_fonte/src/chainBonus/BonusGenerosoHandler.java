package chainBonus;

import memento.Funcionario;

/**
 *
 * @author wagner
 */
public class BonusGenerosoHandler implements ITratador{

    private Funcionario funcionario;
    
    public BonusGenerosoHandler(Funcionario funcionario) {
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
