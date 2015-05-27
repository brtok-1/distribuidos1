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

    /**
     * Acessa a classe de Controle de Veículos para fornecer um ArrayList de Veículos ao cliente, quando solicitado
     * 
     * @return ArrayList de Veículos
     * @throws Exception 
     */
    @Override
    public ArrayList<Veiculo> ConsultarVeiculos() throws Exception {
        ControleVeiculo cv = new ControleVeiculo();
        return cv.RecuperarVeiculos();
    }
    
    /**
     * Acessa a classe de Controle de Locação para fornecer um ArrayList de Locações ao cliente, quando solicitado
     * 
     * @param idVeiculo
     * @return ArrayList de Locação de acordo com o Veiculo Fornecido
     * @throws Exception 
     */
    @Override
    public ArrayList<Locacao> RecuperarLocacoesPorVeiculo(int idVeiculo) throws Exception {
        ControleLocacao cl = new ControleLocacao();
        return cl.getLocacoesPorVeiculo(idVeiculo);
    }

    /**
     * Registra a intenção do cliente em receber uma notificação e guarda dados para que isso seja possível posteriormente
     * 
     * @param cliente Referência da Classe de  Comunicação do Cliente
     * @param idVeiculo Identificação para busca do veículo
     * @throws Exception 
     */
    @Override
    public void RegistrarParaNotificacao(ComunicacaoClient cliente, int idVeiculo) throws Exception {
        Notificacao n = new Notificacao();
        n.setIdVeiculo(idVeiculo);
        n.setComClient(cliente);
        System.out.println(cliente);
        ListaClientes lc = ListaClientes.getInstancia();
        lc.getListaClientesNotificar().add(n);
        
    }
    
    /**
     * Acessa a classe de Controle de Locacao salvar a locação enviada
     * 
     * @param locacao Locacao a qual se deseja cadastrar
     * @return sucesso Boolean de verificação de sucesso da operação
     * @throws Exception 
     */
    @Override
    public boolean EfetuarLocacao(Locacao locacao) throws Exception {        
        ControleLocacao cl = new ControleLocacao();
        return cl.addLocacao(locacao);
    }   
    
    //Unificando a implementação da interface com o controle

    /**
     * Método para Registro e declaração Inicial do Serviço de RMI
     * 
     * @throws Exception 
     */
    public void IniciaRMI() throws Exception {
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.bind("servidor", new RMIServer());
        System.out.println("RMIServer criado e registrado");
    }
    
}
