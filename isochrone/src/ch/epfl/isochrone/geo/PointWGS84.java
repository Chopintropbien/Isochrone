package ch.epfl.isochrone.geo;

import static java.lang.Math.PI;
import static java.lang.Math.asin;
import static java.lang.Math.cos;
import static java.lang.Math.sqrt;
import static java.lang.Math.toDegrees;
import ch.epfl.isochrone.Math;

public final class PointWGS84 {

    private final double longitude;
    private final double latitude;
    final double rayonTerre = 6378137;

    public  PointWGS84(double longitude, double latitude) throws IllegalArgumentException {

        //Check longitude et latitude
        if(longitude < -PI || longitude > PI) {
            throw new IllegalArgumentException("La longitude n'est pas dans un interval correct");
        }
        else if(latitude < -PI/2.0 || latitude > PI/2.0) {
            throw new IllegalArgumentException("La latitude n'est pas dans un interval correct");
        }

        this.longitude = longitude;
        this.latitude = latitude;
    }

    double longitude() {
        return longitude;
    }

    double latitude() {
        return latitude;
    }

    double distanceTo(PointWGS84 that) {
        double tempCalcul = Math.haversin(latitude - that.latitude()) + cos(latitude) * cos(that.latitude()) * Math.haversin(longitude - that.longitude());
        return 2 * rayonTerre * asin(sqrt(tempCalcul));
    }

    PointOSM toOSM(int zoom) {
        //TODO
    }

    @Override
    public String toString() {
        return "(" + toDegrees(longitude) + "," + toDegrees(latitude) + ")";

    }
}
