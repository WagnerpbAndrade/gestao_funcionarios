package command;

import chainBonus.Processadora;
import dao.IFabricaAbstrata;
import dao.IFuncionarioDAO;
import factoryMethodDinamico.FabricaDAO;
import funcionarios.collection.Logs;
import memento.Funcionario;
import funcionarios.model.Log;
import funcionarios.presenter.IncluirFuncionarioPresenter;
import funcionarios.view.IncluirFuncionarioView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import funcionarios.collection.Funcionarios;
import state.EdicaoFuncionarioState;
import zelador.Zelador;

/**
 *
 * @author wagner
 */
public class IncluirFuncionarioCommand implements IFuncionarioCommand {

    private IncluirFuncionarioView view;
    private IFabricaAbstrata fabrica;
    private IFuncionarioDAO dao;
    private Zelador zelador;
    private Funcionario f;
    private Funcionarios funcionarios;

    public IncluirFuncionarioCommand() {

        try {

            this.fabrica = FabricaDAO.getInstance().create();
            this.dao = this.fabrica.criaFabricaFuncionario();
            this.zelador = Zelador.getInstance();
            this.funcionarios = Funcionarios.getInstance();

        } catch (Exception ex) {
            Logger.getLogger(IncluirFuncionarioCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void executar(IncluirFuncionarioPresenter presenter) {

        this.view = presenter.getView();

        this.view.getjTextFieldSalarioComBonus().setEnabled(false);
        this.view.getjButtonBonus().setVisible(false);

//        if (this.zelador.getQtdEstados() == 0){
//            this.view.getjButtonDesfazer().setVisible(false);
//        }
        this.view.getBtnSalvar().addActionListener((e) -> {
            try {

                btnSalvar();

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

        this.view.getjButtonDesfazer().addActionListener((e) -> {
            try {

                btnDesfazer(presenter);

            } catch (Exception ex) {

                //Logger.getLogger(IncluirFuncionarioCommand.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "<html><body>"
                        + "<h3>"
                        + "<font face='Arial'>" + ex.getMessage() + "</font>"
                        + "</h3>"
                        + "</body></html>", "MENSAGEM", 1);
            }
        });

    }

    private void btnFechar() {
        this.view.setVisible(false);
        this.view.dispose();
    }

    private void btnSalvar() throws Exception {

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

            f = new Funcionario(nome, telefone, salarioConvertido, salarioConvertido, cargo, regiao, bonus, faltas, dependentes);

            tratarBonus(f);

            zelador.addMemento(f.getMemento());

            this.dao.inserir(f);

            JOptionPane.showMessageDialog(view, nome + " cadastrado com sucesso!");
            this.view.getTxtNome().setText("");
            this.view.getTxtTelefone().setText("");
            this.view.getjTextFieldSalario().setText("");
            this.view.getjTextFieldAssiduidade().setText("");
            this.view.getjTextFieldDependentes().setText("");

            //Gerar Log
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            Logs.getInstance().addLog(new Log("Insersão: ", f.getNome() + " foi cadastrado!", dateFormat.format(date)));

        } else {
            throw new Exception("Informe os campos!");
        }

    }

    private void tratarBonus(Funcionario f) {

        Processadora p = new Processadora(f);
        
        p.processar();
    }
    
    private void btnDesfazer(IncluirFuncionarioPresenter presenter) throws Exception {
        if (this.zelador.getQtdEstados() <= 0) {
            throw new Exception("Nenhum estado salvo!");
        }

        Funcionario restaurado = f.restaurar(this.zelador.getUltimoSalvo());

        this.funcionarios.setFuncionarioSelecionado(restaurado);

        this.funcionarios.atualizarStatus(restaurado);

        presenter = new IncluirFuncionarioPresenter();
        presenter.setState(new EdicaoFuncionarioState(presenter));
        presenter.desfazer();

        btnFechar();

        throw new Exception("Operação realizada com sucesso!");

    }
}
