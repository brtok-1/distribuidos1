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
public class Cartao {
    
    private int idCartao;
    
    private String local;
    
    private Colecionador proprietario;

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Colecionador getProprietario() {
        return proprietario;
    }

    public void setProprietario(Colecionador proprietario) {
        this.proprietario = proprietario;
    }
    
}
