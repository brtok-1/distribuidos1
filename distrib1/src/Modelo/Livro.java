/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Inicio.Lance;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class Livro {
    String codigo;
    String nome;
    String descricao;
    double precoInicial;
    long tempoTotalLeilao;
    long tempoNoInicio;
    ArrayList<Lance> lances = new ArrayList<>();

    public Livro(String codigo, String nome, String descricao, long tempoTotalLeilao, long tempoInicial) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.tempoTotalLeilao = tempoTotalLeilao;
        this.tempoNoInicio = tempoInicial;
    }
    
    public Livro()
    {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }

    public void setPrecoInicial(double precoInicial) {
        this.precoInicial = precoInicial;
    }

    public long getTempoTotalLeilao() {
        return tempoTotalLeilao;
    }

    public void setTempoTotalLeilao(long tempoTotalLeilao) {
        this.tempoTotalLeilao = tempoTotalLeilao;
    }

    public long getTempoNoInicio() {
        return tempoNoInicio;
    }

    public void setTempoNoInicio(long tempoNoInicio) {
        this.tempoNoInicio = tempoNoInicio;
    }

    public String getPrecoInicialString() {
        String preco = String.valueOf(precoInicial);
        preco = preco.replaceAll("\\.", ",");
        return preco;
    }

    public void setPrecoInicialString(String preco) {
        preco = preco.replaceAll(",", "\\.");
        double precoIn = Double.parseDouble(preco);
        precoInicial = precoIn;
    }

    public ArrayList<Lance> getLances() {
        return lances;
    }

    public void setLances(ArrayList<Lance> lances) {
        this.lances = lances;
    }
    
}
