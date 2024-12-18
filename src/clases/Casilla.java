package clases;

public class Casilla {

    private Ficha ficha;
    private byte x;
    private byte y;
    private char color;

    public Casilla(char c) {
        this.color = c;
    }

    public Casilla(Ficha f, byte x, byte y, char c) {
        this.ficha = f;
        this.x = x;
        this.y = y;
        this.color = c;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha f) {
        this.ficha = f;
    }
    
    public byte getPosX() {
        return x;
    }
    
    public byte getPosY() {
        return y;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char c) {
        this.color = c;
    }

    public char mostrarCasilla() {
        if (ficha == null) {
            if (this.x % 2 == this.y % 2) {
                return color;
            } else {
                return color;
            }
        } else {
            return ficha.mostrarFicha();
        }

    }
}
