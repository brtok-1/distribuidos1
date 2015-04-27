/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import Inicio.Distrib1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ComunicacaoEnvioInicial extends Thread {

    /**
     *
     */
    @Override
    public void run() {
        try {
            DefinirComunicacao comunica = new DefinirComunicacao();
            boolean naotem4 = true;
            while (naotem4) {
                InetAddress addr = InetAddress.getByName(comunica.INET_ADDR);
                try (DatagramSocket serverSocket = new DatagramSocket()) {
                    for (int i = 0; i < 100; i++) {
                        String msg = Distrib1.IDpublica;
                        DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, comunica.PORT);
                        serverSocket.send(msgPacket);
                        JanelaConsole.escreveNaJanela("Mandou: " + msg);
                        try {
                            sleep(2500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ComunicacaoEnvioInicial.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ComunicacaoEnvioInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ComunicacaoEnvioInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
