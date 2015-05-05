/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bruno
 */
public class Conexao {
    
    String idPublica;
    int idRede;
    
    public static String souOq = "servidor";
    public static String INET_ADDR = "228.5.6.7";
    public static int PORT = 8885;

    public Conexao(String idPublica, int idRede) {
        this.idPublica = idPublica;
        this.idRede = idRede;
    }

    public String getIdPublica() {
        return idPublica;
    }

    public void setIdPublica(String idPublica) {
        this.idPublica = idPublica;
    }

    public int getIdRede() {
        return idRede;
    }

    public void setIdRede(int idRede) {
        this.idRede = idRede;
    }
    
    
}
