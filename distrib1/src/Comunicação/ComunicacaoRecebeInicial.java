/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import GUI.JanelaCriaLeilao;
import Inicio.Conexao;
import Inicio.Distrib1;
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
            InetAddress addres = InetAddress.getByName(Distrib1.INET_ADDR);
            try (MulticastSocket clientSocket = new MulticastSocket(Distrib1.PORT)) {
                clientSocket.joinGroup(addres);
                while (naotem4) {
                    byte[] buf = new byte[256];
                    DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                    clientSocket.receive(msgPacket);
                    String msg = new String(buf);
                    msg = msg.trim();
                    JanelaConsole.escreveNaJanela("Recebeu: " + msg);
                    String[] msgs = msg.split("#");
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
                        if (Distrib1.souOq.equalsIgnoreCase("servidor") && ((!(c.getIdPublica().equals(Distrib1.idPublica))) && (c.getIdRede() > Distrib1.idRede))) {
                            Distrib1.souOq = "cliente";
                        }
                    }
                    if (conexoes.size() >= 4) {
                        JanelaConsole.escreveNaJanela("Aguarde mais 10 segundos pois podem haver novas conexões.");
                        for (int i = 0; i < 10; i++) {
                            byte[] outrobuf = new byte[256];
                            DatagramPacket msgPacket2 = new DatagramPacket(outrobuf, outrobuf.length);
                            clientSocket.receive(msgPacket2);
                            String msg2 = new String(outrobuf);
                            msg2 = msg2.trim();
                            JanelaConsole.escreveNaJanela("Recebeu: " + msg2);
                            String[] msgs2 = msg2.split("#");
                            Conexao c2 = new Conexao(msgs2[0], Integer.parseInt(msgs2[1]));
                            boolean naoAchou2 = true;
                            for (int j = 0; j < conexoes.size(); j++) {
                                if (conexoes.get(j).getIdPublica().equalsIgnoreCase(c2.getIdPublica()) && conexoes.get(j).getIdRede() == c2.getIdRede()) {
                                    naoAchou2 = false;
                                }
                            }
                            if (naoAchou2) {
                                conexoes.add(c2);
                                JanelaCriaLeilao.atualizar();
                            }
                            sleep(1000);
                        }
                        naotem4 = false;
                        ComunicacaoEnvioInicial.naotem4 = false;
                        if (Distrib1.souOq.equalsIgnoreCase("servidor")) {
                            JanelaConsole.escreveNaJanela("Característica já definida: SERVIDOR");
                        } else {
                            JanelaConsole.escreveNaJanela("Característica já definida: CLIENTE");
                        }
                    }
                }
                clientSocket.leaveGroup(addres);
            } catch (IOException ex) {
                Logger.getLogger(ComunicacaoRecebeInicial.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ComunicacaoRecebeInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(ComunicacaoRecebeInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
