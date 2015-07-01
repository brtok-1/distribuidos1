/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chaves;

import Modelo.Conexao;
import Modelo.Usuario;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;

/**
 * Controladora responsável pela utilização de chaves para autenticação de usuários
 * @author Bruno Tokarski e Rafael Vidal
 */
public class ControladoraChaves {

    private Usuario usuario;
    private Conexao conexao;

    public ControladoraChaves() {
        usuario = Usuario.getInstancia();
        conexao = Conexao.getInstancia();
    }
    
    /**
     * Método responsável pela geração de um par de chaves para o usuário
     * 
     */
    public void GeraChaves() {

        try {

            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");

            keyGen.initialize(1024);
            final KeyPair key = keyGen.generateKeyPair();

            usuario.setChavePublica(key.getPublic());
            usuario.setChavePrivada(key.getPrivate());

            //Converte as chaves para string
            String ChavePublicaString = Base64.getEncoder().encodeToString(key.getPublic().getEncoded());
            String ChavePrivadaString = Base64.getEncoder().encodeToString(key.getPrivate().getEncoded());

            usuario.setChavePublicaString(ChavePublicaString);
            usuario.setChavePrivadaString(ChavePrivadaString);

        } catch (Exception ex) {
            Logger.getLogger(ControladoraChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Converte as chaves de String para PublicKey e PrivateKay
     * 
     * @throws Exception 
     */
    public void ConverteChaves() throws Exception {
        for (Usuario u : conexao.getParticipantes()) {
            if (u.getChavePublicaString() != null) {
                byte[] chavePublicaBytes = Base64.getDecoder().decode(u.getChavePublicaString());
                X509EncodedKeySpec keySpec = new X509EncodedKeySpec(chavePublicaBytes);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                PublicKey chavePublica = keyFactory.generatePublic(keySpec);
                u.setChavePublica(chavePublica);
            }
        }

    }

    /**
     * Encripta o lance utilizando a chave privada do participante
     * 
     * @param lance
     * @return
     * @throws Exception 
     */
    public String EncriptaLance(String lance) throws Exception {
        String lanceEncriptado;

        Cipher cifrador = Cipher.getInstance("RSA");
        cifrador.init(Cipher.ENCRYPT_MODE, usuario.getChavePrivada());

        byte[] textoCifrado = cifrador.doFinal(lance.getBytes());

        lanceEncriptado = Base64.getEncoder().encodeToString(textoCifrado);

        return lanceEncriptado;
    }

    /**
     * Decripta o lance utilizando a chave publica do jogador
     * @param lanceEncriptado
     * @param chavePublicaParticipante
     * @return 
     */
    public String DecriptaLance(String lanceEncriptado, PublicKey chavePublicaParticipante){

        conexao = Conexao.getInstancia();
        
        String lance = null;
        try {
            Cipher cifrador = Cipher.getInstance("RSA");
            cifrador.init(Cipher.DECRYPT_MODE, chavePublicaParticipante);

            byte[] textoCifrado = Base64.getDecoder().decode(lanceEncriptado);

            byte[] lanceBytes = cifrador.doFinal(textoCifrado);

            lance = new String(lanceBytes);
            conexao.setUsuarioAutenticado(true);
            
        }catch (Exception e)
        {            
            conexao.setUsuarioAutenticado(false);
        }
        return lance;

    }

}
