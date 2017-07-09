package factoryMethodDinamico;

import configuracao.Configuracao;
import dao.IFabricaAbstrata;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.IFuncionarioDAO;

/**
 *
 * @author Wagner
 */
public final class FabricaDAO {
    
    private static FabricaDAO INSTANCE;
    private Properties modeloDAO;
    private String nomeDAO;
    

    private FabricaDAO() {
        this.modeloDAO = new Properties();
        
        try {
            
            carregaDAO();
            
        } catch (IOException ex) {
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static FabricaDAO getInstance(){
        if(INSTANCE == null)
            INSTANCE = new FabricaDAO();
        
        return INSTANCE;
    }
    
    private void carregaDAO() throws FileNotFoundException, IOException{
        this.modeloDAO.load(new FileInputStream("src/factoryMethodDinamico/commands.properties"));
    }
    
    public IFabricaAbstrata create() throws Exception{
        IFabricaAbstrata fabrica = null;
        
        try {
            this.nomeDAO = this.modeloDAO.getProperty(Configuracao.getInstance().getValor("persistencia"));
            Class classe = Class.forName(this.nomeDAO);
            Object object = classe.newInstance();
            fabrica = (IFabricaAbstrata) object;
        } catch (Exception e) {
            throw new Exception("Esse modelo de persistência não existe!");
        }
        
        return fabrica;
    }
    
    
}
