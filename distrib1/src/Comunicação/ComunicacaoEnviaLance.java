/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import Modelo.Conexao;
import Modelo.Lance;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ComunicacaoEnviaLance extends MinhaComunicacaoEnvio {

    Lance lance;
    String codigoLivro;

    public ComunicacaoEnviaLance(Lance lance, String codigoLivro) throws Exception {
        conexao = Conexao.getInstancia();
        ConfiguraConexaoMulticast();
        this.lance = lance;
        this.codigoLivro = codigoLivro;
    }

    @Override
    public void run() {
        try {
            mensagem = "4#" + codigoLivro + "#" + lance.getValorOferecidoString() + "#" + lance.getIdPublicaQuemOfereceu() + "#" + lance.getIdRedeQuemOfereceu();
            EnviaMensagem();
        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoEnviaLance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
