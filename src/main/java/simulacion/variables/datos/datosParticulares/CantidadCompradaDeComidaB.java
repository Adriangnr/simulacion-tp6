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

        if(val < 0 || val > 20)
            val = this.obtenerValor();

        return RandomValue.round(val); //CCB = (18511/10000)-(6799/10000)*ln(1/R-1)
    }
}
