/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import GUI.JanelaNotificacao;
import Interface.ComunicacaoClient;
import Interface.ComunicacaoServer;
import Modelo.Locacao;
import Modelo.Veiculo;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Métodos acessíveis aos clientes via RMI
 *
 * @author Bruno Tokarski e Rafael Vidal
 */
public class RMICliente extends UnicastRemoteObject implements ComunicacaoClient {

    private Registry reg;
    private ComunicacaoServer obj;
    private RMICliente rmic;

    public RMICliente() throws Exception {
        super();
        reg = LocateRegistry.getRegistry("localhost", 1099);
        obj = (ComunicacaoServer) reg.lookup("servidor");
  
        
    }

    /**
     * Método que recebe a notificação de interesse do cliente
     * 
     * @param mensagem
     * @throws Exception 
     */
    @Override
    public void ReceberNotificacao(String mensagem) throws Exception {
        java.awt.Toolkit.getDefaultToolkit().beep();
        JanelaNotificacao jn = new JanelaNotificacao(mensagem);
        jn.setVisible(true);
    }
    
    /**
     * Início da comunicação RMI
     *
     * @throws InterruptedException
     */
    public void IniciaRMI() throws Exception {
        rmic = new RMICliente();
    }
    
    /**
     * Recupera uma lista de veículos do servidor
     * 
     * @return @throws Exception
     */
    public ArrayList<Veiculo> RecuperarVeiculos() throws Exception {
        IniciaRMI();
        ArrayList<Veiculo> veiculos = obj.ConsultarVeiculos();
        return veiculos;
    }

    /**
     * Recupera do servidor uma lista de locações para determinado veiculo
     * 
     * @param idVeiculo
     * @return ArrayList de locações
     * @throws Exception 
     */
    public ArrayList<Locacao> RecuperarLocacoesPorVeiculo(int idVeiculo) throws Exception {
        IniciaRMI();
        ArrayList<Locacao> locacoes = obj.RecuperarLocacoesPorVeiculo(idVeiculo);
        return locacoes;
    }
    
    /**
     * Método que registra o interesse do Cliente em um veículo, passando a referência do
     * Objeto Remoto e a ID do veículo
     * 
     * @param idVeiculo
     * @throws Exception 
     */
    public void ManifestarInteresse(int idVeiculo) throws Exception {
        IniciaRMI();
        obj.RegistrarParaNotificacao(rmic, idVeiculo);
        JOptionPane.showMessageDialog(null, "Interesse no Veiculo " + idVeiculo + " registrado com sucesso!");
    }

    /**
     * Faz a locação do veículo no servidor
     * 
     * @param locacao 
     * @return Resultado da Operação = sucesso
     * @throws Exception 
     */
    public boolean EfetuarLocacao(Locacao locacao) throws Exception {
        IniciaRMI();
        return obj.EfetuarLocacao(locacao);
    }

}
