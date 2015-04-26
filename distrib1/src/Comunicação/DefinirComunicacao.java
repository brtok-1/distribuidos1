/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicação;

import Inicio.Distrib1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Bruno
 */
public class DefinirComunicacao {

    final String INET_ADDR = "224.0.0.10";
    static int PORT = 8888;

    public DefinirComunicacao() throws IOException, ClassNotFoundException {
        File arquivo = new File("pt");
        if (arquivo.exists()) {
            ObjectInputStream leitor = new ObjectInputStream(new FileInputStream("pt"));
            PORT = (int) leitor.readObject();
            PORT--;
            leitor.close();
            System.out.println(PORT);
            Distrib1.souOq = "cliente";
        } else {
            Distrib1.souOq = "servidor";
        }
        arquivo.delete();
        ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("pt"));
        escritor.writeObject(PORT);
        escritor.close();
    }    
}
