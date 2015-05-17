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
        mensagem = "77#" + usuario.getIdPublica() + "#" + usuario.getIdRede() + "#" + usuario.getPapel() + "#" + usuario.getChavePublica();
        EnviaMensagem();
        sleep(6000);
    }

}

//    @Override
//    public void run() {
//        try {
//            JanelaConsole.escreveNaJanela("Thread de envio inicial iniciada.");
//
//            //Obtem a conexao
//            conexao = Conexao.getInstancia();
//            //Obtem o usuário
//            usuario = Usuario.getInstancia();
//            ConfiguraConexaoMulticast();
//            ConfiguraConexaoUnicast();
//            while (conexao.getStatusLeilao().equalsIgnoreCase("aguardando") || conexao.getStatusLeilao().equalsIgnoreCase("tempoAdicional")) {
//                EnvioInicial();
//                conexao = Conexao.getInstancia();
//            }
//            while (conexao.isServidorOnline()) {
//                if (conexao.getStatusLeilao().equals("andamento")) {
//                    ParticiparLeilao();
//                }
//                conexao = Conexao.getInstancia();
//            }
//            JanelaConsole.escreveNaJanela("O servidor caiu. A detecção de usuários e eleição");
//            JanelaConsole.escreveNaJanela("de um novo servidor, começará em instantes.");
//        } catch (Exception ex) {
//            Logger.getLogger(ComunicacaoEnvioInicial.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    //Envio de informações enquanto se aguardam os usuários    
//    public void EnvioInicial() throws Exception {
//        mensagem = "77#" + usuario.getIdPublica() + "#" + usuario.getIdRede() + "#" + usuario.getPapel() + "#" + usuario.getChavePublica();
//        EnviaMensagem();
//        sleep(6000);
//    }
//
//    //Configura a conexao unicast
//    public void ConfiguraConexaoUnicast() throws Exception {
//
//    }
//
//    public void ParticiparLeilao() throws Exception {
//        if (!(conexao.getBalcao().isEmpty())) {
//            EnviaLivro();
//            conexao.getBalcao().clear();
//        }
//        if (!conexao.getEstante().isEmpty()) {
//
//            ArrayList<Livro> estante = new ArrayList<>();
//            estante = conexao.getEstante();
//
//            for (Livro l : estante) {
//                LeiloaLivro(l);
//            }
//
//        }
//    }
//
//    //Envia o livro para leilão
//    public void EnviaLivro() throws Exception {
//
//        //Livro livro = new Livro();
//        Livro livro = conexao.getBalcao().get(0);
//        mensagem = "2#" + livro.getCodigo() + "#" + livro.getDescricao() + "#" + livro.getNome() + "#" + livro.getPrecoInicial()
//                + "#" + livro.getTempoTotalLeilao();
//        EnviaMensagem();
//    }
//
//    //Executa o leilão do livro
//    public void LeiloaLivro(Livro livro) throws Exception {
//        mensagem = "3#" + livro.getCodigo() + "#" + livro.getDescricao() + "#" + livro.getNome() + "#" + livro.getPrecoInicial()
//                + "#" + livro.getTempoTotalLeilao();
//        EnviaMensagem();
//    }
//
//}