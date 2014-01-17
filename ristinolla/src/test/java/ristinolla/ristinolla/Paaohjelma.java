package ristinolla.ristinolla;

/**
 * Ville Tanttu, opiskelijanumero 014245482
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Paaohjelma extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Paaohjelma( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( Paaohjelma.class );
    }

    public void testApp() {
        assertTrue( true );
    }
}
