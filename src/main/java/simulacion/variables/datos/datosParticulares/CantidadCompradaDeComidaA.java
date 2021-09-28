package simulacion.variables.datos.datosParticulares;

import simulacion.random.RandomValue;
import simulacion.variables.datos.Dato;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class CantidadCompradaDeComidaA extends Dato {

    @Override
    public Double obtenerValor() {
        Double r = RandomValue.random();

        Double ln = Math.log(-r+1);

        Double val = ln/(-6061/10000.0);
        if(val < 1){
            val = val + 1;
        }
        return RandomValue.round(val); /*  CCA = ln(-R+1)/(-6061/10000)  */
    }
}
