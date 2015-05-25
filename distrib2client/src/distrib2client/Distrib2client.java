/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distrib2client;

import Controle.ControleRMICliente;
import GUI.InicialClient;
import GUI.JanelaConsole;
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
    public static void main(String[] args) throws InterruptedException {
        JanelaConsole janelaConsole = JanelaConsole.getInstancia();
        janelaConsole.setVisible(true);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            InicialClient ic = new InicialClient();
            ic.setVisible(true);
            ic.repaint();

            janelaConsole.EscreveNaJanela("Aplicação iniciada.");

            ControleRMICliente crmic = new ControleRMICliente();
            crmic.IniciaRMI();

        } catch (Exception e) {
            janelaConsole.EscreveNaJanela("Erro: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
