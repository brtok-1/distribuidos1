/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import Interface.ComunicacaoServer;
import Modelo.Cartao;
import Modelo.Colecionador;
import Modelo.Troca;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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

    @Override
    public ArrayList<Cartao> ListarCartoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método para Registro e declaração Inicial do Serviço de RMI
     * 
     * @throws Exception 
     */
    public void IniciaRMI() throws Exception {
        Colecionador logado = Colecionador.getInstancia();
        String nomeServer = "servidor" + logado.getIdColecionador();
        Registry reg = LocateRegistry.createRegistry(logado.getPorta());
        reg.bind(nomeServer, new RMIServer());
        System.out.println("RMIServer criado e registrado");
    }    
}
