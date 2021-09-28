package simulacion;

import simulacion.eventos.Evento;
import simulacion.random.RandomValue;
import simulacion.variables.resultados.CalculadorDeResultados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Simulador {

    private Simulacion simulacion;
    private Double tiempo = 0.0;

    public Simulador(Simulacion s){
        this.simulacion = s;
    }

    private Evento proximoEvento(){
        Collections.sort(this.simulacion.getEventos(), (e1, e2) -> (int)(e1.getTiempo() - e2.getTiempo()));
        return this.simulacion.getEventos().get(0);
    }

    private void avanzarTiempo(Evento e){
        this.tiempo = RandomValue.round(e.getTiempo());
    }

    private void proximoEventoFuturoNoCondicionado(Evento eventoActual){
        Evento efnc = eventoActual.getEFNC(simulacion);
        if(efnc != null){
            simulacion.getEventos().remove(eventoActual);
            simulacion.getEventos().add(efnc);
        }

    }

    private void actualizarVectorDeEstado(Evento eventoActual){
        eventoActual.ejecutar(this.simulacion);
    }

    private void proximoEventoFuturoCondicionado(Evento eventoActual){
        Evento efc = eventoActual.getEFC();
        if(efc != null){
            simulacion.getEventos().add(efc);
        }
    }

    private boolean finDeSimulacion(){
        return this.tiempo > simulacion.gettF();
    }

    private void imprimirResultados() throws SimulacionException {
        CalculadorDeResultados.calcularResultados(this.simulacion, this.tiempo);
        System.out.println();
        System.out.println("Resultados para las siguietes variables de control:");
        System.out.println("CAPA: "+ simulacion.getVariablesDeControl().getVariableValue("CAPA"));
        System.out.println("CBPA: "+ simulacion.getVariablesDeControl().getVariableValue("CBPA"));
        System.out.println("CCPA: "+ simulacion.getVariablesDeControl().getVariableValue("CCPA"));
        System.out.println("SMA: "+ simulacion.getVariablesDeControl().getVariableValue("SMA"));
        System.out.println("SMB: "+ simulacion.getVariablesDeControl().getVariableValue("SMB"));
        System.out.println("SMC: "+ simulacion.getVariablesDeControl().getVariableValue("SMC"));
        System.out.println("TFRSA: "+ simulacion.getVariablesDeControl().getVariableValue("TFRSA"));
        System.out.println();
        this.simulacion.getVariablesDeResultado().resultados().entrySet().stream().forEach( entry -> {
            System.out.println(entry);
        });

        System.out.println();
        System.out.println("Variables de estado:");
        this.simulacion.getVariablesDeEstado().getEstados().entrySet().stream().forEach( System.out::println);

        System.out.println();
        this.simulacion.getVariablesGlobales().getGlobales().entrySet().stream().forEach( System.out::println);
    }

    public void simular() throws SimulacionException {
        while( !this.finDeSimulacion() ){
            Evento eventoActual = this.proximoEvento();
            this.avanzarTiempo(eventoActual);
            this.proximoEventoFuturoNoCondicionado(eventoActual);
            this.actualizarVectorDeEstado(eventoActual);
            this.proximoEventoFuturoCondicionado(eventoActual);
        }
        this.imprimirResultados();
    }
}
