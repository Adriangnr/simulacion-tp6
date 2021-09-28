package simulacion.variables;

import simulacion.SimulacionException;
import simulacion.random.RandomValue;

import java.util.Map;

public abstract class Variable {

    protected Map<String, Double> variables;

    protected Variable(Map<String, Double> vars){
        this.variables = vars;
    }

    protected abstract String getTipo();

    public Double getVariableValue(String name) throws SimulacionException {
        if(this.variables.containsKey(name)){
            return RandomValue.round(this.variables.get(name));
        }
        throw new SimulacionException("La variable de tipo "+ this.getTipo()+": "+name+" no existe.");
    }

    public void setValue(String name, Double value) throws SimulacionException {
        if(this.variables.containsKey(name)){
            this.variables.replace(name, value);
        }else{
            throw new SimulacionException("La variable de tipo "+ this.getTipo()+": "+name+" no existe.");
        }
    }
}
