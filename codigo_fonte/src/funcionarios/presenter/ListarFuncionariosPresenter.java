package funcionarios.presenter;

import dao.IFabricaAbstrata;
import factoryMethodDinamico.FabricaDAO;
import funcionarios.presenter.apoio.ComparadorDeTelefoneFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import memento.Funcionario;
import funcionarios.collection.Funcionarios;
import funcionarios.view.ListarFuncionariosView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import observer.Observador;
import state.EdicaoFuncionarioState;
import state.VisualizacaoFuncionarioState;
import dao.IFuncionarioDAO;
import java.awt.Dimension;

/**
 *
 * @author clayton
 */
public final class ListarFuncionariosPresenter implements Observador {

    private DefaultTableModel tm;
    private Funcionarios funcionarios;
    private ListarFuncionariosView view;
    private IncluirFuncionarioPresenter presenter;
    private IFabricaAbstrata fabrica;
    private IFuncionarioDAO dao;

    public ListarFuncionariosPresenter() {

        try {
            configuraTela();

            configuraTabela();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "<html><body>"
                    + "<h3>"
                    + "<font face='Arial'>" + ex.getMessage() + "</font>"
                    + "</h3>"
                    + "</body></html>", "MENSAGEM", 1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "<html><body>"
                    + "<h3>"
                    + "<font face='Arial'>" + ex.getMessage() + "</font>"
                    + "</h3>"
                    + "</body></html>", "MENSAGEM", 1);
        }

    }

    private void configuraTela() throws FileNotFoundException, Exception {
        this.view = new ListarFuncionariosView();
        this.funcionarios = Funcionarios.getInstance();
        this.funcionarios.addObservador(this);
        
        this.fabrica = FabricaDAO.getInstance().create();
        this.dao = this.fabrica.criaFabricaFuncionario();

        this.view.getCbOrdenarTelefone().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    ordenaTelefone();

                } catch (Exception ex) {
                    Logger.getLogger(ListarFuncionariosPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        this.view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFechar();
            }
        });

        this.view.getjButtonEditar().addActionListener((e) -> {
            try {

                btnEditar();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "<html><body>"
                        + "<h3>"
                        + "<font face='Arial'>" + ex.getMessage() + "</font>"
                        + "</h3>"
                        + "</body></html>", "MENSAGEM", 1);
            }
        });

        this.view.getJtPessoas().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    try {
                        visualizarFuncionario();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "<html><body>"
                                + "<h3>"
                                + "<font face='Arial'>" + ex.getMessage() + "</font>"
                                + "</h3>"
                                + "</body></html>", "MENSAGEM", 1);
                    }
                }
            }

        });

        this.view.getjButtonRemover().addActionListener((e) -> {
            try {

                btnRemover();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "<html><body>"
                        + "<h3>"
                        + "<font face='Arial'>" + ex.getMessage() + "</font>"
                        + "</h3>"
                        + "</body></html>", "MENSAGEM", 1);
            }
        });

        setDimension();
        this.view.setResizable(false);
        this.view.setVisible(true);
    }

    private void setDimension() {
        Dimension d = PrincipalPresenter.getInstance().getView().getjDesktopPanePrincipalView().getSize();

        this.view.setLocation((d.width - this.view.getSize().width) / 2, (d.height - this.view.getSize().height) / 2);
    }

    private void ordenaTelefone() throws Exception {
        if (view.getCbOrdenarTelefone().isSelected()) {
            ArrayList<Funcionario> lista = new ArrayList<>(this.dao.getAll());
            Collections.sort(lista, new ComparadorDeTelefoneFuncionario());
            carregaFuncionarios(lista);
        } else {
            carregaFuncionarios(this.dao.getAll());
        }
    }

    private void visualizarFuncionario() throws Exception {

        JTable tabela = this.view.getJtPessoas();

        if (tabela.getSelectedRow() != -1) {
            int linhaSelecionada = tabela.getSelectedRow();
            String nomeFuncionario = (String) tabela.getValueAt(linhaSelecionada, 0);

            Funcionario f = this.funcionarios.getFuncionarioByNome(nomeFuncionario);
            this.funcionarios.setFuncionarioSelecionado(f);

            presenter = new IncluirFuncionarioPresenter();
            presenter.setState(new VisualizacaoFuncionarioState(presenter));
            presenter.visualizacao();

            btnFechar();

        }
    }

    private void btnEditar() throws Exception {
        JTable tabela = this.view.getJtPessoas();

        if (tabela.getSelectedRow() != -1) {

            int linhaSelecionada = tabela.getSelectedRow();
            String nomeFuncionario = (String) tabela.getValueAt(linhaSelecionada, 0);

            Funcionario f = this.funcionarios.getFuncionarioByNome(nomeFuncionario);

            this.funcionarios.setFuncionarioSelecionado(f);

            presenter = new IncluirFuncionarioPresenter();
            presenter.setState(new EdicaoFuncionarioState(presenter));
            presenter.edicao();

        } else {
            throw new Exception("Selecione um funcionário para editar!");
        }
    }

    private void btnRemover() throws Exception {
        JTable tabela = this.view.getJtPessoas();

        if (tabela.getSelectedRow() != -1) {

            String mensagem = "Deseja excluir esse funcionário?";
            if (JOptionPane.showConfirmDialog(this.view, "<html><body><h3><font face='Arial'>" + mensagem + "</font></h3></body></html>", "Selecionar a Opção", 0) == 0) {
                int linhaSelecionada = tabela.getSelectedRow();
                String nomeFuncionario = (String) tabela.getValueAt(linhaSelecionada, 0);

                Funcionario f = this.funcionarios.getFuncionarioByNome(nomeFuncionario);

                this.funcionarios.removerFuncionario(this.dao.getAll(), f);

            }

        } else {
            throw new Exception("Selecione um funcionário para remover!");
        }
    }

    private void btnFechar() {
        view.setVisible(false);
        view.dispose();
    }

    private void configuraTabela() throws Exception {

        try {

            Object colunas[] = {"Nome", "Telefone", "Cargo", "Salário Total", "Assiduidade", "Região", "Dependentes"};
            tm = new DefaultTableModel(colunas, 0) {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            };

            carregaFuncionarios(this.dao.getAll());

            view.getJtPessoas().setModel(tm);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    private void carregaFuncionarios(Collection<Funcionario> c) throws Exception {
        tm.setNumRows(0);
        if (c != null) {
            Iterator<Funcionario> it = c.iterator();
            while (it.hasNext()) {
                Funcionario f = it.next();
                tm.addRow(new Object[]{f.getNome(), f.getTelefone(), f.getCargo(), f.getSalarioComBonus(), f.getAssiduidade(), f.getRegiao(), f.getNumeroDependentes()});
            }
        } else {
            throw new Exception("Nenhum funcionário cadastrado!");
        }
    }

    public ListarFuncionariosView getView() {
        return view;
    }

    @Override
    public void update() {
        try {

            carregaFuncionarios(this.dao.getAll());

        } catch (Exception ex) {
            Logger.getLogger(ListarFuncionariosPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
