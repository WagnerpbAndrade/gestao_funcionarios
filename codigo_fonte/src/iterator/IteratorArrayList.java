package iterator;

import java.util.ArrayList;
import sistemaa.Cliente;

/**
 *
 * @author Wagner
 */
public class IteratorArrayList implements IteratorIF{
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private int pos = 0;

    public IteratorArrayList(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public Object primeiro() {
        
        return this.clientes.get(pos);
        
    }

    @Override
    public Object proximo() {
        if(existeProximo()){
            Cliente c = this.clientes.get(pos);
            pos++;
            
            return c;
        }
        
        return null;
    }

    @Override
    public Boolean existeProximo() {
       return pos < this.clientes.size();
    }

    @Override
    public Object itemAtual() {
        return this.clientes.get(pos);
    }
    
    
}
