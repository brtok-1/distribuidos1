/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import Modelo.Lance;

/**
 *
 * @author Bruno
 */
public class ComunicacaoEnviaLance extends MinhaComunicacaoEnvio {
    
    Lance lance;
    String codigoLivro;
    
    public ComunicacaoEnviaLance(Lance lance, String codigoLivro) {
        this.lance = lance;
        this.codigoLivro = codigoLivro;
    }
    
    @Override
    public void run() {
        mensagem = "4#" + codigoLivro + "#" + lance.getValorOferecidoString() + "#" + lance.getIdPublicaQuemOfereceu() + "#" + lance.getIdRedeQuemOfereceu();
    }
}
