package funcionarios.presenter;

import funcionarios.view.GraficoView;
import grafico.GerarGrafico;
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
        
        myChartPanel.setSize(this.view.getjPanelGrafico().getWidth(), this.view.getjPanelGrafico().getHeight());
        myChartPanel.setVisible(true);
        this.panel.removeAll();
        this.panel.add(myChartPanel);
        this.panel.revalidate();
        this.panel.repaint();
        
        this.view.getjButtonSair().addActionListener((e) -> {
            btnSair();
        });
        
        this.view.setResizable(false);
        this.view.setLocation(0, 0);
        this.view.setVisible(true);
    }   
    
    private void btnSair(){
        this.view.dispose();
    }

    public GraficoView getView() {
        return view;
    }    
    
}
