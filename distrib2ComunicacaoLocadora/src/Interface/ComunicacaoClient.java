/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;

/**
 * Interface de comunicação do cliente
 * @author Bruno Tokarski e Rafael Vidal
 */
public interface ComunicacaoClient extends Remote {
    
    /**
     * Recebimento de notificação do servidor
     * @param mensagem texto da notificação
     * @throws Exception 
     */
    void ReceberNotificacao(String mensagem) throws Exception;
    
}
