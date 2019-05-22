package practica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static practica.PanellCercles.parets;
import static practica.PanellCercles.seguirRatoli;

public class InterficiePanel extends JPanel implements ActionListener {

    private static JTextField tf;
    private static JCheckBox checkWalls, checkMouse;
    public static int DIMPANELX = 1000;
    public static int DIMPANELY = 0;
    public static int WIDTH = 400;
    public static int HEIGHT = 900;

    public InterficiePanel() {
        this.setLayout(null);
        this.setBounds(DIMPANELX, DIMPANELY, WIDTH, HEIGHT);

        tf = new JTextField();

        tf.setBounds(1130, 200, 150, 50);
        tf.addActionListener(this);
        add(tf);

        checkWalls = new JCheckBox();
        checkWalls.setText("  With Walls");
        checkWalls.setBounds(1130, 350, 120, 20);
        checkWalls.addActionListener(this);
        add(checkWalls);

        checkMouse = new JCheckBox();
        checkMouse.setText("  Follow Mouse");
        checkMouse.setBounds(1130, 400, 120, 20);
        checkMouse.addActionListener(this);
        add(checkMouse);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        

        if (checkWalls.isSelected()) {
            parets = true;
        } else {
            parets = false;
        }
        if (checkMouse.isSelected()) {
            seguirRatoli = true;
        } else {
            seguirRatoli = false;
        }
    }

    private void BollesActionPerformed(ActionEvent evt) {
        try {
            
            int num = Integer.parseInt(tf.getText());
            PanellCercles p = new PanellCercles();
            p.setNumBolles(num);
            
        } catch (NumberFormatException e) {
            tf.setText("5");
            
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);   
        g2d.setStroke(new BasicStroke(5));
        Rectangle2D.Double rec = new Rectangle.Double(DIMPANELX+2, DIMPANELY+2, WIDTH-10, HEIGHT-40);

        g2d.draw(rec);
        g2d.setColor(Color.DARK_GRAY);
        g2d.fill(rec);
        
    }

}
