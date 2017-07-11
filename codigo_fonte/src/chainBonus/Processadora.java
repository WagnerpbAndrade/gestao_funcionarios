package chainBonus;

import model.AbstractFuncionario;
import java.util.ArrayList;

/**
 *
 * @author wagner
 */
public class Processadora {

    protected ArrayList<ITratador> tratadores;

    public Processadora(AbstractFuncionario f) {
        this.tratadores = new ArrayList<>();
        this.tratadores.add(new BonusNormalHandler(f));
        this.tratadores.add(new BonusGenerosoHandler(f));
        this.tratadores.add(new BonusAssiduidadeHandler(f));
        this.tratadores.add( new BonusLocalidadeHandler(f));
        this.tratadores.add(new BonusDependentesHandler(f));
    }

    public void addTratador(ITratador t) {
        if (!this.tratadores.contains(t)) {
            this.tratadores.add(t);
        }
    }
    
    public void processar(){
        this.tratadores.forEach((t) -> {
            if(t.aceitar())
                t.tratar();
        });
    }
}
