/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import IOarquivo.IOCartao;
import Interface.ComunicacaoClient;
import Interface.ComunicacaoServer;
import Modelo.Cartao;
import Modelo.ColecionadorEncontrado;
import Modelo.Troca;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class RMIClient extends UnicastRemoteObject implements ComunicacaoClient {

    private Registry reg;
    private ComunicacaoServer obj;

    public RMIClient(ColecionadorEncontrado conexao) throws Exception {
        super();
        reg = LocateRegistry.getRegistry("localhost", conexao.getPorta());
        String nomeServer = "servidor" + conexao.getIdColecionador();
        nomeServer = nomeServer.trim();
        obj = (ComunicacaoServer) reg.lookup(nomeServer);
    }

    @Override
    public void EnviaProposta(Troca troca, ComunicacaoClient cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Troca RespondeProposta(Troca troca, ComunicacaoClient cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cartao> SolicitaListaCartoes(int idColecionador) {
        try {
            IOCartao ioc = new IOCartao();
            return ioc.RecuperarCartoes();
        } catch (Exception ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
