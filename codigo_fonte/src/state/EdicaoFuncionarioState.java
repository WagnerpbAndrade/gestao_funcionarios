package state;

import command.EditarFuncionarioCommand;
import presenter.IncluirFuncionarioPresenter;

/**
 *
 * @author wagner
 */
public class EdicaoFuncionarioState extends FuncionarioState{
    
    public EdicaoFuncionarioState(IncluirFuncionarioPresenter presenter) {
        super(presenter);
        this.command = new EditarFuncionarioCommand();
    }

    @Override
    public void edicao() throws Exception {
        this.command.executar(presenter);
    }

    @Override
    public void desfazer() throws Exception {
        this.command.desfazer(presenter);
    }
    
    
}
