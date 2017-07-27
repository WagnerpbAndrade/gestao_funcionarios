package buildergrafico;

import apoio.SalarioPorRegiao;
import dao.IFabricaAbstrata;
import dao.IFuncionarioDAO;
import factorymethoddinamico.FabricaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AbstractFuncionario;
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

    private IFabricaAbstrata fabrica;
    private IFuncionarioDAO dao;

    public GraficoBarraVerticalBuilder() {
        this.dataset = new DefaultCategoryDataset();
        this.salario = SalarioPorRegiao.getInstance();

        try {
            this.fabrica = FabricaDAO.getInstance().create();

        } catch (Exception ex) {
            Logger.getLogger(GraficoBarraHorizontalBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.dao = this.fabrica.criaFabricaFuncionario();
    }

    @Override
    public CategoryDataset createDataset() {

        try {

            for (AbstractFuncionario f : this.dao.getAll()) {
                dataset.addValue(this.salario.getSalario(f.getRegiao()), f.getRegiao(), "País");
            }

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
