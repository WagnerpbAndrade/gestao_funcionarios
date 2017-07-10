package dao;

import funcionarios.model.AbstractFuncionario;
import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author wagner
 */
public interface IFuncionarioDAO {
    
    public void inserir(AbstractFuncionario f) throws Exception;
    
    public TreeSet<AbstractFuncionario> getAll() throws Exception;
    
    public void editarFuncionario(Collection<AbstractFuncionario> c, AbstractFuncionario funciocnario) throws Exception;
    
    public void removerFuncionario(Collection<AbstractFuncionario> c, AbstractFuncionario funcionario) throws Exception;
    
    default public void atualizarStatus(AbstractFuncionario f) throws Exception{}; 
    //Utilizei esse recurso do java 8, porque dessa forma não preciso obrigar
    //classes como txt implementar esse método e não para o funcionamento do 
    //sistema.
}
