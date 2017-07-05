package factoryMethodDinamico;

import dao.IPersistenciaDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.IFuncionarioDAO;

/**
 *
 * @author wagner
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
    
    private IPersistenciaDAO createDaoInterna(String nome) throws Exception{
        //Esse método é apenas para eu ter uma instância TxtDAO
        //E recuperar qual a persistência salva pelo usuário
        //No arquivo persistencia.txt
        IPersistenciaDAO dao = null;
        
        try {
            this.nomeDAO = this.modeloDAO.getProperty(nome);
            Class classe = Class.forName(this.nomeDAO);
            Object object = classe.newInstance();
            dao = (IPersistenciaDAO) object;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new Exception("Esse modelo de persistência não existe!");
        }
        
        return dao;
    }
    
    private String obterPersistenciaSalva() throws Exception{
        return createDaoInterna("PersistenciaTxtDAO").obterPersistenciaSalva();
    }
    
    public void atualizarPersistenciaSalva(String nome) throws Exception{
        IPersistenciaDAO dao = createDaoInterna("PersistenciaTxtDAO");
        dao.atualizarPersistenciaSalva(nome);
    }
    
    public IFuncionarioDAO create() throws Exception{
        IFuncionarioDAO dao = null;
        
        try {
            this.nomeDAO = this.modeloDAO.getProperty(obterPersistenciaSalva());
            Class classe = Class.forName(this.nomeDAO);
            Object object = classe.newInstance();
            dao = (IFuncionarioDAO) object;
        } catch (Exception e) {
            throw new Exception("Esse modelo de persistência não existe!");
        }
        
        return dao;
    }
    
    
}
