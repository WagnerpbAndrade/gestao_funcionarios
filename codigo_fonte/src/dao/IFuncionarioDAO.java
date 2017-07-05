package dao;

import memento.Funcionario;
import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author wagner
 */
public interface IFuncionarioDAO {
    
    public void inserir(Funcionario f) throws Exception;
    
    public TreeSet<Funcionario> getAll() throws Exception;
    
    public void editarFuncionario(Collection<Funcionario> c, Funcionario funcionario) throws Exception;
    
    //public void removerFuncionario(Collection<Funcionario> c, Funcionario funcionario) throws Exception;
    
}
