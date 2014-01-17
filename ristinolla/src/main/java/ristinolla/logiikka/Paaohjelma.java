package ristinolla.logiikka;

/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

public class Paaohjelma {
    public static void main(String[] args) {
        Logiikka logiikka = new Logiikka();
        logiikka.tulostaTaulu();
        logiikka.suoritaVuoro(2, 0, 0);
        logiikka.suoritaVuoro(2, 1, 1);
        logiikka.suoritaVuoro(2, 2, 2);
        logiikka.tulostaTaulu();
        System.out.println(logiikka.tarkistaVoitto(2));
    }
}
