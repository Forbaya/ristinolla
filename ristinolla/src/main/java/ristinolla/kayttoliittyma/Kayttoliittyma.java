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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import ristinolla.logiikka.Logiikka;

public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Logiikka logiikka;
    
    public Kayttoliittyma() {
        this.logiikka = new Logiikka();
    }
    
    @Override
    public void run() {
        frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(620, 340));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    // Asettaa GridLayoutin. Luo piirtoalustan ja menun, jotka lisätään containeriin.
    public void luoKomponentit(Container container){
        container.setLayout(new GridLayout(1, 2));
        
        JTextField tekstiKentta = new JTextField("Tervetuloa Ristinollaan!");
        tekstiKentta.setEditable(false);
        Piirtoalusta piirtoalusta = new Piirtoalusta();
        piirtoalusta.addMouseListener(new PiirtoalustaKuuntelija(this.logiikka, piirtoalusta, tekstiKentta));
        
        container.add(piirtoalusta);
        container.add(luoMenu(tekstiKentta, piirtoalusta));
    }
    
    /*  Luo oikean puolen käyttöliittymästä. Menu sisältää tekstikentän, sekä napit uudelle pelille ja
        pelin lopettamiselle. Tätä metodia kutsutaan luoKomponentit-metodissa. */
    public JPanel luoMenu(JTextField tekstiKentta, Piirtoalusta piirtoalusta) {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        
        JButton uusiPeli = new JButton("Uusi peli");
        uusiPeli.addActionListener(new UusiPeliKuuntelija(this.logiikka, tekstiKentta, piirtoalusta));
        
        JButton lopeta = new JButton("Lopeta");
        // Luo ActionListenerin lopeta-napille.
        lopeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        panel.add(tekstiKentta);
        panel.add(uusiPeli);
        panel.add(lopeta);
        panel.add(new JLabel(""));
        
        return panel;
    }
}
