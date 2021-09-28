package simulacion.eventos.eventosParticulares;

import simulacion.Simulacion;
import simulacion.SimulacionException;
import simulacion.eventos.Evento;

import java.util.logging.Level;

public class LlegadaStockB extends Evento {
    private static final double TLLPB = 2880.0;
    private static final int KILOS_POR_BOLSA = 20;

     public LlegadaStockB(String n, Double t) {
        super(n, t);
    }

    @Override
    public void ejecutar(Simulacion s) {

         this.checkearStockMinimo(s);
    }

    @Override
    public Evento getEFNC(Simulacion s) {
         return new LlegadaStockB("LLB", this.getTiempoProximoEvento(s));
    }

    @Override
    public Evento getEFC() {
        return null;
    }

    @Override
    public Double getTiempoProximoEvento(Simulacion s) {
        return this.getTiempo()+TLLPB;
    }

    private void checkearStockMinimo(Simulacion s){
         this.checkearStockMinimoDeA(s);
         this.checkearStockMinimoDeB(s);
         this.checkearStockMinimoDeC(s);
    }

    private void checkearStockMinimoDeA(Simulacion s){
        try{
            Double sa = s.getVariablesDeEstado().getVariableValue("SA");
            Double sma = s.getVariablesDeControl().getVariableValue("SMA");

            Double ccapb = s.getVariablesGlobales().getVariableValue("CCAPB");

            if(sa < sma){
                sa=sa+KILOS_POR_BOLSA;
                ccapb = ccapb + KILOS_POR_BOLSA;
                s.getVariablesGlobales().setValue("CCAPB", ccapb);
                s.getVariablesDeEstado().setValue("SA", sa);

                this.checkearStockMinimoDeA(s);
            }
            else{
             return;
            }
        }
        catch (SimulacionException exception){
            logger.log(Level.SEVERE, exception.getMessage());
        }
    }

    private void checkearStockMinimoDeB(Simulacion s){
        try{
            Double sb = s.getVariablesDeEstado().getVariableValue("SB");
            Double smb = s.getVariablesDeControl().getVariableValue("SMB");

            Double ccbpb = s.getVariablesGlobales().getVariableValue("CCBPB");
            if(sb < smb){
                sb=sb+KILOS_POR_BOLSA;
                ccbpb = ccbpb + KILOS_POR_BOLSA;
                s.getVariablesGlobales().setValue("CCBPB", ccbpb);
                s.getVariablesDeEstado().setValue("SB", sb);
                this.checkearStockMinimoDeB(s);
            }else{
                return;
            }

        }
        catch (SimulacionException exception){
            logger.log(Level.SEVERE, exception.getMessage());
        }
    }

    private void checkearStockMinimoDeC(Simulacion s){
        try{
            Double sc = s.getVariablesDeEstado().getVariableValue("SC");
            Double smc = s.getVariablesDeControl().getVariableValue("SMC");

            Double cccpb = s.getVariablesGlobales().getVariableValue("CCCPB");
            if(sc < smc){
                sc=sc+KILOS_POR_BOLSA;
                cccpb = cccpb + KILOS_POR_BOLSA;
                s.getVariablesGlobales().setValue("CCCPB", cccpb);
                s.getVariablesDeEstado().setValue("SC", sc);
                this.checkearStockMinimoDeC(s);
            }else{
                return;
            }

        }
        catch (SimulacionException exception){
            logger.log(Level.SEVERE, exception.getMessage());
        }
    }
}
