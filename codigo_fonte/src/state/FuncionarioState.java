package state;

import command.IFuncionarioCommand;
import funcionarios.presenter.IncluirFuncionarioPresenter;

/**
 *
 * @author wagner
 */
public abstract class FuncionarioState {
    protected IncluirFuncionarioPresenter presenter;
    protected IFuncionarioCommand command;

    public FuncionarioState(IncluirFuncionarioPresenter presenter) {
        this.presenter = presenter;
    }
    
    public void inclusao() throws Exception {
        throw new Exception("Estado indisponível");
    }

    public void edicao() throws Exception {
        throw new Exception("Estado indisponível");
    }
    
    public void visualizacao() throws Exception {
        throw new Exception("Estado indisponível");
    }
    
    public void desfazer() throws Exception{
        throw new Exception("Estado indisponível");
    }
}
