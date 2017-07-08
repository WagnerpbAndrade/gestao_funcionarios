package grafico;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author wagner
 */
public class GerarGrafico {
    private String titulo;
    private String eixoy;
    private String txt_legenda;
    private boolean legenda;
    private boolean tooltips;
    private boolean urls;
    private JFreeChart grafico;

    public GerarGrafico(String titulo, String eixoy, String txt_legenda, boolean legenda, boolean tooltips, boolean urls) {
        this.titulo = titulo;
        this.eixoy = eixoy;
        this.txt_legenda = txt_legenda;
        this.legenda = legenda;
        this.tooltips = tooltips;
        this.urls = urls;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEixoy() {
        return eixoy;
    }

    public String getTxt_legenda() {
        return txt_legenda;
    }

    public boolean isLegenda() {
        return legenda;
    }

    public boolean isTooltips() {
        return tooltips;
    }

    public boolean isUrls() {
        return urls;
    }
    
    public JFreeChart criarGrafico(){
         return ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, createDataset(), PlotOrientation.VERTICAL, legenda, tooltips, urls);
    }
    
    private CategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1000.0, "01/2012", "Mês/Ano");
        dataset.addValue(1690.0, "02/2012", "Mês/Ano");
        dataset.addValue(90.0, "03/2012", "Mês/Ano");
        
        return dataset;
    }

    
}
