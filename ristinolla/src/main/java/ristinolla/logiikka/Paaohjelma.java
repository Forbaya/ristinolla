/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.logiikka;

public class Paaohjelma {
    public static void main(String[] args) {
        Logiikka logiikka = new Logiikka();
        logiikka.tulostaTaulu();
        logiikka.suoritaVuoro(2, 0, 0);
        logiikka.suoritaVuoro(2, 1, 0);
        logiikka.suoritaVuoro(2, 2, 0);
        logiikka.tulostaTaulu();
        System.out.println(logiikka.tarkistaVoitto(2));
    }
}
