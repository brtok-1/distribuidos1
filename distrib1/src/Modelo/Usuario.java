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
public class Usuario {
    
    private int idRede;
    private String idPublica;
    private String chavePublica;
    private String chavePrivada;

    public Usuario(int idRede, String idPublica, String chavePublica, String chavePrivada) {
        this.idRede = idRede;
        this.idPublica = idPublica;
        this.chavePublica = chavePublica;
        this.chavePrivada = chavePrivada;
    }   

    public int getIdRede() {
        return idRede;
    }

    public void setIdRede(int idRede) {
        this.idRede = idRede;
    }

    public String getIdPublica() {
        return idPublica;
    }

    public void setIdPublica(String idPublica) {
        this.idPublica = idPublica;
    }

    public String getChavePublica() {
        return chavePublica;
    }

    public void setChavePublica(String chavePublica) {
        this.chavePublica = chavePublica;
    }

    public String getChavePrivada() {
        return chavePrivada;
    }

    public void setChavePrivada(String chavePrivada) {
        this.chavePrivada = chavePrivada;
    }
    
    
}
