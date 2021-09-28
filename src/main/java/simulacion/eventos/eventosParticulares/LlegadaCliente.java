package simulacion.eventos.eventosParticulares;

import simulacion.Simulacion;
import simulacion.SimulacionException;
import simulacion.eventos.Evento;
import simulacion.random.RandomValue;

import java.util.Random;
import java.util.logging.Level;

public class LlegadaCliente extends Evento {
    public LlegadaCliente(String n, Double t) {
        super(n, t);
    }

    @Override
    public void ejecutar(Simulacion s) {
        //Arrepentimiento
        try{
            Double r = RandomValue.random();

            if(r < 0.2151){
                Double cca = s.getDatos().getDato("CCA").obtenerValor();
                Double sa = s.getVariablesDeEstado().getVariableValue("SA");
                Double cnva = s.getVariablesGlobales().getVariableValue("CNVA");
                if(seArrepientePorStock(cca, sa)){
                    cnva = cnva + cca;
                    s.getVariablesGlobales().setValue("CNVA", cnva);
                }else{
                    if(sa < cca){
                        cnva = cnva + cca - sa;
                        sa = 0.0;
                        s.getVariablesDeEstado().setValue("SA", sa);
                                             s.getVariablesGlobales().setValue("CNVA", cnva);
                                             Double ca = s.getVariablesGlobales().getVariableValue("clientesA");
                         s.getVariablesGlobales().setValue("clientesA", ca+1);
                    }
                    else{
                        sa = sa - cca;
                        s.getVariablesDeEstado().setValue("SA", sa);
                        Double ca = s.getVariablesGlobales().getVariableValue("clientesA");
                        s.getVariablesGlobales().setValue("clientesA", ca+1);
                                            }
                }
            }
            else{
                if(r < 0.4678){
                    Double ccb = s.getDatos().getDato("CCB").obtenerValor();
                    Double sb = s.getVariablesDeEstado().getVariableValue("SB");
                    Double cnvb = s.getVariablesGlobales().getVariableValue("CNVB");
                    if( seArrepientePorStock(ccb, sb)){
                        cnvb = cnvb + ccb;
                        s.getVariablesGlobales().setValue("CNVB", cnvb);
                    }
                    else{
                        if(sb < ccb){
                            cnvb = cnvb + ccb - sb;
                            sb = 0.0;
                            s.getVariablesGlobales().setValue("CNVB", cnvb);
                            s.getVariablesDeEstado().setValue("SB", sb);
                            Double cb = s.getVariablesGlobales().getVariableValue("clientesB");
                            s.getVariablesGlobales().setValue("clientesB", cb+1);
                        }else{
                            sb = sb - ccb;
                            s.getVariablesDeEstado().setValue("SB", sb);
                            Double cb = s.getVariablesGlobales().getVariableValue("clientesB");
                            s.getVariablesGlobales().setValue("clientesB", cb+1);
                        }
                    }
                }
                else{
                    Double ccc = s.getDatos().getDato("CCC").obtenerValor();
                    Double sc = s.getVariablesDeEstado().getVariableValue("SC");
                    Double cnvc = s.getVariablesGlobales().getVariableValue("CNVC");

                    if( seArrepientePorStock(ccc, sc) ){
                        cnvc = cnvc + ccc;
                        s.getVariablesGlobales().setValue("CNVC", cnvc);
                    }else{
                        if( sc < ccc ){
                            cnvc = cnvc - sc;
                            sc = 0.0;
                            s.getVariablesDeEstado().setValue("SC", sc);
                            s.getVariablesGlobales().setValue("CNVC", cnvc);
                            Double cc = s.getVariablesGlobales().getVariableValue("clientesC");
                            s.getVariablesGlobales().setValue("clientesC", cc+1);
                        }else{
                            sc = sc - ccc;
                            s.getVariablesDeEstado().setValue("SC", sc);
                            Double cc = s.getVariablesGlobales().getVariableValue("clientesC");
                            s.getVariablesGlobales().setValue("clientesC", cc+1);
                        }
                    }
                }
            }
        }catch (SimulacionException exception){
            logger.log(Level.SEVERE, exception.getMessage());
        }
    }

    @Override
    public Evento getEFNC(Simulacion s) {
        return new LlegadaCliente("LLC", this.getTiempoProximoEvento(s));
    }

    @Override
    public Evento getEFC() {
        return null;
    }

    @Override
    public Double getTiempoProximoEvento(Simulacion s) {
        return s.getDatos().getDato("IA").obtenerValor() + this.getTiempo();
    }

    private boolean seArrepientePorStock(Double ccx, Double sx){

        if( sx < ccx ){
            Double p = (sx / ccx);
            if( p < 0.35){
                return true;
            } else if(p < 0.75){
                Double r = (new Random()).nextDouble();
                if(r < 0.6){
                    return true;
                }else{
                    return false;
                }
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }
}
