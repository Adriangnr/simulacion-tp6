package simulacion.variables.datos;

import java.util.Map;

public class Datos {
    private Map valores;

    public Datos(Map valores){
        this.valores = valores;
    }

    public Dato getDato(String name){
        return (Dato)this.valores.get(name);
    }
}
