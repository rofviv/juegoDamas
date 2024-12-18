package presentacion;

import com.sun.awt.AWTUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class frmInicio extends javax.swing.JFrame {

    Timer timer;

    public frmInicio() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(360, 600);
        // AWTUtilities.setWindowOpaque(this, false);
        timer = new Timer(50, new Progreso());
        timer.start();
    }

    public class Progreso implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            byte n = (byte) barraProgreso.getValue();
            barraProgreso.setMaximum(100);
            if (n < 100) {
                carga(n++);
                barraProgreso.setValue(n);
            } else {
                timer.stop();
                new frmPrincipal().setVisible(true);
                dispose();
            }
        }

        private void carga(byte n) {
            if (n == 00) {
                lblCarga.setText("Cargando Componentes...");
            }
            if (n == 30) {
                lblCarga.setText("Cargando Interfaz de Usuario...");
            }
            if (n == 50) {
                lblCarga.setText("Cargando Tablero...");
            }
            if (n == 80) {
                lblCarga.setText("Iniciando Módulos...");
            }
            if (n == 90) {
                lblCarga.setText("Bienvenido al juego de damas...");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicio1 = new contenedores.pnlInicio();
        barraProgreso = new javax.swing.JProgressBar();
        lblCarga = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        barraProgreso.setForeground(new java.awt.Color(0, 204, 0));

        lblCarga.setBackground(new java.awt.Color(255, 255, 153));
        lblCarga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCarga.setForeground(new java.awt.Color(255, 255, 255));
        lblCarga.setText("Carga");

        javax.swing.GroupLayout pnlInicio1Layout = new javax.swing.GroupLayout(pnlInicio1);
        pnlInicio1.setLayout(pnlInicio1Layout);
        pnlInicio1Layout.setHorizontalGroup(
            pnlInicio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicio1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnlInicio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCarga)
                    .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        pnlInicio1Layout.setVerticalGroup(
            pnlInicio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicio1Layout.createSequentialGroup()
                .addContainerGap(509, Short.MAX_VALUE)
                .addComponent(lblCarga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(379, 644));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmInicio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JLabel lblCarga;
    private contenedores.pnlInicio pnlInicio1;
    // End of variables declaration//GEN-END:variables
}
