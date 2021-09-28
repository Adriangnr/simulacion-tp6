package simulacion;

import org.junit.Test;
import simulacion.eventos.Evento;
import simulacion.eventos.eventosParticulares.LlegadaCliente;
import simulacion.eventos.eventosParticulares.LlegadaStockA;
import simulacion.eventos.eventosParticulares.LlegadaStockB;
import simulacion.variables.VariablesGlobales;
import simulacion.variables.control.VariablesDeControl;
import simulacion.variables.datos.Dato;
import simulacion.variables.datos.Datos;
import simulacion.variables.datos.datosParticulares.CantidadCompradaDeComidaA;
import simulacion.variables.datos.datosParticulares.CantidadCompradaDeComidaB;
import simulacion.variables.datos.datosParticulares.CantidadCompradaDeComidaC;
import simulacion.variables.datos.datosParticulares.IntervaloEntreArrivosDeClientes;
import simulacion.variables.estado.VariablesDeEstado;
import simulacion.variables.resultados.VariablesDeResultado;

import java.util.*;

public class SimuladorTest {

    @Test
    public void simularTest() throws SimulacionException {

        List<Evento> eventos = new ArrayList<>();
        eventos.add(new LlegadaCliente("LLC", 20.0));
        eventos.add(new LlegadaStockA("LLSA", 0.0));
        eventos.add(new LlegadaStockB("LLSB", 1440.0));

        Simulacion simulacion = new Simulacion(61920.0*500, eventos);

        Map<String, Dato> valores = new HashMap<String, Dato>();
        valores.put("IA", new IntervaloEntreArrivosDeClientes());
        valores.put("CCA", new CantidadCompradaDeComidaA());
        valores.put("CCB", new CantidadCompradaDeComidaB());
        valores.put("CCC", new CantidadCompradaDeComidaC());

        Datos datos = new Datos(valores);
        simulacion.setDatos(datos);

        Map<String, Double> estados = new HashMap<String, Double>();
        estados.put("SA", 0.0);
        estados.put("SB", 0.0);
        estados.put("SC", 0.0);
        VariablesDeEstado variablesDeEstado = new VariablesDeEstado(estados);
        simulacion.setVariablesDeEstado(variablesDeEstado);

        Map<String, Double> globales = new HashMap<>();
        globales.put("CSA", 0.0);
        globales.put("CSB", 0.0);
        globales.put("CSC", 0.0);
        globales.put("CVCPA", 0.0);
        globales.put("CCPB", 0.0);
        globales.put("CNVA", 0.0);
        globales.put("CNVB", 0.0);
        globales.put("CNVC", 0.0);
        globales.put("CCAPB", 0.0);
        globales.put("CCBPB", 0.0);
        globales.put("CCCPB", 0.0);

        globales.put("clientesA", 0.0);
        globales.put("clientesB", 0.0);
        globales.put("clientesC", 0.0);
        VariablesGlobales variablesGlobales = new VariablesGlobales(globales);
        simulacion.setVariablesGlobales(variablesGlobales);

        Map<String, Double> control = new HashMap<>();
        control.put("CAPA", 2.0);
        control.put("CBPA", 3.0);
        control.put("CCPA", 8.0);
        control.put("SMA", 5.0);
        control.put("SMB", 7.0);
        control.put("SMC", 40.0);
        control.put("TFRSA", 2880.0);
        VariablesDeControl variablesDeControl = new VariablesDeControl(control);
        simulacion.setVariablesDeControl(variablesDeControl);

        Map<String, Double> resultados = new LinkedHashMap<>();
        resultados.put("PCNVA", 0.0);
        resultados.put("PCNVB", 0.0);
        resultados.put("PCNVC", 0.0);

        resultados.put("PCSA", 0.0);
        resultados.put("PCSB", 0.0);
        resultados.put("PCSC", 0.0);

        resultados.put("PCAPB", 0.0);
        resultados.put("PCBPB", 0.0);
        resultados.put("PCCPB", 0.0);
        simulacion.setVariablesDeResultado(new VariablesDeResultado(resultados));

        Simulador simulador = new Simulador(simulacion);
        simulador.simular();
    }
}
