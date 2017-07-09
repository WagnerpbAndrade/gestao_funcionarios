package funcionarios.presenter;

import configuracao.Configuracao;
import dao.IFabricaAbstrata;
import dao.ILogDAO;
import factoryMethodDinamico.FabricaDAO;
import factoryMethodDinamicoLog.FabricaLogDAO;
import funcionarios.collection.Funcionarios;
import funcionarios.collection.Logs;
import funcionarios.model.Log;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import funcionarios.view.PrincipalView;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import observer.Observador;
import dao.IFuncionarioDAO;
import java.awt.Frame;

/**
 *
 * @author wagner
 */
public class PrincipalPresenter implements Observador {

    private PrincipalView view;
    private Funcionarios funcionarios;
    private static PrincipalPresenter INSTANCE = null;
    private IFabricaAbstrata fabrica;
    private IFuncionarioDAO dao;
    private IFabricaAbstrata fabricaLog;
    private ILogDAO logDAO;
    private Configuracao configuracao;

    private PrincipalPresenter() {

        try {

            configuraTela();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static PrincipalPresenter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PrincipalPresenter();
        }

        return INSTANCE;
    }

    private void configuraTela() throws FileNotFoundException, Exception {
        this.view = new PrincipalView();
        
        this.configuracao = Configuracao.getInstance();

        this.fabrica = FabricaDAO.getInstance().create();
        this.dao = this.fabrica.criaFabricaFuncionario();

        this.funcionarios = Funcionarios.getInstance();
        this.funcionarios.addObservador(this);

        this.fabricaLog = FabricaLogDAO.getInstance().create();
        this.logDAO = fabricaLog.criaFabricaLog();

        this.view.getjMenuItemAdicionarFuncionario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    miAdicionarFuncionario();

                } catch (Exception ex) {
                    Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getjMenuItemListarFuncionario().addActionListener((e) -> {

            miListarFuncionario();

        });
        
        this.view.getjMenuItemGraficoBarras().addActionListener((e) -> {
            
            miGraficoBarras();
            
        });

        this.view.getjMenuItemSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    miSair();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "<html><body>"
                            + "<h3>"
                            + "<font face='Arial'>" + ex.getMessage() + "</font>"
                            + "</h3>"
                            + "</body></html>", "MENSAGEM", 1);
                }

            }
        });

        this.view.getjMenuItemPersistenciaTxt().addActionListener((e) -> {

            try {

                miPersistenciaTxt();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "<html><body>"
                        + "<h3>"
                        + "<font face='Arial'>" + ex.getMessage() + "</font>"
                        + "</h3>"
                        + "</body></html>", "MENSAGEM", 1);
            }

        });

        this.view.getjMenuItemPersistenciaMySQL().addActionListener((e) -> {
            try {

                miPersistenciaMySQL();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "<html><body>"
                        + "<h3>"
                        + "<font face='Arial'>" + ex.getMessage() + "</font>"
                        + "</h3>"
                        + "</body></html>", "MENSAGEM", 1);
            }
        });

        this.view.getjMenuItemLogMySQL().addActionListener((e) -> {
            try {

                miLogMySQL();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "<html><body>"
                        + "<h3>"
                        + "<font face='Arial'>" + ex.getMessage() + "</font>"
                        + "</h3>"
                        + "</body></html>", "MENSAGEM", 1);
            }
        });

        this.view.getjMenuItemLogTxt().addActionListener((e) -> {
            try {

                miLogTxt();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "<html><body>"
                        + "<h3>"
                        + "<font face='Arial'>" + ex.getMessage() + "</font>"
                        + "</h3>"
                        + "</body></html>", "MENSAGEM", 1);
            }
        });

        this.view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {

                    fecharTelaPrincipal();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "<html><body>"
                            + "<h3>"
                            + "<font face='Arial'>" + ex.getMessage() + "</font>"
                            + "</h3>"
                            + "</body></html>", "MENSAGEM", 1);
                }
            }

        });

        update();

        //setDimension();
        this.view.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.view.getjDesktopPanePrincipalView().setVisible(true);
        //this.view.setResizable(false);
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }
    
    private void miGraficoBarras(){
        this.view.getjDesktopPanePrincipalView().add(new GraficoPresenter().getView());
    }
    
    private void fecharTelaPrincipal() throws Exception {

        this.logDAO.salvarLog(Logs.getInstance().getLogs());

    }

    private void setDimension() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.view.setSize(d.width, d.height);

        this.view.getjDesktopPanePrincipalView().setSize(d);
    }

    private void miLogTxt() throws Exception {

        this.configuracao.setValor("log", "TxtDAO");

        //Gerar Log
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Logs.getInstance().addLog(new Log("Persistência Log: ", " Alterado para LogTxtDAO ", dateFormat.format(date)));

        throw new Exception("Log usando TXT atualizado com sucesso!");
    }

    private void miLogMySQL() throws Exception {

        this.configuracao.setValor("log", "MySQLDAO");

        //Gerar Log
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Logs.getInstance().addLog(new Log("Persistência Log: ", " Alterado para LogMySQL ", dateFormat.format(date)));

        throw new Exception("Log usando MySQL atualizado com sucesso!");
    }

    private void miPersistenciaTxt() throws Exception {

        this.configuracao.setValor("persistencia", "TxtDAO");

        //Gerar Log
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Logs.getInstance().addLog(new Log("Persistência de dados: ", " Alterado para TxtDAO ", dateFormat.format(date)));

        throw new Exception("Persistência de dados usando TXT atualizado com sucesso!");

    }

    private void miPersistenciaMySQL() throws Exception {
        
        this.configuracao.setValor("persistencia", "MySQLDAO");

        //Gerar Log
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Logs.getInstance().addLog(new Log("Persistência de dados: ", " Alterado para MySQLDAO ", dateFormat.format(date)));

        throw new Exception("Persistência de dados usando MySQL atualizado com sucesso!");

    }

    private void miAdicionarFuncionario() throws Exception {

        IncluirFuncionarioPresenter presenter = new IncluirFuncionarioPresenter();
        presenter.inclusao();

    }

    private void miListarFuncionario() {
        this.view.getjDesktopPanePrincipalView().add(new ListarFuncionariosPresenter().getView());
    }

    private void miSair() throws Exception {

        //Salvar Logs
        this.logDAO.salvarLog(Logs.getInstance().getLogs());

        this.view.setVisible(true);
        this.view.dispose();
    }

    public PrincipalView getView() {
        return view;
    }

    @Override
    public void update() {
        try {

            this.view.getjLabelTotalCadastrado().setText("Funcionários cadastrados: " + this.dao.getAll().size());

        } catch (Exception ex) {
            Logger.getLogger(PrincipalPresenter.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
