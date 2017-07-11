package command;

import presenter.IncluirFuncionarioPresenter;

/**
 *
 * @author wagner
 */
public interface IFuncionarioCommand {
    public void executar(IncluirFuncionarioPresenter presenter);
    
    default public void desfazer(IncluirFuncionarioPresenter presenter) throws Exception{};
    
}
