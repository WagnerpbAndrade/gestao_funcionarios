package command;

import funcionarios.collection.Funcionarios;
import funcionarios.collection.Logs;
import funcionarios.model.AbstractFuncionario;
import funcionarios.model.Log;
import funcionarios.presenter.BonusPresenter;
import funcionarios.presenter.IncluirFuncionarioPresenter;
import funcionarios.view.IncluirFuncionarioView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import state.EdicaoFuncionarioState;

/**
 *
 * @author wagner
 */
public class VisualizarFuncionarioCommand implements IFuncionarioCommand {

    private IncluirFuncionarioView view;
    private Funcionarios funcionarios;
    private AbstractFuncionario funcionario;

    public VisualizarFuncionarioCommand() {

        this.funcionarios = Funcionarios.getInstance();

    }

    @Override
    public void executar(IncluirFuncionarioPresenter presenter) {
        this.view = presenter.getView();
        this.view.getjButtonDesfazer().setVisible(false);
        this.funcionario = this.funcionarios.getFuncionarioSelecionado();

        //Gerar Log
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Logs.getInstance().addLog(new Log("Visualização: ", funcionario.getNome()+ " foi visualizado! ", dateFormat.format(date)));

        //Desabilitando os campos da view
        this.view.getTxtNome().setEnabled(false);
        this.view.getTxtTelefone().setEnabled(false);
        this.view.getjTextFieldAssiduidade().setEnabled(false);
        this.view.getjTextFieldSalario().setEnabled(false);
        this.view.getjTextFieldSalarioComBonus().setEnabled(false);
        this.view.getjTextFieldDependentes().setEnabled(false);
        this.view.getjComboBoxBonus().setEnabled(false);
        this.view.getjComboBoxCargo().setEnabled(false);
        this.view.getjComboBoxRegiao().setEnabled(false);

        //Configurando os títulos
        this.view.getjLabelTitulo().setText("Visualizar Funcionário");
        this.view.setTitle("Visualizar Funcionário");
        this.view.getBtnSalvar().setText("Editar");

        //Settando os dados do funcionário
        this.view.getTxtNome().setText(funcionario.getNome());
        this.view.getTxtTelefone().setText(funcionario.getTelefone());
        this.view.getjTextFieldAssiduidade().setText(String.valueOf(funcionario.getAssiduidade()));
        this.view.getjTextFieldSalario().setText(String.valueOf(funcionario.getSalarioBase()));
        this.view.getjTextFieldSalarioComBonus().setText(String.valueOf(funcionario.getSalarioComBonus()));
        this.view.getjTextFieldDependentes().setText(String.valueOf(funcionario.getNumeroDependentes()));
        this.view.getjComboBoxBonus().getModel().setSelectedItem(funcionario.getBonus().get(0));
        this.view.getjComboBoxCargo().getModel().setSelectedItem(funcionario.getCargo());
        this.view.getjComboBoxRegiao().getModel().setSelectedItem(funcionario.getRegiao());

        this.view.getBtnSalvar().addActionListener((e) -> {
            try {
                btnSalvar(presenter);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "<html><body>"
                        + "<h3>"
                        + "<font face='Arial'>" + ex.getMessage() + "</font>"
                        + "</h3>"
                        + "</body></html>", "MENSAGEM", 1);
            }
        });

        this.view.getBtnFechar().addActionListener((e) -> {
            btnFechar();
        });

        this.view.getjButtonBonus().addActionListener((e) -> {
            btnBonus();
        });
    }

    private void btnBonus() {
        new BonusPresenter();
    }

    private void btnSalvar(IncluirFuncionarioPresenter presenter) throws Exception {

        this.funcionarios.setFuncionarioSelecionado(funcionario);

        presenter.setState(new EdicaoFuncionarioState(presenter));
        presenter.edicao();

    }

    private void btnFechar() {
        this.view.setVisible(false);
        this.view.dispose();
    }

}
