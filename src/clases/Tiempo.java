package clases;

public class Tiempo implements Runnable {

    boolean cuentaAtras;
    boolean activo;
    boolean suspendido;
    Thread hilo;
    Integer dia, hora, minutos, segundos, milesima;

    public Tiempo() {
        dia = hora = minutos = segundos = milesima = 0;
        hilo = new Thread(this);
        suspendido = false;
        cuentaAtras = false;
    }

    public Tiempo(Integer min, Integer seg) {
        dia = hora = 0;
        minutos = min;
        segundos = seg;
        milesima = 4;
        hilo = new Thread(this);
    }
    
    public void todoCero() {
        dia = hora = minutos = segundos = milesima = 0;
    }

    public void cuentaAtras(boolean t) {
        cuentaAtras = t;
    }

    public boolean activo() {
        return activo;
    }

    public boolean suspendido() {
        return suspendido;
    }

    public Integer getDia() {
        return dia;
    }

    public Integer getHora() {
        return hora;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public Integer getSegundos() {
        return segundos;
    }

    public Integer getMilesima() {
        return milesima;
    }

    public void activar() {
        if (suspendido == false && activo == false) {
            this.activo = true;
            hilo.start();
        } else {
            hilo.resume();
            suspendido = false;
        }
    }

    public void pausar() {
        hilo.suspend();
        suspendido = true;
    }

    public void detener() {
        hilo.suspend();
        dia = hora = minutos = segundos = milesima = 0;
        activo = false;
        suspendido = true;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public void setSegundos(Integer segundos) {
        this.segundos = segundos;
    }

    public void setMilesima(Integer milesima) {
        this.milesima = milesima;
    }

    private void contar() throws Exception {
        Thread.sleep(4);
        milesima += 4;
        if (milesima == 1000) {
            milesima = 0;
            segundos++;
            if (segundos == 60) {
                segundos = 0;
                minutos++;
                if (minutos == 60) {
                    minutos = 0;
                    hora++;
                    if (hora == 24) {
                        hora = 0;
                        dia++;
                    }
                }
            }
        }
    }

    private void descontar() throws Exception {
        Thread.sleep(4);
        milesima -= 4;
        if (milesima == 0) {
            segundos--;
            if (terminoTiempo()) {
                System.out.println("Se acabo");
                hilo.suspend();
            }
            milesima = 1000;
            if (segundos == 0) {
                if (getMinutos().equals(0)) {
                    segundos = 0;
                } else {
                    segundos = 59;
                    minutos--;
                }
                if (minutos >= 0) {
                    if (getHora().equals(0)) {
                        minutos = 0;
                    } else {
                        minutos = 59;
                        hora--;
                    }
                    if (hora >= 0) {
                        hora = 24;
                        dia--;
                    }
                }
            }
        }
    }

    private boolean terminoTiempo() {
        return getDia().equals(0) && getHora().equals(0) && getMinutos().equals(0) && getSegundos().equals(0) && getMilesima().equals(0);
    }

    @Override
    public void run() {
        while (activo) {
            try {
                if (!cuentaAtras) {
                    contar();
                } else {
                    descontar();
                }
            } catch (Exception ex) {
                //
            }
        }
    }
}
