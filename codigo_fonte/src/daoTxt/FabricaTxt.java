package daoTxt;

import dao.IFabricaAbstrata;
import dao.IFuncionarioDAO;

/**
 *
 * @author Wagner
 */
public class FabricaTxt implements IFabricaAbstrata{

    @Override
    public IFuncionarioDAO criaFabricaFuncionario() {
        return new FuncionarioTxtDAO();
    }
    
}
