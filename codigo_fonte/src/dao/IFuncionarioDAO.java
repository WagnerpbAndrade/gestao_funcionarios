package dao;

import funcionarios.model.Funcionario;
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
    
    public void removerFuncionario(Collection<Funcionario> c, Funcionario funcionario) throws Exception;
    
    default public void atualizarStatus(Funcionario f) throws Exception{}; 
    //Utilizei esse recurso do java 8, porque dessa forma não preciso obrigar
    //classes como txt implementar esse método e não para o funcionamento do 
    //sistema.
}
