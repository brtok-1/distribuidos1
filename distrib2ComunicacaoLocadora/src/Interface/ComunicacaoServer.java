/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Modelo.Locacao;
import Modelo.Veiculo;
import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Interface de comunicação do usuário
 * @author Bruno Tokarski e Rafael Vidal
 */
public interface ComunicacaoServer extends Remote {
    
    /**
     * Consulta de veículos
     * @return lista de veículos
     * @throws Exception 
     */
    ArrayList<Veiculo> ConsultarVeiculos() throws Exception;
    
    /**
     * Efetuar locaçãp de veículo
     * @param locacao objeto locacao preenchido
     * @return locação efetuada ou não
     * @throws Exception 
     */
    boolean EfetuarLocacao(Locacao locacao) throws Exception;
    
    /**
     * Registrar para notificação conforme interesse em determinado veículo
     * @param cliente interface do cliente
     * @param idVeiculo código do veículo
     * @throws Exception 
     */
    void RegistrarParaNotificacao(ComunicacaoClient cliente, int idVeiculo) throws Exception;

    ArrayList<Locacao> RecuperarLocacoesPorVeiculo(int idVeiculo) throws Exception;
    
}
