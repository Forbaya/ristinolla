/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.logiikka;

import java.util.Random;

public class Logiikka {
    private int poyta[][];
    private int pelinTila;  // Peli on käynnissä kun tila on 1, poissa kun tila on 0.
    private Random random;
    private int vuoro;      // x = 1, o = 2.
    
    public Logiikka() {
        this.poyta = new int[][] {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        this.pelinTila = 0;
        this.random = new Random();
        this.vuoro = 0;
    }
    
    public int getPelinTila() {
        return this.pelinTila;
    }
    
    public int[][] getPoyta() {
        return this.poyta;
    }
    
    public int getVuoro() {
        return this.vuoro;
    }
    
    public void setPelinTila(int x) {
        if (x == 0 || x == 1) {
            this.pelinTila = x; 
        }
    }
    
    // Käynnistää uuden pelin nollaamalla ensin taulun, jonka jälkeen arvotaan aloittaja. Lopuksi pelin tila vaihdetaan 1.
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
    
    // Nollaa taulun.
    public void nollaa() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.poyta[i][j] = 0;
            }
        }
    }
    
    // Sijoittaa pöytään x tai o ja vaihtaa vuoroa.
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
    
    // Tarkistaa onko toisella kolme vierekkäin. 
    public boolean tarkistaVoitto(int kuka) {
        return this.tarkistaRivit(kuka) || this.tarkistaSarakkeet(kuka) || this.tarkistaViistot(kuka);
    }
    
    // Tarkistaa onko riveillä kolme vierekkäistä samaa merkkiä.
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
    
    // Tarkistaa onko sarakkeissa kolme vierekkäistä samaa merkkiä.
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
    
    // Tarkistaa onko viistoissa kolme vierekkäistä samaa merkkiä.
    public boolean tarkistaViistot(int kuka) {
        if (poyta[0][0] == kuka && poyta[1][1] == kuka && poyta[2][2] == kuka) {
            return true;
        }
        
        if (poyta[0][2] == kuka && poyta[1][1] == kuka && poyta[2][0] == kuka) {
            return true;
        }
        
        return false;
    }
    
    // Tarkistaa montako ristiä ja nollaa pöydässä on. Palauttaa tosi jos pöytä on täysi.
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
    
    // Tulostaa pöydän. Tämä metodi on testaustarkoituksiin.
    public void tulostaPoyta() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(poyta[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
