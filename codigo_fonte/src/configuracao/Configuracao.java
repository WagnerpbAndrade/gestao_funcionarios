package configuracao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wagner
 */
public class Configuracao {

    private static Configuracao INSTANCE;
    private Properties propertiesConfig;
    private File file = new File("src/configuracao/configuracao.properties");

    private Configuracao() {
        this.propertiesConfig = new Properties();

        try {

            carregaConfiguracao();
        } catch (FileNotFoundException ex) {

            Logger.getLogger(Configuracao.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(Configuracao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Configuracao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Configuracao();
        }

        return INSTANCE;
    }

    private void carregaConfiguracao() throws FileNotFoundException, IOException {
        this.propertiesConfig.load(new FileInputStream(file));
    }

    public String getValor(String chave) {
        return (String) this.propertiesConfig.getProperty(chave);
    }

    public void setValor(String chave, String valor) {
        FileOutputStream outputStream = null;

        this.propertiesConfig.setProperty(chave, valor);

        try {

            outputStream = new FileOutputStream(file);
            this.propertiesConfig.store(outputStream, "Modificação no Properties!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuracao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                outputStream.close();

            } catch (IOException ex) {
                Logger.getLogger(Configuracao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void verificarConfiguracao() throws Exception {
        String persistencia = getValor("persistencia");
        if (!persistencia.equals("")) {
            
        }
    }

}
