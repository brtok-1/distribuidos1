/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Modelo.Veiculo;
import java.rmi.Remote;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public interface ComunicacaoServer extends Remote {
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    ArrayList<Veiculo> ConsultarVeiculos() throws Exception;
    
    void EfetuarLocacao() throws Exception;
    
    void ManifestarInteresse() throws Exception;
    
    void SalvarCredencialRMI(String idClient) throws Exception;
    
    void RegistrarParaNotificacao(ComunicacaoClient cliente, int idVeiculo) throws Exception;
    
    
}
