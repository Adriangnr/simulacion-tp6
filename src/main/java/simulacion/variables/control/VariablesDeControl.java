package simulacion.variables.control;

import simulacion.variables.Variable;

import java.util.Map;

public class VariablesDeControl extends Variable {
    public VariablesDeControl(Map<String, Double> control) {
        super(control);
    }

    @Override
    protected String getTipo() {
        return "Control";
    }
}
