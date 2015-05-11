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
public class ComunicacaoEnvioInicial extends Thread {

    private Usuario usuario;
    private Conexao conexao;
    private String mensagem;

    InetAddress address;
    DatagramSocket serverSocket;

    @Override
    public void run() {

        try {
            //Obtem a conexao
            conexao = Conexao.getInstancia();
            //Obtem o usuário
            usuario = Usuario.getInstancia();
            ConfiguraConexao();
            while (true) {
                if (conexao.getStatusLeilao().equals("aguardando")) {
                    EnvioInicial();
                }
                if (conexao.getStatusLeilao().equals("andamento")) {
                    ParticiparLeilao();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Envio de informações enquanto se aguardam os usuários    
    public void EnvioInicial() throws Exception {
        while (conexao.getStatusLeilao().equalsIgnoreCase("aguardando")) {
            mensagem = "#" + usuario.getIdPublica() + "#" + usuario.getIdRede() + "#" + usuario.getPapel() + "#" + usuario.getChavePublica();
            EnviaMensagem();
            sleep(5000);
        }
    }

    //Envia mensagem
    public void EnviaMensagem() throws Exception {
        DatagramPacket msgPacket = new DatagramPacket(mensagem.getBytes(), mensagem.getBytes().length, address, conexao.getPORT());
        serverSocket.send(msgPacket);
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dh = formatter.format(now);
        JanelaConsole.escreveNaJanela(dh + " Mandou: " + mensagem);
    }

    //Configura a conexao
    public void ConfiguraConexao() throws Exception {
        address = InetAddress.getByName(conexao.getINET_ADDR());
        serverSocket = new DatagramSocket();
    }

    public void ParticiparLeilao() throws Exception {
        while (conexao.getStatusLeilao().equalsIgnoreCase("andamento")) {

            if (!conexao.getBalcao().isEmpty()) {
                EnviaLivro();
                conexao.setBalcao(null);
            }

            //Envia um "olá" a cada 10 segundos para avisar que continua participando do leilão
            if (usuario.getPapel().equals("servidor")) {
                mensagem = "ola";
                EnviaMensagem();
                sleep(10000);
            }

        }
    }
    
    //Envia o livro para leilão
    public void EnviaLivro() throws Exception {
        
        mensagem = "Novo livro de " + usuario.getIdPublica();
        EnviaMensagem();

    }

    

}
