/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.awt.Color;
import java.util.Random;

public class Cercle {
    
    public static int diametre = 50;
    private final Color col = generaColor();
    private Vector pos;
    private Vector vel;
    private Vector acc;
    
    public Cercle(){
        pos = new Vector(0,0);
        vel = new Vector(2,5);
        acc = new Vector(0,10);
    }

    public int getDiametre() {
        return diametre;
    }

    public Color getCol() {
        return col;
    }

    public Vector getPos() {
        return pos;
    }

    public Vector getVel() {
        return vel;
    }

    public Vector getAcc() {
        return acc;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

//    public void setCol(Color col) {
//        this.col = col;
//    }

    public void setPos(Vector pos) {
        this.pos = pos;
    }

    public void setVel(Vector vel) {
        this.vel = vel;
    }

    public void setAcc(Vector acc) {
        this.acc = acc;
    }
    
    
    
    public Color generaColor(){
        Random aleatori = new Random();
        float r = aleatori.nextFloat();
        float g = aleatori.nextFloat();
        float b = aleatori.nextFloat();
        
        Color c = new Color(r,g,b);
        return c;
    }
    
    public void actiualitzaAccel(int x, int y){
        Vector s = new Vector(x,y);
        this.acc.suma(s);
    }
    
}
