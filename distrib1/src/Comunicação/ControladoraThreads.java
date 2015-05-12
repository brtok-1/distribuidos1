/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import GUI.JanelaCriaLeilao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ControladoraThreads extends Thread {

    /**
     *
     */
    @Override
    public void run() {
        try {
            ComunicacaoEnvioInicial envio = new ComunicacaoEnvioInicial();
            envio.start();
            JanelaConsole.escreveNaJanela("Thread de envio iniciada.");
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladoraThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ComunicacaoRecebeInicial recebe = new ComunicacaoRecebeInicial();
            recebe.start();
            JanelaConsole.escreveNaJanela("Thread de recepção iniciada.");
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladoraThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Controladora() {
        try {
            JanelaConsole.escreveNaJanela("Controladora de Threads iniciada.");
            JanelaCriaLeilao jcl = new JanelaCriaLeilao();
            jcl.setVisible(true);
            jcl.repaint();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladoraThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
