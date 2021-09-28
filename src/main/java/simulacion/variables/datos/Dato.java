package simulacion.variables.datos;

import java.util.logging.Logger;

public abstract class Dato {
    protected static final Logger logger = Logger.getLogger(Dato.class.getName());
    public abstract Double obtenerValor();
}
