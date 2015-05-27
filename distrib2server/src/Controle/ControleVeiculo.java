/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Veiculo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Controle da entidade veículo
 *
 * @author Bruno Tokaski e Rafael Vidal
 */
public class ControleVeiculo {

    private ArrayList<Veiculo> veiculos;

    /**
     * Salvar em arquivo o objeto veículo recebido por parâmetro
     *
     * @param veiculo Veiculo a ser salvo
     * @return sucesso Variável boolean que indica o sucesso ou fracasso da operação de salvamento
     * @throws java.lang.Exception
     */
    public boolean SalvaVeiculo(Veiculo veiculo) throws Exception {
        boolean duplicado = false;
        File arquivo = new File("C:/Distrib2/Veiculo.dst");
        if (arquivo.exists()) {
            veiculos = RecuperarVeiculos();
            for (Veiculo v : veiculos) {
                if (v.getIdVeiculo() == veiculo.getIdVeiculo()) {
                    duplicado = true;
                }
            }
        } else {
            veiculos = new ArrayList<>();
        }
        
        if (duplicado) {
            JOptionPane.showMessageDialog(null, "Já existe um veículo cadastrado com ID " + veiculo.getIdVeiculo() + ".");
            return false;
        } else {
            veiculos.add(veiculo);

            //Deleta o arquivo
            arquivo.delete();

            //Cria um arquivo novo para salvar o array atualizado
            FileOutputStream arquivoGrav = new FileOutputStream(arquivo);
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
            objGravar.writeObject(veiculos);
            JOptionPane.showMessageDialog(null, "Veículo ID " + veiculo.getIdVeiculo() + " cadastrado com sucesso.");
            return true;
        }
    }

    /**
     * Salvar uma edição de um veículo específico, ao final testa seu novo preço para disparar ou não a notificação de clientes
     * 
     * @param veiculo Veiculo a ser salvo
     * @throws Exception 
     */
    public void EditaVeiculo(Veiculo veiculo) throws Exception {
        File arquivo = new File("C:/Distrib2/Veiculo.dst");
        Veiculo veiculoAntes = new Veiculo();
        if (arquivo.exists()) {
            veiculos = RecuperarVeiculos();
            for (Veiculo v : veiculos) {
                if (v.getIdVeiculo() == veiculo.getIdVeiculo()) {
                    veiculoAntes = v;
                    veiculos.remove(v);
                    break;
                }
            }
        } else {
            veiculos = new ArrayList<>();
        }
        veiculos.add(veiculo);

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

    /**
     * Recupera todos os veículos salvos no arquivo
     *
     * @return ArrayList com todos os Veiculos salvos
     * @throws Exception
     */
    public ArrayList<Veiculo> RecuperarVeiculos() throws Exception {
        File arquivo = new File("C:/Distrib2/Veiculo.dst");
        if (arquivo.exists()) {
            FileInputStream arquivoLeitura = new FileInputStream("C:/Distrib2/Veiculo.dst");
            if (arquivoLeitura.available() != 0) {
                ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
                veiculos = (ArrayList<Veiculo>) objLeitura.readObject();
            }
        }
        return veiculos;
    }

    /**
     * Recupera o veiculo salvo que possui a identificação recebida por parâmetro
     *
     * @param id Identificação do veiculo procurado
     * @return Veiculo solicitado
     * @throws java.lang.Exception
     */
    public Veiculo RecuperarVeiculoPorID(int id) throws Exception {
        File arquivo = new File("C:/Distrib2/Veiculo.dst");
        if (arquivo.exists()) {
            veiculos = RecuperarVeiculos();
            Veiculo v = null;
            for (Veiculo veiculo : veiculos) {
                if (veiculo.getIdVeiculo() == id) {
                    v = veiculo;
                }
            }
            return v;
        } else {
            JOptionPane.showMessageDialog(null, "Ainda não existe nenhum veículo cadastrado");
            return null;
        }

    }
}
