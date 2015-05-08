/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import Modelo.Conexao;
import Modelo.Usuario;
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

    private Usuario usuario;
    private Conexao conexao;
    
    //static boolean naotem4 = true;
    /**
     *
     */
    @Override
    public void run() {
        
        //Obtem a conexao
        conexao = Conexao.getInstancia();
        
        //Obtem o usuário
        usuario = Usuario.getInstancia();        
        
        if(conexao.getStatusLeilao().equals("aguardando"))
        {
            EnvioInicial();
        }
        if(conexao.getStatusLeilao().equals("andamento"))
        {
            ParticiparLeilao();
        }    
    }
    
    //Envio de informações enquanto se aguardam os usuários    
    public void EnvioInicial()
    {
        try {           
            while (conexao.getStatusLeilao().equalsIgnoreCase("aguardando")) {
                InetAddress addr = InetAddress.getByName(conexao.getINET_ADDR());
                DatagramSocket serverSocket = new DatagramSocket();
                String msg = usuario.getIdPublica() + "#" + usuario.getIdRede() + "#" + usuario.getPapel() + "#" + usuario.getChavePublica();
                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, conexao.getPORT());
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
    
    public void ParticiparLeilao()
    {        
        if(usuario.getPapel().equalsIgnoreCase("servidor"))
        {
            
        }
    }
    
    
    
}
