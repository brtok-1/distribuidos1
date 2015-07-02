/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Modelo.Colecionador;
import Modelo.Troca;

/**
 * Interface de envio de ações para outros participantes
 * @author Rafael
 */
public interface ComunicacaoClient {
    
    void EnviaId(Colecionador colecionador);
    
    void EnviaProposta(Troca troca, ComunicacaoClient cliente);
    
    Troca RespondeProposta(Troca troca, ComunicacaoClient cliente);
    
    void SolicitaListaCartoes(Colecionador colecionador);
}
