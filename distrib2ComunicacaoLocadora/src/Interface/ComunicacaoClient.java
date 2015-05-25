/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Modelo.Veiculo;
import java.rmi.Remote;

/**
 *
 * @author Rafael
 */
public interface ComunicacaoClient extends Remote {
    
    void NotificarCliente(Veiculo veiculo, double precoAntigo) throws Exception;
    
}
