/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ristinolla.logiikka.Logiikka;

/** ActionListener käyttöliittymän Asetukset-napille.
 */
public class AsetuksetKuuntelija implements ActionListener {
    private Logiikka logiikka;

    
    /** Alustaa logiikka-muuttujan.
     * @param logiikka 
     */
    public AsetuksetKuuntelija(Logiikka logiikka) {
        this.logiikka = logiikka;
    }
    
    /** Luo uuden ikkunan asetuksille.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Asetukset asetukset = new Asetukset(this.logiikka);
    }
}
