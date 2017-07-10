package daoTxt;

import log.LogTxt;
import dao.IFabricaAbstrata;
import dao.IFuncionarioDAO;
import log.ILog;

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
    public ILog criaFabricaLog() {
        return new LogTxt();
    }
    
}
