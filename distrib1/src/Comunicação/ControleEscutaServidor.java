/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import Modelo.Conexao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ControleEscutaServidor extends Thread {

    private Conexao conexao;

    /**
     *
     */
    @Override
    public void run() {
        conexao = Conexao.getInstancia();
        try {
            sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControleEscutaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (!(conexao.getStatusLeilao().equalsIgnoreCase("quedaServidor"))) {
            try {
                sleep(3500);
                if (System.currentTimeMillis() > (conexao.getUltimoHelloServer() + 10000)) {
                    conexao.setStatusLeilao("quedaServidor");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ControleEscutaServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
