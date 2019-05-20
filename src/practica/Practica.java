/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import javax.swing.JFrame;

public class Practica extends JFrame {
    
    public static int DIMENSIO = 600;
    
    public Practica(){
        this.setTitle("Flying Balls");
        this.setSize(DIMENSIO,DIMENSIO);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanellCercles p = new PanellCercles();
        this.add(p);
    }
    
    public static void main(String[] args) {
        (new Practica()).setVisible(true);
    }
    
}
