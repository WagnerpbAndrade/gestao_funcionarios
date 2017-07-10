package dao;

import log.ILog;

/**
 *
 * @author Wagner
 */
public interface IFabricaAbstrata {
    public IFuncionarioDAO criaFabricaFuncionario();
    public ILog criaFabricaLog();
}
