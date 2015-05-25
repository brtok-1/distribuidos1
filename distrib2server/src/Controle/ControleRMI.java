/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Comunicacao.RMIServer;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Métodos acessíveis aos clientes via RMI
 * @author Bruno Tokarski e Rafael Vidal
 */
public class ControleRMI {
    
    public void IniciaRMI() throws Exception
    {
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.bind("servidor", new RMIServer());
        
//        System.setSecurityManager(new SecurityManager());
//        
//        RMIServer rmis = new RMIServer();
//        Naming.bind("rmi://localhost/helloserver", rmis);
//        
        System.out.println("RMIServer criado e registrado");
    }
    
}
