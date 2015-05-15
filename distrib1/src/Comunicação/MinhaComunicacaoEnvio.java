/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import Modelo.Conexao;
import Modelo.Usuario;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bruno
 */
public class MinhaComunicacaoEnvio extends Thread {

    private Usuario usuario;
    private Conexao conexao;
    private String mensagem;
    
    InetAddress address;
    DatagramSocket serverSocket;

    //Configura a conexao multicast
    public void ConfiguraConexaoMulticast() throws Exception {
        address = InetAddress.getByName(conexao.getINET_ADDR());
        serverSocket = new DatagramSocket();
    }
    
    
    //Envia mensagem
    public void EnviaMensagem() throws Exception {
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dh = formatter.format(now);
        JanelaConsole.escreveNaJanela(dh + " Mandou: " + mensagem);
        DatagramPacket msgPacket = new DatagramPacket(mensagem.getBytes(), mensagem.getBytes().length, address, conexao.getPORT());
        serverSocket.send(msgPacket);
    }

}
