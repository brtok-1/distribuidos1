/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import Modelo.Livro;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ComunicacaoEnviaLivro extends MinhaComunicacaoEnvio {

    private final Livro livro;
    
    public ComunicacaoEnviaLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public void run() {
        try {
            mensagem = "2#" + livro.getCodigo() + "#" + livro.getDescricao() + "#" + livro.getNome()
                    + "#" + livro.getPrecoInicial() + "#" + livro.getTempoTotalLeilao()
                    + "#" + livro.getIdPublicaDonoLivro() + "#" + livro.getIdRedeDonoLivro();
            EnviaMensagem();
        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoEnviaLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
