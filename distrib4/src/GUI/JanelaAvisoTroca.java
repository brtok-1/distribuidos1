/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Modelo.Cartao;
import Modelo.Colecionador;
import Modelo.Troca;

/**
 *
 * @author Rafael
 */
public class JanelaAvisoTroca extends javax.swing.JFrame {

    Troca troca;
    /**
     * Creates new form JanelaAvisoTroca
     */
    public JanelaAvisoTroca(Troca troca) {
        
        initComponents();
        setLocationRelativeTo(null);
        
        Colecionador logado = Colecionador.getInstancia();
        
        this.setTitle("Nova Solicitação - " + logado.getIdColecionador());
        
        this.troca = troca;
        
        Cartao cartaoRecebe = troca.getCartaoManda();
        Cartao cartaoManda = troca.getCartaoRecebe();
        
        Colecionador outroColecionador = troca.getSolicitante();
        
        String textoTroca = "Trocar " + cartaoRecebe.getIdCartao() + " - " + cartaoRecebe.getLocal() + 
                " por " + cartaoManda.getIdCartao() + " - " + cartaoManda.getLocal() + " com " +
        outroColecionador.getIdColecionador() + " - " + outroColecionador.getNomeColecionador();
        
<<<<<<< HEAD
        tpTroca.setText(textoTroca);
=======
        txtTroca.setText(textoTroca);
>>>>>>> origin/master
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
<<<<<<< HEAD

        jScrollPane1 = new javax.swing.JScrollPane();
        tpTroca = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(tpTroca);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nova Solicitação de Troca");
=======
        
        jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
        txtTroca = new javax.swing.JTextField();
        labelStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabel1.setText("Solicitação de Troca");

        jLabel2.setText("Status:");

        txtTroca.setEditable(false);

        labelStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelStatus.setText("LABELSTATUS");
>>>>>>> origin/master

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1)))
                .addContainerGap(24, Short.MAX_VALUE))
=======
				.addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
						.addComponent(txtTroca, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
						.addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelStatus)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
>>>>>>> origin/master
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
=======
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(labelStatus))
                .addGap(18, 18, 18)
                .addComponent(txtTroca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
>>>>>>> origin/master
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
<<<<<<< HEAD
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane tpTroca;
=======
	private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JTextField txtTroca;
>>>>>>> origin/master
    // End of variables declaration//GEN-END:variables
}
