package daoMySQL;

import dao.IFabricaAbstrata;
import dao.IFuncionarioDAO;
import dao.ILogDAO;

/**
 *
 * @author Wagner
 */
public class FabricaMySQL implements IFabricaAbstrata{

    @Override
    public IFuncionarioDAO criaFabricaFuncionario() {
        return new FuncionarioMySQLDAO();
    }

    @Override
    public ILogDAO criaFabricaLog() {
        return new LogMySQL();
    }
    
}
