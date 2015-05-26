/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interface.ComunicacaoClient;

/**
 *
 * @author Rafael
 */
public class Notificacao {
    
    private int idVeiculo;
    private ComunicacaoClient comClient;

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public ComunicacaoClient getComClient() {
        return comClient;
    }

    public void setComClient(ComunicacaoClient comClient) {
        this.comClient = comClient;
    }  
    
}
