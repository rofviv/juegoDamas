package presentacion;

import clases.Casilla;
import clases.Game;

@SuppressWarnings("serial")
public class frmTablero extends javax.swing.JDialog {

    Game game;
    private Casilla cas_1 = new Casilla('a');
    private Casilla cas_2 = new Casilla('b');

    public void datos(Game game) {
        this.game = game;
    }
    
    private void nuevaCasilla(char c1, char c2) {
        cas_1 = new Casilla(c1);
        cas_2 = new Casilla(c2);
    }

    public void actualizarTablero() {
        if (model_1.isSelected()) {
            nuevaCasilla('a', 'b');
        } else if (model_2.isSelected()) {
            nuevaCasilla('c', 'd');
        } else {
            nuevaCasilla('f', 'g');
        }
    }

    private byte dimTablero() {
        if (cbDimension.getSelectedIndex() == 0) {
            return 6;
        } else if (cbDimension.getSelectedIndex() == 1) {
            return 8;
        } else {
            return 10;
        }
    }

    public Casilla getCasilla_1() {
        return cas_1;
    }

    public Casilla getCasila_2() {
        return cas_2;
    }

    public frmTablero(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlDialog1 = new contenedores.pnlDialog();
        cbDimension = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        model_1 = new javax.swing.JCheckBox();
        lbl_1 = new javax.swing.JLabel();
        model_2 = new javax.swing.JCheckBox();
        lbl_2 = new javax.swing.JLabel();
        model_3 = new javax.swing.JCheckBox();
        lbl_3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modelo y tamaño");

        cbDimension.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbDimension.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6 x 6", "8 x 8", "10 x 10" }));
        cbDimension.setSelectedIndex(1);
        cbDimension.setToolTipText("Dimension del tablero");
        cbDimension.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        buttonGroup1.add(model_1);
        model_1.setSelected(true);
        model_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        model_1.setBorderPainted(true);
        model_1.setBorderPaintedFlat(true);
        model_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        model_1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        model_1.setOpaque(false);
        model_1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        model_1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        model_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                model_1MouseClicked(evt);
            }
        });
        jPanel1.add(model_1);
        model_1.setBounds(0, 0, 96, 96);

        lbl_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/model1.png"))); // NOI18N
        jPanel1.add(lbl_1);
        lbl_1.setBounds(0, 0, 96, 96);

        buttonGroup1.add(model_2);
        model_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        model_2.setBorderPainted(true);
        model_2.setBorderPaintedFlat(true);
        model_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        model_2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        model_2.setOpaque(false);
        model_2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        model_2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        model_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                model_2MouseClicked(evt);
            }
        });
        model_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                model_2ActionPerformed(evt);
            }
        });
        jPanel1.add(model_2);
        model_2.setBounds(110, 0, 96, 96);

        lbl_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/model2.png"))); // NOI18N
        jPanel1.add(lbl_2);
        lbl_2.setBounds(110, 0, 96, 96);

        buttonGroup1.add(model_3);
        model_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        model_3.setBorderPainted(true);
        model_3.setBorderPaintedFlat(true);
        model_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        model_3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        model_3.setOpaque(false);
        model_3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        model_3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        model_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                model_3MouseClicked(evt);
            }
        });
        model_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                model_3ActionPerformed(evt);
            }
        });
        jPanel1.add(model_3);
        model_3.setBounds(220, 0, 96, 96);

        lbl_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/model3.png"))); // NOI18N
        jPanel1.add(lbl_3);
        lbl_3.setBounds(220, 0, 96, 96);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("Modelo y tamaño del tablero");

        javax.swing.GroupLayout pnlDialog1Layout = new javax.swing.GroupLayout(pnlDialog1);
        pnlDialog1.setLayout(pnlDialog1Layout);
        pnlDialog1Layout.setHorizontalGroup(
            pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cbDimension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlDialog1Layout.setVerticalGroup(
            pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDialog1Layout.createSequentialGroup()
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAceptar)
                            .addComponent(cbDimension, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDialog1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDialog1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(616, 291));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void model_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_model_2MouseClicked
        actualizarTablero();
        game.inicializar(cas_1, cas_2);
    }//GEN-LAST:event_model_2MouseClicked

    private void model_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_model_1MouseClicked
        actualizarTablero();
        game.inicializar(cas_1, cas_2);
    }//GEN-LAST:event_model_1MouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        game.setDim(dimTablero());
        actualizarTablero();
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void model_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_model_2ActionPerformed
    }//GEN-LAST:event_model_2ActionPerformed

    private void model_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_model_3MouseClicked
    }//GEN-LAST:event_model_3MouseClicked

    private void model_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_model_3ActionPerformed
        actualizarTablero();
        game.inicializar(cas_1, cas_2);
    }//GEN-LAST:event_model_3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmTablero dialog = new frmTablero(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbDimension;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JCheckBox model_1;
    private javax.swing.JCheckBox model_2;
    private javax.swing.JCheckBox model_3;
    private contenedores.pnlDialog pnlDialog1;
    // End of variables declaration//GEN-END:variables
}
