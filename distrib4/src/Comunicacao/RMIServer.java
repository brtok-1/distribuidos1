/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import Interface.ComunicacaoServer;
import Modelo.Troca;
import java.rmi.server.UnicastRemoteObject;

/**
 * Métodos acessíveis aos outros colecionadores via RMI
 * @author Rafael
 */
public class RMIServer extends UnicastRemoteObject implements ComunicacaoServer {
    
    public RMIServer() throws Exception {
        super();
    }

    @Override
    public void ReceberProposta(Troca troca) {
    }
    
}
