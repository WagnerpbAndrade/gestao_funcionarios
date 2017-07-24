package iterator;

import managementcollaborators.Collaborator;

/**
 *
 * @author Wagner
 */
public class IteratorArray implements IteratorIF{
    private int pos = 0;
    Collaborator[] vetor;

    public IteratorArray(Collaborator[] vetor) {
        this.vetor = vetor;
    }
    
    @Override
    public Object primeiro() {
        return vetor[pos];
    }

    @Override
    public Object proximo() {
        if(existeProximo()){
            Collaborator c = vetor[pos];
            pos++;
            
            return c;
        }
        
        return null;    
    }

    @Override
    public Boolean existeProximo() {
        return pos < this.vetor.length;
    }

    @Override
    public Object itemAtual() {
        return vetor[pos];
    }
    
}
