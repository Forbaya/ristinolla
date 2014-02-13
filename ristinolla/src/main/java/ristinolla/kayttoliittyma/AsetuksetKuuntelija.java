/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ristinolla.logiikka.Logiikka;

public class AsetuksetKuuntelija implements ActionListener {
    private Logiikka logiikka;
    private Asetukset asetukset;
    
    public AsetuksetKuuntelija(Logiikka logiikka) {
        this.logiikka = logiikka;
    }
    
    /** Luo uuden ikkunan asetuksille.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.asetukset = new Asetukset(this.logiikka);
    }
    
}
