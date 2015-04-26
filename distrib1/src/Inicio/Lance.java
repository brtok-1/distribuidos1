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
public class Lance {
    int codigoLeilao;
    double valorOferecido;
    String quemOfereceu;
    int tempoNaHora;

    public Lance(int codigoLeilao, double valorOferecido, String quemOfereceu, int tempoNaHora) {
        this.codigoLeilao = codigoLeilao;
        this.valorOferecido = valorOferecido;
        this.quemOfereceu = quemOfereceu;
        this.tempoNaHora = tempoNaHora;
    }

        public int getCodigoLeilao() {
        return codigoLeilao;
    }

    public void setCodigoLeilao(int codigoLeilao) {
        this.codigoLeilao = codigoLeilao;
    }

    public double getValorOferecido() {
        return valorOferecido;
    }

    public void setValorOferecido(double valorOferecido) {
        this.valorOferecido = valorOferecido;
    }

    public String getQuemOfereceu() {
        return quemOfereceu;
    }

    public void setQuemOfereceu(String quemOfereceu) {
        this.quemOfereceu = quemOfereceu;
    }

    public int getTempoNaHora() {
        return tempoNaHora;
    }

    public void setTempoNaHora(int tempoNaHora) {
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
}
