/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import Interface.ComunicacaoClient;
import Modelo.Veiculo;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

/**
 * Métodos acessíveis aos clientes via RMI
 * @author Bruno Tokarski e Rafael Vidal
 */
public class RMICliente extends UnicastRemoteObject implements ComunicacaoClient {

    public RMICliente() throws Exception {
        super();
    }

    @Override
    public void NotificarCliente(Veiculo veiculo, double precoAntigo) throws Exception {
        java.awt.Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "<html><center>O veículo " + veiculo.getIdVeiculo()
                + "-" + veiculo.getModelo() + " teve queda de preço na locação!<br>"
                + "Verifique em \"Locar Veículo\" para alugá-lo!");
    }

}
