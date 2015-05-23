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
 * Classe responsável pelo envio de mensagens do cliente para o servidor
 * @author Bruno Tokarski e Rafael Vidal
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

    /**
     * Monta a mensagem de lance de cliente para servidor e aciona o método de envio
     */
    @Override
    public void run() {
        try {
            String mensagemLance = "#" + codigoLivro + "#" + lance.getValorOferecidoString() + "#" + lance.getIdPublicaQuemOfereceu();
            
            ControladoraChaves cc = new ControladoraChaves();
            
            String lanceCriptografado = cc.EncriptaLance(mensagemLance);
            mensagem = "4#" + lance.getIdRedeQuemOfereceu() + "#" + lanceCriptografado;
            
            EnviaMensagem();
        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoEnviaLanceParaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
