package buildergrafico;

import org.jfree.chart.ChartPanel;

/**
 *
 * @author wagner
 */
public class Diretor {
    private GraficoBuilder builder;

    public Diretor(GraficoBuilder builder) {
        this.builder = builder;
    }
    
    public void build(){
        this.builder.setGrafico();
        this.builder.criaChartPanel();
    }
    
    public ChartPanel getChartPanel(){
        return this.builder.getChartPanel();
    }
    
}
