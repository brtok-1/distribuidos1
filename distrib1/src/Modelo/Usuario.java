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
    private String papel;
    
    private static Usuario instancia;
    
    public Usuario()
    {
        
    }

    public Usuario(int idRede, String idPublica, String chavePublica, String chavePrivada, String papel) {
        this.idRede = idRede;
        this.idPublica = idPublica;
        this.chavePublica = chavePublica;
        this.chavePrivada = chavePrivada;
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
