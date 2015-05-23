/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Classe de modelo para o lance
 * @author Bruno Tokarski e Rafael Vidal
 */
public class Lance {
    double valorOferecido;
    String idPublicaQuemOfereceu;
    int idRedeQuemOfereceu;
    long tempoNaHora;

    public Lance(String idPublicaQuemOfereceu, int idRedeQuemOfereceu, long tempoNaHora) {
        this.idPublicaQuemOfereceu = idPublicaQuemOfereceu;
        this.idRedeQuemOfereceu = idRedeQuemOfereceu;
        this.tempoNaHora = tempoNaHora;
    }
    
    public Lance() {
        valorOferecido = -1;
    }

    public double getValorOferecido() {
        return valorOferecido;
    }

    public void setValorOferecido(double valorOferecido) {
        this.valorOferecido = valorOferecido;
    }

    public long getTempoNaHora() {
        return tempoNaHora;
    }

    public void setTempoNaHora(long tempoNaHora) {
        this.tempoNaHora = tempoNaHora;
    }
    
    public String getValorOferecidoString() {
        String valor = String.valueOf(valorOferecido);
        valor = valor.replaceAll("\\.", ",");
        return valor;
    }

    public void setValorOferecidoString(String valor) {
        valor = valor.replaceAll(",", "\\.");
        valorOferecido = Double.parseDouble(valor);
    }

    public String getIdPublicaQuemOfereceu() {
        return idPublicaQuemOfereceu;
    }

    public void setIdPublicaQuemOfereceu(String idPublicaQuemOfereceu) {
        this.idPublicaQuemOfereceu = idPublicaQuemOfereceu;
    }

    public int getIdRedeQuemOfereceu() {
        return idRedeQuemOfereceu;
    }

    public void setIdRedeQuemOfereceu(int idRedeQuemOfereceu) {
        this.idRedeQuemOfereceu = idRedeQuemOfereceu;
    }
    
}
