package clases;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

    BufferedImage img;
    public static final byte ANCHO = 64, ALTO = 64;
    private Image dibujoAux = null;
    private Graphics gAux;
    private Dimension dimAux, dimCanvas;
    public static final byte MAX = 12;
    private Casilla[][] tablero;
    private byte dim;
    Jugador player1;
    Jugador player2;
    private Sonido sonido;
    private boolean delete = false;
    private char fichaEliminada;

    public Game(Jugador j1, Jugador j2) {
        this.dim = 8;
        valoresIndispensables();
        this.player1 = j1;
        this.player2 = j2;
    }

    private void valoresIndispensables() {
        tablero = new Casilla[MAX][MAX];
        setLocation(10, 10);
        setSize(dim * 64, dim * 64);
        addMouseListener(new Mouse(this));
        sonido = new Sonido();
        dimCanvas = this.getSize();
    }

    public void activarSonido() {
        sonido.activar();
    }

    public void desactivarSonido() {
        sonido.mute();
    }

    public void setDim(byte d) {
        this.dim = d;
    }

    public byte getDim() {
        return dim;
    }

    public Sonido sonidoGame() {
        return sonido;
    }

    public char getFicha(byte f, byte c) {
        return tablero[f][c].mostrarCasilla();
    }

    public char getFichaEliminada() {
        return fichaEliminada;
    }

    private void setFichaEliminada(char f) {
        fichaEliminada = f;
    }

    public boolean eliminoFicha() {
        return delete;
    }

    public void setDelete(boolean d) {
        delete = d;
    }

    public void inicializar(Casilla c1, Casilla c2) {
        setSize(dim * 64, dim * 64);
        dimCanvas = this.getSize();
        for (byte i = 0; i < dim; i++) {
            for (byte j = 0; j < dim; j++) {
                if ((i + j) % 2 == 0) {
                    tablero[i][j] = new Casilla(null, i, j, c1.getColor());
                } else {
                    tablero[i][j] = new Casilla(null, i, j, c2.getColor());
                }
            }
        }
        repaint();
    }

    public void colocarFichas() {
        for (byte i = 0; i < (dim - 2) / 2; i++) {
            for (byte j = 0; j < dim; j++) {
                if ((i + j) % 2 == 1) {
                    tablero[i][j].setFicha(player1.getFicha());
                }
                if (((dim - (i + 1)) + j) % 2 == 1) {
                    tablero[(dim) - (i + 1)][j].setFicha(player2.getFicha());
                }
            }
        }
        repaint();
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        insertarImagen();
        g.drawImage(dibujoAux, 0, 0, this);
    }

    private void pintarAux() {
        if (gAux == null || dimAux == null || dimCanvas.width != dimAux.width
                || dimCanvas.height != dimAux.height) {
            dimAux = dimCanvas;
            dibujoAux = createImage(dimAux.width, dimAux.height);
            gAux = dibujoAux.getGraphics();
        }
    }

    private void insertarImagen() {
        pintarAux();
        for (byte i = 0; i < dim; i++) {
            for (byte j = 0; j < dim; j++) {
                try {
                    img = ImageIO.read(new File("src/images/piezas/" + this.getFicha(i, j) + ".png"));
                } catch (Exception e) {
                    System.err.println("No se encontro la imagen.");
                }
                gAux.drawImage(img, j * ANCHO, i * ALTO, null);
            }
        }
    }

    public void moverFicha(byte f, byte c, byte f1, byte c1) {
        Ficha auxF = tablero[f][c].getFicha();
        tablero[f][c].setFicha(null);
        tablero[f1][c1].setFicha(auxF);
        repaint();
    }

    private boolean fueraTablero(byte f, byte c, byte f1, byte c1) {
        return ((f + c) % 2 == 0 || (f1 + c1) % 2 == 0 || f < 0 || f >= dim || c < 0 || c >= dim
                || f1 < 0 || f1 >= dim || c1 < 0 || c1 >= dim);
    }

    private boolean cambiarTurno() {
        player1.cambiarTurno();
        player2.cambiarTurno();
        return true;
    }

    private boolean fichaComun(Jugador j, byte f, byte c) {
        return this.getFicha(f, c) == j.getFicha().mostrarFicha();
    }

    private boolean fichaReina(Jugador j, byte f, byte c) {
        return this.getFicha(f, c) == j.getFichaReina().mostrarFicha();
    }

    private boolean casillaDisponible(Jugador j, byte f, byte c, byte f1, byte c1) {
        if (j == player1) {
            return (f + 1) == f1 && (c + 1 == c1 || c - 1 == c1) && tablero[f1][c1].getFicha() == null;
        } else {
            return (f - 1) == f1 && (c + 1 == c1 || c - 1 == c1) && tablero[f1][c1].getFicha() == null;
        }
    }

    public boolean casillaSaltadaDisponible(Jugador j, byte f, byte f1, byte c1) {
        if (j == player1) {
            return (f + 2 == f1) && tablero[f1][c1].getFicha() == null;
        } else {
            return (f - 2 == f1) && tablero[f1][c1].getFicha() == null;
        }
    }

    public boolean eliminarContrario(byte f, byte c, byte c1, Jugador contra) {
        if (contra != player1) {
            return (c1 + 2 == c || c1 - 2 == c) && (getFicha((byte) (f + 1), (byte) ((c + c1) / 2)) == contra.getFicha().mostrarFicha()
                    || getFicha((byte) (f + 1), (byte) ((c + c1) / 2)) == contra.getFichaReina().mostrarFicha());
        } else {
            return (c1 + 2 == c || c1 - 2 == c) && (getFicha((byte) (f - 1), (byte) ((c + c1) / 2)) == contra.getFicha().mostrarFicha()
                    || getFicha((byte) (f - 1), (byte) ((c + c1) / 2)) == contra.getFichaReina().mostrarFicha());
        }
    }

    private void eliminarFicha(byte f, byte c, byte c1, Jugador contra) {
        delete = true;
        if (contra != player1) {
            this.setFichaEliminada(getFicha((byte) (f + 1), (byte) ((c + c1) / 2)));
            tablero[f + 1][(c + c1) / 2].setFicha(null);
        } else {
            this.setFichaEliminada(getFicha((byte) (f - 1), (byte) ((c + c1) / 2)));
            tablero[f - 1][(c + c1) / 2].setFicha(null);
        }
    }

    private void coronar(Jugador actual, byte f, byte c) {
        if (actual == player1) {
            tablero[f][c].setFicha(player1.getFichaReina());
        } else {
            tablero[f][c].setFicha(player2.getFichaReina());
        }
        sonido.reproducir("coronar");
    }

    private boolean posicionReina(Jugador actual, byte f1) {
        if (actual == player1) {
            return f1 == dim - 1;
        } else {
            return f1 == 0;
        }
    }

    public boolean posibilidad(Jugador j1, byte f1, byte c1, Jugador contra) {
        boolean sw = false;
        if (c1 - 2 < 0) {
            if (j1 == player1) {
                if ((f1 + 2 < dim)) {
                    if (casillaSaltadaDisponible(j1, f1, (byte) (f1 + 2), (byte) (c1 + 2)) && eliminarContrario(f1, c1, (byte) (c1 + 2), contra)) {
                        sw = true;
                    }
                }
            } else {
                if ((f1 - 2 >= 0)) {
                    if (casillaSaltadaDisponible(j1, f1, (byte) (f1 - 2), (byte) (c1 + 2)) && eliminarContrario(f1, c1, (byte) (c1 + 2), contra)) {
                        sw = true;
                    }
                }
            }
        } else if (c1 + 2 > dim) {
            if (j1 == player1) {
                if ((f1 + 2 < dim)) {
                    if (casillaSaltadaDisponible(j1, f1, (byte) (f1 + 2), (byte) (c1 - 2)) && (eliminarContrario(f1, c1, (byte) (c1 - 2), contra))) {
                        sw = true;
                    }
                }
            } else {
                if (!(f1 - 2 >= 0)) {
                    if (casillaSaltadaDisponible(j1, f1, (byte) (f1 - 2), (byte) (c1 - 2)) && (eliminarContrario(f1, c1, (byte) (c1 - 2), contra))) {
                        sw = true;
                    }
                }
            }
        } else {
            if (j1 == player1) {
                if ((f1 + 2 < dim && c1 + 2 < dim)) {
                    if ((casillaSaltadaDisponible(j1, f1, (byte) (f1 + 2), (byte) (c1 + 2)))
                            && (eliminarContrario(f1, c1, (byte) (c1 + 2), contra))) {
                        sw = true;
                    } else if ((casillaSaltadaDisponible(j1, f1, (byte) (f1 + 2), (byte) (c1 - 2)))
                            && (eliminarContrario(f1, c1, (byte) (c1 - 2), contra))) {
                        sw = true;
                    }
                }
            } else {
                if ((f1 - 2 >= 0)) {
                    if (casillaSaltadaDisponible(j1, f1, (byte) (f1 - 2), (byte) (c1 + 2))
                            && (eliminarContrario(f1, c1, (byte) (c1 + 2), contra))) {
                        sw = true;
                    } else if (casillaSaltadaDisponible(j1, f1, (byte) (f1 - 2), (byte) (c1 - 2))
                            && (eliminarContrario(f1, c1, (byte) (c1 - 2), contra))) {
                        sw = true;
                    }
                }
            }
        }
        return sw;
    }    
    
    private boolean movimientoFicha(Jugador actual, byte f, byte c, byte f1, byte c1, Jugador contra) {
        boolean sw = false;
        if (casillaDisponible(actual, f, c, f1, c1)) {
            if (posicionReina(actual, f1)) {
                coronar(actual, f, c);
            }
            sonido.reproducir("move");
            sw = cambiarTurno();
        } else if (casillaSaltadaDisponible(actual, f, f1, c1)) {
            if (eliminarContrario(f, c, c1, contra)) {
                eliminarFicha(f, c, c1, contra);
                if (posicionReina(actual, f1)) {
                    coronar(actual, f, c);
                } else if (posibilidad(actual, f1, c1, contra)) {
                    sw = cambiarTurno();
                }
                sonido.reproducir("move2");
                sw = cambiarTurno();
            } else {
                sonido.reproducir("error");
            }
        } else {
            sonido.reproducir("error");
        }
        return sw;
    }

    private boolean movimientoReina(Jugador player, byte f, byte c, byte f1, byte c1, Jugador contra) {
        boolean sw = false;
        byte cont = 0;
        byte auxC = c;
        if ((Math.abs(f1 - c1) == Math.abs(f - c) || f1 + c1 == f + c) && (c != c1 && f != f1) && tablero[f1][c1].getFicha() == null) {
            if (f > f1) {
                for (byte i = (byte) (f - 1); i > f1; i--) {
                    if (auxC > c1) {  //Arriba Iz
                        auxC--;
                        if ((tablero[i][auxC].getFicha() == contra.getFicha()
                                || tablero[i][auxC].getFicha() == contra.getFichaReina())) {
                            cont++;
                            if (cont == 1) {
                                if (f1 == tablero[i][auxC].getPosX() - 1 && c1 == tablero[i][auxC].getPosY() - 1) {
                                    if (player == player1) {
                                        contra = player1;
                                    }
                                    eliminarFicha((byte) (tablero[i][auxC].getPosX() + 1), (byte) (tablero[i][auxC].getPosY() + 1), c1, contra);
                                    sonido.reproducir("move2");
                                    sw = cambiarTurno();
                                    break;
                                } else {
                                    sonido.reproducir("error");
                                }
                            }
                        } else if (tablero[i][auxC].getFicha() != null) {
                            sonido.reproducir("error");
                            cont = 1;
                            break;
                        }
                    } else {
                        auxC++;
                        if ((tablero[i][auxC].getFicha() == contra.getFicha()
                                || tablero[i][auxC].getFicha() == contra.getFichaReina())) {
                            cont++;
                            if (cont == 1) {
                                if (f1 == tablero[i][auxC].getPosX() - 1 && c1 == tablero[i][auxC].getPosY() + 1) {
                                    if (player == player1) {
                                        contra = player1;
                                    }
                                    eliminarFicha((byte) (tablero[i][auxC].getPosX() + 1), (byte) (tablero[i][auxC].getPosY() - 1), c1, contra);
                                    sonido.reproducir("move2");
                                    sw = cambiarTurno();
                                    break;
                                } else {
                                    sonido.reproducir("error");
                                }
                            }
                        } else if (tablero[i][auxC].getFicha() != null) {
                            sonido.reproducir("error");
                            cont = 1;
                            break;
                        }
                    }
                }
            } else {
                for (byte i = (byte) (f + 1); i < f1; i++) {
                    if (auxC > c1) {   // Abajo Izq
                        auxC--;
                        if ((tablero[i][auxC].getFicha() == contra.getFicha()
                                || tablero[i][auxC].getFicha() == contra.getFichaReina())) {
                            cont++;
                            if (cont == 1) {
                                if ((f1 == tablero[i][auxC].getPosX() + 1) && (c1 == tablero[i][auxC].getPosY() - 1)) {
                                    if (contra == player2) {
                                        player = player2;
                                    }
                                    eliminarFicha((byte) (tablero[i][auxC].getPosX() - 1), (byte) (tablero[i][auxC].getPosY() + 1), c1, player);
                                    sonido.reproducir("move2");
                                    sw = cambiarTurno();
                                    break;
                                } else {
                                    sonido.reproducir("error");
                                }
                            }
                        } else if (tablero[i][auxC].getFicha() != null) {
                            sonido.reproducir("error");
                            cont = 1;
                            break;
                        }
                    } else {
                        auxC++;
                        if ((tablero[i][auxC].getFicha() == contra.getFicha()
                                || tablero[i][auxC].getFicha() == contra.getFichaReina())) {
                            cont++;
                            if (cont == 1) {
                                if (((f1 == tablero[i][auxC].getPosX() + 1) && (c1 == tablero[i][auxC].getPosY() + 1))) {
                                    if (contra == player2) {
                                        player = player2;
                                    }
                                    eliminarFicha((byte) (tablero[i][auxC].getPosX() - 1), (byte) (tablero[i][auxC].getPosY() - 1), c1, player);
                                    sonido.reproducir("move2");
                                    sw = cambiarTurno();
                                    break;
                                } else {
                                    sonido.reproducir("error");
                                }
                            }
                        } else if (tablero[i][auxC].getFicha() != null) {
                            sonido.reproducir("error");
                            cont = 1;
                            break;
                        }
                    }
                }
            }
            
            if (cont == 0) {
                sw = cambiarTurno();
                sonido.reproducir("moveReina");
            }
        } else {
            sonido.reproducir("error");
        }
        return sw;
    }

    public boolean validarMovimiento(byte f, byte c, byte f1, byte c1) {
        boolean sw = false;
        if (!(fueraTablero(f, c, f1, c1))) {
            if (player1.getTurno()) {
                if (fichaComun(player1, f, c)) {
                    sw = movimientoFicha(player1, f, c, f1, c1, player2);
                } else if (fichaReina(player1, f, c)) {
                    sw = movimientoReina(player1, f, c, f1, c1, player2);
                } else {
                    sonido.reproducir("error");
                }
            } else if (player2.getTurno()) {
                if (fichaComun(player2, f, c)) {
                    sw = movimientoFicha(player2, f, c, f1, c1, player1);
                } else if (fichaReina(player2, f, c)) {
                    sw = movimientoReina(player2, f, c, f1, c1, player1);
                } else {
                    sonido.reproducir("error");
                }
            }
        } else {
            sonido.reproducir("error");
        }
        return sw;
    }

    public void Cursor(byte f, byte c) {
        if (player1.getTurno() && (fichaComun(player1, f, c) || fichaReina(player1, f, c))) {
            setCursor(new Puntero(this, getFicha(f, c)).getPuntero());
        } else if (player2.getTurno() && (fichaComun(player2, f, c) || fichaReina(player2, f, c))) {
            setCursor(new Puntero(this, getFicha(f, c)).getPuntero());
        }
    }
}
