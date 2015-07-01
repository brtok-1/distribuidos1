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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Envio de mensagens via multicast
 *
 * @author Bruno Tokarski e Rafael Vidal
 */
public class MinhaComunicacaoEnvio extends Thread {

    Usuario usuario;
    Conexao conexao;
    String mensagem;

    InetAddress address;
    DatagramSocket serverSocket;

    /**
     * Configura a conexão multicast
     *
     * @throws Exception
     */
    public void ConfiguraConexaoMulticast() throws Exception {
        
        conexao = Conexao.getInstancia();        
        serverSocket = new DatagramSocket();
        address = InetAddress.getByName(conexao.getINET_ADDR());

    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * Envia a mensagem via multicast
     *
     * @throws Exception
     */
    public void EnviaMensagem() throws Exception {
        ConfiguraConexaoMulticast();
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dh = formatter.format(now);
        JanelaConsole.escreveNaJanela(dh + " Mandou: " + mensagem);
        DatagramPacket msgPacket = new DatagramPacket(mensagem.getBytes(), mensagem.getBytes().length, address, conexao.getPORT());
        serverSocket.send(msgPacket);
    }

    /**
     * Thread de envio de mensagens via multicast
     */
    @Override
    public void run() {
        try {
            EnviaMensagem();
        } catch (Exception ex) {
            Logger.getLogger(MinhaComunicacaoEnvio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
