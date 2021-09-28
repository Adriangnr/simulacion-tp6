package simulacion.eventos;

import simulacion.Simulacion;

import java.util.logging.Logger;

public abstract class Evento {
    private String nombre;
    private Double tiempo;

    protected static final Logger logger = Logger.getLogger(Evento.class.getName());

    public Evento(String n, Double t){
        this.nombre = n;
        this.tiempo = t;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTiempo() {
        return tiempo;
    }

    public void setTiempo(Double tiempo) {
        this.tiempo = tiempo;
    }

    public abstract void ejecutar(Simulacion s);

    public abstract Evento getEFNC(Simulacion s);

    public abstract Evento getEFC();

    public abstract Double getTiempoProximoEvento(Simulacion s);
}
