package simulacion.variables.datos.datosParticulares;

import simulacion.random.RandomValue;
import simulacion.variables.datos.Dato;

public class IntervaloEntreArrivosDeClientes extends Dato {

    @Override
    public Double obtenerValor() {
        Double r = RandomValue.random();

        Double pot = Math.pow(((1/r)-1), (1/1380.0));

        Double val = ((2/pot)+1380)/60;

        return RandomValue.round(val);/*  2/(( 1/R -1)^(1/1380))+1380  */
    }
}
