package simulacion.variables.resultados;

import simulacion.Simulacion;
import simulacion.SimulacionException;

public class CalculadorDeResultados {

    public static void calcularResultados(Simulacion s, Double tiempo){
        try {
            calcularPCNVA(s, tiempo);
            calcularPCNVB(s, tiempo);
            calcularPCNVC(s, tiempo);

            calcularPCSA(s, tiempo);
            calcularPCSB(s, tiempo);
            calcularPCSC(s, tiempo);

            calcularPCAPB(s, tiempo);
            calcularPCBPB(s, tiempo);
            calcularPCCPB(s, tiempo);

        } catch (SimulacionException exception) {
            exception.printStackTrace();
        }
    }

    private static void calcularPCNVA(Simulacion s, Double tiempo) throws SimulacionException {
        //PCNVA=CNVA/(T/TFRSA)
        Double cnva = s.getVariablesGlobales().getVariableValue("CNVA");
        Double tfrsa = s.getVariablesDeControl().getVariableValue("TFRSA");
        Double pcnva = cnva/(tiempo/tfrsa);
        s.getVariablesDeResultado().setValue("PCNVA", pcnva);
    }

    private static void calcularPCNVB(Simulacion s, Double tiempo) throws SimulacionException {
        //PCNVB=CNVB/(T/TFRSA)
        Double cnvb = s.getVariablesGlobales().getVariableValue("CNVB");
        Double tfrsa = s.getVariablesDeControl().getVariableValue("TFRSA");
        Double pcnvb = cnvb/(tiempo/tfrsa);
        s.getVariablesDeResultado().setValue("PCNVB", pcnvb);
    }

    private static void calcularPCNVC(Simulacion s, Double tiempo) throws SimulacionException {
        //PCNVC=CNVC/(T/TFRSA)
        Double cnvc = s.getVariablesGlobales().getVariableValue("CNVC");
        Double tfrsa = s.getVariablesDeControl().getVariableValue("TFRSA");
        Double pcnvc = cnvc/(tiempo/tfrsa);
        s.getVariablesDeResultado().setValue("PCNVC", pcnvc);
    }

    private static void calcularPCSA(Simulacion s, Double tiempo) throws SimulacionException {
        //PCSA=CSA/(T/TFRSA)
        Double csa = s.getVariablesGlobales().getVariableValue("CSA");
        Double tfrsa = s.getVariablesDeControl().getVariableValue("TFRSA");
        Double pcsa = csa/(tiempo/tfrsa);
        s.getVariablesDeResultado().setValue("PCSA", pcsa);
    }

    private static void calcularPCSB(Simulacion s, Double tiempo) throws SimulacionException {
        //PCSB=CSB/(T/TFRSA)
        Double csb = s.getVariablesGlobales().getVariableValue("CSB");
        Double tfrsa = s.getVariablesDeControl().getVariableValue("TFRSA");
        Double pcsb = csb/(tiempo/tfrsa);
        s.getVariablesDeResultado().setValue("PCSB", pcsb);
    }

    private static void calcularPCSC(Simulacion s, Double tiempo) throws SimulacionException {
        //PCSC=CSC/(T/TFRSA)
        Double csc = s.getVariablesGlobales().getVariableValue("CSC");
        Double tfrsa = s.getVariablesDeControl().getVariableValue("TFRSA");
        Double pcsc = csc/(tiempo/tfrsa);
        s.getVariablesDeResultado().setValue("PCSC", pcsc);
    }

    private static void calcularPCAPB(Simulacion s, Double tiempo) throws SimulacionException {
        // PCAPB=CCAPB/(CCAPB+CAPA*20*CVCPA)
        Double ccapb = s.getVariablesGlobales().getVariableValue("CCAPB");
        Double capa = s.getVariablesDeControl().getVariableValue("CAPA");
        Double cvcpa = s.getVariablesGlobales().getVariableValue("CVCPA");
        Double pcapb = ccapb / (ccapb+capa*20*cvcpa);
        s.getVariablesDeResultado().setValue("PCAPB", pcapb);
    }

    private static void calcularPCBPB(Simulacion s, Double tiempo) throws SimulacionException {
        // PCBPB=CCBPB/(CCBPB+CBPA*20*CVCPA)
        Double ccbpb = s.getVariablesGlobales().getVariableValue("CCBPB");
        Double cbpa = s.getVariablesDeControl().getVariableValue("CBPA");
        Double cvcpa = s.getVariablesGlobales().getVariableValue("CVCPA");
        Double pcbpb = ccbpb / (ccbpb+cbpa*20*cvcpa);
        s.getVariablesDeResultado().setValue("PCBPB", pcbpb);
    }

    private static void calcularPCCPB(Simulacion s, Double tiempo) throws SimulacionException {
        // PCCPB=CCCPB/(CCCPB+CCPA*20*CVCPA)
        Double cccpb = s.getVariablesGlobales().getVariableValue("CCCPB");
        Double ccpa = s.getVariablesDeControl().getVariableValue("CCPA");
        Double cvcpa = s.getVariablesGlobales().getVariableValue("CVCPA");
        Double pccpb = cccpb / (cccpb+ccpa*20*cvcpa);
        s.getVariablesDeResultado().setValue("PCCPB", pccpb);
    }
}
