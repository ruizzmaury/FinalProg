/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;




public class PanellCercles extends JPanel implements MouseMotionListener {
    
    public static int DIMX = 0;
    public static int DIMY = 0;
    public static int PWIDTH = 1000;
    public static int PHEIGHT = 880;
    private Cercle c[];
    private int numBolles =10;
    public static double mouseX, mouseY;
    public static boolean parets;
    public static boolean seguirRatoli;
    
    

    public PanellCercles() {
        this.setBounds(DIMX, DIMY, PWIDTH, PHEIGHT);
        c = new Cercle[numBolles];
        parets = false;
        seguirRatoli = false;
        addMouseMotionListener(this);
        
        
        
        for (int i = 0; i < c.length; i++) {
            c[i] = new Cercle();
//            simulacio(c[i]);
        }
    }

    public void simulacio() {
        while (true) {
            for (int i = 0; i < c.length; i++) {
                c[i].actualitzaPosicio();
                repaint();
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanellCercles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double panel = new Rectangle.Double(DIMX, DIMY, PWIDTH, PHEIGHT);
        
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(panel);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));  
        g2d.setColor(Color.LIGHT_GRAY);
        
        
        for (int i = 0; i < c.length; i++) {
            c[i].paint(g2d);
        }
    }
    
    
    public void setNumBolles(int numBolles) {  
            c = new Cercle[numBolles];
    }
    
    

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
        try {
            Thread.sleep(2);
        } catch (InterruptedException ex) {
            Logger.getLogger(PanellCercles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
