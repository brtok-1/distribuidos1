/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distrib2client;

import Comunicacao.RMICliente;
import GUI.InicialClient;
import GUI.JanelaConsole;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            JanelaConsole janelaConsole = JanelaConsole.getInstancia();
            janelaConsole.setVisible(true);

            InicialClient ic = new InicialClient();
            ic.setVisible(true);
            ic.repaint();
            janelaConsole.EscreveNaJanela("Aplicação iniciada.");            
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Distrib2client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Distrib2client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
