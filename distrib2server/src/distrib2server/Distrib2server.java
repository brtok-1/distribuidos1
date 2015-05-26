/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distrib2server;

import Comunicacao.RMIServer;
import GUI.JanelaInicialServidor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Bruno
 */
public class Distrib2server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JanelaInicialServidor jis = new JanelaInicialServidor();
            jis.setVisible(true);
            jis.repaint();
            RMIServer rmis = new RMIServer();
            rmis.IniciaRMI();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Distrib2server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Distrib2server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
