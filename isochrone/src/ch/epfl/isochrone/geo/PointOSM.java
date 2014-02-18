package ch.epfl.isochrone.geo;

import static java.lang.Math.pow;


public class PointOSM {
    
    
    int maxXY(int zoom) {
        if(zoom < 0) {
            throw new IllegalArgumentException("Le zoom est négatif");
        }
        
        return (int) pow(2, 8 + zoom);
    }
    
}
