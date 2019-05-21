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
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class PanellCercles extends JPanel implements ActionListener, MouseMotionListener {

    private Cercle c[];
    public static double mouseX, mouseY;
    public static boolean parets;
    public static boolean seguirRatoli;

    public PanellCercles() {
        c = new Cercle[10];
        parets = true;
        seguirRatoli = true;
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
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanellCercles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < c.length; i++) {
            c[i].paint(g2d);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(PanellCercles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
