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
                InetAddress addr = InetAddress.getByName(DefinirComunicacao.INET_ADDR);
                DatagramSocket serverSocket = new DatagramSocket();
                String msg = Distrib1.IDpublica + "#" + DefinirComunicacao.idRede;
                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, DefinirComunicacao.PORT);
                serverSocket.send(msgPacket);
                JanelaConsole.escreveNaJanela("Mandou: " + msg);
                sleep(5000);
            }
        } catch (IOException | ClassNotFoundException | InterruptedException ex) {
            Logger.getLogger(ComunicacaoEnvioInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
