package command;

import chainBonus.BonusAssiduidadeHandler;
import chainBonus.BonusDependentesHandler;
import chainBonus.BonusGenerosoHandler;
import chainBonus.BonusLocalidadeHandler;
import chainBonus.BonusNormalHandler;
import chainBonus.ITratador;
import chainBonus.Processadora;
import factoryMethodDinamico.FabricaDAO;
import funcionarios.collection.Funcionarios;
import funcionarios.collection.Logs;
import memento.Funcionario;
import funcionarios.model.Log;
import funcionarios.presenter.IncluirFuncionarioPresenter;
import funcionarios.view.IncluirFuncionarioView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import dao.IFuncionarioDAO;
import zelador.Zelador;

/**
 *
 * @author wagner
 */
public class EditarFuncionarioCommand implements IFuncionarioCommand {

    private Funcionarios funcionarios;
    private IncluirFuncionarioView view;
    private Funcionario funcionarioSelecionado;
    private IFuncionarioDAO dao;
    private Zelador zelador;

    public EditarFuncionarioCommand() {

        try {

            this.funcionarios = Funcionarios.getInstance();
            this.dao = FabricaDAO.getInstance().create();
            this.zelador = Zelador.getInstance();

        } catch (Exception ex) {
            Logger.getLogger(EditarFuncionarioCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void executar(IncluirFuncionarioPresenter presenter) {
        this.view = presenter.getView();
        this.funcionarioSelecionado = this.funcionarios.getFuncionarioSelecionado();

        this.view.getjButtonDesfazer().setVisible(false);

        this.view.getjButtonBonus().setVisible(false);

        //Desabilitando os campos da view
        this.view.getTxtNome().setEnabled(true);
        this.view.getTxtTelefone().setEnabled(true);
        this.view.getjTextFieldAssiduidade().setEnabled(true);
        this.view.getjTextFieldSalario().setEnabled(true);
        this.view.getjTextFieldSalarioComBonus().setEnabled(false);
        this.view.getjTextFieldDependentes().setEnabled(true);
        this.view.getjComboBoxBonus().setEnabled(true);
        this.view.getjComboBoxCargo().setEnabled(true);
        this.view.getjComboBoxRegiao().setEnabled(true);

        //Configurando os títulos
        this.view.getjLabelTitulo().setText("Editar Funcionário");
        this.view.setTitle("Editar Funcionário");
        this.view.getBtnSalvar().setText("Salvar");

        //Settando os dados do funcionário
        this.view.getTxtNome().setText(funcionarioSelecionado.getNome());
        this.view.getTxtTelefone().setText(funcionarioSelecionado.getTelefone());
        this.view.getjTextFieldAssiduidade().setText(String.valueOf(funcionarioSelecionado.getAssiduidade()));
        this.view.getjTextFieldSalario().setText(String.valueOf(funcionarioSelecionado.getSalarioBase()));
        this.view.getjTextFieldSalarioComBonus().setText(String.valueOf(funcionarioSelecionado.getSalarioComBonus()));
        this.view.getjTextFieldDependentes().setText(String.valueOf(funcionarioSelecionado.getNumeroDependentes()));
        this.view.getjComboBoxBonus().getModel().setSelectedItem(funcionarioSelecionado.getBonus().get(0));
        this.view.getjComboBoxCargo().getModel().setSelectedItem(funcionarioSelecionado.getCargo());
        this.view.getjComboBoxRegiao().getModel().setSelectedItem(funcionarioSelecionado.getRegiao());

        this.view.getBtnSalvar().addActionListener((e) -> {
            try {
                btnSalvar(funcionarioSelecionado);
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

    }

    private void btnFechar() {
        this.view.setVisible(false);
        this.view.dispose();
    }

    private void btnSalvar(Funcionario funcionario) throws Exception {

        String nome = this.view.getTxtNome().getText();
        String telefone = this.view.getTxtTelefone().getText();
        String salario = this.view.getjTextFieldSalario().getText();
        String cargo = this.view.getjComboBoxCargo().getSelectedItem().toString();
        String bonus = this.view.getjComboBoxBonus().getSelectedItem().toString();
        String regiao = this.view.getjComboBoxRegiao().getSelectedItem().toString();
        String assiduidade = this.view.getjTextFieldAssiduidade().getText();
        String numeroDependentes = this.view.getjTextFieldDependentes().getText();

        double salarioConvertido = 0.0;
        int faltas = 0;
        int dependentes = 0;

        if (!nome.equals("") && !telefone.equals("") && !salario.equals("") && !assiduidade.equals("") && !numeroDependentes.equals("")) {

            try {
                salarioConvertido = Double.parseDouble(salario.replace(",", "."));
            } catch (Exception e) {
                view.getjTextFieldSalario().requestFocus();
                view.getjTextFieldSalario().setText("");

                throw new Exception("Infome um salário válido!");
            }

            try {
                faltas = Integer.parseInt(assiduidade);
            } catch (Exception e) {
                view.getjTextFieldAssiduidade().requestFocus();
                view.getjTextFieldAssiduidade().setText("");

                throw new Exception("Infome um número de faltas válido!");
            }

            try {
                dependentes = Integer.parseInt(numeroDependentes);
            } catch (Exception e) {
                view.getjTextFieldAssiduidade().requestFocus();
                view.getjTextFieldAssiduidade().setText("");

                throw new Exception("Infome um número de dependentes válido!");
            }

            Funcionario funcionarioEditado = new Funcionario(nome, telefone, salarioConvertido, salarioConvertido, cargo, regiao, bonus, faltas, dependentes);

            tratarBonus(funcionarioEditado);

            if (funcionario.getId() != 0) {
                funcionarioEditado.setId(funcionario.getId());

                editarFuncionario(funcionarioEditado);

            } else {
                this.funcionarios.add(funcionarioEditado);
            }

            JOptionPane.showMessageDialog(view, "Funcionário editado com sucesso!");

            //GerarLog
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            Logs.getInstance().addLog(new Log("Edição: ", "O funcionário: " + funcionario.getNome() + "foi editado para: " + funcionarioEditado.toString(), dateFormat.format(date)));

            btnFechar();

        } else {
            throw new Exception("Informe os campos!");
        }
    }

    private void editarFuncionario(Funcionario f) throws Exception {
        TreeSet<Funcionario> funcs = this.dao.getAll();

        for (Funcionario funcionario : funcs) {
            if (funcionario.compareTo(this.funcionarioSelecionado) == 0) {
                funcs.remove(funcionario);
                break;
            }
        }

        funcs.add(f);

        this.funcionarios.editarFuncionario(funcs, f);

    }

    private void tratarBonus(Funcionario f) {
        
        Processadora p = new Processadora(f);
        
        p.processar();
        
    }

    @Override
    public void desfazer(IncluirFuncionarioPresenter presenter) throws Exception {

        this.view = presenter.getView();

        Funcionario f = this.funcionarios.getFuncionarioSelecionado();

        this.view.getjButtonDesfazer().setVisible(false);

        this.view.getjButtonBonus().setVisible(false);

        //Desabilitando os campos da view
        this.view.getTxtNome().setEnabled(true);
        this.view.getTxtTelefone().setEnabled(true);
        this.view.getjTextFieldAssiduidade().setEnabled(true);
        this.view.getjTextFieldSalario().setEnabled(true);
        this.view.getjTextFieldSalarioComBonus().setEnabled(false);
        this.view.getjTextFieldDependentes().setEnabled(true);
        this.view.getjComboBoxBonus().setEnabled(true);
        this.view.getjComboBoxCargo().setEnabled(true);
        this.view.getjComboBoxRegiao().setEnabled(true);

        //Configurando os títulos
        this.view.getjLabelTitulo().setText("Editar Funcionário");
        this.view.setTitle("Editar Funcionário");
        this.view.getBtnSalvar().setText("Salvar");

        //Settando os dados do funcionário
        this.view.getTxtNome().setText(f.getNome());
        this.view.getTxtTelefone().setText(f.getTelefone());
        this.view.getjTextFieldAssiduidade().setText(String.valueOf(f.getAssiduidade()));
        this.view.getjTextFieldSalario().setText(String.valueOf(f.getSalarioBase()));
        this.view.getjTextFieldSalarioComBonus().setText(String.valueOf(f.getSalarioComBonus()));
        this.view.getjTextFieldDependentes().setText(String.valueOf(f.getNumeroDependentes()));
        this.view.getjComboBoxBonus().getModel().setSelectedItem(f.getBonus().get(0));
        this.view.getjComboBoxCargo().getModel().setSelectedItem(f.getCargo());
        this.view.getjComboBoxRegiao().getModel().setSelectedItem(f.getRegiao());

        this.view.getBtnSalvar().addActionListener((e) -> {
            try {

                btnSalvar(f);

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
    }

}
