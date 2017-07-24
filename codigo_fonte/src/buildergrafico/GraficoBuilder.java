package buildergrafico;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

/**
 *
 * @author wagner
 */
public abstract class GraficoBuilder {
    
    protected ChartPanel chartPanel;
    protected String titulo = "Renda Total Por Região";
    protected String eixoy = "Renda (R$)";
    protected String txt_legenda = "Legenda";
    protected boolean legenda = true;
    protected boolean urls = true;
    protected boolean tooltips = true;
    protected JFreeChart grafico;
    
    public abstract CategoryDataset createDataset();
    
    public abstract void setGrafico();
    
    public abstract void criaChartPanel();

    public ChartPanel getChartPanel() {
        return chartPanel;
    }
}
