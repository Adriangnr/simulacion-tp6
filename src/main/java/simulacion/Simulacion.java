package simulacion;

import simulacion.eventos.Evento;
import simulacion.variables.VariablesGlobales;
import simulacion.variables.control.VariablesDeControl;
import simulacion.variables.datos.Datos;
import simulacion.variables.estado.VariablesDeEstado;
import simulacion.variables.resultados.VariablesDeResultado;

import java.util.List;

public class Simulacion {

    private Double tF;
    private VariablesDeControl variablesDeControl;
    private VariablesGlobales variablesGlobales;
    private VariablesDeEstado variablesDeEstado;
    private VariablesDeResultado variablesDeResultado;
    private Datos datos;
    private List<Evento> eventos;

    public Simulacion(Double tF, List<Evento> e){
        this.tF = tF;
        this.eventos = e;
    }

    public List<Evento> getEventos(){
        return this.eventos;
    }

    public void setVariablesGlobales(VariablesGlobales vg){
        this.variablesGlobales = vg;
    }

    public void setVariablesDeControl(VariablesDeControl vc){
        this.variablesDeControl = vc;
    }

    public void setVariablesDeResultado(VariablesDeResultado vr){
        this.variablesDeResultado = vr;
    }

    public void setVariablesDeEstado(VariablesDeEstado ve){
        this.variablesDeEstado = ve;
    }

    public void setDatos(Datos d){
        this.datos = d;
    }

    public Double gettF() {
        return tF;
    }

    public VariablesDeControl getVariablesDeControl() {
        return variablesDeControl;
    }

    public VariablesGlobales getVariablesGlobales() {
        return variablesGlobales;
    }

    public VariablesDeEstado getVariablesDeEstado() {
        return variablesDeEstado;
    }

    public VariablesDeResultado getVariablesDeResultado() {
        return variablesDeResultado;
    }

    public Datos getDatos() {
        return datos;
    }

    public void setEventos(List<Evento> nuevosEventos) {
        this.eventos = nuevosEventos;
    }
}
