/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanellCercles extends JPanel implements ActionListener, MouseMotionListener {

    private Cercle c[];
    private int numBolles =50;
    public static double mouseX, mouseY;
    public static boolean parets;
    public static boolean seguirRatoli;
    private static JTextField tf;
    private static JCheckBox checkWalls,checkMouse;
    

    public PanellCercles() {
        this.setLayout(null);
        c = new Cercle[numBolles];
        parets = false;
        seguirRatoli = false;
        addMouseMotionListener(this);
        
        tf = new JTextField();
        tf.setBounds(730,100,150,50);
        tf.addActionListener(this);
        add(tf);
        
        checkWalls = new JCheckBox();
        checkWalls.setText("  With Walls");
        checkWalls.setBounds(730,250,120,20);
        checkWalls.addActionListener(this);
        add(checkWalls);
        
        checkMouse = new JCheckBox();
        checkMouse.setText("  Follow Mouse");
        checkMouse.setBounds(730,300,120,20);
        checkMouse.addActionListener(this);
        add(checkMouse);
        
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
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanellCercles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double rec = new Rectangle2D.Double(650, 0, 400, 600);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5));  
        g2d.draw(rec);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(rec);
        for (int i = 0; i < c.length; i++) {
            c[i].paint(g2d);
        }
    }
    
    
//    private void numBolles() {                                        
//            numBolles = Integer.parseInt(tf.getText());
//            
//        // TODO add your handling code here:
//        
//    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        
        
        if(checkWalls.isSelected()) {
            parets = true;
        }else {
            parets = false;
        }
        if(checkMouse.isSelected()) {
            seguirRatoli = true;
        }else {
            seguirRatoli = false;
        }
        
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
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(PanellCercles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
