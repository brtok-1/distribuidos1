/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Interface.Comunicacao;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Rafael
 */
public class ControleRMICliente {
    
    
    public void IniciaRMI()
    {
        try {
            
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            Comunicacao obj = (Comunicacao)reg.lookup("servidor");
            System.out.println(obj.TesteRMI());
            
        }catch (Exception e) {
            
            System.out.println("Não deu :/ " + e.getMessage());
            e.printStackTrace();
        
        }
    }
}
