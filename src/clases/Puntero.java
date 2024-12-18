package clases;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Puntero {

    Cursor puntero;
    Image cursor;

    public Puntero(Game g, char n) {
        cursor = new ImageIcon(getClass().getResource("/images/piezas/" + n + ".png")).getImage();
        puntero = g.getToolkit().createCustomCursor(cursor, new Point(5, 5), "none");
    }

    public Cursor getPuntero() {
        return puntero;
    }
}
