

package ristinolla.logiikka;

import java.io.File;
import java.util.Scanner;

public class TiedostonKasittelija {
    private File pisteet;
    private File viimeisimmatVoitot;
    private Scanner lukija;
    
    public TiedostonKasittelija(String pisteet, String viimeisimmatVoitot) {
        this.pisteet = new File(pisteet);
        this.viimeisimmatVoitot = new File(viimeisimmatVoitot);
    }
    
    public void luePisteet() throws Exception {
        this.lukija = new Scanner(this.pisteet);
    }
    
    public void lueVoitot() throws Exception {
        this.lukija = new Scanner(this.viimeisimmatVoitot);
    }
    
    public void kirjoitaPisteisiin(String kirjoitettava) {
        
    }
    
    public void kirjoitaViimeisimpiinVoittoihin(String kirjoitettava) {
        
    }
}
