package simulacion.variables.datos.datosParticulares;

import simulacion.random.RandomValue;
import simulacion.variables.datos.Dato;

public class IntervaloEntreArrivosDeClientes extends Dato {

    @Override
    public Double obtenerValor() {
        Double r = RandomValue.random();

        Double a=Math.log(-r+1);

        Double val= (a/(-0.0006))/60;


        if(val<7)
            val=val+7;

        return RandomValue.round(val);/*  2/(( 1/R -1)^(1/1380))+1380  */
    }
}
