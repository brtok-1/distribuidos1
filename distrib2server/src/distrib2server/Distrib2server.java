/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distrib2server;

import Controle.ControleRMI;
import GUI.JanelaInicialServidor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

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
            
            ControleRMI crmi = new ControleRMI();
            crmi.IniciaRMI();

        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            Logger.getLogger(Distrib2server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
