/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import Modelo.Veiculo;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Classe que indica quais métodos um cliente deve possuir.
 * 
 * @author Henrique
 */
public interface InterfaceClient extends Remote {
    
    /**
     * 
     * @param veiculo
     * @param precoAnterior
     * @throws RemoteException 
     */
    public void comunicarBaixaPreco(Veiculo veiculo, double precoAnterior) throws RemoteException;

}
