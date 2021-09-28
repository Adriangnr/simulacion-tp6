package simulacion.variables.estado;

import simulacion.variables.Variable;

import java.util.Map;

public class VariablesDeEstado extends Variable {

    private Map<String, Double> estado;

    public VariablesDeEstado(Map<String, Double> vars){
        super(vars);
        this.estado = vars;
    }

    public Map<String, Double> getEstados(){
        return this.estado;
    }

    protected String getTipo(){
        return "Estado";
    }
}
