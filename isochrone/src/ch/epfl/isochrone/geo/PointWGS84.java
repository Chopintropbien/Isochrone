package ch.epfl.isochrone.geo;

import static java.lang.Math.PI;
import static java.lang.Math.asin;
import static java.lang.Math.cos;
import static java.lang.Math.tan;
import static java.lang.Math.sqrt;
import static java.lang.Math.toDegrees;
import static java.lang.Math.pow;
import ch.epfl.isochrone.math.Math;


/**
 * Represente un point dans le systeme de coordonnees WGS 84.
 *
 * @author Marius Rosset(236522)
 */
public final class PointWGS84 {

    /**Represente la longitude du point*/
    private final double longitude;
    /**Represente la latitude du point*/
    private final double latitude;
    /**Permet de stocker l'appproxmiation du rayon de la terre (supposee spherique)*/
    private final double rayonTerre = 6378137;

    /**
     * Constructeur de la classe PointWGS 84
     * 
     * @param longitude La longitude du point dans le systeme de coordonnees WGS 84
     * @param latitude La latitude du point dans le systeme de coordonnees WGS 84
     * @throws IllegalArgumentException Si la latitude ou la longitude ne sont pas dans un intervalle correct
     */
    public  PointWGS84(double longitude, double latitude) throws IllegalArgumentException {
        if(longitude < -PI || longitude > PI) {
            throw new IllegalArgumentException("La longitude n'est pas dans un intervalle correct");
        }
        else if(latitude < -PI/2.0 || latitude > PI/2.0) {
            throw new IllegalArgumentException("La latitude n'est pas dans un intervalle correct");
        }

        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Retourne la longitude du point dans le systeme de coordonees WGS 84.
     * @return la longitude du point dans le systeme de coordonees WGS 84.
     */
    public double longitude() {
        return longitude;
    }

    /**
     * Retourne la latitude du point dans le systeme de coordonees WGS 84.
     * @return la latitude du point dans le systeme de coordonees WGS 84.
     */
    public double latitude() {
        return latitude;
    }

    /**
     * Calcul la distance entre deux points dans le systeme de coordonnes WGS 84. Le premier point etant celui-ci et le second est fourni en parametre.
     * @param that Une seconde instace de PointWGS 84 afin de calculer la distance separant les deux points dans le systeme de coordonees WGS 84.
     * @return La distance entre les deux points dans le systeme de coordonees WGS 84.
     */
    public double distanceTo(PointWGS84 that) {
        double tempCalcul = Math.haversin(latitude - that.latitude()) + cos(latitude) * cos(that.latitude()) * Math.haversin(longitude - that.longitude());
        return 2 * rayonTerre * asin(sqrt(tempCalcul));
    }

    /**
     * Retourne la representation du point dans le dans le systeme de coordonees OSM.
     * @param zoom Le niveau de zoom utilise dans le systeme de coordonees OSM.
     * @return La representation du point dans le dans le systeme de coordonees OSM. 
     * @throws IllegalArgumentException Si le zoom est negatif
     */
    public PointOSM toOSM(int zoom) throws IllegalArgumentException {

        if(zoom < 0) {
            throw new IllegalArgumentException("Zoom negatif !");
        }

        double s = pow(2, zoom + 8);

        double x  = (longitude + PI) * s / (2 * PI);
        double y = (PI -asin(tan(latitude))) * s / (2*PI); 

        return new PointOSM(zoom, x, y);
    }

    /**
     * Represente le point sous sa forme textuelle en affichant les coordonnes en degrees.
     * Exemple : (6.57,46.52)
     */
    @Override
    public String toString() {
        return "(" + toDegrees(longitude) + "," + toDegrees(latitude) + ")";

    }
}
