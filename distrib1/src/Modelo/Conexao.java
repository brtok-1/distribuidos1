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
    
    private String INET_ADDR;
    private int PORT;
    
    private static Conexao instancia;    
 
    public String getINET_ADDR() {
        return INET_ADDR;
    }

    public void setINET_ADDR(String INET_ADDR) {
        this.INET_ADDR = INET_ADDR;
    }

    public int getPORT() {
        return PORT;
    }

    public void setPORT(int PORT) {
        this.PORT = PORT;
    }

    public static Conexao getInstancia() {
        if (instancia == null)
        {
            instancia = new Conexao();
        }
        return instancia;
    }

    public static void setInstancia(Conexao instancia) {
        Conexao.instancia = instancia;
    }

    
}
