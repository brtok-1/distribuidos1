/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import Modelo.Conexao;
import Modelo.Livro;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ControleLeilaoServidor extends Thread {

    private Usuario usuario;
    private Conexao conexao;
    private Livro livro;

    long tempoTotal;
    long horarioAgora;

    @Override
    public void run() {
        conexao = Conexao.getInstancia();
        while (true) {
            try {
                if ((!(conexao.getEstante().isEmpty()))
                        && (conexao.getStatusLeilao().equalsIgnoreCase("andamento"))) {
                    ArrayList<Livro> estante = conexao.getEstante();
                    livro = estante.get(0);
                    estante.remove(0);
                    conexao.setEstante(estante);
                    MinhaComunicacaoEnvio envia = new MinhaComunicacaoEnvio();
                    conexao.setStatusLeilao("leiloando");
                    envia.setMensagem("3#" + livro.getCodigo() + "#" + livro.getDescricao()
                            + "#" + livro.getNome() + "#" + livro.getPrecoInicial() + "#"
                            + String.valueOf(System.currentTimeMillis() + livro.getTempoTotalLeilao())
                            + "#" + System.currentTimeMillis() + "#" + livro.getIdPublicaDonoLivro()
                            + "#" + livro.getIdRedeDonoLivro());
                }
                while (conexao.getStatusLeilao().equalsIgnoreCase("leiloando")) {
                    sleep(1000);
                    horarioAgora = System.currentTimeMillis();
                    if (horarioAgora >= tempoTotal) {
                        conexao.setStatusLeilao("finalizando");
                    }
                }
                if (conexao.getStatusLeilao().equalsIgnoreCase("finalizando")) {
                    
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ControleLeilaoServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//metodo tempo leilao
//    boolean naoAcabou = true;
//                while (naoAcabou) {
//                    try {
//                        sleep(1000);
//                        //tempoTotal = leilao.getTempoNoInicio() + leilao.getTempoTotalLeilao();
//                        horarioAgora = System.currentTimeMillis();
//                        if (horarioAgora >= tempoTotal) {
//                            //ENCERRAR O LEILÃO
//                            naoAcabou = false;
//                    //JanelaLeilaoEncerrado jle = new JanelaLeilaoEncerrado(leilao);
//                            //jle.setVisible(true);
//                            //jle.repaint();
//                        }
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(ControleLeilaoServidor.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
    public void tempoRestanteLeilaoEmMinutos() {

    }

    public void criaLeilao() {
        usuario = Usuario.getInstancia();

        if (usuario.getPapel().equalsIgnoreCase("servidor")) {

        } else {

        }
    }

    public void salvaLivro() {

    }
}
