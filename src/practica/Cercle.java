/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.awt.BasicStroke;
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
        vel = new Vector(0.1, 1);
        acc = new Vector(0, 0.008);
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
        
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5));  
        g2.draw(c1);
        Color col = this.getCol();
        g2.setColor(col);
        g2.fill(c1);
        
    }

    public void actualitzaPosicio() {
        
        Vector velMax = new Vector(4,3);
        Vector velMin = new Vector(-4,-3);

        if (!PanellCercles.seguirRatoli) {
            vel.suma(acc);
            if(vel.getX()>velMax.getX()){
                vel = new Vector(velMax.getX(),vel.getY());
            }else if(vel.getX()<velMin.getX()){
                vel = new Vector(velMin.getX(),vel.getY());
            }
            if(vel.getY()>velMax.getY()){
                vel = new Vector(vel.getX(),velMax.getY());
            }else if(vel.getY()<velMin.getX()){
                vel = new Vector(vel.getX(),velMin.getY());
            }
            
            pos.suma(vel);
            if (!PanellCercles.parets) {
                interaccioLimitsSenseParets();
            } else {
                interaccioLimitsParets();
            }

        } else { // seguir ratolí
            Vector posMouse = new Vector(PanellCercles.mouseX,PanellCercles.mouseY);
            acc = posMouse.resta(pos);  //acc centrípeta
            acc.limitar(0.1, 0.1);
            
            vel.suma(acc);
            if(vel.getX()>velMax.getX()){
                vel = new Vector(velMax.getX(),vel.getY());
            }else if(vel.getX()<velMin.getX()){
                vel = new Vector(velMin.getX(),vel.getY());
            }
            if(vel.getY()>velMax.getY()){
                vel = new Vector(vel.getX(),velMax.getY());
            }else if(vel.getY()<velMin.getX()){
                vel = new Vector(vel.getX(),velMin.getY());
            }
            pos.suma(vel);
            if (!PanellCercles.parets) {
                interaccioLimitsSenseParets();
            } else {
                interaccioLimitsParets();
            }
        }

    }

    public void interaccioLimitsParets() {
        if (pos.getX() > Practica.DIMENSIOX - 350 || pos.getX() < 0) {
            vel = new Vector(-vel.getX(), vel.getY());
        }
        if (pos.getY() > Practica.DIMENSIOY - 50 || pos.getY() < 0) {
            vel = new Vector(vel.getX(), -vel.getY());
        }
    }

    public void interaccioLimitsSenseParets() {
        if (pos.getX() > Practica.DIMENSIOX - 350) {
            pos = new Vector(0, pos.getY());
        } else if (pos.getX() < 0) {
            pos = new Vector(Practica.DIMENSIOX, pos.getY());
        }
        if (pos.getY() > Practica.DIMENSIOY- 60) {
            pos = new Vector(pos.getX(), 0);
        } else if (pos.getY() < 0) {
            pos = new Vector(pos.getX(), Practica.DIMENSIOY);
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
