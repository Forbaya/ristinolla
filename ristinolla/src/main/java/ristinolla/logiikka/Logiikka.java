/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.logiikka;

import java.util.Random;

/** Pelin sovelluslogiikka. Käyttöliittymän toiminnot käyttävät tätä toimiakseen.
 */
public class Logiikka {
    private int poyta[][];
    private int pelinTila;  // Peli on käynnissä kun tila on 1, poissa kun tila on 0.
    private Random random;
    private int vuoro;      // x = 1, o = 2.
    private VoittojenLaskija voittojenLaskija;
    private int ristinAsetus; // Määrittää minkänäköinen kuvio ristin vuorolla piirretään.
    private int nollanAsetus; // Määrittää minkänäköinen kuvio nollan vuorolla piirretään.
    
    /** Alustaa tyhjän pelipöydän ja muut muuttujat, sekä luo voittojen laskijan..
     */
    public Logiikka() {
        this.poyta = new int[][] {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        this.pelinTila = 0;
        this.random = new Random();
        this.vuoro = 0;
        this.voittojenLaskija = new VoittojenLaskija();
        this.ristinAsetus = 1;
        this.nollanAsetus = 1;
    }
    
    public int getPelinTila() {
        return this.pelinTila;
    }
    
    public int[][] getPoyta() {
        return this.poyta;
    }
    
    public VoittojenLaskija getVoittojenLaskija() {
        return this.voittojenLaskija;
    }
    
    public int getVuoro() {
        return this.vuoro;
    }
    
    public int getRistinAsetus() {
        return this.ristinAsetus;
    }
    
    public int getNollanAsetus() {
        return this.nollanAsetus;
    }
    
    public void setPelinTila(int x) {
        if (x == 0 || x == 1) {
            this.pelinTila = x; 
        }
    }
    
    public void setRistinAsetus(int uusiAsetus) {
        this.ristinAsetus = uusiAsetus;
    }
    
    public void setNollanAsetus(int uusiAsetus) {
        this.nollanAsetus = uusiAsetus;
    }
    
    /** Käynnistää uuden pelin nollaamalla ensin taulun, jonka jälkeen arvotaan aloittaja. Lopuksi pelin tila vaihdetaan 1.
     */
    public void aloitaPeli() {
        this.nollaa();
        
        double satunnainen = random.nextDouble();
        if (satunnainen < 0.5) {
            this.vuoro = 1;
        } else {
            this.vuoro = 2;
        }
        this.pelinTila = 1;
    }
    
    /** Nollaa taulun.
     */
    public void nollaa() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.poyta[i][j] = 0;
            }
        }
    }
    
    /** Sijoittaa pöytään x tai o ja vaihtaa vuoroa.
     * @param kuka Risti tai nolla
     * @param rivi Mille riville vuoro pelataan
     * @param sarake Mille sarakkeelle vuoro pelataan
     */
    public void suoritaVuoro(int kuka, int rivi, int sarake) {
        if ((kuka == 1 || kuka == 2) && this.pelinTila == 1) {
            this.poyta[rivi][sarake] = kuka;
        }
        
        if (this.vuoro == 1) {
            this.vuoro = 2;
        } else if (this.vuoro == 2) {
            this.vuoro = 1;
        }
    }
    
    /** Tarkistaa onko toisella kolme vierekkäin. 
     * @param kuka Risti tai nolla
     * @return Palauttaa true tai false
     */
    public boolean tarkistaVoitto(int kuka) {
        if (this.tarkistaRivit(kuka) || this.tarkistaSarakkeet(kuka) || this.tarkistaViistot(kuka)) {
            voittojenLaskija.lisaaVoitto(kuka);
            return true;
        }
        return false;
    }
    
    /** Tarkistaa onko riveillä kolme vierekkäistä samaa merkkiä.
     * @param kuka Risti tai nolla
     * @return Palauttaa true tai false
     */
    public boolean tarkistaRivit(int kuka) {
        int vierekkaiset = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (poyta[i][j] == kuka) {
                    vierekkaiset++;
                }
            }
            if (vierekkaiset == 3) {
                return true;
            } else {
                vierekkaiset = 0;
            }
        }
        return false;
    }
    
    /** Tarkistaa onko sarakkeissa kolme vierekkäistä samaa merkkiä.
     * @param kuka Risti tai nolla
     * @return Palauttaa true tai false
     */
    public boolean tarkistaSarakkeet(int kuka) {
        int vierekkaiset = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (poyta[j][i] == kuka) {
                    vierekkaiset++;
                }
            }
            if (vierekkaiset == 3) {
                return true;
            } else {
                vierekkaiset = 0;
            }
        }
        return false;
    }
    
    /** Tarkistaa onko viistoissa kolme vierekkäistä samaa merkkiä.
     * @param kuka Risti tai nolla
     * @return Palauttaa true tai false
     */
    public boolean tarkistaViistot(int kuka) {
        if (poyta[0][0] == kuka && poyta[1][1] == kuka && poyta[2][2] == kuka) {
            return true;
        }
        
        if (poyta[0][2] == kuka && poyta[1][1] == kuka && poyta[2][0] == kuka) {
            return true;
        }
        
        return false;
    }
    
    /** Tarkistaa montako ristiä ja nollaa pöydässä on. Palauttaa tosi jos pöytä on täysi.
     * @return Palauttaa true jos pöytä on täysi
     */
    public boolean onkoPoytaTaynna() {
        int ristitJaNollat = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (poyta[i][j] != 0) {
                    ristitJaNollat++;
                }
            }
        }
        return ristitJaNollat == 9;
    }
    
    /* Tulostaa pöydän. Tämä metodi on testaustarkoituksiin.
    public void tulostaPoyta() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(poyta[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    */
}
