package funcionarios.presenter;

import funcionarios.collection.Funcionarios;
import memento.Funcionario;
import funcionarios.view.BonusView;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wagner
 */
public class BonusPresenter {

    private BonusView view;
    private DefaultTableModel tm;

    public BonusPresenter() {

        configuraTela();

    }

    private void configuraTela() {
        this.view = new BonusView(null, true);

        configuraTabela();

        this.view.getjButtonFechar().addActionListener((e) -> {
            btnFechar();
        });

        this.view.setResizable(false);
        this.view.setVisible(true);
    }

    private void btnFechar() {
        this.view.dispose();
    }

    private void configuraTabela() {

        Object colunas[] = {"Indice", "Tipo"};
        tm = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };

        carregarTabela();

        this.view.getjTableBonus().setModel(tm);

    }

    private void carregarTabela() {
        Funcionario funcionarioSelecionado = Funcionarios.getInstance().getFuncionarioSelecionado();
        tm.setNumRows(0);

        Iterator<String> it = funcionarioSelecionado.getBonus().iterator();

        int i = 1;
        while (it.hasNext()) {
            String tipo = it.next();

            tm.addRow(new Object[]{i, tipo});

            i++;
        }

    }

}
