package factoryMethodDinamico;

import configuracao.Configuracao;
import dao.IFabricaAbstrata;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wagner
 */
public final class FabricaDAO {

    private static FabricaDAO INSTANCE;
    private IFabricaAbstrata classeDAO = null;

    private FabricaDAO() {

        try {

            carregaDAO();

        } catch (IOException ex) {
            Logger.getLogger(FabricaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static FabricaDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FabricaDAO();
        }

        return INSTANCE;
    }

    private void carregaDAO() throws FileNotFoundException, IOException {

    }

    public IFabricaAbstrata create() throws Exception {

        try {
            
            String persistencia = Configuracao.getInstance().getValor("persistencia");
            String caminhoDao = "dao" + persistencia + "." + "Fabrica" + persistencia;
            String caminhoJar = "Dao" + persistencia + ".jar";
            
            File jarFile = new File(caminhoJar).getAbsoluteFile();
            URL[] caminhosClasses = new URL[]{jarFile.toURI().toURL()};
            ClassLoader carregador = new URLClassLoader(caminhosClasses);
            Class classe = carregador.loadClass(caminhoDao);
            Constructor constructor = classe.getDeclaredConstructor();
            constructor.setAccessible(true);
            
            this.classeDAO = (IFabricaAbstrata) constructor.newInstance();            

        } catch (Exception e) {
            throw new Exception("Não foi possível carregar o módulo de acesso a dado: \n\n\t" + e.getMessage()
                        + "\n\n Atribua um classe válida à chave \"persistencia\", no arquivo configuracao.properties "
                        + "\n Padrão correto de escrita: MySQL ou Txt \n");
        }

        return classeDAO;
    }
}
