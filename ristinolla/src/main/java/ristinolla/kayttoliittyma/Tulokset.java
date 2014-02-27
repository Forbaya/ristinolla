/**
 * Ville Tanttu
 * Ristinolla, Ohjelmoinnin harjoitustyö 2014
 */

package ristinolla.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ristinolla.logiikka.*;

/** Ikkuna tulosten tarkastelemiseen, sekä nollaamiseen.
 */
public class Tulokset extends JFrame {
    private JFrame frame;
    private TiedostonKasittelija tiedostonKasittelija;

    
    /** Alustaa oliomuuttujat ja avaa uuden ikkunan tuloksille.
     * @param logiikka Pelin logiikka
     */
    public Tulokset(Logiikka logiikka) {
        this.tiedostonKasittelija = logiikka.getTiedostonKasittelija();
        this.frame = new JFrame("Tulokset");
        this.frame.setPreferredSize(new Dimension(340, 340));
        this.frame.setResizable(false);
        this.frame.pack();
        try {
            this.luoKomponentit(frame.getContentPane());
        } catch (Exception ex) {
            Logger.getLogger(Tulokset.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.frame.setVisible(true);
    }
    
    /** Luo tulos-ikkunan komponentit, niiden kuuntelijat ja lisää ne containeriin.
     * @param container Container, johon komponentit asetetaan.
     */
    private void luoKomponentit(Container container) throws Exception {
        container.setLayout(new GridLayout(4, 1));
        
        final JTextField tekstiKentta = new JTextField("Risti " + tiedostonKasittelija.lueRistinPisteet() + " - " + tiedostonKasittelija.lueNollanPisteet() + " Nolla");
        final JTextArea tekstiAlue = new JTextArea();
        
        tekstiKentta.setEditable(false);
        tekstiAlue.setEditable(false);
        
        String aikaisemmatPelit = "";
        try {
            aikaisemmatPelit = tiedostonKasittelija.lueVoitot();
        } catch (Exception ex) {
            Logger.getLogger(Tulokset.class.getName()).log(Level.SEVERE, null, ex);
        }
        tekstiAlue.setText(aikaisemmatPelit);
        
        JButton nollaa = new JButton("Nollaa");
        luoNollaaKuuntelija(nollaa, tekstiKentta, tekstiAlue);
        
        JButton sulje = new JButton("Sulje");
        sulje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
            } 
        });
        
        
        container.add(tekstiKentta);
        container.add(tekstiAlue);
        container.add(nollaa);
        container.add(sulje);
    }
    
    /** Luo kuuntelijan nollaa-napille. Ristin ja nollan pisteet nollataan ja viimeksi pelatut pelit poistetaan.
     * @param nollaa Painike, jolle kuuntelija tehdään.
     * @param tekstiKentta Tekstikenttä, jossa näkyy ristin ja nollan pisteet.
     * @param tekstiAlue Tekstialue, jossa näkyy viime pelien voitot.
     */
    private void luoNollaaKuuntelija(JButton nollaa, final JTextField tekstiKentta, final JTextArea tekstiAlue) {
        nollaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tiedostonKasittelija.kirjoitaPisteisiin("0:0");
                    tiedostonKasittelija.nollaaViimeisetVoitot();
                    tekstiKentta.setText("Risti " + tiedostonKasittelija.lueRistinPisteet() + " - " + tiedostonKasittelija.lueNollanPisteet() + " Nolla");
                } catch (Exception ex) {
                    Logger.getLogger(Tulokset.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                tekstiAlue.setText("");
            }
        });
    }
}
