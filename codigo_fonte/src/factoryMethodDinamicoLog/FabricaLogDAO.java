package factoryMethodDinamicoLog;

import configuracao.Configuracao;
import dao.ILogDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wagner
 */
public final class FabricaLogDAO {

    private static FabricaLogDAO INSTANCE;
    private Properties modeloDAO;
    private String nomeDAO;

    private FabricaLogDAO() {
        this.modeloDAO = new Properties();
        try {
            
            carregaDAO();
            
        } catch (IOException ex) {
            Logger.getLogger(FabricaLogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static FabricaLogDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FabricaLogDAO();
        }

        return INSTANCE;
    }

    private void carregaDAO() throws FileNotFoundException, IOException{
        this.modeloDAO.load(new FileInputStream("src/factoryMethodDinamicoLog/commands.properties"));
    }
   
    public ILogDAO create() throws Exception {
        ILogDAO dao = null;

        try {
            this.nomeDAO = this.modeloDAO.getProperty(Configuracao.getInstance().getValor("log"));
            Class classe = Class.forName(this.nomeDAO);
            Object object = classe.newInstance();
            dao = (ILogDAO) object;
        } catch (Exception e) {
            throw new Exception("Esse modelo de persistência não existe!");
        }

        return dao;
    }
}