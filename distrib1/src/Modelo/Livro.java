/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Classe de modelo para o livro
 * @author Bruno Tokaski e Rafael Vidal
 */
public class Livro {
    int idRedeDonoLivro;
    String idPublicaDonoLivro;
    String codigo;
    String nome;
    String descricao;
    double precoInicial;
    long tempoTotalLeilao;
    long tempoNoInicio;
    Lance maiorLance;

    public Livro(String codigo, String nome, String descricao, long tempoTotalLeilao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.tempoTotalLeilao = tempoTotalLeilao;
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

    public Lance getMaiorLance() {
        return maiorLance;
    }

    public void setMaiorLance(Lance maiorLance) {
        this.maiorLance = maiorLance;
    }

    public int getIdRedeDonoLivro() {
        return idRedeDonoLivro;
    }

    public void setIdRedeDonoLivro(int idRedeDonoLivro) {
        this.idRedeDonoLivro = idRedeDonoLivro;
    }

    public String getIdPublicaDonoLivro() {
        return idPublicaDonoLivro;
    }

    public void setIdPublicaDonoLivro(String idPublicaDonoLivro) {
        this.idPublicaDonoLivro = idPublicaDonoLivro;
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
