/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

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
        ComunicacaoRecebeInicial recebe = new ComunicacaoRecebeInicial();
        recebe.start();
    }
}
