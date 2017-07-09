package daoTxt;

import dao.IFabricaAbstrata;
import dao.IFuncionarioDAO;
import dao.ILogDAO;

/**
 *
 * @author Wagner
 */
public class FabricaTxt implements IFabricaAbstrata{

    @Override
    public IFuncionarioDAO criaFabricaFuncionario() {
        return new FuncionarioTxtDAO();
    }

    @Override
    public ILogDAO criaFabricaLog() {
        return new LogTxtDAO();
    }
    
}
