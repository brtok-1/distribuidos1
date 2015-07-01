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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controladora de execução das threads responsáveis pelo envio e recebimento de informações via multicast
 * @author Bruno Tokarski e Rafael Vidal
 */
public class ControladoraThreads extends Thread {

    /**
     * Thread responsável pela manutenção da comunicação entre os participantes do multicast
     */
    @Override
    public void run() {
        try {
            JanelaConsole.escreveNaJanela("Controladora de Threads iniciada.");
            while (true) {
                JanelaCriaLeilao jcl = new JanelaCriaLeilao();
                jcl.setVisible(true);
                jcl.repaint();
                ComunicacaoRecebe recebe = new ComunicacaoRecebe();
                recebe.start();
                sleep(1000);
                ComunicacaoEnvioInicial envio = new ComunicacaoEnvioInicial();
                envio.start();
                Conexao c = Conexao.getInstancia();
                while (c.isServidorOnline()) {
                    Thread.sleep(8000);
                }
                jcl.dispose();
                Usuario usuario = Usuario.getInstancia();
                sleep(8000);
                JanelaConsole.escreveNaJanela("O servidor caiu. A detecção de usuários e eleição");
                JanelaConsole.escreveNaJanela("de um novo servidor, começará em instantes.");
                if (c.getStatusLeilao().equalsIgnoreCase("leiloando")) {
                    JanelaConsole.escreveNaJanela("O leilão ativo no momento foi cancelado.");
                }
                usuario.setPapel("servidor");
                c.setStatusLeilao("aguardando");
                c.setQuantidadeUsuarios(0);
                c.setServidorOnline(true);
                Conexao.setInstancia(c);
                JanelaCriaLeilao.mostraBotao(false);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladoraThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Configura a conexão multicast
     * @throws Exception 
     */
//    public void ConfiguraConexao() throws Exception {
//        //address = InetAddress.getByName(conexao.getINET_ADDR());
//        clientSocket = new MulticastSocket(conexao.getPORT());
//        clientSocket.joinGroup(address);
//    }

}
