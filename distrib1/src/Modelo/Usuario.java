/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Classe de modelo para o usuário
 * @author Bruno Tokarski e Rafael Vidal
 */
public class Usuario {
    
    private int idRede;
    private String idPublica;
    private String chavePublicaString;
    private String chavePrivadaString;
    private String papel;
    
    private PublicKey chavePublica;
    private PrivateKey chavePrivada;
    
    private static Usuario instancia;
    
    public Usuario()
    {
        
    }

    public Usuario(int idRede, String idPublica, String chavePublicaString, String chavePrivadaString, String papel) {
        this.idRede = idRede;
        this.idPublica = idPublica;
        this.chavePublicaString = chavePublicaString;
        this.chavePrivadaString = chavePrivadaString;
        this.papel = papel;
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

    public String getChavePrivadaString() {
        return chavePrivadaString;
    }

    public void setChavePrivadaString(String chavePrivadaString) {
        this.chavePrivadaString = chavePrivadaString;
    }  

    public String getChavePublicaString() {
        return chavePublicaString;
    }

    public void setChavePublicaString(String chavePublicaString) {
        this.chavePublicaString = chavePublicaString;
    }

    public PublicKey getChavePublica() {
        return chavePublica;
    }

    public void setChavePublica(PublicKey chavePublica) {
        this.chavePublica = chavePublica;
    }

    public PrivateKey getChavePrivada() {
        return chavePrivada;
    }

    public void setChavePrivada(PrivateKey chavePrivada) {
        this.chavePrivada = chavePrivada;
    }    
    

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }  

    public static Usuario getInstancia() {
        if (instancia == null)
        {
            instancia = new Usuario();
        }
        return instancia;
    }

    public static void setInstancia(Usuario instancia) {
        Usuario.instancia = instancia;
    }
    
    
}
