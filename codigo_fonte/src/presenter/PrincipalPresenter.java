package presenter;

import chainBonus.Processadora;
import collection.CollectionArray;
import collection.CollectionArrayList;
import dao.IFabricaAbstrata;
import factoryMethodDinamico.FabricaDAO;
import factoryMethodDinamicoLog.FabricaLog;
import collection.Funcionarios;
import collection.ICollection;
import collection.Logs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.PrincipalView;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import observer.Observador;
import dao.IFuncionarioDAO;
import iterator.IteratorIF;
import java.awt.Frame;
import log.ILog;
import managementcollaborators.Collaborator;
import model.Funcionario;
import sistemaa.Cliente;

/**
 *
 * @author Wagner
 */
public class PrincipalPresenter implements Observador {

    private PrincipalView view;
    private Funcionarios funcionarios;
    private static PrincipalPresenter INSTANCE = null;
    private IFabricaAbstrata fabrica;
    private IFuncionarioDAO dao;
    private IFabricaAbstrata fabricaLog;
    private ILog log;

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

        this.fabrica = FabricaDAO.getInstance().create();
        this.dao = this.fabrica.criaFabricaFuncionario();

        this.funcionarios = Funcionarios.getInstance();
        this.funcionarios.addObservador(this);

        this.log = FabricaLog.getInstance().create();

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

            miGraficoHorizontal();

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

        this.view.getjMenuItemSistemaA().addActionListener((e) -> {
            try {
                miSistemaA();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "<html><body>"
                        + "<h3>"
                        + "<font face='Arial'>" + ex.getMessage() + "</font>"
                        + "</h3>"
                        + "</body></html>", "MENSAGEM", 1);
            }
        });

        this.view.getjMenuItemSistemaB().addActionListener((e) -> {

            try {
                miSistemaB();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "<html><body>"
                        + "<h3>"
                        + "<font face='Arial'>" + ex.getMessage() + "</font>"
                        + "</h3>"
                        + "</body></html>", "MENSAGEM", 1);
            }

        });
        
        this.view.getjMenuItemGraficoVertical().addActionListener((e) -> {
            miGraficoVertical();
        });
        
        this.view.getjMenuItemGraficoPilha().addActionListener((e) -> {
            miGraficoLinha();
        });

        update();

        //setDimension();
        this.view.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.view.getjDesktopPanePrincipalView().setVisible(true);
        //this.view.setResizable(false);
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }
    
    private void miGraficoLinha(){
        this.view.getjDesktopPanePrincipalView().add(new GraficoPilhaVerticalPresenter().getView());
    }

    private void miSistemaB() throws Exception {

        ICollection collectionArray = new CollectionArray();
        IteratorIF it = collectionArray.criaIterator();

        while (it.existeProximo()) {
            Collaborator c = (Collaborator) it.proximo();

            Funcionario func = new Funcionario(c.getFirstName() + " " + c.getMiddleName() + " " + c.getLastName(),
                    c.getPhone(), 0, 0, "Programador", c.getCountry(), "Normal", 0, 0);

            Processadora p = new Processadora(func);
            p.processar();

            this.funcionarios.add(func);

        }

        throw new Exception("Importação efetuada com sucesso!");
    }

    private void miSistemaA() throws Exception {

        ICollection collectionArraylist = new CollectionArrayList();
        IteratorIF it = collectionArraylist.criaIterator();

        while (it.existeProximo()) {
            Cliente c = (Cliente) it.proximo();

            Funcionario func = new Funcionario(c.getNomeCompleto(), c.getTelefone(), c.getRendaBruta(), 0, "Programador", "?", "Normal", 0, 0);

            Processadora p = new Processadora(func);
            p.processar();

            this.funcionarios.add(func);

        }

        throw new Exception("Importação efetuada com sucesso!");

    }
    
    private void miGraficoVertical(){
        this.view.getjDesktopPanePrincipalView().add(new GraficoVerticalPresenter().getView());
    }

    private void miGraficoHorizontal() {
        this.view.getjDesktopPanePrincipalView().add(new GraficoHorizontalPresenter().getView());
    }

    private void fecharTelaPrincipal() throws Exception {

        this.log.salvarLog(Logs.getInstance().getLogs());

    }

    private void setDimension() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.view.setSize(d.width, d.height);

        this.view.getjDesktopPanePrincipalView().setSize(d);
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
        this.log.salvarLog(Logs.getInstance().getLogs());

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
