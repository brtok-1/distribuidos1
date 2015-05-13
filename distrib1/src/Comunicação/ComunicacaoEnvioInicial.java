/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import Modelo.Conexao;
import Modelo.Livro;
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
        synchronized (this) {
            //Obtem a conexao
            conexao = Conexao.getInstancia();
            //Obtem o usuário
            usuario = Usuario.getInstancia();
            try {
                ConfiguraConexao();
                while (conexao.getStatusLeilao().equalsIgnoreCase("aguardando") || conexao.getStatusLeilao().equalsIgnoreCase("tempoAdicional")) {
                    EnvioInicial();
                }
                while (conexao.isServidorOnline()) {
                    if (conexao.getStatusLeilao().equals("andamento")) {
                        ParticiparLeilao();
                    }
                }
                JanelaConsole.escreveNaJanela("O servidor caiu. A detecção de usuários e eleição");
                JanelaConsole.escreveNaJanela("de um novo servidor, começará em instantes.");
                notify();
            } catch (Exception ex) {
                Logger.getLogger(ComunicacaoEnvioInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Envio de informações enquanto se aguardam os usuários    
    public void EnvioInicial() throws Exception {
        mensagem = "77#" + usuario.getIdPublica() + "#" + usuario.getIdRede() + "#" + usuario.getPapel() + "#" + usuario.getChavePublica();
        EnviaMensagem();
        sleep(6000);
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

    //Configura a conexao
    public void ConfiguraConexao() throws Exception {
        address = InetAddress.getByName(conexao.getINET_ADDR());
        serverSocket = new DatagramSocket();
    }

    public void ParticiparLeilao() throws Exception {
        while (conexao.getStatusLeilao().equalsIgnoreCase("andamento")) {
            if (!(conexao.getBalcao().isEmpty())) {
                EnviaLivro();
                conexao.setBalcao(null);
            }
        }
    }

    //Envia o livro para leilão
    public void EnviaLivro() throws Exception {
        Livro livro = new Livro();
        livro = conexao.getBalcao().get(0);
        mensagem = "2#" + livro.getCodigo() + "#" + livro.getDescricao() + "#" + livro.getNome() + "#" + livro.getPrecoInicialString() 
                + "#" + livro.getTempoTotalLeilao();
        JanelaConsole.escreveNaJanela("Novo livro de  " + usuario.getIdPublica());
        EnviaMensagem();
    }

}
