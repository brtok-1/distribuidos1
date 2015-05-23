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
 * Envio de informações via multicast
 *
 * @author Bruno Tokarski e Rafael Vidal
 */
public class ComunicacaoEnvioInicial extends MinhaComunicacaoEnvio {
    
    /**
     * Monta a mensagem contendo informações do usuário e aciona o método de envio
     */
    @Override
    public void run() {
        try {
            JanelaConsole.escreveNaJanela("Thread de envio inicial iniciada.");

            //Obtem a conexao
            conexao = Conexao.getInstancia();
            //Obtem o usuário
            usuario = Usuario.getInstancia();
            while (conexao.getStatusLeilao().equalsIgnoreCase("aguardando") || conexao.getStatusLeilao().equalsIgnoreCase("tempoAdicional")) {
                mensagem = "77#" + usuario.getIdPublica() + "#" + usuario.getIdRede() + "#" + usuario.getPapel() + "#" + usuario.getChavePublicaString();
                EnviaMensagem();
                sleep(6000);
            }
        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoEnvioInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
