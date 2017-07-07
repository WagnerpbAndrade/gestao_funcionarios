package funcionarios.view;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Wagner Andrade
 */
public class GraficoView extends javax.swing.JInternalFrame {

    /**
     * Creates new form GraficoView
     */
    public GraficoView() {
        initComponents();
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public JPanel getjPanelGrafico() {
        return jPanelGrafico;
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGrafico = new javax.swing.JPanel();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jButtonSair.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonSair.setText("Sair");

        javax.swing.GroupLayout jPanelGraficoLayout = new javax.swing.GroupLayout(jPanelGrafico);
        jPanelGrafico.setLayout(jPanelGraficoLayout);
        jPanelGraficoLayout.setHorizontalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGraficoLayout.createSequentialGroup()
                .addContainerGap(327, Short.MAX_VALUE)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(312, 312, 312))
        );
        jPanelGraficoLayout.setVerticalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGraficoLayout.createSequentialGroup()
                .addContainerGap(464, Short.MAX_VALUE)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSair;
    private javax.swing.JPanel jPanelGrafico;
    // End of variables declaration//GEN-END:variables
}
