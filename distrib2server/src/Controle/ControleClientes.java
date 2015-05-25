/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

/**
 *
 * @author Bruno
 */
public class ControleClientes {
    
    private static ControleClientes instancia = new ControleClientes();

    public static ControleClientes getInstancia() {
        return instancia;
    }

    public static void setInstancia(ControleClientes instancia) {
        ControleClientes.instancia = instancia;
    }
    
}
