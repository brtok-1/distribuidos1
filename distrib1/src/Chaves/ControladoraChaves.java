/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chaves;

import Modelo.Usuario;
import java.io.File;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class ControladoraChaves {

    //String PATH_CHAVE_PRIVADA;
    //String PATH_CHAVE_PUBLICA;
    
    private Usuario usuario;
    
    public ControladoraChaves()
    {
        usuario = Usuario.getInstancia();
    }

    public void GeraChaves() {
        ArrayList<String> chaves = new ArrayList();

//        //Locais onde as chaves serão armazenadas
//        PATH_CHAVE_PRIVADA = "C:/keys/" + idUsuario + "/private.key";
//        PATH_CHAVE_PUBLICA = "C:/keys/" + idUsuario + "/public.key";

        try {          

            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");

            keyGen.initialize(1024);
            final KeyPair key = keyGen.generateKeyPair();

//            File chavePrivadaFile = new File(PATH_CHAVE_PRIVADA);
//            File chavePublicaFile = new File(PATH_CHAVE_PUBLICA);

            // Cria os arquivos para armazenar a chave Privada e a chave Publica
//            if (chavePrivadaFile.getParentFile() != null) {
//                chavePrivadaFile.getParentFile().mkdirs();
//            }
//
//            chavePrivadaFile.createNewFile();
//
//            if (chavePublicaFile.getParentFile() != null) {
//                chavePublicaFile.getParentFile().mkdirs();
//            }
//
//            chavePublicaFile.createNewFile();

//            // Salva a Chave Pública no arquivo
//            ObjectOutputStream chavePublicaOS = new ObjectOutputStream(new FileOutputStream(chavePublicaFile));
//            chavePublicaOS.writeObject(key.getPublic());
//            chavePublicaOS.close();
//
//            // Salva a Chave Privada no arquivo
//            ObjectOutputStream chavePrivadaOS;
//            chavePrivadaOS = new ObjectOutputStream(new FileOutputStream(chavePrivadaFile));
//            chavePrivadaOS.writeObject(key.getPrivate());
//            chavePrivadaOS.close();
            
            //usuario.setChavePublicaString(key.getPublic().toString());
            //usuario.setChavePrivadaString(key.getPrivate().toString());

            //Converte as chaves para string
            String ChavePublicaString = Base64.getEncoder().encodeToString(key.getPublic().getEncoded());
            String ChavePrivadaString = Base64.getEncoder().encodeToString(key.getPrivate().getEncoded());
                        
            usuario.setChavePublicaString(ChavePublicaString);
            usuario.setChavePrivadaString(ChavePrivadaString);

//            chaves.add(ChavePublica);
//            chaves.add(ChavePrivada);
            
        } catch (Exception ex) {
            Logger.getLogger(ControladoraChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
