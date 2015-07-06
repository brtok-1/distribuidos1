/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import Modelo.Colecionador;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class MulticastRecebimento extends Thread {

    @Override
    public void run() {
        try {
            InetAddress address = InetAddress.getByName("228.5.6.7");
            MulticastSocket clientSocket = new MulticastSocket(8885);
            clientSocket.joinGroup(address);
            while (true) {
                byte[] buf = new byte[256];
                DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                clientSocket.receive(msgPacket);
                String mensagem = new String(buf);
                int recebido = Integer.parseInt(mensagem.trim());
                Colecionador instancia = Colecionador.getInstancia();
                instancia.getListaParticipantes().add(recebido);
            }
        } catch (Exception ex) {
            Logger.getLogger(MulticastRecebimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
