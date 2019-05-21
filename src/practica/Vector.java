/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

public class Vector {
    
    private double X;
    private double Y;
    
    public Vector(double x,double y){
        X = x;
        Y = y;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public void setX(double X) {
        this.X = X;
    }

    public void setY(double Y) {
        this.Y = Y;
    }
    
    
    
    public Vector suma(Vector v){
        X += v.getX();
        Y += v.getY();
        Vector u = new Vector(X,Y);
        return u;
    }
    
    public Vector resta(Vector v){
        X -= v.getX();
        Y -= v.getY();
        Vector u = new Vector(X,Y);
        return u;
    }
    
    public void producteEscalar(double a){
        X = a*X;
        Y = a*Y;
    }
    
    public void divisioEscalar(double a){
        X = X/a;
        Y = Y/a;
    }
    
    public double modul(){
        double m = Math.sqrt(X*X+Y*Y);
        return m;
    }
    
    public void normalizar(){
        double m = modul();
        X = X/m;
        Y = Y/m;
    }
    
    public void limitar(double limitX, double limitY){
        normalizar();
        X = limitX*X;
        Y = limitY*Y;
    }
    
}
