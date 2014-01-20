/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import ristinolla.logiikka.Logiikka;

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Logiikka logiikka;
    
    public Kayttoliittyma() {
        this.logiikka = new Logiikka();
    }
    
    @Override
    public void run() {
        frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(500, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    // Luo komponentit jotka lisätään containeriin.
    public void luoKomponentit(Container container){
    }
}
