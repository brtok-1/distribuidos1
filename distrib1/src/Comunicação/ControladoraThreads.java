/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import java.io.IOException;
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
            DefinirComunicacao comunica = new DefinirComunicacao();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ControladoraThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
        ComunicacaoEnvioInicial envio = new ComunicacaoEnvioInicial();
        envio.start();
        ComunicacaoRecebeInicial recebe = new ComunicacaoRecebeInicial();
        recebe.start();
    }
}
