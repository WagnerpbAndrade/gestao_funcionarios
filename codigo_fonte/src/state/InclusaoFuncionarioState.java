package state;

import command.IncluirFuncionarioCommand;
import presenter.IncluirFuncionarioPresenter;

/**
 *
 * @author wagner
 */
public class InclusaoFuncionarioState extends FuncionarioState {

    public InclusaoFuncionarioState(IncluirFuncionarioPresenter presenter) {
        super(presenter);
        this.command = new IncluirFuncionarioCommand();
    }

    @Override
    public void inclusao() throws Exception {
        this.command.executar(presenter);
    }
    
}
