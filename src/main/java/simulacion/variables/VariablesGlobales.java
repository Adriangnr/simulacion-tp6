package simulacion.variables;

import java.util.Map;

public class VariablesGlobales extends Variable {

    private Map<String, Double> globales;

    public VariablesGlobales(Map<String, Double> variables){
        super(variables);
        this.globales = variables;
    }

    public Map<String, Double> getGlobales(){
        return this.globales;
    }

    @Override
    protected String getTipo() {
        return "Global";
    }


}
