package factoryMethodDinamicoLog;

import configuracao.Configuracao;
import dao.IFabricaAbstrata;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import log.ILog;

/**
 *
 * @author wagner
 */
public final class FabricaLog {

    private static FabricaLog INSTANCE;
    private Properties modeloDAO;
    private String nomeDAO;

    private FabricaLog() {
        this.modeloDAO = new Properties();
        try {
            
            carregaDAO();
            
        } catch (IOException ex) {
            Logger.getLogger(FabricaLog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static FabricaLog getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FabricaLog();
        }

        return INSTANCE;
    }

    private void carregaDAO() throws FileNotFoundException, IOException{
        this.modeloDAO.load(new FileInputStream("src/factoryMethodDinamicoLog/commands.properties"));
    }
   
    public ILog create() throws Exception {
        ILog log = null;

        try {
            this.nomeDAO = this.modeloDAO.getProperty(Configuracao.getInstance().getValor("log"));
            Class classe = Class.forName(this.nomeDAO);
            Object object = classe.newInstance();
            log = (ILog) object;
        } catch (Exception e) {
            throw new Exception("Esse modelo de persistência não existe!");
        }

        return log;
    }
}