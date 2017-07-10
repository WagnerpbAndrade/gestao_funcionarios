package daoMySQL;

import log.LogMySQL;
import dao.IFabricaAbstrata;
import dao.IFuncionarioDAO;
import log.ILog;

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
    public ILog criaFabricaLog() {
        return new LogMySQL();
    }
    
}
