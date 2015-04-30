/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
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
        ComunicacaoEnvioInicial envio = new ComunicacaoEnvioInicial();
        envio.start();
        try {
            JanelaConsole.escreveNaJanela("Thread Multicast inicial de envio iniciada.");
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladoraThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
        ComunicacaoRecebeInicial recebe = new ComunicacaoRecebeInicial();
        recebe.start();
        try {
            JanelaConsole.escreveNaJanela("Thread Multicast inicial de recepção iniciada.");
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladoraThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
