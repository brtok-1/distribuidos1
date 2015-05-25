/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distrib2client;

import Controle.ControleRMICliente;
import GUI.InicialClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Bruno
 */
public class Distrib2client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Distrib2client.class.getName()).log(Level.SEVERE, null, ex);
        }

        InicialClient ic = new InicialClient();
        ic.setVisible(true);
        ic.repaint();
        
        ControleRMICliente crmic = new ControleRMICliente();
        crmic.IniciaRMI();
    }
    
}
