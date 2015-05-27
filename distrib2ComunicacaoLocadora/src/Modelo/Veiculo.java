/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 * Classe modelo da entidade veículo
 * @author Bruno Tokarski e Rafael Vidal
 */
public class Veiculo implements Serializable {
    
    private int idVeiculo;    
    private int ano;
    private double valorDiaria;
    private String  fabricante;
    private String modelo;
    private String placa;

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    
    public String getValorDiariaString() {
        String valor = String.valueOf(valorDiaria).replaceAll("\\.", ",");
        return valor;
    }

    public void setValorDiariaString(String valor) {
        valor = valor.trim().replaceAll(",", "\\.");
        this.valorDiaria = Double.parseDouble(valor);
    }
}
