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
//import static Inicio.Distrib1.conexoes;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
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

    //public static ArrayList<Conexao> conexoes = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    /**
     *
     */
    @Override
    public void run() {
        try {
            //Obtem a conexão
            Conexao conexao = Conexao.getInstancia();
            
            boolean naotem4 = true;
            InetAddress addres = InetAddress.getByName(conexao.getINET_ADDR());
            try (MulticastSocket clientSocket = new MulticastSocket(conexao.getPORT())) {
                clientSocket.joinGroup(addres);
                while (naotem4) {
                    byte[] buf = new byte[256];
                    DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                    clientSocket.receive(msgPacket);
                    String msg = new String(buf);
                    msg = msg.trim();
                    JanelaConsole.escreveNaJanela("Recebeu: " + msg);
                    String[] msgs = msg.split("#");
                    //Obtem o usuário local
                    Usuario usuarioLocal = Usuario.getInstancia();
                    Usuario usuario = new Usuario(Integer.parseInt(msgs[1]), msgs[0], null, null, msgs[2]);
                    boolean naoAchou = true;
                    for (Usuario us : usuarios) {
                        if (us.getIdPublica().equalsIgnoreCase(usuario.getIdPublica()) && us.getIdRede() == usuario.getIdRede()) {
                            naoAchou = false;
                        }
                    }
                    if (naoAchou) {
                        //conexoes.add(c);
                        usuarios.add(usuario);
                        //JanelaCriaLeilao.atualizar(conexoes);
                        JanelaCriaLeilao.atualizar(usuarios);
                        if (usuarioLocal.getPapel().equalsIgnoreCase("servidor") && ((!(usuario.getIdPublica().equals(usuarioLocal.getIdPublica()))) && (usuario.getIdRede() > usuarioLocal.getIdRede()))) {
                            //Distrib1.souOq = "cliente";
                            usuarioLocal.setPapel("cliente");
                        }
                    }
                    if (usuarios.size() >= 4) {
                        JanelaConsole.escreveNaJanela("Aguarde mais 10 segundos pois podem haver novas conexões.");
                        for (int i = 0; i < 10; i++) {
                            byte[] outrobuf = new byte[256];
                            DatagramPacket msgPacket2 = new DatagramPacket(outrobuf, outrobuf.length);
                            clientSocket.receive(msgPacket2);
                            Date now = new Date();
                            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            String dh = formatter.format(now);
                            String msg2 = new String(outrobuf);
                            msg2 = msg2.trim();
                            JanelaConsole.escreveNaJanela(dh + " Recebeu: " + msg2);
                            String[] msgs2 = msg2.split("#");
                            Usuario novoUsuario = new Usuario(Integer.parseInt(msgs2[1]), msgs2[0], null, null, msgs2[2]);
                            boolean naoAchou2 = true;
                            for (Usuario us : usuarios) {
                                if (us.getIdPublica().equalsIgnoreCase(novoUsuario.getIdPublica()) && us.getIdRede() == novoUsuario.getIdRede()) {
                                    naoAchou2 = false;
                                }
                            }
                            
                            if (naoAchou2) {
                                usuarios.add(novoUsuario);
                                JanelaCriaLeilao.atualizar(usuarios);
                            }
                            sleep(1000);
                        }
                        naotem4 = false;
                        ComunicacaoEnvioInicial.naotem4 = false;
                        if (usuarioLocal.getPapel().equalsIgnoreCase("servidor")) {
                            JanelaConsole.escreveNaJanela("Característica já definida: SERVIDOR");
                        } else {
                            JanelaConsole.escreveNaJanela("Característica já definida: CLIENTE");
                        }
                    }
                }
                clientSocket.leaveGroup(addres);
                JanelaCriaLeilao.mostraBotao(true);
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
