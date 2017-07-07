package command;

import funcionarios.presenter.IncluirFuncionarioPresenter;

/**
 *
 * @author wagner
 */
public interface IFuncionarioCommand {
    public void executar(IncluirFuncionarioPresenter presenter);
    
    public void desfazer(IncluirFuncionarioPresenter presenter) throws Exception;
    
}
