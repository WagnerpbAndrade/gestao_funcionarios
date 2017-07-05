package observer;

/**
 *
 * @author wagner
 */
public interface Observado{ 
    public void addObservador(Observador o);
    public void removerObservador(Observador o);
    public void notificar();
}
