/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Modelo.Cartao;
import Modelo.Troca;
import java.util.ArrayList;

/**
 * Interface de recebimento de ações de outros colecionadores
 * @author Bruno Tokarski e Rafael Vidal
 */
public interface ComunicacaoServer {
    
    void ReceberProposta(Troca troca);
    
    ArrayList<Cartao> ListarCartoes();
    
}
