package presentacion;

import clases.Ficha;
import clases.Jugador;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class frmFicha extends javax.swing.JDialog {

    Jugador player1;
    Jugador player2;
    char J1;
    char J2;
    char reinaJ1;
    char reinaJ2;

    public void jugadores(Jugador J1, Jugador J2) {
        this.player1 = J1;
        this.player2 = J2;
        mostrarDatos();
    }

    public void mostrarDatos() {
        rbJugador1.setText(player1.getNick());
        rbJugador2.setText(player2.getNick());
        mostrarFichaActual();
    }

    private void mostrarFichaActual() {
        lblPiezaJugador1.setIcon(piezaJugador(player1.getFicha().mostrarFicha()));
        lblPiezaJugador2.setIcon(piezaJugador(player2.getFicha().mostrarFicha()));
        J1 = player1.getFicha().mostrarFicha();
        J2 = player2.getFicha().mostrarFicha();
    }

    public ImageIcon piezaJugador(char p) {
        return new ImageIcon(getClass().getResource("/images/piezas/" + p + ".png"));
    }

    private void actualizarFicha() {
        if (rbJugador1.isSelected()) {
            lblPiezaJugador1.setIcon(piezaJugador(pieza()));
            J1 = pieza();
        } else {
            lblPiezaJugador2.setIcon(piezaJugador(pieza()));
            J2 = pieza();
        }
    }

    private char pieza() {
        if (pieza_1.isSelected()) {
            return '1';
        } else if (pieza_2.isSelected()) {
            return '2';
        } else if (pieza_3.isSelected()) {
            return '5';
        } else if (pieza_4.isSelected()) {
            return '6';
        } else if (pieza_5.isSelected()) {
            return 'w';
        } else if (pieza_6.isSelected()) {
            return 'x';
        } else if (pieza_7.isSelected()) {
            return 's';
        } else {
            return 't';
        }
    }

    private void guardarDatos() {
        player1.setFicha(new Ficha(J1));
        player2.setFicha(new Ficha(J2));
        player1.setFichaReina(new Ficha((char) (J1 + 2)));
        player2.setFichaReina(new Ficha((char) (J2 + 2)));
    }

    public frmFicha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnlDialog1 = new contenedores.pnlDialog();
        lblPiezaJugador2 = new javax.swing.JLabel();
        lblPiezaJugador1 = new javax.swing.JLabel();
        rbJugador1 = new javax.swing.JRadioButton();
        rbJugador2 = new javax.swing.JRadioButton();
        btnOk = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pieza_1 = new javax.swing.JCheckBox();
        lbl_1 = new javax.swing.JLabel();
        pieza_2 = new javax.swing.JCheckBox();
        lbl_2 = new javax.swing.JLabel();
        pieza_3 = new javax.swing.JCheckBox();
        lbl_3 = new javax.swing.JLabel();
        pieza_4 = new javax.swing.JCheckBox();
        lbl_4 = new javax.swing.JLabel();
        pieza_5 = new javax.swing.JCheckBox();
        lbl_5 = new javax.swing.JLabel();
        pieza_6 = new javax.swing.JCheckBox();
        lbl_6 = new javax.swing.JLabel();
        pieza_7 = new javax.swing.JCheckBox();
        lbl_7 = new javax.swing.JLabel();
        pieza_8 = new javax.swing.JCheckBox();
        lbl_8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar Ficha");

        lblPiezaJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPiezaJugador2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblPiezaJugador2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblPiezaJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPiezaJugador1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblPiezaJugador1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        buttonGroup2.add(rbJugador1);
        rbJugador1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbJugador1.setForeground(new java.awt.Color(255, 204, 0));
        rbJugador1.setSelected(true);
        rbJugador1.setText("Nick J1");
        rbJugador1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbJugador1.setOpaque(false);

        buttonGroup2.add(rbJugador2);
        rbJugador2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rbJugador2.setForeground(new java.awt.Color(255, 204, 0));
        rbJugador2.setText("Nick J2");
        rbJugador2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbJugador2.setOpaque(false);

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        buttonGroup1.add(pieza_1);
        pieza_1.setSelected(true);
        pieza_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pieza_1.setBorderPainted(true);
        pieza_1.setBorderPaintedFlat(true);
        pieza_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pieza_1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pieza_1.setOpaque(false);
        pieza_1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pieza_1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pieza_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pieza_1MouseClicked(evt);
            }
        });
        jPanel1.add(pieza_1);
        pieza_1.setBounds(0, 0, 80, 60);

        lbl_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/1.png"))); // NOI18N
        jPanel1.add(lbl_1);
        lbl_1.setBounds(10, 0, 64, 60);

        buttonGroup1.add(pieza_2);
        pieza_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pieza_2.setBorderPainted(true);
        pieza_2.setBorderPaintedFlat(true);
        pieza_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pieza_2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pieza_2.setOpaque(false);
        pieza_2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pieza_2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pieza_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pieza_2MouseClicked(evt);
            }
        });
        jPanel1.add(pieza_2);
        pieza_2.setBounds(80, 0, 80, 60);

        lbl_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/2.png"))); // NOI18N
        jPanel1.add(lbl_2);
        lbl_2.setBounds(90, 0, 64, 60);

        buttonGroup1.add(pieza_3);
        pieza_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pieza_3.setBorderPainted(true);
        pieza_3.setBorderPaintedFlat(true);
        pieza_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pieza_3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pieza_3.setOpaque(false);
        pieza_3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pieza_3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pieza_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pieza_3MouseClicked(evt);
            }
        });
        jPanel1.add(pieza_3);
        pieza_3.setBounds(0, 60, 80, 60);

        lbl_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/5.png"))); // NOI18N
        jPanel1.add(lbl_3);
        lbl_3.setBounds(10, 60, 64, 60);

        buttonGroup1.add(pieza_4);
        pieza_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pieza_4.setBorderPainted(true);
        pieza_4.setBorderPaintedFlat(true);
        pieza_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pieza_4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pieza_4.setOpaque(false);
        pieza_4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pieza_4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pieza_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pieza_4MouseClicked(evt);
            }
        });
        jPanel1.add(pieza_4);
        pieza_4.setBounds(80, 60, 80, 60);

        lbl_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/6.png"))); // NOI18N
        jPanel1.add(lbl_4);
        lbl_4.setBounds(90, 60, 64, 60);

        buttonGroup1.add(pieza_5);
        pieza_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pieza_5.setBorderPainted(true);
        pieza_5.setBorderPaintedFlat(true);
        pieza_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pieza_5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pieza_5.setOpaque(false);
        pieza_5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pieza_5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pieza_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pieza_5MouseClicked(evt);
            }
        });
        jPanel1.add(pieza_5);
        pieza_5.setBounds(160, 0, 80, 60);

        lbl_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/w.png"))); // NOI18N
        jPanel1.add(lbl_5);
        lbl_5.setBounds(170, 0, 64, 60);

        buttonGroup1.add(pieza_6);
        pieza_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pieza_6.setBorderPainted(true);
        pieza_6.setBorderPaintedFlat(true);
        pieza_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pieza_6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pieza_6.setOpaque(false);
        pieza_6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pieza_6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pieza_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pieza_6MouseClicked(evt);
            }
        });
        pieza_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieza_6ActionPerformed(evt);
            }
        });
        jPanel1.add(pieza_6);
        pieza_6.setBounds(160, 60, 80, 60);

        lbl_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/x.png"))); // NOI18N
        jPanel1.add(lbl_6);
        lbl_6.setBounds(170, 60, 64, 60);

        buttonGroup1.add(pieza_7);
        pieza_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pieza_7.setBorderPainted(true);
        pieza_7.setBorderPaintedFlat(true);
        pieza_7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pieza_7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pieza_7.setOpaque(false);
        pieza_7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pieza_7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pieza_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pieza_7MouseClicked(evt);
            }
        });
        pieza_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieza_7ActionPerformed(evt);
            }
        });
        jPanel1.add(pieza_7);
        pieza_7.setBounds(0, 120, 80, 60);

        lbl_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/s.png"))); // NOI18N
        jPanel1.add(lbl_7);
        lbl_7.setBounds(10, 120, 64, 60);

        buttonGroup1.add(pieza_8);
        pieza_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pieza_8.setBorderPainted(true);
        pieza_8.setBorderPaintedFlat(true);
        pieza_8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pieza_8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pieza_8.setOpaque(false);
        pieza_8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        pieza_8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pieza_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pieza_8MouseClicked(evt);
            }
        });
        pieza_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieza_8ActionPerformed(evt);
            }
        });
        jPanel1.add(pieza_8);
        pieza_8.setBounds(80, 120, 80, 60);

        lbl_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/t.png"))); // NOI18N
        jPanel1.add(lbl_8);
        lbl_8.setBounds(90, 120, 64, 60);

        javax.swing.GroupLayout pnlDialog1Layout = new javax.swing.GroupLayout(pnlDialog1);
        pnlDialog1.setLayout(pnlDialog1Layout);
        pnlDialog1Layout.setHorizontalGroup(
            pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPiezaJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPiezaJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnlDialog1Layout.setVerticalGroup(
            pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPiezaJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbJugador1))
                        .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDialog1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(rbJugador2)
                                .addGap(38, 38, 38)
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDialog1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblPiezaJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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

        setSize(new java.awt.Dimension(671, 259));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        guardarDatos();
        dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void pieza_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieza_1MouseClicked
        actualizarFicha();
    }//GEN-LAST:event_pieza_1MouseClicked

    private void pieza_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieza_2MouseClicked
        actualizarFicha();
    }//GEN-LAST:event_pieza_2MouseClicked

    private void pieza_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieza_3MouseClicked
        actualizarFicha();
    }//GEN-LAST:event_pieza_3MouseClicked

    private void pieza_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieza_4MouseClicked
        actualizarFicha();
    }//GEN-LAST:event_pieza_4MouseClicked

    private void pieza_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieza_5MouseClicked
        actualizarFicha();
    }//GEN-LAST:event_pieza_5MouseClicked

    private void pieza_7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieza_7MouseClicked
        actualizarFicha();
    }//GEN-LAST:event_pieza_7MouseClicked

    private void pieza_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieza_6MouseClicked
    }//GEN-LAST:event_pieza_6MouseClicked

    private void pieza_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieza_7ActionPerformed
        actualizarFicha();
    }//GEN-LAST:event_pieza_7ActionPerformed

    private void pieza_8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieza_8MouseClicked
    }//GEN-LAST:event_pieza_8MouseClicked

    private void pieza_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieza_8ActionPerformed
        actualizarFicha();
    }//GEN-LAST:event_pieza_8ActionPerformed

    private void pieza_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieza_6ActionPerformed
        actualizarFicha();
    }//GEN-LAST:event_pieza_6ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmFicha dialog = new frmFicha(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnOk;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPiezaJugador1;
    private javax.swing.JLabel lblPiezaJugador2;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_5;
    private javax.swing.JLabel lbl_6;
    private javax.swing.JLabel lbl_7;
    private javax.swing.JLabel lbl_8;
    private javax.swing.JCheckBox pieza_1;
    private javax.swing.JCheckBox pieza_2;
    private javax.swing.JCheckBox pieza_3;
    private javax.swing.JCheckBox pieza_4;
    private javax.swing.JCheckBox pieza_5;
    private javax.swing.JCheckBox pieza_6;
    private javax.swing.JCheckBox pieza_7;
    private javax.swing.JCheckBox pieza_8;
    private contenedores.pnlDialog pnlDialog1;
    private javax.swing.JRadioButton rbJugador1;
    private javax.swing.JRadioButton rbJugador2;
    // End of variables declaration//GEN-END:variables
}
