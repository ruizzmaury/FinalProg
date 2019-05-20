/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;


public class PanellCercles extends JPanel implements ActionListener {
    
    private Cercle c [];
    private boolean parets;
    private boolean seguirRatoli;
    private Cercle c1;
    
    public PanellCercles(){
        c = new Cercle[2];
        c1 = new Cercle();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        MRU(g);
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(PanellCercles.class.getName()).log(Level.SEVERE, null, ex);
        }
            this.repaint();
    }



    @Override
    public void actionPerformed(ActionEvent ae) {

    }
    
    
    public void setCercles(Cercle[] cercles) {
        this.c = cercles;
    }

    public void setParets(boolean parets) {
        this.parets = parets;
    }

    public void setSeguirRatoli(boolean seguirRatoli) {
        this.seguirRatoli = seguirRatoli;
    }
    
    public void MRU(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        int diametre = Cercle.diametre;
        Vector pos = c1.getPos();
        Ellipse2D.Float cercle = new Ellipse2D.Float(pos.getX(), pos.getY(),
                diametre, diametre);
        Color col = c1.getCol();
        g2.setColor(col);
        g2.fill(cercle);
        Vector vel = c1.getVel();
        Vector nPos = pos.suma(vel);
        c1.setPos(nPos);
        if(nPos.getX() > Practica.DIMENSIO-50 || nPos.getX() < 0){
            vel = new Vector(-c1.getVel().getX(),c1.getVel().getY());
            c1.setVel(vel);
        }else if(nPos.getY() > Practica.DIMENSIO -50|| nPos.getY() < 0){
            vel = new Vector(c1.getVel().getX(),-c1.getVel().getY());
            c1.setVel(vel);
        }
    }
    
    public void MRUA(Graphics g){

    }
  
}
