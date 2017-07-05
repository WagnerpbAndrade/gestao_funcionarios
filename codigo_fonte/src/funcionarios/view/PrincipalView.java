package funcionarios.view;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public PrincipalView() {
        initComponents();
    }

    public JDesktopPane getjDesktopPanePrincipalView() {
        return jDesktopPanePrincipalView;
    }

    public JMenuItem getjMenuItemAdicionarFuncionario() {
        return jMenuItemAdicionarFuncionario;
    }

    public JMenuItem getjMenuItemListarFuncionario() {
        return jMenuItemListarFuncionario;
    }

    public JMenuItem getjMenuItemSair() {
        return jMenuItemSair;
    }

    public JLabel getjLabelTotalCadastrado() {
        return jLabelTotalCadastrado;
    }

    public JMenuItem getjMenuItemPersistenciaMySQL() {
        return jMenuItemPersistenciaMySQL;
    }

    public JMenuItem getjMenuItemPersistenciaTxt() {
        return jMenuItemPersistenciaTxt;
    }

    public JMenuItem getjMenuItemLogMySQL() {
        return jMenuItemLogMySQL;
    }

    public JMenuItem getjMenuItemLogTxt() {
        return jMenuItemLogTxt;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPanePrincipalView = new javax.swing.JDesktopPane();
        jLabelTotalCadastrado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAdicionarFuncionario = new javax.swing.JMenuItem();
        jMenuItemListarFuncionario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemPersistenciaTxt = new javax.swing.JMenuItem();
        jMenuItemPersistenciaMySQL = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemLogTxt = new javax.swing.JMenuItem();
        jMenuItemLogMySQL = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de pessoas");

        jLabelTotalCadastrado.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N

        jMenu1.setText("Funcionário");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItemAdicionarFuncionario.setText("Adicionar Funcionário");
        jMenuItemAdicionarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdicionarFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAdicionarFuncionario);

        jMenuItemListarFuncionario.setText("Listar Funcionários");
        jMenuItemListarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemListarFuncionario);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Persistência");

        jMenuItemPersistenciaTxt.setText("Persistência de dados em TXT");
        jMenu3.add(jMenuItemPersistenciaTxt);

        jMenuItemPersistenciaMySQL.setText("Persistência de dados em MySQL");
        jMenu3.add(jMenuItemPersistenciaMySQL);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Log");

        jMenuItemLogTxt.setText("Salvar Log Txt");
        jMenu4.add(jMenuItemLogTxt);

        jMenuItemLogMySQL.setText("Salvar Log MySQL");
        jMenu4.add(jMenuItemLogMySQL);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Sistema");

        jMenuItemSair.setText("Sair do Sistema");
        jMenu2.add(jMenuItemSair);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipalView, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(703, Short.MAX_VALUE)
                .addComponent(jLabelTotalCadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPanePrincipalView, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTotalCadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItemAdicionarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdicionarFuncionarioActionPerformed
        
    }//GEN-LAST:event_jMenuItemAdicionarFuncionarioActionPerformed

    private void jMenuItemListarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarFuncionarioActionPerformed
       
    }//GEN-LAST:event_jMenuItemListarFuncionarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanePrincipalView;
    private javax.swing.JLabel jLabelTotalCadastrado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAdicionarFuncionario;
    private javax.swing.JMenuItem jMenuItemListarFuncionario;
    private javax.swing.JMenuItem jMenuItemLogMySQL;
    private javax.swing.JMenuItem jMenuItemLogTxt;
    private javax.swing.JMenuItem jMenuItemPersistenciaMySQL;
    private javax.swing.JMenuItem jMenuItemPersistenciaTxt;
    private javax.swing.JMenuItem jMenuItemSair;
    // End of variables declaration//GEN-END:variables
}
