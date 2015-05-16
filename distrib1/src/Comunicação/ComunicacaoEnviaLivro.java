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

    private Livro livro;
    private String tipoEnvio;
//    Usuario usuario;
//    Conexao conexao;
//    String mensagem;

    public ComunicacaoEnviaLivro(Livro livro, String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
        this.livro = livro;
    }

    @Override
    public void run() {

        try {
            if (tipoEnvio.equals("paraServidor")) {
                setMensagem("2#" + livro.getCodigo() + "#" + livro.getDescricao() + "#" + livro.getNome()
                        + "#" + livro.getPrecoInicial() + "#" + livro.getTempoTotalLeilao()
                        + "#" + livro.getIdPublicaDonoLivro() + "#" + livro.getIdRedeDonoLivro());
                EnviaMensagem();
            }
            if (tipoEnvio.equals("paraClientes")) {
                mensagem = "3#" + livro.getCodigo() + "#" + livro.getDescricao() + "#" + livro.getNome()
                        + "#" + livro.getPrecoInicial() + "#" + livro.getTempoTotalLeilao()
                        + "#" + livro.getIdPublicaDonoLivro() + "#" + livro.getIdRedeDonoLivro();
                EnviaMensagem();
            }

        } catch (Exception ex) {
            Logger.getLogger(ComunicacaoEnviaLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
