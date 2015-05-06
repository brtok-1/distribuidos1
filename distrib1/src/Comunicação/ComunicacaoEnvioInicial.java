/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import Modelo.Conexao;
//import Inicio.Distrib1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ComunicacaoEnvioInicial extends Thread {

    private Conexao conexao;
    
    static boolean naotem4 = true;
    /**
     *
     */
    @Override
    public void run() {
        try {
            while (naotem4) {
                InetAddress addr = InetAddress.getByName(Distrib1.INET_ADDR);
                DatagramSocket serverSocket = new DatagramSocket();
                String msg = Distrib1.idPublica + "#" + Distrib1.idRede;
                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, Distrib1.PORT);
                serverSocket.send(msgPacket);
                Date now = new Date();
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String dh = formatter.format(now);
                JanelaConsole.escreveNaJanela(dh + " Mandou: " + msg);
                sleep(5000);
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ComunicacaoEnvioInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Conexao getConexao() {
        return conexao;
    }

    public void setConexao(Conexao conexao) {
        this.conexao = conexao;
    }
    
    
    
    
}
