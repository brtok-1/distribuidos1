/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import GUI.JanelaLeilaoEncerrado;
import Inicio.Livro;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ControleLeilao extends Thread {

    static Livro leilao;
    long tempoTotal;
    long horarioAgora;

    public ControleLeilao(Livro l) {
        leilao = l;
    }

    @Override
    public void run() {
        boolean naoAcabou = true;
        while (naoAcabou) {
            try {
                sleep(1000);
                tempoTotal = leilao.getTempoNoInicio() + leilao.getTempoTotalLeilao();
                horarioAgora = System.currentTimeMillis();
                if (horarioAgora >= tempoTotal) {
                    //ENCERRAR O LEILÃO
                    naoAcabou = false;
                    JanelaLeilaoEncerrado jle = new JanelaLeilaoEncerrado(leilao);
                    jle.setVisible(true);
                    jle.repaint();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ControleLeilao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void tempoRestanteLeilaoEmMinutos() {

    }

}
