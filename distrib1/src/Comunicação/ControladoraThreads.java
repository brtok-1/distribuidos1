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
 *
 * @author Bruno
 */
public class ControladoraThreads extends Thread {

    /**
     *
     */
    @Override
    public void run() {
        try {
            JanelaConsole.escreveNaJanela("Controladora de Threads iniciada.");
            while (true) {
                JanelaCriaLeilao jcl = new JanelaCriaLeilao();
                jcl.setVisible(true);
                jcl.repaint();
                ComunicacaoEnvioInicial envio = new ComunicacaoEnvioInicial();
                envio.start();
                ComunicacaoRecebeInicial recebe = new ComunicacaoRecebeInicial();
                recebe.start();
                Conexao c = Conexao.getInstancia();
                while (c.isServidorOnline()) {
                    c = Conexao.getInstancia();
                }
                System.out.println("passou");
                jcl.dispose();
                Usuario usuario = Usuario.getInstancia();
                usuario.setPapel("servidor");
                c.setStatusLeilao("aguardando");
                c.setQuantidadeUsuarios(0);
                sleep(10000);
                envio.stop();
                recebe.stop();
                c.setServidorOnline(true);
                JanelaCriaLeilao.mostraBotao(false);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladoraThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
