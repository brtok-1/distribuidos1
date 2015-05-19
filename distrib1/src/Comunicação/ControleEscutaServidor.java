/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
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
        try {
            sleep(10000);
            JanelaConsole.escreveNaJanela("Escuta Hello iniciada.");
            conexao = Conexao.getInstancia();
            conexao.setUltimoHelloServer(System.currentTimeMillis()+10000);
            Conexao.setInstancia(conexao);
            while (conexao.isServidorOnline()) {
                if (System.currentTimeMillis() > (conexao.getUltimoHelloServer() + 10000)) {
                    conexao.setServidorOnline(false);
                }
                sleep(8000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ControleEscutaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
