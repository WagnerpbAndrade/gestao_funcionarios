package state;

import command.VisualizarFuncionarioCommand;
import presenter.IncluirFuncionarioPresenter;

/**
 *
 * @author wagner
 */
public class VisualizacaoFuncionarioState extends FuncionarioState {
    
    public VisualizacaoFuncionarioState(IncluirFuncionarioPresenter presenter) {
        super(presenter);
        this.command = new VisualizarFuncionarioCommand();
    }

    @Override
    public void visualizacao() throws Exception {
        this.command.executar(presenter);
    }
    
    
}
