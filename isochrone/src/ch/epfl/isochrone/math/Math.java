package ch.epfl.isochrone.math;


import static java.lang.Math.log;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

public final class Math {

    //Empeche la classe d'etre instanciee
    private Math(){    
    }

    public static double asinh(double x) {
        //TODO : Verifier que l'argument ne soit problematique
        return log(x + sqrt(1 + pow(x, 2)));
    }

    public static double haversin(double x){
        //TODO : Verifier que l'argument ne soit problematique
        return pow(sin(x / 2.0), 2);
    }
}
