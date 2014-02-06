/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.logiikka;

import java.util.ArrayList;

public class VoittojenLaskija {
    private ArrayList<Integer> voitot;
    private int ristinVoitot;
    private int nollanVoitot;
    
    public VoittojenLaskija() {
        this.voitot = new ArrayList<>();
        this.ristinVoitot = 0;
        this.nollanVoitot = 0;
    }
    
    public int getRistinVoitot() {
        return this.ristinVoitot;
    }
    
    public int getNollanVoitot() {
        return this.nollanVoitot;
    }
    
    public ArrayList<Integer> getVoitot() {
        return this.voitot;
    }
    
    public void lisaaVoitto(int kumpi) {
        if (kumpi == 1) {
            this.voitot.add(1);
            this.ristinVoitot++;
        } else if (kumpi == 2) {
            this.voitot.add(2);
            this.nollanVoitot++;
        }
    }
}
