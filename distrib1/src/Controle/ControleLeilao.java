/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

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
public class ControleLeilao extends Thread {

    private Usuario usuario;
    private Conexao conexao;    
    private Livro livro;

    long tempoTotal;
    long horarioAgora;

    public ControleLeilao(Livro l) {
        livro = l;
        
        conexao = Conexao.getInstancia();
        
        AdicionarLivro();
    }
    
    //Adiciona o livro no balcão
    public void AdicionarLivro()
    {
        ArrayList<Livro> balcao = new ArrayList<>();
        balcao = conexao.getBalcao();
        balcao.add(livro);
        conexao.setBalcao(balcao);
    }

    @Override
    public void run() {
        boolean naoAcabou = true;
        while (naoAcabou) {
            try {
                sleep(1000);
                //tempoTotal = leilao.getTempoNoInicio() + leilao.getTempoTotalLeilao();
                horarioAgora = System.currentTimeMillis();
                if (horarioAgora >= tempoTotal) {
                    //ENCERRAR O LEILÃO
                    naoAcabou = false;
                    //JanelaLeilaoEncerrado jle = new JanelaLeilaoEncerrado(leilao);
                    //jle.setVisible(true);
                    //jle.repaint();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ControleLeilao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void tempoRestanteLeilaoEmMinutos() {

    }
    
    public void criaLeilao()
    {
        usuario = Usuario.getInstancia();
        
        if(usuario.getPapel().equalsIgnoreCase("servidor"))
        {
            
        } else
        {
            
        }     
    }
    
    public void salvaLivro()
    {
        
    }
}
