package presentacion;

import clases.SonidoMP3;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class frmMusica extends javax.swing.JDialog {

    private String direccion = "C:\\Users\\Roy Favio\\Documents\\NetBeansProjects\\proyectoDamas\\src\\sonido\\piano.mp3";
    private SonidoMP3 music;
    JFileChooser archivos = new JFileChooser("D:\\Mis documentos\\Musica");
    FileFilter extension = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");

    public void setMusica(SonidoMP3 music) {
        this.music = music;
    }

    public String getDireccion() {
        return direccion;
    }

    private void buscarMusica() {
        archivos.addChoosableFileFilter(extension);
        int opcion = archivos.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            direccion = archivos.getSelectedFile().getPath();
            txtDireccion.setText(direccion);
            music.reproducir(direccion);
        }
    }

    public frmMusica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlDialog1 = new contenedores.pnlDialog();
        rbMusica_1 = new javax.swing.JRadioButton();
        txtDireccion = new javax.swing.JTextField();
        btnImportar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        rbMusica_2 = new javax.swing.JRadioButton();
        rbMusica_3 = new javax.swing.JRadioButton();
        rbImportar = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selección de música");

        buttonGroup1.add(rbMusica_1);
        rbMusica_1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        rbMusica_1.setForeground(new java.awt.Color(255, 204, 51));
        rbMusica_1.setSelected(true);
        rbMusica_1.setText("Sonido 1");
        rbMusica_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbMusica_1.setOpaque(false);
        rbMusica_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbMusica_1MouseClicked(evt);
            }
        });
        rbMusica_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMusica_1ActionPerformed(evt);
            }
        });

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnImportar.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        btnImportar.setText("Importar");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbMusica_2);
        rbMusica_2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        rbMusica_2.setForeground(new java.awt.Color(255, 204, 51));
        rbMusica_2.setText("Sonido 2");
        rbMusica_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbMusica_2.setOpaque(false);
        rbMusica_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbMusica_2MouseClicked(evt);
            }
        });
        rbMusica_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMusica_2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbMusica_3);
        rbMusica_3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        rbMusica_3.setForeground(new java.awt.Color(255, 204, 51));
        rbMusica_3.setText("Sonido 3");
        rbMusica_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbMusica_3.setOpaque(false);
        rbMusica_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbMusica_3MouseClicked(evt);
            }
        });

        buttonGroup1.add(rbImportar);
        rbImportar.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        rbImportar.setForeground(new java.awt.Color(204, 204, 204));
        rbImportar.setText("Sonido externo");
        rbImportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbImportar.setOpaque(false);
        rbImportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbImportarMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgMusica2.png"))); // NOI18N

        javax.swing.GroupLayout pnlDialog1Layout = new javax.swing.GroupLayout(pnlDialog1);
        pnlDialog1.setLayout(pnlDialog1Layout);
        pnlDialog1Layout.setHorizontalGroup(
            pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDialog1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnImportar)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbImportar)
                            .addComponent(rbMusica_1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbMusica_2)
                            .addComponent(rbMusica_3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74))))
        );
        pnlDialog1Layout.setVerticalGroup(
            pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDialog1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(rbMusica_1)
                .addGroup(pnlDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1)
                        .addGap(50, 50, 50)
                        .addComponent(rbImportar))
                    .addGroup(pnlDialog1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rbMusica_2)
                        .addGap(18, 18, 18)
                        .addComponent(rbMusica_3)))
                .addGap(18, 18, 18)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        rbImportar.setSelected(true);
        buscarMusica();
    }//GEN-LAST:event_btnImportarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rbMusica_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbMusica_1MouseClicked
        direccion = "C:\\Users\\Roy Favio\\Documents\\NetBeansProjects\\proyectoDamas\\src\\sonido\\piano.mp3";
        music.reproducir(direccion);
    }//GEN-LAST:event_rbMusica_1MouseClicked

    private void rbMusica_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbMusica_2MouseClicked
        direccion = "D:\\Mis documentos\\Musica\\Puerto Seguro - Búscalo.mp3";
        music.reproducir(direccion);
    }//GEN-LAST:event_rbMusica_2MouseClicked

    private void rbMusica_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbMusica_3MouseClicked
        direccion = "D:\\Mis documentos\\Musica\\Pendiente\\Martin Garrix - Animals (Official Video).mp3";
        music.reproducir(direccion);
    }//GEN-LAST:event_rbMusica_3MouseClicked

    private void rbImportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbImportarMouseClicked
        buscarMusica();
    }//GEN-LAST:event_rbImportarMouseClicked

    private void rbMusica_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMusica_1ActionPerformed
    }//GEN-LAST:event_rbMusica_1ActionPerformed

    private void rbMusica_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMusica_2ActionPerformed
    }//GEN-LAST:event_rbMusica_2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmMusica dialog = new frmMusica(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnImportar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private contenedores.pnlDialog pnlDialog1;
    private javax.swing.JRadioButton rbImportar;
    private javax.swing.JRadioButton rbMusica_1;
    private javax.swing.JRadioButton rbMusica_2;
    private javax.swing.JRadioButton rbMusica_3;
    private javax.swing.JTextField txtDireccion;
    // End of variables declaration//GEN-END:variables
}
