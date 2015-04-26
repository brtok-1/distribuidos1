/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

/**
 *
 * @author Bruno
 */
public class Livro {
    String codigo;
    String nome;
    String descricao;
    double precoInicial;
    int tempoTotalLeilao;

    public Livro(String codigo, String nome, String descricao, double precoInicial, int tempoTotalLeilao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.precoInicial = precoInicial;
        this.tempoTotalLeilao = tempoTotalLeilao;
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

    public double getPrecoInicialDouble() {
        return precoInicial;
    }

    public void setPrecoInicialDouble(double precoInicial) {
        this.precoInicial = precoInicial;
    }

    public int getTempoTotalLeilao() {
        return tempoTotalLeilao;
    }

    public void setTempoTotalLeilao(int tempoTotalLeilao) {
        this.tempoTotalLeilao = tempoTotalLeilao;
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
    
}
