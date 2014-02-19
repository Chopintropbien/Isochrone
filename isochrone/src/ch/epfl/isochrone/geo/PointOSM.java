package ch.epfl.isochrone.geo;

import static java.lang.Math.pow;
import static java.lang.Math.PI;
import static java.lang.Math.sinh;
import static java.lang.Math.atan;




public class PointOSM {
        private int zoom;
        private double x;
        private double y;
        
    
    
        // getteur
    public int zoom() {
        return zoom;
    }
    public double x() {
        return x;
    }
    public double y() {
        return y;
    }
       // constructor
    public PointOSM(int zoom, double x, double y) throws IllegalArgumentException {
        
            // erreurs possibles: depassement des bornes de x et y et zoom négatifs
        if(zoom < 0){
            throw new IllegalArgumentException("Le zoomm est négatif"); 
        }
        else if (x < 0 || x > maxXY(zoom)){
            throw new IllegalArgumentException("La coodonné x dépassent les bornes"); 
        }
        else if (y < 0 || y > maxXY(zoom)){
            throw new IllegalArgumentException("La coodonné y dépassent les bornes"); 
        }
        
        this.zoom = zoom;
        this.x = x; 
        this.y = y;
    }
        // return la taille de l'image de la carte
    public int maxXY(int zoom) throws IllegalArgumentException {
        if(zoom < 0){
            throw new IllegalArgumentException("Le zoom est négatif");
        }
        return (int) pow(2, 8 + zoom);
    }
    
    public int roundedX(){
        int xTronque = (int) x;
        if(x - xTronque < 0.5){
            return xTronque;
        }
        else{
            return xTronque + 1;
        }
    }
    public int roundedY(){
        int yTronque = (int) y;
        if(y - yTronque < 0.5){
            return yTronque;
        }
        else{
            return yTronque + 1;
        }
    }
    public PointWGS84 toWGS84(){
        double s = pow(2, zoom + 8);
        double lambda = 2 * PI / s * x - PI;
        double phi = atan(sinh(PI - 2*PI * y / s));
    }
    
    
    
}
