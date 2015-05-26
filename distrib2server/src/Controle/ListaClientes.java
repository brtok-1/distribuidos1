/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Notificacao;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class ListaClientes {
    
    private static ListaClientes instancia = new ListaClientes();
    private ArrayList<Notificacao> listaClientesNotificar = new ArrayList<>();

    public static ListaClientes getInstancia() {
        return instancia;
    }

    public static void setInstancia(ListaClientes instancia) {
        ListaClientes.instancia = instancia;
    }

    public ArrayList<Notificacao> getListaClientesNotificar() {
        return listaClientesNotificar;
    }

    public void setListaClientesNotificar(ArrayList<Notificacao> listaClientesNotificar) {
        this.listaClientesNotificar = listaClientesNotificar;
    }
    
}
