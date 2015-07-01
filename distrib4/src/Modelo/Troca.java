/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rafael
 */
public class Troca {
    
    private int idSolicitante;
    
    private int idSolicitado;
    
    private int idCartaoManda;
    
    private int idCartaoRecebe;
    
    //1: Aguardando, 2: Efetuada, 3: Recusada
    private int situacaoTroca;

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public int getIdSolicitado() {
        return idSolicitado;
    }

    public void setIdSolicitado(int idSolicitado) {
        this.idSolicitado = idSolicitado;
    }

    public int getIdCartaoManda() {
        return idCartaoManda;
    }

    public void setIdCartaoManda(int idCartaoManda) {
        this.idCartaoManda = idCartaoManda;
    }

    public int getIdCartaoRecebe() {
        return idCartaoRecebe;
    }

    public void setIdCartaoRecebe(int idCartaoRecebe) {
        this.idCartaoRecebe = idCartaoRecebe;
    }

    public int getSituacaoTroca() {
        return situacaoTroca;
    }

    public void setSituacaoTroca(int situacaoTroca) {
        this.situacaoTroca = situacaoTroca;
    }
    
    
}
