package grafico;

import funcionarios.model.AbstractFuncionario;
import dao.IFabricaAbstrata;
import dao.IFuncionarioDAO;
import factoryMethodDinamico.FabricaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private IFabricaAbstrata fabrica;
    private IFuncionarioDAO dao;
    private double salarioB, salarioC, salarioS;
    

    public GerarGrafico(String titulo, String eixoy, String txt_legenda, boolean legenda, boolean tooltips, boolean urls) {
        this.titulo = titulo;
        this.eixoy = eixoy;
        this.txt_legenda = txt_legenda;
        this.legenda = legenda;
        this.tooltips = tooltips;
        this.urls = urls;
        
        try {
            
            this.fabrica = FabricaDAO.getInstance().create();
            this.dao = this.fabrica.criaFabricaFuncionario();
            
        } catch (Exception ex) {
            Logger.getLogger(GerarGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        
        try {
            for(AbstractFuncionario f: this.dao.getAll()){
                if(f.getRegiao().equals("Brasil"))
                    salarioB += f.getSalarioComBonus();
                else if (f.getRegiao().equals("Caribe"))
                    salarioC += f.getSalarioComBonus();
                else
                    salarioS =+ f.getSalarioComBonus();
            }
                
        } catch (Exception ex) {
            Logger.getLogger(GerarGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataset.addValue(salarioB, "Brasil", "País");
        dataset.addValue(salarioC, "Caribe", "País");
        dataset.addValue(salarioS, "Síria", "País");
        
        return dataset;
    }

    
}
