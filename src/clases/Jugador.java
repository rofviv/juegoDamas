package clases;

public class Jugador {

    private Ficha ficha;
    private Ficha fichaReina;
    private String nick;
    private boolean turno;

    public Jugador(boolean t, Ficha f, Ficha r) {
        this.turno = t;
        this.ficha = f;
        this.fichaReina = r;
    }

    public Jugador(String n, boolean t, Ficha f, Ficha r) {
        this.nick = n;
        this.turno = t;
        this.ficha = f;
        this.fichaReina = r;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha f) {
        this.ficha = f;
    }

    public Ficha getFichaReina() {
        return fichaReina;
    }

    public void setFichaReina(Ficha r) {
        this.fichaReina = r;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String n) {
        this.nick = n;
    }

    public boolean getTurno() {
        return turno;
    }
    
    public void setTurno(boolean t) {
        this.turno = t;
    }

    public void cambiarTurno() {
        this.turno = !this.turno;
    }
}
