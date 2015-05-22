/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import Chaves.ControladoraChaves;
import Modelo.Conexao;
import Modelo.Lance;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ComunicacaoEnviaLanceParaCliente extends MinhaComunicacaoEnvio {

    Lance lance;
    String codigoLivro;

    public ComunicacaoEnviaLanceParaCliente(Lance lance, String codigoLivro) throws Exception {
        conexao = Conexao.getInstancia();
        ConfiguraConexaoMulticast();
        this.lance = lance;
        this.codigoLivro = codigoLivro;
    }

    @Override
    public void run() {
        try {
            mensagem = "5#" + codigoLivro + "#" + lance.getValorOferecidoString() + "#"
                    + lance.getIdPublicaQuemOfereceu() + "#" + lance.getIdRedeQuemOfereceu();
            EnviaMensagem();
        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoEnviaLanceParaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
