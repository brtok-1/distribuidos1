/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import GUI.JanelaConsole;
import Interface.Comunicacao;
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
    Comunicacao obj;
    JanelaConsole janelaConsole;

    public ControleRMICliente() throws Exception {
        
        janelaConsole = JanelaConsole.getInstancia();
        
        reg = LocateRegistry.getRegistry("localhost", 1099);
        obj = (Comunicacao) reg.lookup("servidor");
    }
    
    /**
     * Teste inicial da comunicação RMI
     * @throws Exception 
     */
    public void IniciaRMI() throws InterruptedException {

        try
        {
            janelaConsole.EscreveNaJanela(obj.TesteRMI());
        }catch (Exception e)
        {
            janelaConsole.EscreveNaJanela("Erro na comunicação com o servidor: " + e.getMessage());
            e.printStackTrace();
        }      

    }
    
    public ArrayList<Veiculo> RecuperarVeiculos() throws Exception
    {
        janelaConsole.EscreveNaJanela("Recuperando veículos...");
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        veiculos = obj.ConsultarVeiculos();
        janelaConsole.EscreveNaJanela("Veículos recuperados. Total: " + veiculos.size());
        
        return veiculos;
    }
}
