package presentacion;

import clases.Game;
import clases.Jugador;
import clases.Sonido;
import clases.SonidoMP3;

@SuppressWarnings("serial")
public class frmAjustes extends javax.swing.JDialog {
    
    frmNombres ajustesNombre;
    frmFicha ajustesFicha;
    frmTablero ajustesTablero;
    frmMusica elegirMusica;
    Game game;
    Jugador player1;
    Jugador player2;
    SonidoMP3 musica;
    Sonido sonido;
    
    private void habilitarSonido(Game game) {
        sonido = new Sonido(btnNombre, game.sonidoGame().activo());
        sonido = new Sonido(btnFichas, game.sonidoGame().activo());
        sonido = new Sonido(btnTablero, game.sonidoGame().activo());
        sonido = new Sonido(btnMusica, game.sonidoGame().activo());
        sonido = new Sonido(btnVolver, game.sonidoGame().activo());
    }
    
    public void juego(Game game, Jugador J1, Jugador J2, SonidoMP3 musica) {
        this.game = game;
        this.player1 = J1;
        this.player2 = J2;
        this.musica = musica;
//        habilitarSonido(this.game);
    }
    
    public frmMusica musica() {
        return elegirMusica;
    }
    
    public frmTablero casilla() {
        return ajustesTablero;
    }
    
    public frmAjustes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ajustesNombre = new frmNombres(null, true);
        ajustesFicha = new frmFicha(null, true);
        ajustesTablero = new frmTablero(null, true);
        elegirMusica = new frmMusica(null, true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDialog1 = new contenedores.pnlDialog();
        jLabel1 = new javax.swing.JLabel();
        btnNombre = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnFichas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnTablero = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnMusica = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajustes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ajustes del juego");

        btnNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNombre.setForeground(new java.awt.Color(255, 255, 255));
        btnNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario1.png"))); // NOI18N
        btnNombre.setText("Nombre y turno");
        btnNombre.setBorder(null);
        btnNombre.setBorderPainted(false);
        btnNombre.setContentAreaFilled(false);
        btnNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNombre.setHideActionText(true);
        btnNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNombre.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNombre.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png"))); // NOI18N
        btnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 102));
        jLabel2.setText(">>");

        btnFichas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFichas.setForeground(new java.awt.Color(255, 255, 255));
        btnFichas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N
        btnFichas.setText("Cambiar fichas");
        btnFichas.setBorder(null);
        btnFichas.setBorderPainted(false);
        btnFichas.setContentAreaFilled(false);
        btnFichas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFichas.setHideActionText(true);
        btnFichas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFichas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFichas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piezas/1.png"))); // NOI18N
        btnFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFichasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 102));
        jLabel3.setText(">>");

        btnTablero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTablero.setForeground(new java.awt.Color(255, 255, 255));
        btnTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tablero2.png"))); // NOI18N
        btnTablero.setText("Cambiar tablero");
        btnTablero.setBorder(null);
        btnTablero.setBorderPainted(false);
        btnTablero.setContentAreaFilled(false);
        btnTablero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTablero.setHideActionText(true);
        btnTablero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTablero.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTablero.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tablero.png"))); // NOI18N
        btnTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableroActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 102));
        jLabel5.setText(">>");

        btnMusica.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMusica.setForeground(new java.awt.Color(255, 255, 255));
        btnMusica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMusica2.png"))); // NOI18N
        btnMusica.setText("Elegir musica");
        btnMusica.setBorder(null);
        btnMusica.setBorderPainted(false);
        btnMusica.setContentAreaFilled(false);
        btnMusica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMusica.setHideActionText(true);
        btnMusica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMusica.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMusica.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMusica.png"))); // NOI18N
        btnMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setText(">>");

        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volver2.png"))); // NOI18N
        btnVolver.setToolTipText("Volver");
        btnVolver.setBorder(null);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.setHideActionText(true);
        btnVolver.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVolver.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVolver.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volver.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDialog1Layout = new javax.swing.GroupLayout(pnlDialog1);
        pnlDialog1.setLayout(pnlDialog1Layout);
        pnlDialog1Layout.setHorizontalGroup(
            pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDialog1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(btnVolver))
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnFichas)
                                .addComponent(btnNombre))
                            .addComponent(btnTablero)
                            .addComponent(btnMusica))
                        .addGap(32, 32, 32)
                        .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlDialog1Layout.setVerticalGroup(
            pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNombre)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFichas)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTablero)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMusica)
                    .addComponent(jLabel6))
                .addGap(19, 19, 19)
                .addComponent(btnVolver)
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void btnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreActionPerformed
        ajustesNombre.jugadores(player1, player2);
        ajustesNombre.setVisible(true);
    }//GEN-LAST:event_btnNombreActionPerformed

    private void btnFichasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFichasActionPerformed
        ajustesFicha.jugadores(player1, player2);
        ajustesFicha.setVisible(true);
    }//GEN-LAST:event_btnFichasActionPerformed

    private void btnTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableroActionPerformed
        ajustesTablero.datos(game);
        ajustesTablero.setVisible(true);
    }//GEN-LAST:event_btnTableroActionPerformed

    private void btnMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicaActionPerformed
        elegirMusica.setMusica(musica);
        elegirMusica.setVisible(true);
    }//GEN-LAST:event_btnMusicaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmAjustes dialog = new frmAjustes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnFichas;
    private javax.swing.JButton btnMusica;
    private javax.swing.JButton btnNombre;
    private javax.swing.JButton btnTablero;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private contenedores.pnlDialog pnlDialog1;
    // End of variables declaration//GEN-END:variables
}
