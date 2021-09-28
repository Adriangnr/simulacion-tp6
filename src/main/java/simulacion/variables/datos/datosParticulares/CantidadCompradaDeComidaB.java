package simulacion.variables.datos.datosParticulares;

import simulacion.random.RandomValue;
import simulacion.variables.datos.Dato;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class CantidadCompradaDeComidaB extends Dato {
    @Override
    public Double obtenerValor() {
        Double r = RandomValue.random();

        Double ln = Math.log((1/r)-1);

        Double val = (18511/10000.0)-(6799/10000.0)*ln;

        if(val < 1){
            val = val + 1;
        }
        return RandomValue.round(val); //CCB = (18511/10000)-(6799/10000)*ln(1/R-1)
    }
}
