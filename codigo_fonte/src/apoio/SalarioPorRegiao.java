package apoio;

import dao.IFabricaAbstrata;
import dao.IFuncionarioDAO;
import factoryMethodDinamico.FabricaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AbstractFuncionario;

/**
 *
 * @author wagner
 */
public class SalarioPorRegiao {

    private double salario;
    private static SalarioPorRegiao INSTANCE;
    private IFabricaAbstrata fabricaAbstrata;
    private IFuncionarioDAO dao;

    private SalarioPorRegiao() {

        try {

            this.fabricaAbstrata = FabricaDAO.getInstance().create();

        } catch (Exception ex) {
            Logger.getLogger(SalarioPorRegiao.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.dao = this.fabricaAbstrata.criaFabricaFuncionario();
    }

    public static SalarioPorRegiao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SalarioPorRegiao();
        }

        return INSTANCE;
    }

    public double getSalario(String regiao) throws Exception {
        
        this.salario = 0;

        for (AbstractFuncionario f : this.dao.getAll()) {
            if (f.getRegiao().equalsIgnoreCase(regiao)) {
                this.salario += f.getSalarioComBonus();
            }
        }

        return this.salario;
    }

}
