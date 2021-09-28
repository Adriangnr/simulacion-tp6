package simulacion.variables.datos.datosParticulares;

import simulacion.random.RandomValue;
import simulacion.variables.datos.Dato;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class CantidadCompradaDeComidaC extends Dato {
    @Override
    public Double obtenerValor() {
        Double r = RandomValue.random();

        Double ln = Math.log((1/r)-1);

        Double val = 2-(8485/10000.0)*ln;

        if(val < 0 || val > 20)
            this.obtenerValor();

        return RandomValue.round(val); //CCC =  2-(8485/10000)*ln(1/R-1)
    }
}
