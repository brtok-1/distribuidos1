/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bruno
 */
public class ColecionadorEncontrado {
    
    private int idColecionador;
    private long considerarQueda;
    private String nome;
    private int numeroCartoes;

    public ColecionadorEncontrado(int idColecionador, long considerarQueda, String nome, int numeroCartoes) {
        this.idColecionador = idColecionador;
        this.considerarQueda = considerarQueda;
        this.nome = nome;
        this.numeroCartoes = numeroCartoes;
    }

    public int getIdColecionador() {
        return idColecionador;
    }

    public void setIdColecionador(int idColecionador) {
        this.idColecionador = idColecionador;
    }

    public long getConsiderarQueda() {
        return considerarQueda;
    }

    public void setConsiderarQueda(long considerarQueda) {
        this.considerarQueda = considerarQueda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroCartoes() {
        return numeroCartoes;
    }

    public void setNumeroCartoes(int numeroCartoes) {
        this.numeroCartoes = numeroCartoes;
    }
    
}
