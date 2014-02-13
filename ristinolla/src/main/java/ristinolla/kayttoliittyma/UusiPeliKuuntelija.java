/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.kayttoliittyma;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import ristinolla.logiikka.Logiikka;

/** ActionListener käyttöliittymän Uusi peli -napille.
 */

public class UusiPeliKuuntelija implements ActionListener {
    private Logiikka logiikka;
    private JTextField tekstiKentta;
    private Piirtoalusta piirtoalusta;
    private Graphics graphics;
    
    public UusiPeliKuuntelija(Logiikka logiikka, JTextField tekstiKentta, Piirtoalusta piirtoalusta) {
        this.logiikka = logiikka;
        this.tekstiKentta = tekstiKentta;
        this.piirtoalusta = piirtoalusta;
    }
    
    /** Tyhjentää piirretyt ristit ja nollat, aloittaa logiikassa uuden pelin ja kertoo tekstikentässä kuka aloittaa.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.graphics = piirtoalusta.getGraphics();
        this.piirtoalusta.paintComponent(graphics);
        this.logiikka.aloitaPeli();
        
        String aloittaja = "";
        if (this.logiikka.getVuoro() == 1) {
            aloittaja = "Risti aloittaa!";
        } else {
            aloittaja = "Nolla aloittaa!";
        }
        this.tekstiKentta.setText("Uusi peli aloitettu. " + aloittaja);
    }
    
}
