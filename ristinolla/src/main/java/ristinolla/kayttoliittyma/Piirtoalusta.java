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
    
    /** Piirtää pelialustalle ristikon.
     * @param g Grafiikka
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawLine(0, 0, 0, 300);
        g.drawLine(0, 0, 300, 0);
        g.drawLine(100, 0, 100, 300);
        g.drawLine(200, 0, 200, 300);
        g.drawLine(300, 0, 300, 300);
        g.drawLine(0, 100, 300, 100);
        g.drawLine(0, 200, 300, 200);
        g.drawLine(0, 300, 300, 300);
    }
    
    /** Piirtää X haluttuun koordinaattiin piirtoalustassa.
     * @param x Piirtokohdan x-koordinaatti
     * @param y Piirtokohdan y-koordinaatti
     */
    public void piirraRisti(int x, int y) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.BLUE);
        graphics.drawLine(x, y, x + 50, y + 50);
        graphics.drawLine(x + 50, y, x, y + 50);
    }
    
    /** Piirtää O haluttuun koordinaattiin piirtoalustassa.
     * @param x Piirtokohdan x-koordinaatti
     * @param y Piirtokohdan y-koordinaatti
     */
    public void piirraNolla(int x, int y) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.RED);
        graphics.drawOval(x - 12, y - 12, 75, 75);
    }
}
