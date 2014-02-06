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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ristinolla.logiikka.*;

public class Tulokset extends JFrame {
    private JFrame frame;
    private VoittojenLaskija voittojenLaskija;
    
    public Tulokset(Logiikka logiikka) {
        this.voittojenLaskija = logiikka.getVoittojenLaskija();
        this.frame = new JFrame("Tulokset");
        this.frame.setPreferredSize(new Dimension(340, 340));
        this.frame.setResizable(false);
        this.frame.pack();
        this.luoKomponentit(frame.getContentPane());
        this.frame.setVisible(true);
    }
    
    public VoittojenLaskija getVoittojenLaskija() {
        return this.voittojenLaskija;
    }
    
    /** Luo tulos-ikkunan komponentit ja lisää ne containeriin.
     * @param container 
     */
    public void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(3, 1));
        
        JTextField tekstiKentta = new JTextField("Risti " + voittojenLaskija.getRistinVoitot() + " - " + voittojenLaskija.getNollanVoitot() + " Nolla");
        JTextArea tekstiAlue = new JTextArea();
        
        tekstiKentta.setEditable(false);
        tekstiAlue.setEditable(false);
        String aikaisemmatPelit = "";
        
        ArrayList<Integer> voitot = voittojenLaskija.getVoitot();
        for (int i = 0; i < voitot.size(); i++) {
            if (voitot.get(i) == 1) {
                aikaisemmatPelit += "Risti voitti\n";
            } else {
                aikaisemmatPelit += "Nolla voitti\n";
            }
        }
        
        tekstiAlue.setText(aikaisemmatPelit);
        JButton sulje = new JButton("Sulje");
        sulje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
            } 
        });
        
        container.add(tekstiKentta);
        container.add(tekstiAlue);
        container.add(sulje);
    }
}
