package Inicio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Chaves.ControladoraChaves;
import GUI.JanelaMinhaIDPublica;
import Modelo.Conexao;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe inicial do programa
 * @author Bruno
 */
public class Distrib1 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Cria e instancia o usuário
        Usuario usuario = Usuario.getInstancia();
        
        usuario.setIdRede((int) (Math.random() * 100));
        usuario.setPapel("servidor");       
        
        //Cria e instancia a conexão
        Conexao conexao = Conexao.getInstancia();
        conexao.setINET_ADDR("228.5.6.7");
        conexao.setPORT(8885);
        conexao.setStatusLeilao("aguardando");
        
        //Obtem o par de chaves para o usuário
        ControladoraChaves cc = new ControladoraChaves();
        ArrayList<String> chaves = cc.GeraChaves(usuario.getIdRede());
        
        System.out.println("Chave pública: " + chaves.get(0));
        usuario.setChavePublica(chaves.get(0));
        System.out.println("Chave privada: " + chaves.get(1));
        usuario.setChavePrivada(chaves.get(1));
        
        Usuario.setInstancia(usuario);
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Distrib1.class.getName()).log(Level.SEVERE, null, ex);
        }
        JanelaMinhaIDPublica jid = new JanelaMinhaIDPublica();
        jid.setVisible(true);
        jid.repaint();
    }
    
}
