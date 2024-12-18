package clases;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

public class Sonido {

    private JButton btn;
    private Clip clip;
    private String tipo = "";
    private String path = "/sonido/";
    private boolean activo;

    public Sonido() {
        this.activo = true;
    }

    public Sonido(Object obj, boolean a) {
        this.activo = a;
        MouseListener mouse = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (tipo.equals("button")) {
                    reproducir("move");
                }
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                if (tipo.equals("button")) {
                    reproducir("move2");
                }
            }
        };
        if (obj instanceof javax.swing.JButton) {
            btn = (JButton) obj;
            btn.addMouseListener(mouse);
            this.tipo = "button";
        }
    }

    public boolean activo() {
        return activo;
    }

    public void activar() {
        this.activo = true;
    }

    public void mute() {
        this.activo = false;
    }

    public void reproducir(String sonido) {
        if (activo) {
            try {
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path + sonido + ".wav")));
                clip.start();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                System.err.println("Error al reproducir el sonido.");
            }
        }
    }
}
