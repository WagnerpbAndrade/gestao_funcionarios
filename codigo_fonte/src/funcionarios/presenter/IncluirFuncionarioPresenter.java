package funcionarios.presenter;

import javax.swing.JOptionPane;
import funcionarios.view.IncluirFuncionarioView;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import state.EdicaoFuncionarioState;
import state.FuncionarioState;
import state.InclusaoFuncionarioState;
import state.VisualizacaoFuncionarioState;

public class IncluirFuncionarioPresenter {

    private IncluirFuncionarioView view;
    private FuncionarioState state;

    public IncluirFuncionarioPresenter() {
        
        try {
            
            configuraTela();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "<html><body>"
                    + "<h3>"
                    + "<font face='Arial'>" + ex.getMessage() + "</font>"
                    + "</h3>"
                    + "</body></html>", "MENSAGEM", 1);
//            Logger.getLogger(IncluirFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PrincipalPresenter.getInstance().getView().getjDesktopPanePrincipalView().add(view);
    }

    private void configuraTela() throws FileNotFoundException {
        
        this.view = new IncluirFuncionarioView();
        this.view.setResizable(true);
        this.view.setVisible(true);
        
    }
    
    private void setDimension(){
        Dimension d = PrincipalPresenter.getInstance().getView().getjDesktopPanePrincipalView().getSize();
        
        this.view.setSize(d);
    }
    
    public void inclusao() throws Exception{
        this.setState(new InclusaoFuncionarioState(this));
        this.state.inclusao();
    }
    
    public void edicao() throws Exception{
        this.setState(new EdicaoFuncionarioState(this));
        this.state.edicao();
    }
    
    public void visualizacao() throws Exception{
        this.setState(new VisualizacaoFuncionarioState(this));
        this.state.visualizacao();
    }
    
    public void setState(FuncionarioState state){
        this.state = state;
    }
    
    public IncluirFuncionarioView getView() {
        return view;
    }

}
