/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ristinolla.logiikka.Logiikka;

/** ActionListener käyttöliittymän Tulokset-napille.
 */
public class TuloksetKuuntelija implements ActionListener {
    private Logiikka logiikka;
    
    /** Alustaa logiikka-muuttujan.
     * @param logiikka Pelin logiikka
     */
    public TuloksetKuuntelija(Logiikka logiikka) {
        this.logiikka = logiikka;
    }
    
    /** Luo uuden ikkunan tuloksille.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Tulokset tulokset = new Tulokset(this.logiikka);
    }
}
