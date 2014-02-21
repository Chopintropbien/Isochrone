package ch.epfl.isochrone.math;

import static java.lang.Math.log;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 * Implemente les fonctions mathematiques utiles pour la realistion du projet
 * 
 * @author Marius Rosset(236522)
 */
public final class Math {

    /**
     * Constructeur de la class Math. Afin que celle-ci ne puisse etre instanciee, celui-ci est private
     */
    private Math(){    
    }

    /**
     * Implemente la fonction arcsinh (l'inverse de la fonction hyperbolique)
     * @param x l'entree x
     * @return l'angle en radian
     */
    public static double asinh(double x) {
        return log(x + sqrt(1 + pow(x, 2)));
    }

    /**
     * Implemente la fonction mathematique haversin
     * @param x l'entree x
     * @return le resultat de la formule (sin(x/2))^2
     */
    public static double haversin(double x){
        //TODO : Verifier que l'argument ne soit problematique
        return pow(sin(x / 2.0), 2);
    }
}
