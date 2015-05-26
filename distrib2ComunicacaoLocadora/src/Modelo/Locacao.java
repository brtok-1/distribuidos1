/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Time;
import java.util.Date;

/**
 * Modelo da entidade locação
 * @author Bruno Tokarski e Rafael Vidal
 */
public class Locacao {
    
    private String localRetirada;
    private String localDevolucao;
    private Date dataRetirada;
    private Time horaRetirada;
    private Date dataDevolucao;
    private Time horaDevolucao;
    private String nomeCondutor;
    private int idadeCondutor;
    private String numeroCartao;
    private int parcelasCartao;
    private Veiculo veiculo;

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

    public String getNomeCondutor() {
        return nomeCondutor;
    }

    public void setNomeCondutor(String nomeCondutor) {
        this.nomeCondutor = nomeCondutor;
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

    public int getParcelasCartao() {
        return parcelasCartao;
    }

    public void setParcelasCartao(int parcelasCartao) {
        this.parcelasCartao = parcelasCartao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Time getHoraRetirada() {
        return horaRetirada;
    }

    public void setHoraRetirada(Time horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Time getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(Time horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }
    
}
