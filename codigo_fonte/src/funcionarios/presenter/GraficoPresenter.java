package funcionarios.presenter;

import funcionarios.view.GraficoView;
import grafico.GerarGrafico;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Wagner
 */
public class GraficoPresenter {
    
    private GraficoView view;
    private GerarGrafico gerarGrafico;
    private JFreeChart grafico;
    private JPanel panel;

    public GraficoPresenter() {
        
        configuraTela();
        
    }
    
    private void configuraTela(){
        this.view = new GraficoView();
        
        this.panel = this.view.getjPanelGrafico();
        
        this.gerarGrafico = new GerarGrafico("Gráfico de Teste", "Valores", "Legenda", true, true, true);
        
        this.grafico = this.gerarGrafico.criarGrafico();
        
        ChartPanel myChartPanel = new ChartPanel(grafico, true);
        
        myChartPanel.setSize(this.panel.getWidth(), this.panel.getHeight());
        myChartPanel.setVisible(true);
        this.panel.removeAll();
        this.panel.add(myChartPanel);
        this.panel.revalidate();
        this.panel.repaint();
        
        this.view.getjButtonSair().addActionListener((e) -> {
            btnSair();
        });
        
        setDimension();
        this.view.setResizable(false);
        this.view.setVisible(true);
    }   
    
    private void setDimension() {
        Dimension d = PrincipalPresenter.getInstance().getView().getjDesktopPanePrincipalView().getSize();

        this.view.setLocation( (d.width - this.view.getSize().width) / 2, (d.height - this.view.getSize().height) / 2);
    }
    
    private void btnSair(){
        this.view.dispose();
    }

    public GraficoView getView() {
        return view;
    }    
    
}
