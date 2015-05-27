/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import GUI.JanelaConsole;
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

    @Override
    public void ReceberNotificacao(String mensagem) throws Exception {
        java.awt.Toolkit.getDefaultToolkit().beep();
        JanelaNotificacao jn = new JanelaNotificacao(mensagem);
        jn.setVisible(true);
    }

    //******************* Unificando o controle ***********************************
    /**
     * Teste inicial da comunicação RMI
     *
     * @throws InterruptedException
     */
    public void IniciaRMI() throws Exception {
        rmic = new RMICliente();
    }
    /**
     *
     * @return @throws Exception
     */
    public ArrayList<Veiculo> RecuperarVeiculos() throws Exception {
        IniciaRMI();
        ArrayList<Veiculo> veiculos = obj.ConsultarVeiculos();
        return veiculos;
    }

    public ArrayList<Locacao> RecuperarLocacoesPorVeiculo(int idVeiculo) throws Exception {
        IniciaRMI();
        ArrayList<Locacao> locacoes = obj.RecuperarLocacoesPorVeiculo(idVeiculo);
        return locacoes;
    }
    
    public void ManifestarInteresse(int idVeiculo) throws Exception {
        IniciaRMI();
        obj.RegistrarParaNotificacao(rmic, idVeiculo);
        JOptionPane.showMessageDialog(null, "Interesse no Veiculo " + idVeiculo + " registrado com sucesso!");
    }

    public boolean EfetuarLocacao(Locacao locacao) throws Exception {
        IniciaRMI();
        return obj.EfetuarLocacao(locacao);
    }

}
