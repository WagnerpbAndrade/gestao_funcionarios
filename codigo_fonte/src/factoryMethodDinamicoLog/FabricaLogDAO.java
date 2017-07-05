/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoryMethodDinamicoLog;

import dao.ILogDAO;
import dao.IPersistenciaDAO;
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
    
    private IPersistenciaDAO createDaoInterna(String nome) throws Exception{
        //Esse método é apenas para eu ter uma instância TxtDAO
        //E recuperar qual a persistência salva pelo usuário
        //No arquivo persistenciaLog.txt
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
    
    private String obterLogSalvo() throws Exception{
        return createDaoInterna("PersistenciaTxtDAO").obterLogSalvo();
    }
    
    public void atualizarLogSalvo(String nome) throws Exception{
        IPersistenciaDAO dao = createDaoInterna("PersistenciaTxtDAO");
        dao.atualizarLogSalvo(nome);
    }
   
    public ILogDAO create() throws Exception {
        ILogDAO dao = null;

        try {
            this.nomeDAO = this.modeloDAO.getProperty(obterLogSalvo());
            Class classe = Class.forName(this.nomeDAO);
            Object object = classe.newInstance();
            dao = (ILogDAO) object;
        } catch (Exception e) {
            throw new Exception("Esse modelo de persistência não existe!");
        }

        return dao;
    }
}