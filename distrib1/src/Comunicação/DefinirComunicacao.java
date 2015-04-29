/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import GUI.JanelaConsole;
import java.io.IOException;

/**
 *
 * @author Bruno
 */
public class DefinirComunicacao {

    public static String INET_ADDR;
    public static int PORT = 8885;
    public static int idRede;

    public DefinirComunicacao() throws IOException, ClassNotFoundException {
        idRede = (int) (Math.random() * 100);
        INET_ADDR = "228.5.6.7";
        JanelaConsole.escreveNaJanela("Participando da comunicação");
        JanelaConsole.escreveNaJanela("com endereço: " + INET_ADDR);
        System.out.println(".");
    }
}
