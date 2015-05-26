/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import Controle.ControleClientes;
import Controle.ControleVeiculo;
import Interface.ComunicacaoClient;
import Interface.ComunicacaoServer;
import Modelo.Notificacao;
import Modelo.Veiculo;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * Métodos acessíveis aos clientes via RMI
 * @author Bruno Tokarski e Rafael Vidal
 */
public class RMIServer extends UnicastRemoteObject implements ComunicacaoServer {

    //private Vector listaClientesNotificar = null;
    private List<Notificacao> listaClientesNotificar = new ArrayList<>();
    
    public RMIServer() throws Exception {
        super();
        listaClientesNotificar = new Vector();
    }

    @Override
    public ArrayList<Veiculo> ConsultarVeiculos() throws Exception {
        ControleVeiculo cv = new ControleVeiculo();
        return cv.RecuperarVeiculos();
    }

    @Override
    public void EfetuarLocacao() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ManifestarInteresse() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void SalvarCredencialRMI(String idClient) throws Exception {
        ControleClientes cc = ControleClientes.getInstancia();
        
    }

    @Override
    public void RegistrarParaNotificacao(ComunicacaoClient cliente, int idVeiculo) throws Exception {
        Notificacao n = new Notificacao();
        n.setIdVeiculo(idVeiculo);
        n.setComClient(cliente);
        listaClientesNotificar.add(n);
    }
    
    
    //Unificando a implementação da interface com o controle

    public void IniciaRMI() throws Exception
    {
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.bind("servidor", new RMIServer());
        
        System.out.println("RMIServer criado e registrado");
    }
    
    
    //Não é um método da interface
    public void EnviarNotificacao(String mensagem, int idVeiculo) throws Exception {
        
        for(Notificacao n : listaClientesNotificar)
        {
            if(n.getIdVeiculo() == idVeiculo)
            {
                ComunicacaoClient notificacao = (ComunicacaoClient) n.getComClient();
                notificacao.ReceberNotificacao("Veículo (...) teve seu preço reduzido");
            }
        }
        
//        for (Enumeration clientes = listaClientesNotificar.elements(); clientes.hasMoreElements();)
//        {
//            ComunicacaoClient notificacao = (ComunicacaoClient) clientes.nextElement();
//            notificacao.ReceberNotificacao(mensagem);
//        }
    }
    
}
