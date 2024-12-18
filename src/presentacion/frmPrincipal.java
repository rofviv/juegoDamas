package presentacion;

import clases.Casilla;
import clases.Ficha;
import clases.Game;
import clases.Jugador;
import clases.SonidoMP3;
import clases.Tiempo;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class frmPrincipal extends javax.swing.JFrame implements Runnable {

    Game game;
    Jugador player1;
    Jugador player2;
    Tiempo tiempo;
    frmAjustes ajustesJuego;
    SonidoMP3 musica;
    Thread hilo;
    String path = "C:\\Users\\Roy Favio\\Documents\\NetBeansProjects\\proyectoDamas\\src\\sonido\\piano.mp3";
    JLabel fichaEliminada;
    boolean juegoTerminado = false;
    boolean partidaNueva = true;

    @Override
    public void run() {
        try {
            while (tiempo.activo()) {
                Thread.sleep(200);
                if (game.eliminoFicha()) {
                    fichasEliminadas();
                }
                jLabel1.setText(cantFichas(player1) + "");
                jLabel3.setText(cantFichas(player2) + "");
                if (cantFichas(player1) == 0 || cantFichas(player2) == 0) {
                    tiempo.detener();
                    JOptionPane.showMessageDialog(this, "Juego terminado.");
                    juegoTerminado = true;
                    hilo.suspend();
                }
                lblTiempo.setText(tiempoGame());
                turno();
            }
        } catch (Exception e) {
            lblTiempo.setText("00:00");
        }
    }

    private boolean juegoTerminado() {
        return juegoTerminado;
    }

    private boolean partidaNueva() {
        return !juegoTerminado;
    }

    private void terminarPartida() {
        tiempo.detener();
        limpiarFichasEliminadas();
        limpiarTablero();
        pnlMensaje.setVisible(true);
        pnlPiezas.setVisible(false);
        juegoTerminado = true;
    }

    private void limpiarTablero() {
        game.inicializar(ajustesJuego.casilla().getCasilla_1(), ajustesJuego.casilla().getCasila_2());
    }

    private void colocarFichaEliminada(JPanel pnl, int x, int y) {
        game.setDelete(false);
        fichaEliminada = new JLabel(new ImageIcon(getClass().getResource("/images/piezas/" + game.getFichaEliminada() + ".png")));
        fichaEliminada.setBounds(x, y, 64, 64);
        pnl.add(fichaEliminada);
        fichaEliminada.setVisible(true);
        pnl.validate();
        pnl.repaint();
    }

    private void fichasEliminadas() {
        if (!player1.getTurno()) {
            colocarFichaEliminada(pnlFichasJ1, (int) (Math.random() * 150), (int) (Math.random() * 83));
        } else {
            colocarFichaEliminada(pnlFichasJ2, (int) (Math.random() * 150), (int) (Math.random() * 83));
        }
    }

    private String tiempoGame() {
        String min, seg;
        if (tiempo.getMinutos() < 10) {
            min = "0" + tiempo.getMinutos();
        } else {
            min = tiempo.getMinutos().toString();
        }
        if (tiempo.getSegundos() < 10) {
            seg = "0" + tiempo.getSegundos();
        } else {
            seg = tiempo.getSegundos().toString();
        }
        return min + ":" + seg;
    }

    private void turno() {
        if (player1.getTurno()) {
            lblTurno1.setVisible(true);
            lblTurno2.setVisible(false);
        } else {
            lblTurno2.setVisible(true);
            lblTurno1.setVisible(false);
        }
    }

    private byte cantFichas(Jugador player) {
        byte cont = 0;
        for (byte i = 0; i < game.getDim(); i++) {
            for (byte j = 0; j < game.getDim(); j++) {
                if (game.getFicha(i, j) == player.getFicha().mostrarFicha()
                        || game.getFicha(i, j) == player.getFichaReina().mostrarFicha()) {
                    cont++;
                }
            }
        }
        return cont;
    }

    private void limpiarFichasEliminadas() {
        pnlFichasJ1.removeAll();
        pnlFichasJ2.removeAll();
        pnlFichasJ1.repaint();
        pnlFichasJ2.repaint();
    }

    public void posicionarElementos() {
        pnlTablero.setBounds(50, 45, game.getDim() * 66 + 3, game.getDim() * 66 + 3);
        pnlTablero.add(game);
        pnlFichasJ1.setBounds(pnlTablero.getWidth() + 110, pnlTablero.getY() + 25, 220, 140);
        pnlFichasJ2.setBounds(pnlTablero.getWidth() + 110, pnlFichasJ1.getHeight() + 295, 220, 140);
        pnlInformacion.setLocation(pnlTablero.getWidth() + 350, 125);
        lblTurno1.setVisible(false);
        lblTurno2.setVisible(false);
    }

    public void iniciar() {
        lblJ1.setText(player1.getNick());
        lblJ2.setText(player2.getNick());
        lblJ1.setIcon(new ImageIcon(getClass().getResource("/images/piezas/" + player1.getFicha().mostrarFicha() + ".png")));
        lblJ2.setIcon(new ImageIcon(getClass().getResource("/images/piezas/" + player2.getFicha().mostrarFicha() + ".png")));
        pnlMensaje.setVisible(false);
        pnlPiezas.setVisible(true);
    }

    private void limpiarJuego() {
        tiempo.detener();
        pnlMensaje.setVisible(true);
        pnlPiezas.setVisible(false);
        limpiarFichasEliminadas();
        game.inicializar(ajustesJuego.casilla().getCasilla_1(), ajustesJuego.casilla().getCasila_2());
    }

    public void valoresPorDefecto() {
        player1 = new Jugador("Jugador 1", true, new Ficha('1'), new Ficha('3'));
        player2 = new Jugador("Jugador 2", false, new Ficha('2'), new Ficha('4'));
        game = new Game(player1, player2);
        game.inicializar(new Casilla('a'), new Casilla('b'));
        posicionarElementos();
        pnlPiezas.setVisible(false);
    }

    public frmPrincipal() {
        setUndecorated(true);
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(getClass().getResource("/images/piezas/1.png")).getImage());
        ajustesJuego = new frmAjustes(this, true);

        musica = new SonidoMP3();
        musica.reproducir(path);
        valoresPorDefecto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTiempo = new javax.swing.JButton();
        pnlFondo = new contenedores.pnlFondo();
        pnlInformacion = new contenedores.pnlInformacion();
        pnlPiezas = new javax.swing.JPanel();
        btnRetirarse = new javax.swing.JButton();
        lblTurno1 = new javax.swing.JLabel();
        lblJ1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblTurno2 = new javax.swing.JLabel();
        lblJ2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlMensaje = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        pnlTablero = new contenedores.pnlTablero();
        pnlFichasJ1 = new javax.swing.JPanel();
        pnlFichasJ2 = new javax.swing.JPanel();
        pnlOpciones = new contenedores.pnlDialog();
        btnJuegoNuevo = new javax.swing.JButton();
        btnAjustes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblMinimizar = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        lblSonido = new javax.swing.JLabel();
        lblMusica = new javax.swing.JLabel();

        btnTiempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setTiempo.png"))); // NOI18N
        btnTiempo.setBorder(null);
        btnTiempo.setBorderPainted(false);
        btnTiempo.setContentAreaFilled(false);
        btnTiempo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTiempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTiempo.setIconTextGap(-3);
        btnTiempo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnTiempo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiempoActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego de machos");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        pnlFondo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFondo.setLayout(null);

        pnlPiezas.setOpaque(false);
        pnlPiezas.setLayout(null);

        btnRetirarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/retirarse2.png"))); // NOI18N
        btnRetirarse.setToolTipText("Rendirse");
        btnRetirarse.setBorder(null);
        btnRetirarse.setBorderPainted(false);
        btnRetirarse.setContentAreaFilled(false);
        btnRetirarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRetirarse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRetirarse.setIconTextGap(-3);
        btnRetirarse.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/retirarse.png"))); // NOI18N
        btnRetirarse.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRetirarse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarseActionPerformed(evt);
            }
        });
        pnlPiezas.add(btnRetirarse);
        btnRetirarse.setBounds(150, 309, 50, 50);

        lblTurno1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTurno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/turno.png"))); // NOI18N
        pnlPiezas.add(lblTurno1);
        lblTurno1.setBounds(21, 70, 24, 24);

        lblJ1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblJ1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblJ1.setText("Player 1");
        pnlPiezas.add(lblJ1);
        lblJ1.setBounds(60, 30, 230, 110);

        jLabel1.setText("jLabel1");
        pnlPiezas.add(jLabel1);
        jLabel1.setBounds(220, 120, 34, 14);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/time.png"))); // NOI18N
        pnlPiezas.add(jLabel2);
        jLabel2.setBounds(78, 144, 32, 39);

        lblTiempo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTiempo.setText("00:00");
        pnlPiezas.add(lblTiempo);
        lblTiempo.setBounds(128, 159, 32, 15);
        pnlPiezas.add(jSeparator2);
        jSeparator2.setBounds(58, 194, 190, 10);

        lblTurno2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTurno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/turno.png"))); // NOI18N
        pnlPiezas.add(lblTurno2);
        lblTurno2.setBounds(21, 247, 24, 24);

        lblJ2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblJ2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblJ2.setText("Player 2");
        pnlPiezas.add(lblJ2);
        lblJ2.setBounds(60, 210, 230, 110);

        jLabel3.setText("jLabel3");
        pnlPiezas.add(jLabel3);
        jLabel3.setBounds(230, 290, 34, 14);

        pnlMensaje.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("<html>Antiguamente juego de Damas...<br>\nEn este dia se llamará...<br>\nJuego de Machos!!</html>");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<html>Feria científica<br> Unibeth 2015 </html>");

        javax.swing.GroupLayout pnlMensajeLayout = new javax.swing.GroupLayout(pnlMensaje);
        pnlMensaje.setLayout(pnlMensajeLayout);
        pnlMensajeLayout.setHorizontalGroup(
            pnlMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMensajeLayout.createSequentialGroup()
                .addGroup(pnlMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMensajeLayout.createSequentialGroup()
                        .addGroup(pnlMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMensajeLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMensajeLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMensajeLayout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlMensajeLayout.setVerticalGroup(
            pnlMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMensajeLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout pnlInformacionLayout = new javax.swing.GroupLayout(pnlInformacion);
        pnlInformacion.setLayout(pnlInformacionLayout);
        pnlInformacionLayout.setHorizontalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(pnlPiezas, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addGap(24, 24, 24))
            .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlInformacionLayout.createSequentialGroup()
                    .addGap(0, 45, Short.MAX_VALUE)
                    .addComponent(pnlMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 45, Short.MAX_VALUE)))
        );
        pnlInformacionLayout.setVerticalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInformacionLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(pnlPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlInformacionLayout.createSequentialGroup()
                    .addGap(0, 70, Short.MAX_VALUE)
                    .addComponent(pnlMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 70, Short.MAX_VALUE)))
        );

        pnlFondo.add(pnlInformacion);
        pnlInformacion.setBounds(600, 80, 370, 470);

        pnlTablero.setBorder(new javax.swing.border.MatteBorder(null));
        pnlTablero.setPreferredSize(new java.awt.Dimension(512, 512));

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        pnlFondo.add(pnlTablero);
        pnlTablero.setBounds(50, 120, 120, 130);

        pnlFichasJ1.setOpaque(false);

        javax.swing.GroupLayout pnlFichasJ1Layout = new javax.swing.GroupLayout(pnlFichasJ1);
        pnlFichasJ1.setLayout(pnlFichasJ1Layout);
        pnlFichasJ1Layout.setHorizontalGroup(
            pnlFichasJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        pnlFichasJ1Layout.setVerticalGroup(
            pnlFichasJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        pnlFondo.add(pnlFichasJ1);
        pnlFichasJ1.setBounds(230, 120, 170, 60);

        pnlFichasJ2.setOpaque(false);

        javax.swing.GroupLayout pnlFichasJ2Layout = new javax.swing.GroupLayout(pnlFichasJ2);
        pnlFichasJ2.setLayout(pnlFichasJ2Layout);
        pnlFichasJ2Layout.setHorizontalGroup(
            pnlFichasJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        pnlFichasJ2Layout.setVerticalGroup(
            pnlFichasJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        pnlFondo.add(pnlFichasJ2);
        pnlFichasJ2.setBounds(230, 190, 170, 60);

        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        pnlOpciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnJuegoNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevoJuego.png"))); // NOI18N
        btnJuegoNuevo.setBorder(null);
        btnJuegoNuevo.setBorderPainted(false);
        btnJuegoNuevo.setContentAreaFilled(false);
        btnJuegoNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJuegoNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnJuegoNuevo.setIconTextGap(-3);
        btnJuegoNuevo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnJuegoNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnJuegoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJuegoNuevoActionPerformed(evt);
            }
        });

        btnAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajustes2.png"))); // NOI18N
        btnAjustes.setBorder(null);
        btnAjustes.setBorderPainted(false);
        btnAjustes.setContentAreaFilled(false);
        btnAjustes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjustes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAjustes.setIconTextGap(-3);
        btnAjustes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajustes.png"))); // NOI18N
        btnAjustes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAjustes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjustesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 102, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tablero.png"))); // NOI18N
        jLabel4.setText("    Juego de Machos....");

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar.png"))); // NOI18N
        lblMinimizar.setToolTipText("Minimizar");
        lblMinimizar.setBorder(new javax.swing.border.MatteBorder(null));
        lblMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizarMouseClicked(evt);
            }
        });

        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salir.png"))); // NOI18N
        lblSalir.setToolTipText("Salir");
        lblSalir.setBorder(new javax.swing.border.MatteBorder(null));
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        lblSonido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/audio.png"))); // NOI18N
        lblSonido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSonido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSonidoMouseClicked(evt);
            }
        });

        lblMusica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/music.png"))); // NOI18N
        lblMusica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMusica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMusicaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(btnJuegoNuevo)
                .addGap(72, 72, 72)
                .addComponent(lblSonido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnAjustes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(lblMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAjustes)
                    .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMinimizar)
                        .addComponent(lblSalir)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOpcionesLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnJuegoNuevo, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(pnlOpcionesLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblSonido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlOpciones, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(1037, 692));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowActivated

    private void lblMusicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMusicaMouseClicked
        if (musica.reproduciendo()) {
            musica.detener();
            lblMusica.setIcon(new ImageIcon(getClass().getResource("/images/notMusic.png")));
        } else {
            musica.reproducir(path);
            lblMusica.setIcon(new ImageIcon(getClass().getResource("/images/music.png")));
        }
    }//GEN-LAST:event_lblMusicaMouseClicked

    private void lblSonidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSonidoMouseClicked
        if (game.sonidoGame().activo()) {
            game.desactivarSonido();
            lblSonido.setIcon(new ImageIcon(getClass().getResource("/images/mute.png")));
        } else {
            game.activarSonido();
            lblSonido.setIcon(new ImageIcon(getClass().getResource("/images/audio.png")));
        }
    }//GEN-LAST:event_lblSonidoMouseClicked

    private void btnTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiempoActionPerformed
//        tiempo = new Tiempo((Integer) 1, (Integer) 20 + 1);
//        tiempo.cuentaAtras(true);
//        iniciar();
    }//GEN-LAST:event_btnTiempoActionPerformed

    private void btnRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarseActionPerformed
        int r = JOptionPane.showOptionDialog(this, "Desea realmente abandonar la partida?", "Retirarse", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, null, new String[]{"Si, retirarse", "No"}, 1);
        if (r == 0) {
            JOptionPane.showMessageDialog(this, "Abandono el menos macho...");
            limpiarJuego();
            game.inicializar(ajustesJuego.casilla().getCasilla_1(), ajustesJuego.casilla().getCasila_2());
        }
    }//GEN-LAST:event_btnRetirarseActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            JOptionPane.showMessageDialog(this, "escape");
        }
    }//GEN-LAST:event_formKeyPressed

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblSalirMouseClicked

    private void lblMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMouseClicked
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    }//GEN-LAST:event_formMouseClicked

    private void btnJuegoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJuegoNuevoActionPerformed
        tiempo = new Tiempo();
        tiempo.activar();
        game.inicializar(ajustesJuego.casilla().getCasilla_1(), ajustesJuego.casilla().getCasila_2());
        game.colocarFichas();
        limpiarFichasEliminadas();
        if (juegoTerminado) {
            hilo.resume();
            juegoTerminado = false;
        } else if (partidaNueva) {
            hilo = new Thread(this);
            hilo.start();
            partidaNueva = false;
        }
        iniciar();
    }//GEN-LAST:event_btnJuegoNuevoActionPerformed

    private void btnAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjustesActionPerformed
        if ((partidaNueva && !juegoTerminado)) {
            ajustesJuego.juego(game, player1, player2, musica);
            ajustesJuego.setVisible(true);
            game.inicializar(ajustesJuego.casilla().getCasilla_1(), ajustesJuego.casilla().getCasila_2());
            this.path = ajustesJuego.elegirMusica.getDireccion();
            posicionarElementos();
        } else {
            int r = JOptionPane.showOptionDialog(this, "Se perderá la partida actual.", "Advertencia", JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, new Object[]{"Continuar", "Cancelar"}, 1);
            if (r == 0) {
                terminarPartida();
                ajustesJuego.juego(game, player1, player2, musica);
                ajustesJuego.setVisible(true);
                game.inicializar(ajustesJuego.casilla().getCasilla_1(), ajustesJuego.casilla().getCasila_2());
                this.path = ajustesJuego.elegirMusica.getDireccion();
                posicionarElementos();
            }
        }
    }//GEN-LAST:event_btnAjustesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnJuegoNuevo;
    private javax.swing.JButton btnRetirarse;
    private javax.swing.JButton btnTiempo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblJ1;
    private javax.swing.JLabel lblJ2;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblMusica;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblSonido;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTurno1;
    private javax.swing.JLabel lblTurno2;
    private javax.swing.JPanel pnlFichasJ1;
    private javax.swing.JPanel pnlFichasJ2;
    private contenedores.pnlFondo pnlFondo;
    private contenedores.pnlInformacion pnlInformacion;
    private javax.swing.JPanel pnlMensaje;
    private contenedores.pnlDialog pnlOpciones;
    private javax.swing.JPanel pnlPiezas;
    private contenedores.pnlTablero pnlTablero;
    // End of variables declaration//GEN-END:variables
}
