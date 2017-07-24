package buildergrafico;

import apoio.SalarioPorRegiao;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author wagner
 */
public class GraficoBarraVerticalBuilder extends GraficoBuilder {

    private DefaultCategoryDataset dataset;
    private SalarioPorRegiao salario;

    public GraficoBarraVerticalBuilder() {
        this.dataset = new DefaultCategoryDataset();
        this.salario = SalarioPorRegiao.getInstance();
    }

    @Override
    public CategoryDataset createDataset() {

        try {

            dataset.addValue(this.salario.getSalario("Brasil"), "Brasil", "País");
            dataset.addValue(this.salario.getSalario("Caribe"), "Caribe", "País");
            dataset.addValue(this.salario.getSalario("Síria"), "Síria", "País");

        } catch (Exception ex) {
            Logger.getLogger(GraficoBarraHorizontalBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this.dataset;
    }

    @Override
    public void setGrafico() {
        this.grafico = ChartFactory.createBarChart3D(this.titulo, "", "", createDataset(), PlotOrientation.VERTICAL, this.legenda, this.tooltips, this.urls);
    }

    @Override
    public void criaChartPanel() {
        this.chartPanel = new ChartPanel(this.grafico, true);
    }

}
