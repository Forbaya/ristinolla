

package ristinolla.logiikka;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TiedostonKasittelija {
    private File pisteet;
    private File viimeisimmatVoitot;
    private Scanner lukija;
    
    public TiedostonKasittelija(String pisteet, String viimeisimmatVoitot) {
        this.pisteet = new File(pisteet);
        this.viimeisimmatVoitot = new File(viimeisimmatVoitot);
    }
    
    public int lueRistinPisteet() throws Exception {
        lukija = new Scanner(pisteet);
        String rivi = "";
        if (lukija.hasNextLine()) {
            rivi = lukija.nextLine();
        }
        String[] osat = rivi.split(":");
        String risti = osat[0];
        
        return Integer.parseInt(risti);
    }
    
    public int lueNollanPisteet() throws Exception {
        lukija = new Scanner(pisteet);
        String rivi = "";
        if (lukija.hasNextLine()) {
            rivi = lukija.nextLine();
        }
        String[] osat = rivi.split(":");
        String nolla = osat[1];
        
        return Integer.parseInt(nolla);
    }
    
    public String lueVoitot() throws Exception {
        this.lukija = new Scanner(this.viimeisimmatVoitot);
        String voitot = "";
        while (lukija.hasNextLine()) {
            voitot += lukija.nextLine();
            voitot += "\n";
        }
        lukija.close();
        return voitot;
    }
    
    public void kirjoitaPisteisiin(String kirjoitettava) throws Exception {
        FileWriter kirjoittaja = new FileWriter(pisteet, false);
        kirjoittaja.write(kirjoitettava);
        kirjoittaja.close();
    }
    
    public void nollaaViimeisetVoitot() throws Exception {
        FileWriter kirjoittaja = new FileWriter(viimeisimmatVoitot);
        kirjoittaja.write("");
        kirjoittaja.close();
    }
    
    public void kirjoitaViimeisimpiinVoittoihin(String kirjoitettava) throws Exception {
        FileWriter kirjoittaja = new FileWriter(viimeisimmatVoitot, true);
        kirjoittaja.append(kirjoitettava);
        kirjoittaja.close();
    }
}
