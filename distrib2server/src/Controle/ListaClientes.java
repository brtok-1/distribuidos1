/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Notificacao;
import java.util.ArrayList;

/**
 * Classe que fará o armazenamento dos Clientes que desejam ser notificados
 *
 * @author Bruno Tokarski e Rafael Vidal
 */
public class ListaClientes {
    
    private static ListaClientes instancia;
    private final ArrayList<Notificacao> listaClientesNotificar = new ArrayList<>();

    /**
     * Retorna Instância estática de ListaClientes
     * 
     * @return  Retorna uma instância da Classe
     */
    public static ListaClientes getInstancia() {
        if (instancia == null) {
            instancia = new ListaClientes();
        }
        return instancia;
    }

    /**
     * Método que retorna um ArrayList de clientes a ser notificados
     * 
     * @return ArrayList de Clientes a Notificar
     */
    public ArrayList<Notificacao> getListaClientesNotificar() {
        return listaClientesNotificar;
    }
    
}
