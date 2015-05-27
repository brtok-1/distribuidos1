/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Interface.ComunicacaoClient;
import Modelo.Notificacao;
import Modelo.Veiculo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que controla as Noticacoes que serão enviadas aos Clientes
 * 
 * @author Bruno Tokarski e Rafael Vidal
 */
public class ControleNotificacao extends Thread {

    Veiculo veiculo;
    String precoAntigo;

    /**
     * O construtor dessa recebe os parâmetros que serão necessários às notificações
     * 
     * @param veiculo Veiculo que teve preço reduzido
     * @param precoAntigo Preço antigo do veículo com preço reduzido
     */
    public ControleNotificacao(Veiculo veiculo, String precoAntigo) {
        this.veiculo = veiculo;
        this.precoAntigo = precoAntigo;
    }

    /**
     * Método de Thread separada para enviar as notificações aos clientes
     * O método define a mensagem e depois percorre o vetor de clientes que desejam notificação daquele veículo disparando as mensagens
     * 
     */
    @Override
    public void run() {
        try {
            String mensagem = "<html><center>O veículo " + veiculo.getIdVeiculo() + "-"
                    + veiculo.getModelo() + " teve queda de preço na locação!<br>"
                    + "De R$ " + precoAntigo + "  por R$ " + veiculo.getValorDiariaString()
                    + "  o valor da diária<br>Verifique em \"Locar Veículo\" para alugá-lo!";
            ListaClientes lc = ListaClientes.getInstancia();
            for (Notificacao n : lc.getListaClientesNotificar()) {
                if (n.getIdVeiculo() == veiculo.getIdVeiculo()) {
                    ComunicacaoClient notificacao = (ComunicacaoClient) n.getComClient();
                    notificacao.ReceberNotificacao(mensagem);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ControleNotificacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
