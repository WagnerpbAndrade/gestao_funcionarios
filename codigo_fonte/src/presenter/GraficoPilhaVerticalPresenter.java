package presenter;

import buildergrafico.Diretor;
import buildergrafico.GraficoPilhaVerticalBuilder;
import buildergrafico.GraficoBarraVerticalBuilder;
import collection.Funcionarios;
import view.GraficoView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import observer.Observador;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Wagner
 */
public class GraficoPilhaVerticalPresenter implements Observador {

    private GraficoView view;
    private JPanel panel;
    private Funcionarios funcionarios;

    public GraficoPilhaVerticalPresenter() {

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

        Diretor diretor = new Diretor(new GraficoPilhaVerticalBuilder());
        diretor.build();
        ChartPanel myChartPanel = diretor.getChartPanel();

        this.panel = this.view.getjPanelGrafico();

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
