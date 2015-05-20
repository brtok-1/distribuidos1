/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chaves;

import Modelo.Conexao;
import Modelo.Usuario;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;

/**
 *
 * @author Rafael
 */
public class ControladoraChaves {

    //String PATH_CHAVE_PRIVADA;
    //String PATH_CHAVE_PUBLICA;
    private Usuario usuario;
    private Conexao conexao;

    public ControladoraChaves() {
        usuario = Usuario.getInstancia();
        conexao = Conexao.getInstancia();
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
            usuario.setChavePublica(key.getPublic());
            usuario.setChavePrivada(key.getPrivate());

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

    //Converte as chaves de String para PublicKey e PrivateKay
    public void ConverteChaves() throws Exception {
        //ArrayList<Usuario> participantes = conexao.getParticipantes();
        System.out.println("Atribuindo chave privada");
        for (Usuario u : conexao.getParticipantes()) {
            System.out.println((u.getChavePublicaString() != null) + " e " + (u.getIdRede() != usuario.getIdRede()));
            if (u.getChavePublicaString() != null && u.getIdRede() != usuario.getIdRede()) {
                System.out.println("Vai atribuir a chave publica");
                byte[] chavePublicaBytes = Base64.getDecoder().decode(u.getChavePublicaString());
                X509EncodedKeySpec keySpec = new X509EncodedKeySpec(chavePublicaBytes);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                PublicKey chavePublica = keyFactory.generatePublic(keySpec);
                u.setChavePublica(chavePublica);
            }          
        }

    }

    public String EncriptaLance(String lance) throws Exception {
        String lanceEncriptado;

        Cipher cifrador = Cipher.getInstance("RSA");
        cifrador.init(Cipher.ENCRYPT_MODE, usuario.getChavePrivada());

        byte[] textoCifrado = cifrador.doFinal(lance.getBytes());
        System.out.println("Tamanho dos bytes ao cifrar " + textoCifrado.length );
        System.out.println("Texto cifrado: " + textoCifrado);

        //lanceEncriptado = new String(textoCifrado);
        lanceEncriptado = Base64.getEncoder().encodeToString(textoCifrado);
        
        //byte[] textoCifrado2 = lanceEncriptado.getBytes();
        byte[] textoCifrado2 = Base64.getDecoder().decode(lanceEncriptado);
        
        System.out.println("Convertendo e desconvertendo " + textoCifrado2.length);
        System.out.println("Texto cifrado: " + textoCifrado2);

        return lanceEncriptado;
    }

    //Decripta o lance utilizando a chave publica do jogador
    public String DecriptaLance(String lanceEncriptado, PublicKey chavePublicaParticipante) throws Exception {
        String lance = "";

//        Cipher cifrador = Cipher.getInstance("RSA");
//        cifrador.init(Cipher.DECRYPT_MODE, chavePublicaParticipante);
//
//        byte[] textoCifrado = Base64.getDecoder().decode(lanceEncriptado);
//
//        System.out.println("Tamanho dos bytes " + textoCifrado.length );
//        byte[] lanceBytes = cifrador.doFinal(textoCifrado);
//        
//
//        lance = new String(lanceBytes);
//
//        System.out.println("Testo decifrado: " + lance);

        return lance;
    }

}
