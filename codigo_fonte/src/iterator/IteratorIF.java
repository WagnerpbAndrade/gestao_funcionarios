package iterator;

/**
 *
 * @author Wagner
 */
public interface IteratorIF {
    
    public Object primeiro();
    public Object proximo();
    public Boolean existeProximo();
    public Object itemAtual();
}
