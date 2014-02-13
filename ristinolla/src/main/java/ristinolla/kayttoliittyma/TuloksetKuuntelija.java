/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ristinolla.logiikka.Logiikka;
import ristinolla.logiikka.VoittojenLaskija;

public class TuloksetKuuntelija implements ActionListener {
    private Logiikka logiikka;
    private VoittojenLaskija voittojenLaskija;
    private Tulokset tulokset;
    
    public TuloksetKuuntelija(Logiikka logiikka) {
        this.logiikka = logiikka;
    }
    
    /** Luo uuden ikkunan tuloksille.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.tulokset = new Tulokset(this.logiikka);
    }
}
