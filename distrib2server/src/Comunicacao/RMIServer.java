/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import Controle.ControleClientes;
import Controle.ControleVeiculo;
import Interface.ComunicacaoServer;
import Modelo.Veiculo;
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

}
