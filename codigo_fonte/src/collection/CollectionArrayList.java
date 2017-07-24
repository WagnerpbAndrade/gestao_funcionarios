package collection;

import iterator.IteratorArrayList;
import iterator.IteratorIF;
import java.util.ArrayList;
import sistemaa.Cliente;
import sistemaa.SistemaA;

/**
 *
 * @author Wagner
 */
public class CollectionArrayList implements ICollection{
    
    ArrayList<Cliente> clientes = (ArrayList<Cliente>) SistemaA.getTodosClientes();
    

    @Override
    public IteratorIF criaIterator() {
        return new IteratorArrayList(clientes);
    }
    
}
