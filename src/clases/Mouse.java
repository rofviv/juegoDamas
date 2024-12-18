package clases;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    private Game game;
    private byte f, c;
    private byte f1, c1;

    public Mouse(Game game) {
        this.game = game;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        f = (byte) (e.getY() / 64);
        c = (byte) ((e.getX()) / 64);
        game.Cursor(f, c);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        f1 = (byte) (e.getY() / 64);
        c1 = (byte) ((e.getX()) / 64);
        if (game.validarMovimiento(f, c, f1, c1)) {
            game.moverFicha(f, c, f1, c1);
        }
        game.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
}
