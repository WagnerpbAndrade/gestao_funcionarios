package grafico;

import java.io.IOException;
import java.io.OutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author wagner
 */
public class GeradordeGrafico {

    private TimeSeries serie;
    private int comeco;
    private int fim;

    private DefaultCategoryDataset dados;
    private JFreeChart grafico;

    public GeradordeGrafico(TimeSeries serie, int comeco, int fim) {
        this.serie = serie;
        this.comeco = comeco;
        this.fim = fim;
        this.dados = new DefaultCategoryDataset();
        this.grafico = ChartFactory.createBarChart("Indicadores",
                "Dias", "Valores",
                dados,
                PlotOrientation.VERTICAL,
                true, true, false);
    }

//    public void plotaMediaMovelSimples() {
//        MediaMovelSimples ind = new MediaMovelSimples();
//        for (int i = comeco; i <= fim; i++) {
//            double valor = ind.calcula(i, serie);
//            dados.addValue(valor, ind.toString(), Integer.valueOf(i));
//        }
//    }

    public void salvar(OutputStream out) throws IOException {
        ChartUtilities.writeChartAsPNG(out, grafico, 500, 350);
    }
}

