/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import GUI.JanelaCriaLeilao;
import Modelo.Conexao;
import Modelo.Usuario;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ComunicacaoRecebeInicial extends Thread {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Conexao conexao;
    private Usuario usuarioLocal;
    private String[] mensagemQuebrada;
    private int participantesTempoAdicional;

    InetAddress address;
    MulticastSocket clientSocket;

    @Override
    public void run() {
        participantesTempoAdicional = 0;
        //Obtem a conexão
        conexao = Conexao.getInstancia();
        //Obtem o usuário local
        usuarioLocal = Usuario.getInstancia();
        ConfiguraConexao();
        while (true) {
            try {
                byte[] buf = new byte[256];
                DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                clientSocket.receive(msgPacket);
                String mensagem;
                mensagem = new String(buf);
                mensagem = mensagem.trim();
                Date now = new Date();
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String dh = formatter.format(now);
                JanelaConsole.escreveNaJanela(dh + " Recebeu: " + mensagem);
                mensagemQuebrada = mensagem.split("#");
                DirecionaMensagem();
            } catch (Exception ex) {
                Logger.getLogger(ComunicacaoRecebeInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void RecebeParticipantes() throws Exception {
        Usuario usuario = new Usuario(Integer.parseInt(mensagemQuebrada[2]), mensagemQuebrada[1], null, null, mensagemQuebrada[3]);
        boolean naoAchou = true;
        for (Usuario us : usuarios) {
            if (us.getIdPublica().equalsIgnoreCase(usuario.getIdPublica()) && us.getIdRede() == usuario.getIdRede()) {
                naoAchou = false;
            }
        }
        if (naoAchou) {
            usuarios.add(usuario);
            conexao.setQuantidadeUsuarios(conexao.getQuantidadeUsuarios() + 1);
            JanelaCriaLeilao.atualizar(usuarios);
            if (usuarioLocal.getPapel().equalsIgnoreCase("servidor") && ((!(usuario.getIdPublica().equals(usuarioLocal.getIdPublica()))) && (usuario.getIdRede() > usuarioLocal.getIdRede()))) {
                usuarioLocal.setPapel("cliente");
            }
        }
        if (usuarios.size() >= 4) {
            JanelaConsole.escreveNaJanela("Aguarde mais alguns segundos");
            JanelaConsole.escreveNaJanela("enquanto identificamos se pode haver mais conexões.");
            conexao.setStatusLeilao("tempoAdicional");
        }
    }

    public void RecebeParticipantesTempoAdicional() throws Exception {
        Usuario usuario = new Usuario(Integer.parseInt(mensagemQuebrada[2]), mensagemQuebrada[1], null, null, mensagemQuebrada[3]);
        boolean naoAchou = true;
        for (Usuario us : usuarios) {
            if (us.getIdPublica().equalsIgnoreCase(usuario.getIdPublica()) && us.getIdRede() == usuario.getIdRede()) {
                naoAchou = false;
            }
        }
        if (naoAchou) {
            usuarios.add(usuario);
            conexao.setQuantidadeUsuarios(conexao.getQuantidadeUsuarios() + 1);
            JanelaCriaLeilao.atualizar(usuarios);
            if (usuarioLocal.getPapel().equalsIgnoreCase("servidor") && ((!(usuario.getIdPublica().equals(usuarioLocal.getIdPublica()))) && (usuario.getIdRede() > usuarioLocal.getIdRede()))) {
                usuarioLocal.setPapel("cliente");
            }
        }
        participantesTempoAdicional++;
        sleep(1000);
        if (participantesTempoAdicional > 9) {
            conexao.setStatusLeilao("andamento");
            participantesTempoAdicional = 0;
            if (usuarioLocal.getPapel().equalsIgnoreCase("servidor")) {
                JanelaConsole.escreveNaJanela("Característica já definida: SERVIDOR");
            } else {
                JanelaConsole.escreveNaJanela("Característica já definida: CLIENTE");
            }
            JanelaConsole.escreveNaJanela("Aguardando inicio de Leilão.");
            JanelaCriaLeilao.mostraBotao(true);
        }
    }

    //Configura a conexao
    public void ConfiguraConexao() {
        try {
            address = InetAddress.getByName(conexao.getINET_ADDR());
            clientSocket = new MulticastSocket(conexao.getPORT());
            clientSocket.joinGroup(address);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Recebe mensagem através do multicast
//    public void RecebeMensagem() throws Exception {
//
//    }
    //direcionar mensagem para um método ou thread
    public void DirecionaMensagem() throws Exception {
        int tipoMensagem = Integer.parseInt(mensagemQuebrada[0]);
        switch (tipoMensagem) {
            case 1:
                HelloServer();
                break;
            case 77:
                if (conexao.getStatusLeilao().equalsIgnoreCase("aguardando")) {
                    RecebeParticipantes();
                }
                if (conexao.getStatusLeilao().equalsIgnoreCase("tempoAdicional")) {
                    RecebeParticipantesTempoAdicional();
                }
                break;
            default:
                JanelaConsole.escreveNaJanela("A última mensagem recebida é desconhecida.");
        }
    }

    //Salva os participantes do leilão
    public void MantemParticipantes() {

    }

    //Escuta os participantes do leilão
    public void EscutaLeilao() throws Exception {

    }

    //Escuta Hello Servidor
    public void HelloServer() throws Exception {
        conexao.setUltimoHelloServer(System.currentTimeMillis());
    }
}
