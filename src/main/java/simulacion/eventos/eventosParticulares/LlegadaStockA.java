package simulacion.eventos.eventosParticulares;

import simulacion.Simulacion;
import simulacion.SimulacionException;
import simulacion.eventos.Evento;

import java.util.logging.Level;

public class LlegadaStockA extends Evento {

    private static final int KILOS_POR_BOLSA = 20;

    public LlegadaStockA(String n, Double t) {
        super(n, t);
    }

    @Override
    public void ejecutar(Simulacion s) {
        try{
            this.actualizarCSX(s);
            this.actualizarSX(s);
            this.actualizarCVCPA(s);
        }
        catch (SimulacionException exception){
            logger.log(Level.SEVERE, exception.getMessage());
        }
    }

    @Override
    public Evento getEFNC(Simulacion s) {
        //TODO: preguntar cada cuanto se compra stock A
        return new LlegadaStockA("LLA", this.getTiempoProximoEvento(s));
    }

    @Override
    public Evento getEFC() {
        return null;
    }

    @Override
    public Double getTiempoProximoEvento(Simulacion s) {
        try {
            return this.getTiempo() + s.getVariablesDeControl().getVariableValue("TFRSA");
        } catch (SimulacionException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private void actualizarCSX(Simulacion s) throws SimulacionException {
        //CSA = CSA+SA
        Double csa = s.getVariablesGlobales().getVariableValue("CSA")+ s.getVariablesDeEstado().getVariableValue("SA");
        s.getVariablesGlobales().setValue("CSA", csa);

        //CSB = CSB+SB
        Double csb = s.getVariablesGlobales().getVariableValue("CSB")+ s.getVariablesDeEstado().getVariableValue("SB");
        s.getVariablesGlobales().setValue("CSB", csb);

        //CSC = CSC+SC
        Double csc = s.getVariablesGlobales().getVariableValue("CSC")+ s.getVariablesDeEstado().getVariableValue("SC");
        s.getVariablesGlobales().setValue("CSC", csc);
    }

    private void actualizarSX(Simulacion s) throws SimulacionException {
        //SA=SA+CAPA*20
        Double sa = s.getVariablesDeEstado().getVariableValue("SA") + s.getVariablesDeControl().getVariableValue("CAPA")*KILOS_POR_BOLSA ;
        s.getVariablesDeEstado().setValue("SA", sa);

        //SB=SB+CBPA*20
        Double sb = s.getVariablesDeEstado().getVariableValue("SB") + s.getVariablesDeControl().getVariableValue("CBPA")*KILOS_POR_BOLSA ;
        s.getVariablesDeEstado().setValue("SB", sb);

        //SC=SC+CCPA*20
        Double sc = s.getVariablesDeEstado().getVariableValue("SC") + s.getVariablesDeControl().getVariableValue("CCPA")*KILOS_POR_BOLSA ;
        s.getVariablesDeEstado().setValue("SC", sc);
    }

    public void actualizarCVCPA(Simulacion s) throws SimulacionException {
        //CVCPA=CVCPA+1
        Double cvcpa = s.getVariablesGlobales().getVariableValue("CVCPA") + 1;
        s.getVariablesGlobales().setValue("CVCPA", cvcpa);
    }
}
