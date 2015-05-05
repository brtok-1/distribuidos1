package Inicio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GUI.JanelaMinhaIDPublica;
import Modelo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Bruno
 */
public class Distrib1 {

    //public static String idPublica;
    //public static int idRede;
    public static String souOq = "servidor";
    public static String INET_ADDR = "228.5.6.7";
    public static int PORT = 8885;
    //public static ArrayList<Conexao> conexoes = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Usuario usuario = new Usuario();
        usuario.setIdRede((int) (Math.random() * 100));
        
        //Distrib1.idRede = (int) (Math.random() * 100);
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Distrib1.class.getName()).log(Level.SEVERE, null, ex);
        }
        JanelaMinhaIDPublica jid = new JanelaMinhaIDPublica();
        jid.setUsuario(usuario);
        jid.setVisible(true);
        jid.repaint();
    }
    
}
