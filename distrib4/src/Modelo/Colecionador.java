/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class Colecionador {
    
    private int idColecionador;
    private String nomeColecionador;
    private boolean coordenador;
    private ArrayList<Cartao> cartoes;
    
    private static Colecionador instancia;

    
    public static Colecionador getInstancia() {
        return instancia;
    }

    public static void setInstancia(Colecionador instancia) {
        Colecionador.instancia = instancia;
    }

    public int getIdColecionador() {
        return idColecionador;
    }

    public void setIdColecionador(int idColecionador) {
        this.idColecionador = idColecionador;
    }

    public String getNomeColecionador() {
        return nomeColecionador;
    }

    public void setNomeColecionador(String nomeColecionador) {
        this.nomeColecionador = nomeColecionador;
    }

    public boolean isCoordenador() {
        return coordenador;
    }

    public void setCoordenador(boolean coordenador) {
        this.coordenador = coordenador;
    }

    public ArrayList<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(ArrayList<Cartao> cartoes) {
        this.cartoes = cartoes;
    }
    
}
