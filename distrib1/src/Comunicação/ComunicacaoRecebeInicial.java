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

/**
 *
 * @author Bruno
 */
public class ComunicacaoRecebeInicial extends Thread {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Conexao conexao;
    private Usuario usuarioLocal;
    private String mensagem;

    InetAddress address;
    MulticastSocket clientSocket;

    @Override
    public void run() {

        try {
            //Obtem a conexão
            conexao = Conexao.getInstancia();
            //Obtem o usuário local
            usuarioLocal = Usuario.getInstancia();

            ConfiguraConexao();

            while (true) {

                if (conexao.getStatusLeilao().equalsIgnoreCase("aguardando")) {
                    RecebeParticipantes();
                }
                if (conexao.getStatusLeilao().equalsIgnoreCase("andamento")) {
                    if (usuarioLocal.getPapel().equalsIgnoreCase("servidor")) {
                    } else {
                        MantemParticipantes();
                        EscutaLeilao();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    public void RecebeParticipantes() throws Exception {

        while (conexao.getStatusLeilao().equalsIgnoreCase("aguardando")) {

            RecebeMensagem();
            String[] dadosRecebidos = mensagem.split("#");

            Usuario usuario = new Usuario(Integer.parseInt(dadosRecebidos[1]), dadosRecebidos[0], null, null, dadosRecebidos[2]);
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
                JanelaConsole.escreveNaJanela("Aguarde mais 10 segundos pois podem haver novas conexões.");

                for (int i = 0; i < 10; i++) {
                    RecebeMensagem();
                    String[] dadosRecebidos2 = mensagem.split("#");
                    Usuario novoUsuario = new Usuario(Integer.parseInt(dadosRecebidos2[1]), dadosRecebidos2[0], null, null, dadosRecebidos2[2]);
                    boolean naoAchou2 = true;
                    for (Usuario us : usuarios) {
                        if (us.getIdPublica().equalsIgnoreCase(novoUsuario.getIdPublica()) && us.getIdRede() == novoUsuario.getIdRede()) {
                            naoAchou2 = false;
                        }
                    }

                    if (naoAchou2) {
                        usuarios.add(novoUsuario);
                        conexao.setQuantidadeUsuarios(conexao.getQuantidadeUsuarios() + 1);
                        JanelaCriaLeilao.atualizar(usuarios);
                    }
                    sleep(1000);
                }

                conexao.setStatusLeilao("andamento");
                if (usuarioLocal.getPapel().equalsIgnoreCase("servidor")) {
                    JanelaConsole.escreveNaJanela("Característica já definida: SERVIDOR");
                } else {
                    JanelaConsole.escreveNaJanela("Característica já definida: CLIENTE");
                }
                JanelaConsole.escreveNaJanela("Leilão iniciado");
            }
        }

        //clientSocket.leaveGroup(addres);
        JanelaCriaLeilao.mostraBotao(true);

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
    public void RecebeMensagem() throws Exception {

        byte[] buf = new byte[256];
        DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
        clientSocket.receive(msgPacket);
        mensagem = new String(buf);
        mensagem = mensagem.trim();
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dh = formatter.format(now);
        JanelaConsole.escreveNaJanela(dh + " Recebeu: " + mensagem);

    }

    //Salva os participantes do leilão
    public void MantemParticipantes() {

    }

    //Escuta os participantes do leilão
    public void EscutaLeilao() throws Exception {
        RecebeMensagem();
        String[] dadosRecebidos = mensagem.split("#");
    }

}
