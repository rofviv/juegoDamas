package presentacion;

import clases.Jugador;

@SuppressWarnings("serial")
public class frmNombres extends javax.swing.JDialog {

    Jugador player1;
    Jugador player2;
    
    public void jugadores(Jugador J1, Jugador J2) {
        this.player1 = J1;
        this.player2 = J2;
    }
    
    private void guardarDatos() {
        player1.setNick(txtJugador1.getText());
        player2.setNick(txtJugador2.getText());
        if (rbTurno1.isSelected()) {
            player1.setTurno(true);
            player2.setTurno(false);
        } else {
            player1.setTurno(false);
            player2.setTurno(true);
        }
    }
    
    public frmNombres(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlDialog1 = new contenedores.pnlDialog();
        btnGuardar = new javax.swing.JButton();
        rbTurno2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtJugador1 = new javax.swing.JTextField();
        rbTurno1 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtJugador2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración");

        btnGuardar.setText("Ok");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbTurno2);
        rbTurno2.setFont(new java.awt.Font("Tekton Pro Ext", 2, 18)); // NOI18N
        rbTurno2.setForeground(new java.awt.Color(255, 255, 153));
        rbTurno2.setText("Turno");
        rbTurno2.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Nombre Jugador 1");

        txtJugador1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtJugador1.setText("Jugador 1");

        buttonGroup1.add(rbTurno1);
        rbTurno1.setFont(new java.awt.Font("Tekton Pro Ext", 2, 18)); // NOI18N
        rbTurno1.setForeground(new java.awt.Color(255, 255, 153));
        rbTurno1.setSelected(true);
        rbTurno1.setText("Turno");
        rbTurno1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Nombre Jugador 2");

        txtJugador2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        txtJugador2.setText("Jugador 2");

        javax.swing.GroupLayout pnlDialog1Layout = new javax.swing.GroupLayout(pnlDialog1);
        pnlDialog1.setLayout(pnlDialog1Layout);
        pnlDialog1Layout.setHorizontalGroup(
            pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDialog1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(txtJugador1))
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTurno1)
                    .addComponent(rbTurno2))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnlDialog1Layout.setVerticalGroup(
            pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDialog1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbTurno1))
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbTurno2)
                            .addComponent(txtJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)))
                .addGap(33, 33, 33)
                .addComponent(btnGuardar)
                .addContainerGap(31, Short.MAX_VALUE))
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarDatos();
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmNombres dialog = new frmNombres(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private contenedores.pnlDialog pnlDialog1;
    private javax.swing.JRadioButton rbTurno1;
    private javax.swing.JRadioButton rbTurno2;
    private javax.swing.JTextField txtJugador1;
    private javax.swing.JTextField txtJugador2;
    // End of variables declaration//GEN-END:variables
}
