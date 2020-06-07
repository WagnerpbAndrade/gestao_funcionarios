package daoMySQL;

import dao.IFabricaAbstrata;
import dao.IFuncionarioDAO;

/**
 *
 * @author Wagner
 */
public class FabricaMySQL implements IFabricaAbstrata{

    @Override
    public IFuncionarioDAO criaFabricaFuncionario() {
        return new FuncionarioMySQLDAO();
    }
    
}
