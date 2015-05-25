/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import Modelo.Locacao;
import Modelo.Veiculo;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Classe que indica quais métodos um servidor deve possuir.
 * 
 * @author Henrique
 */
public interface InterfaceServer extends Remote {
    
    /**
     * 
     * @return
     * @throws RemoteException 
     */
    public ArrayList<Veiculo> RecuperarVeiculos() throws RemoteException;
    
    /**
     * 
     * @param locacao
     * @throws RemoteException 
     */
    public void adicionarLocacao(Locacao locacao) throws RemoteException;
    
    /**
     * 
     * @param veiculo
     * @throws RemoteException 
     */
    public void consultarLocacoes(Veiculo veiculo) throws RemoteException;
    
    /**
     * 
     * @param veiculo
     * @throws RemoteException 
     */
    public void adicionarInteresse(Veiculo veiculo) throws RemoteException;
}
