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

    public JMenuItem getjMenuItemGraficoBarras() {
        return jMenuItemGraficoBarras;
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
        jMenu5 = new javax.swing.JMenu();
        jMenuItemGraficoBarras = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemPersistenciaTxt = new javax.swing.JMenuItem();
        jMenuItemPersistenciaMySQL = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemLogTxt = new javax.swing.JMenuItem();
        jMenuItemLogMySQL = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão de Funcionários");

        jDesktopPanePrincipalView.setBackground(new java.awt.Color(0, 0, 0));

        jLabelTotalCadastrado.setBackground(new java.awt.Color(0, 0, 0));
        jLabelTotalCadastrado.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelTotalCadastrado.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTotalCadastrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(101, 60));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/people_32x32.png"))); // NOI18N
        jMenu1.setText("Funcionário");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jMenu1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 60));
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItemAdicionarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_24x24.png"))); // NOI18N
        jMenuItemAdicionarFuncionario.setText("Adicionar Funcionário");
        jMenuItemAdicionarFuncionario.setPreferredSize(new java.awt.Dimension(280, 33));
        jMenuItemAdicionarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdicionarFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAdicionarFuncionario);

        jMenuItemListarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list_24x24.png"))); // NOI18N
        jMenuItemListarFuncionario.setText("Listar Funcionários");
        jMenuItemListarFuncionario.setPreferredSize(new java.awt.Dimension(280, 33));
        jMenuItemListarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemListarFuncionario);

        jMenuBar1.add(jMenu1);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chart_32x32.png"))); // NOI18N
        jMenu5.setText("Gráfico");
        jMenu5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenu5.setPreferredSize(new java.awt.Dimension(150, 60));

        jMenuItemGraficoBarras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barra_24x24.png"))); // NOI18N
        jMenuItemGraficoBarras.setText("Gráfico de Barras");
        jMenuItemGraficoBarras.setPreferredSize(new java.awt.Dimension(240, 30));
        jMenu5.add(jMenuItemGraficoBarras);

        jMenuBar1.add(jMenu5);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/db_32x32.png"))); // NOI18N
        jMenu3.setText("Persistência");
        jMenu3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 60));

        jMenuItemPersistenciaTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/txt_24x24.png"))); // NOI18N
        jMenuItemPersistenciaTxt.setText("Em TXT");
        jMenuItemPersistenciaTxt.setPreferredSize(new java.awt.Dimension(240, 33));
        jMenu3.add(jMenuItemPersistenciaTxt);

        jMenuItemPersistenciaMySQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/db_24x24_1.png"))); // NOI18N
        jMenuItemPersistenciaMySQL.setText("Em MySQL");
        jMenuItemPersistenciaMySQL.setPreferredSize(new java.awt.Dimension(240, 33));
        jMenuItemPersistenciaMySQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPersistenciaMySQLActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemPersistenciaMySQL);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log_32x32.png"))); // NOI18N
        jMenu4.setText("Log");
        jMenu4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 60));

        jMenuItemLogTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/txt_24x24.png"))); // NOI18N
        jMenuItemLogTxt.setText("Em TXT");
        jMenuItemLogTxt.setPreferredSize(new java.awt.Dimension(200, 33));
        jMenu4.add(jMenuItemLogTxt);

        jMenuItemLogMySQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/db_24x24_1.png"))); // NOI18N
        jMenuItemLogMySQL.setText("Em MySQL");
        jMenuItemLogMySQL.setPreferredSize(new java.awt.Dimension(200, 33));
        jMenu4.add(jMenuItemLogMySQL);

        jMenuBar1.add(jMenu4);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/system_32x32.png"))); // NOI18N
        jMenu2.setText("Sistema");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenu2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 19));

        jMenuItemSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit_24x24.png"))); // NOI18N
        jMenuItemSair.setText("Sair do Sistema");
        jMenuItemSair.setPreferredSize(new java.awt.Dimension(240, 30));
        jMenu2.add(jMenuItemSair);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipalView, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
            .addComponent(jLabelTotalCadastrado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPanePrincipalView, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalCadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItemAdicionarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdicionarFuncionarioActionPerformed
        
    }//GEN-LAST:event_jMenuItemAdicionarFuncionarioActionPerformed

    private void jMenuItemListarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarFuncionarioActionPerformed
       
    }//GEN-LAST:event_jMenuItemListarFuncionarioActionPerformed

    private void jMenuItemPersistenciaMySQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPersistenciaMySQLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemPersistenciaMySQLActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanePrincipalView;
    private javax.swing.JLabel jLabelTotalCadastrado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAdicionarFuncionario;
    private javax.swing.JMenuItem jMenuItemGraficoBarras;
    private javax.swing.JMenuItem jMenuItemListarFuncionario;
    private javax.swing.JMenuItem jMenuItemLogMySQL;
    private javax.swing.JMenuItem jMenuItemLogTxt;
    private javax.swing.JMenuItem jMenuItemPersistenciaMySQL;
    private javax.swing.JMenuItem jMenuItemPersistenciaTxt;
    private javax.swing.JMenuItem jMenuItemSair;
    // End of variables declaration//GEN-END:variables
}
