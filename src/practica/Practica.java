/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;



import javax.swing.JFrame;

public class Practica extends JFrame {
    
    public static int DIMENSIOX = 950;
    public static int DIMENSIOY = 600;
    public static PanellCercles p;
    
    
    
    public Practica(){
        this.setTitle("Flying Balls");
        this.setSize(DIMENSIOX,DIMENSIOY);
        this.setResizable(false);
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new PanellCercles();
        this.add(p);
        
    }
    
    
    
    public static void main(String[] args) {
        (new Practica()).setVisible(true);
        p.simulacio();
        
        
        
        
    }

    
    
}
