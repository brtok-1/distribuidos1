/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import Modelo.Conexao;
import Modelo.Usuario;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ComunicacaoEnvioInicial extends MinhaComunicacaoEnvio {

    @Override
    public void run() {
        try {
            JanelaConsole.escreveNaJanela("Thread de envio inicial iniciada.");

            //Obtem a conexao
            conexao = Conexao.getInstancia();
            //Obtem o usuário
            usuario = Usuario.getInstancia();
            ConfiguraConexaoMulticast();
            while (conexao.getStatusLeilao().equalsIgnoreCase("aguardando") || conexao.getStatusLeilao().equalsIgnoreCase("tempoAdicional")) {
                EnvioInicial();
            }
        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoEnvioInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Envio de informações enquanto se aguardam os usuários    
    public void EnvioInicial() throws Exception {
        mensagem = "77#" + usuario.getIdPublica() + "#" + usuario.getIdRede() + "#" + usuario.getPapel() + "#" + usuario.getChavePublicaString();
        EnviaMensagem();
        sleep(6000);
    }

}
