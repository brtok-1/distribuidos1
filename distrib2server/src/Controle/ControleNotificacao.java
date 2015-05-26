/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Veiculo;

/**
 *
 * @author Bruno
 */
public class ControleNotificacao extends Thread {
    
    Veiculo veiculo;
    String precoAntigo;

    public ControleNotificacao(Veiculo veiculo, String precoAntigo) {
        this.veiculo = veiculo;
        this.precoAntigo = precoAntigo;
    }
    
    @Override
    public void run() {
        String mensagem = "<html><center>O veículo " + veiculo.getIdVeiculo() + "-" 
                + veiculo.getModelo() + " teve queda de preço na locação!<br>"
                + "De R$ " + precoAntigo + "  por R$ " + veiculo.getValorDiariaString() 
                + "  o valor da diária<br>Verifique em \"Locar Veículo\" para alugá-lo!";
    }
}
