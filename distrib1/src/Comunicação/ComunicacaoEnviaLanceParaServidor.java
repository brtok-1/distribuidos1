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
public class ComunicacaoEnviaLanceParaServidor extends MinhaComunicacaoEnvio {

    Lance lance;
    String codigoLivro;

    public ComunicacaoEnviaLanceParaServidor(Lance lance, String codigoLivro) throws Exception {
        conexao = Conexao.getInstancia();
        ConfiguraConexaoMulticast();
        this.lance = lance;
        this.codigoLivro = codigoLivro;
    }

    @Override
    public void run() {
        try {
            String mensagemLance = "#" + codigoLivro + "#" + lance.getValorOferecidoString() + "#" + lance.getIdPublicaQuemOfereceu() + "#" + lance.getIdRedeQuemOfereceu();
            
            ControladoraChaves cc = new ControladoraChaves();
            
            //String lanceCriptografado = cc.EncriptaLance(mensagemLance);
            String lanceCriptografado = cc.EncriptaLance("cu");
            mensagem = "4#" + codigoLivro + "#" + lance.getValorOferecidoString() + "#" + lance.getIdPublicaQuemOfereceu() + "#" + 
                    lance.getIdRedeQuemOfereceu() + "#" + lanceCriptografado;
            //mensagem = "4#" + lance.getIdRedeQuemOfereceu() + "#" + lanceCriptografado;
            
            EnviaMensagem();
        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoEnviaLanceParaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
