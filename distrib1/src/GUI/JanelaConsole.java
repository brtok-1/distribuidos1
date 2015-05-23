package GUI;

import Modelo.Usuario;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaConsole.java
 *
 * Created on 03/12/2010, 16:55:02
 */
/**
 * Janela com exibição de informações de execução do programa
 * @author Bruno Tokarski e Rafael Vidal
 */
public class JanelaConsole extends javax.swing.JFrame {

    private static ArrayList<String> mensagens = new ArrayList<>();

    /**
     * Creates new form JanelaConsole
     */
    public JanelaConsole() {
        initComponents();
    }
    
    public static JanelaConsole instancia = new JanelaConsole();

    public static JanelaConsole getInstancia() {
        return instancia;
    }
    
    /**
     * Atualiza o título da janela
     */
    public void atualizaTitulo() {
        Usuario usuario = Usuario.getInstancia();
        setTitle(usuario.getIdPublica() + " - Console");
    }

    /**
     * Escreve mensagem na janela de console
     * @param s
     * @throws InterruptedException 
     */
    public static void escreveNaJanela(String s) throws InterruptedException {
        mensagens.add(s);
        if (mensagens.size() > 12) {
            mensagens.remove(0);
            if (mensagens.size() > 12) {
                mensagens.clear();
                mensagens.add("Houve um pequeno erro no Console. Ele foi esvaziado");
                mensagens.add("mas exibirá as próximas mensagens normalmente.");
            }
        }
        String print = mensagens.get(0) + "\n";
        for (int i = 1; i < mensagens.size(); i++) {
            if (i == mensagens.size() - 1) {
                print = print + mensagens.get(i);
            } else {
                print = print + mensagens.get(i) + "\n";
            }
        }
        jTextArea1.setText(print);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Console");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jTextArea1.setRows(8);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
