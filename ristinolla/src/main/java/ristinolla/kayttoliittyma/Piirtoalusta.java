/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel {
    private Graphics g;
    
    public Piirtoalusta() {
        super.setBackground(Color.WHITE);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Piirtää pelialustalle ristikon.
        g.drawLine(0, 0, 0, 300);
        g.drawLine(0, 0, 300, 0);
        g.drawLine(100, 0, 100, 300);
        g.drawLine(200, 0, 200, 300);
        g.drawLine(300, 0, 300, 300);
        g.drawLine(0, 100, 300, 100);
        g.drawLine(0, 200, 300, 200);
        g.drawLine(0, 300, 300, 300);
    }
    
}
