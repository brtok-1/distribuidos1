/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distrib1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Bruno
 */
public class Distrib1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Distrib1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JanelaMinhaIDPublica jid = new JanelaMinhaIDPublica();
        jid.setVisible(true);
        jid.repaint();
    }
    
}
