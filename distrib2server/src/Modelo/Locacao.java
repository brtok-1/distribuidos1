/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 * Modelo da entidade locação
 * @author Bruno Tokarski e Rafael Vidal
 */
public class Locacao {
    
    private String localRetirada;
    private String localDevolucao;
    private Date dataHoraRetirada;
    private Date dataHoraDevolucao;
    private int idadeCondutor;
    private String numeroCartao;
    private String modoCompra;

    public String getLocalRetirada() {
        return localRetirada;
    }

    public void setLocalRetirada(String localRetirada) {
        this.localRetirada = localRetirada;
    }

    public String getLocalDevolucao() {
        return localDevolucao;
    }

    public void setLocalDevolucao(String localDevolucao) {
        this.localDevolucao = localDevolucao;
    }

    public Date getDataHoraRetirada() {
        return dataHoraRetirada;
    }

    public void setDataHoraRetirada(Date dataHoraRetirada) {
        this.dataHoraRetirada = dataHoraRetirada;
    }

    public Date getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public void setDataHoraDevolucao(Date dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
    }

    public int getIdadeCondutor() {
        return idadeCondutor;
    }

    public void setIdadeCondutor(int idadeCondutor) {
        this.idadeCondutor = idadeCondutor;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getModoCompra() {
        return modoCompra;
    }

    public void setModoCompra(String modoCompra) {
        this.modoCompra = modoCompra;
    }  
    
}
