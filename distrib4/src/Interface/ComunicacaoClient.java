/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Modelo.Cartao;
import Modelo.Colecionador;
import Modelo.Troca;
import java.util.ArrayList;

/**
 * Interface de envio de ações para outros participantes
 * @author Rafael
 */
public interface ComunicacaoClient {
    
    void EnviaPresenca(Colecionador colecionador);
    
    void EnviaProposta(Troca troca, ComunicacaoClient cliente);
    
    Troca RespondeProposta(Troca troca, ComunicacaoClient cliente);
    
    ArrayList<Cartao> SolicitaListaCartoes(int idColecionador);
}
