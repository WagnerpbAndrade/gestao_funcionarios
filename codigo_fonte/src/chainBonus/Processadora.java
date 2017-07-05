package chainBonus;

import java.util.ArrayList;

/**
 *
 * @author wagner
 */
public class Processadora {

    protected ArrayList<ITratador> tratadores;

    public Processadora() {
        this.tratadores = new ArrayList<>();
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
