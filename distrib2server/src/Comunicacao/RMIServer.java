/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import Controle.ControleLocacao;
import Controle.ListaClientes;
import Controle.ControleVeiculo;
import Interface.ComunicacaoClient;
import Interface.ComunicacaoServer;
import Modelo.Locacao;
import Modelo.Notificacao;
import Modelo.Veiculo;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Métodos acessíveis aos clientes via RMI
 * @author Bruno Tokarski e Rafael Vidal
 */
public class RMIServer extends UnicastRemoteObject implements ComunicacaoServer {
    
    public RMIServer() throws Exception {
        super();
    }

    @Override
    public ArrayList<Veiculo> ConsultarVeiculos() throws Exception {
        ControleVeiculo cv = new ControleVeiculo();
        return cv.RecuperarVeiculos();
    }
    
    @Override
    public ArrayList<Locacao> RecuperarLocacoesPorVeiculo(int idVeiculo) {
        ControleLocacao cl = new ControleLocacao();
        return cl.getLocacoesPorVeiculo(idVeiculo);
    }

    @Override
    public void RegistrarParaNotificacao(ComunicacaoClient cliente, int idVeiculo) throws Exception {
        Notificacao n = new Notificacao();
        n.setIdVeiculo(idVeiculo);
        n.setComClient(cliente);
        System.out.println(cliente);
        ListaClientes lc = ListaClientes.getInstancia();
        lc.getListaClientesNotificar().add(n);
        
        System.out.println("Registrado interesse de um cliente no veiculo " + idVeiculo);
    }
    
    @Override
    public boolean EfetuarLocacao(Locacao locacao) throws Exception {        
        ControleLocacao cl = new ControleLocacao();
        return cl.addLocacao(locacao);
    }   
    
    //Unificando a implementação da interface com o controle

    public void IniciaRMI() throws Exception {
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.bind("servidor", new RMIServer());
        System.out.println("RMIServer criado e registrado");
    }
    
}
