/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import GUI.JanelaCriaLeilao;
import Inicio.Conexao;
import static Inicio.Distrib1.conexoes;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ComunicacaoRecebeInicial extends Thread {

    /**
     *
     */
    @Override
    public void run() {
        try {
            boolean naotem4 = true;
            InetAddress addres = InetAddress.getByName(DefinirComunicacao.INET_ADDR);
            try (MulticastSocket clientSocket = new MulticastSocket(DefinirComunicacao.PORT)) {
                clientSocket.joinGroup(addres);
                while (naotem4) {
                    byte[] buf = new byte[256];
                    DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                    clientSocket.receive(msgPacket);
                    String msg = new String(buf);
                    msg = msg.trim();
                    JanelaConsole.escreveNaJanela("Recebeu: " + msg);
                    String [] msgs = msg.split("#");
                    Conexao c = new Conexao(msgs[0], Integer.parseInt(msgs[1]));
                    boolean naoAchou = true;
                    for (int i = 0; i < conexoes.size(); i++) {
                        if (conexoes.get(i).getIdPublica().equalsIgnoreCase(c.getIdPublica()) && conexoes.get(i).getIdRede() == c.getIdRede()) {
                            naoAchou = false;
                        }
                    }
                    if (naoAchou) {
                        conexoes.add(c);
                        JanelaCriaLeilao.atualizar();
                    }
                    if (conexoes.size() >= 4) {
                        naotem4 = false;
                        ComunicacaoEnvioInicial.naotem4 = false;
                    }
                }
                clientSocket.leaveGroup(addres);
            } catch (IOException ex) {
                Logger.getLogger(ComunicacaoRecebeInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(ComunicacaoRecebeInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
