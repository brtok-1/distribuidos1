/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import Modelo.Conexao;

/**
 *
 * @author Bruno
 */
public class ControleServidor extends Thread {
    
    private Conexao conexao;

    /**
     *
     */
    @Override
    public void run() {
        conexao = Conexao.getInstancia();
        while (true) {
            if (System.currentTimeMillis() > (conexao.getUltimoHelloServer() + 10000)) {
                conexao.setStatusLeilao("quedaServidor");
            }
        }
    }
}
