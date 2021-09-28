package simulacion.random;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class RandomValue {

    public static Double random(){
        Double r = (new Random()).nextDouble();
        return r;
    }

    public static Double round(Double val) {
        if(val < 0.01){
            val = val * 100;
        }
        val = Math.abs(val);

        return (new BigDecimal(val)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
