/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

public class Vector {
    
    private int X;
    private int Y;
    
    public Vector(int x,int y){
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
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
    
    public void producteEscalar(int a){
        X = a*X;
        Y = a*Y;
    }
    
    public void divisioEscalar(int a){
        X = X/a;
        Y = Y/a;
    }
    
    public double modul(){
        double m = Math.sqrt(X*X+Y*Y);
        return m;
    }
    
    public void normalizar(){
        int m = (int)modul();
        X = X/m;
        Y = Y/m;
    }
    
    public void limitar(int limitX, int limitY){
        normalizar();
        X = limitX*X;
        Y = limitY*Y;
    }
    
}
