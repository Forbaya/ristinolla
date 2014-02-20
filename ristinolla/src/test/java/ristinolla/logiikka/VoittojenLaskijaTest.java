/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VoittojenLaskijaTest {
    VoittojenLaskija voittojenLaskija;
    
    @Before
    public void setUp() {
        voittojenLaskija = new VoittojenLaskija();
    }

    // Testaa muuttujien alustukset.
    @Test
    public void konstruktorinTestaus() {
        assertTrue(voittojenLaskija.getVoitot() != null);
        assertEquals(0, voittojenLaskija.getNollanVoitot());
        assertEquals(0, voittojenLaskija.getRistinVoitot());
    }
    
    // Testaa toimiiko voiton lisääminen ristille.
    @Test
    public void voittoRistille() {
        voittojenLaskija.lisaaVoitto(1);
        assertEquals(1, voittojenLaskija.getRistinVoitot());
    }
    
    // Testaa toimiiko voiton lisääminen nollalle.
    @Test
    public void voittoNollalle() {
        voittojenLaskija.lisaaVoitto(2);
        assertEquals(1, voittojenLaskija.getNollanVoitot());
    }

}
