/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import Interface.ComunicacaoServer;
import Modelo.Cartao;
import Modelo.Troca;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class RMIClient extends UnicastRemoteObject implements ComunicacaoServer
{
    
    public RMIClient() throws Exception {
        super();
    }

    @Override
    public void ReceberProposta(Troca troca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cartao> ListarCartoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
