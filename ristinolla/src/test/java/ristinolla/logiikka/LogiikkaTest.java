/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LogiikkaTest {
    Logiikka logiikka;
    
    @Before
    public void setUp() {
        logiikka = new Logiikka();
    }
    
    // Testaa konstruktorin luoman pöydän alkioiden sisällön, sekä muut sen luomat muuttujat.
    @Test
    public void konstruktorinLuomatMuuttujat() {
        int poyta[][] = logiikka.getPoyta();
        /*
        assertEquals(0, poyta[0][0]);
        assertEquals(0, poyta[0][1]);
        assertEquals(0, poyta[0][2]);
        assertEquals(0, poyta[1][0]);
        assertEquals(0, poyta[1][1]);
        assertEquals(0, poyta[1][2]);
        assertEquals(0, poyta[2][0]);
        assertEquals(0, poyta[2][1]);
        assertEquals(0, poyta[2][2]);
        */
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, poyta[i][j]);
            }
        }
        
        assertEquals(0, logiikka.getPelinTila());
        assertEquals(0, logiikka.getVuoro());
    }
    
    // Testaa täyden pöydän nollauksen.
    @Test
    public void nollaus() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 0);
        logiikka.suoritaVuoro(1, 0, 1);
        logiikka.suoritaVuoro(2, 0, 2);
        logiikka.suoritaVuoro(2, 1, 0);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 1, 2);
        logiikka.suoritaVuoro(1, 2, 0);
        logiikka.suoritaVuoro(2, 2, 1);
        logiikka.suoritaVuoro(2, 2, 2);
        int poyta[][] = logiikka.getPoyta();
        
        logiikka.nollaa();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, poyta[i][j]);
            }
        }
    }
    
    /* Testaa xxx
     *        ...
     *        ... */
    @Test
    public void ylaRiviX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 0);
        logiikka.suoritaVuoro(1, 0, 1);
        logiikka.suoritaVuoro(1, 0, 2);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa ooo
     *        ...
     *        ... */
    @Test
    public void ylaRiviO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 0);
        logiikka.suoritaVuoro(2, 0, 1);
        logiikka.suoritaVuoro(2, 0, 2);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa ...
     *        xxx
     *        ... */
    @Test
    public void keskiRiviX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 1, 0);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 1, 2);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa ...
     *        ooo
     *        ... */
    @Test
    public void keskiRiviO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 1, 0);
        logiikka.suoritaVuoro(2, 1, 1);
        logiikka.suoritaVuoro(2, 1, 2);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa ...
     *        ...
     *        xxx */
    @Test
    public void alaRiviX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 2, 0);
        logiikka.suoritaVuoro(1, 2, 1);
        logiikka.suoritaVuoro(1, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa ...
     *        ...
     *        ooo */
    @Test
    public void alaRiviO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 2, 0);
        logiikka.suoritaVuoro(2, 2, 1);
        logiikka.suoritaVuoro(2, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa x..
     *        x..
     *        x.. */
    @Test
    public void vasenSarakeX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 0);
        logiikka.suoritaVuoro(1, 1, 0);
        logiikka.suoritaVuoro(1, 2, 0);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa o..
     *        o..
     *        o.. */
    @Test
    public void vasenSarakeO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 0);
        logiikka.suoritaVuoro(2, 1, 0);
        logiikka.suoritaVuoro(2, 2, 0);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa .x.
     *        .x.
     *        .x. */
    @Test
    public void keskiSarakeX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 1);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 2, 1);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa .o.
     *        .o.
     *        .o. */
    @Test
    public void keskiSarakeO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 1);
        logiikka.suoritaVuoro(2, 1, 1);
        logiikka.suoritaVuoro(2, 2, 1);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa ..x
     *        ..x
     *        ..x */
    @Test
    public void oikeaSarakeX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 2);
        logiikka.suoritaVuoro(1, 1, 2);
        logiikka.suoritaVuoro(1, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa ..o
     *        ..o
     *        ..o */
    @Test
    public void oikeaSarakeO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 2);
        logiikka.suoritaVuoro(2, 1, 2);
        logiikka.suoritaVuoro(2, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa x..
     *        .x.
     *        ..x */
    @Test
    public void viistoVasemmaltaOikealleX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 0);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa o..
     *        .o.
     *        ..o */
    @Test
    public void viistoVasemmaltaOikealleO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 0);
        logiikka.suoritaVuoro(2, 1, 1);
        logiikka.suoritaVuoro(2, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa ..x
     *        .x.
     *        x.. */
    @Test
    public void viistoOikealtaVasemmalleX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 2);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 2, 0);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa ..o
     *        .o.
     *        o.. */
    @Test
    public void viistoOikealtaVasemmalleO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 2);
        logiikka.suoritaVuoro(2, 1, 1);
        logiikka.suoritaVuoro(2, 2, 0);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
}
