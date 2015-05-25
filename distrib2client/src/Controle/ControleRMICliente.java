/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import GUI.JanelaConsole;
import Interface.ComunicacaoServer;
import Modelo.Veiculo;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class ControleRMICliente {

    Registry reg;
    ComunicacaoServer obj;
    JanelaConsole janelaConsole;

    public ControleRMICliente() throws Exception {
        
        janelaConsole = JanelaConsole.getInstancia();
        
        reg = LocateRegistry.getRegistry("localhost", 1099);
        obj = (ComunicacaoServer) reg.lookup("servidor");
    }
    
    /**
     * Teste inicial da comunicação RMI
     * @throws InterruptedException 
     */
    public void IniciaRMI() throws InterruptedException {


    }
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    public ArrayList<Veiculo> RecuperarVeiculos() throws Exception {
        janelaConsole.EscreveNaJanela("Recuperando veículos...");
        ArrayList<Veiculo> veiculos = obj.ConsultarVeiculos();
        janelaConsole.EscreveNaJanela("Veículos recuperados. Total: " + veiculos.size());
        return veiculos;
    }
}
