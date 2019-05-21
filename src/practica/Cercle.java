/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cercle {

    public static int diametre = 50;
    private final Color col = generaColor();
    private Vector pos;
    private Vector vel;
    private Vector acc;

    public Cercle() {
        pos = new Vector(aleatoriInt(525), aleatoriInt(525));
        vel = new Vector(0, 1);
        acc = new Vector(0, 0.005);
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

    public Color generaColor() {
        Random aleatori = new Random();
        float r = aleatori.nextFloat();
        float g = aleatori.nextFloat();
        float b = aleatori.nextFloat();

        Color c = new Color(r, g, b);
        return c;
    }

    public int aleatoriInt(int x) {
        Random ran = new Random();
        int y = ran.nextInt(x);
        return y;
    }

    public void paint(Graphics2D g2) {
        Ellipse2D.Double c1 = new Ellipse2D.Double(this.getPos().getX(),
                this.getPos().getY(), this.getDiametre(), this.getDiametre());

        Color col = this.getCol();
        g2.setColor(col);
        g2.fill(c1);
    }

    public void actualitzaPosicio() {

        if (!PanellCercles.seguirRatoli) {
            vel.suma(acc);
            pos.suma(vel);
            if (!PanellCercles.parets) {
                interaccioLimitsSenseParets();
            } else {
                interaccioLimitsParets();
            }

        } else { // seguir ratolí
            double mX = PanellCercles.mouseX;
            double mY = PanellCercles.mouseY;
            Vector mouse = new Vector(mX,mY);
            pos = mouse.resta(pos);
            
            if (!PanellCercles.parets) {
                interaccioLimitsSenseParets();
            } else {
                interaccioLimitsParets();
            }
        }

    }

    public void interaccioLimitsParets() {
        if (pos.getX() > Practica.DIMENSIO - 50 || pos.getX() < 0) {
            vel = new Vector(-vel.getX(), vel.getY());
        }
        if (pos.getY() > Practica.DIMENSIO - 50 || pos.getY() < 0) {
            vel = new Vector(vel.getX(), -vel.getY());
        }
    }

    public void interaccioLimitsSenseParets() {
        if (pos.getX() > Practica.DIMENSIO) {
            pos = new Vector(0, pos.getY());
        } else if (pos.getX() < 0) {
            pos = new Vector(Practica.DIMENSIO, pos.getY());
        }
        if (pos.getY() > Practica.DIMENSIO) {
            pos = new Vector(pos.getX(), 0);
        } else if (pos.getY() < 0) {
            pos = new Vector(pos.getX(), Practica.DIMENSIO);
        }
    }

    public void setAcc(double x, double y) {
        acc = new Vector(x, y);
    }

    public void setVel(double x, double y) {
        vel = new Vector(x, y);
    }

    public void setPos(double x, double y) {
        pos = new Vector(x, y);
    }

}
