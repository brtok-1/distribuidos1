/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOarquivo;

import Modelo.Cartao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class IOCartao {
    
    public boolean SalvaCartao(Cartao cartao) throws Exception {
        ArrayList<Cartao> cartoes;
        boolean duplicado = false;
        File arquivo = new File("C:/Distrib2/Cartao.dst");
        if (arquivo.exists()) {
            cartoes = RecuperarCartoes();
            for (Cartao c : cartoes) {
                if (c.getIdCartao() == cartao.getIdCartao()) {
                    duplicado = true;
                }
            }
        } else {
            cartoes = new ArrayList<>();
        }
        
        if (duplicado) {
            JOptionPane.showMessageDialog(null, "Já existe um cartão cadastrado com ID " + cartao.getIdCartao() + ".");
            return false;
        } else {
            cartoes.add(cartao);

            //Deleta o arquivo
            arquivo.delete();

            //Cria um arquivo novo para salvar o array atualizado
            FileOutputStream arquivoGrav = new FileOutputStream(arquivo);
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
            objGravar.writeObject(cartoes);
            JOptionPane.showMessageDialog(null, "Veículo ID " + cartao.getIdCartao() + " cadastrado com sucesso.");
            return true;
        }
    }
    
    public void EditaCartao(Cartao cartao) throws Exception {
        ArrayList<Cartao> cartoes;
        File arquivo = new File("C:/Distrib2/Cartao.dst");
        Cartao cartaoAntes;
        if (arquivo.exists()) {
            cartoes = RecuperarCartoes();
            for (Cartao c : cartoes) {
                if (c.getIdCartao() == cartao.getIdCartao()) {
                    cartaoAntes = c;
                    cartoes.remove(c);
                    break;
                }
            }
        } else {
            cartoes = new ArrayList<>();
        }
        cartoes.add(cartao);

        //Deleta o arquivo
        arquivo.delete();

        //Cria um arquivo novo para salvar o array atualizado
        FileOutputStream arquivoGrav = new FileOutputStream(arquivo);
        ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
        objGravar.writeObject(veiculos);
        JOptionPane.showMessageDialog(null, "Veículo ID " + veiculo.getIdVeiculo() + " modificado com sucesso.");
        if (veiculo.getValorDiaria() < veiculoAntes.getValorDiaria()) {
            ControleNotificacao cn = new ControleNotificacao(veiculo, veiculoAntes.getValorDiariaString());
            cn.start();
        }
    }
    
}
