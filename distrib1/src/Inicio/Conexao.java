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
public class Conexao {
    
    String idPublica;
    int idRede;

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
