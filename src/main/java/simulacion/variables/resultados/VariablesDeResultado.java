package simulacion.variables.resultados;

import simulacion.variables.Variable;

import java.util.Map;

public class VariablesDeResultado extends Variable {
    public VariablesDeResultado(Map<String, Double> vars) {
        super(vars);
    }

    public Map<String, Double> resultados(){
        return this.variables;
    }

    @Override
    protected String getTipo() {
        return "Resultado";
    }
}
