package presenter;

import collection.Funcionarios;
import view.GraficoView;
import grafico.GerarGrafico;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import observer.Observador;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Wagner
 */
public class GraficoPresenter  implements Observador{

    private GraficoView view;
    private GerarGrafico gerarGrafico;
    private JFreeChart grafico;
    private JPanel panel;
    private Funcionarios funcionarios;

    public GraficoPresenter() {

        configuraTela();

    }

    private void configuraTela() {
        this.view = new GraficoView();
        this.funcionarios = Funcionarios.getInstance();
        this.funcionarios.addObservador(this);

        criarGrafico();

        this.view.getjButtonSair().addActionListener((e) -> {
            btnSair();
        });

        setDimension();
        this.view.setResizable(false);
        this.view.setVisible(true);
    }

    private void setDimension() {
        Dimension d = PrincipalPresenter.getInstance().getView().getjDesktopPanePrincipalView().getSize();

        this.view.setLocation((d.width - this.view.getSize().width) / 2, (d.height - this.view.getSize().height) / 2);
    }

    private void btnSair() {
        this.view.dispose();
    }

    public GraficoView getView() {
        return view;
    }

    private void criarGrafico() {

        this.panel = this.view.getjPanelGrafico();

        this.gerarGrafico = new GerarGrafico("Renda Total Por Região", "Renda (R$)", "Legenda", true, true, true);

        ChartPanel myChartPanel = new ChartPanel(this.gerarGrafico.criarGrafico());
        myChartPanel.setDomainZoomable(true);

        myChartPanel.setSize(this.panel.getPreferredSize());
        myChartPanel.setVisible(true);
        this.panel.removeAll();
        this.panel.add(myChartPanel, BorderLayout.CENTER);
        this.panel.revalidate();
        this.panel.repaint();
        this.panel.setVisible(true);

    }

    @Override
    public void update() {
        criarGrafico();
    }
}
