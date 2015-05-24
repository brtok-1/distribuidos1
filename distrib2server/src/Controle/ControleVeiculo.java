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
     * Salvar o objeto veículo
     *
     * @param veiculo
     * @throws java.lang.Exception
     */
    public void SalvaVeiculo(Veiculo veiculo) throws Exception {
        File arquivo = new File("C:/Distrib2/Veiculo.dst");
        try (FileOutputStream arquivoGrav = new FileOutputStream(arquivo)) {
            if (!arquivo.exists()) {
                veiculos = new ArrayList<>();
            } else {
                veiculos = new ArrayList<>();
                veiculos = RecuperarVeiculos();
            }
            veiculos.add(veiculo);
            try (ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav)) {
                objGravar.writeObject(veiculos);
            }
        }
        for (Veiculo v : veiculos) {
            System.out.println(v.getIdVeiculo());
            System.out.println(v.getModelo());
        }
    }

    /**
     * Recuperar todos os veículos salvos
     *
     * @return
     * @throws Exception
     */
    public ArrayList<Veiculo> RecuperarVeiculos() throws Exception {
        FileInputStream arquivoLeitura = new FileInputStream("C:/Distrib2/Veiculo.dst");
        
        if (arquivoLeitura.available() != 0)
        {
            ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
            veiculos = (ArrayList<Veiculo>) objLeitura.readObject();
        }       

        return veiculos;
    }

    /**
     * Recuperar um veículo salvo
     *
     * @param id
     * @return
     * @throws java.lang.Exception
     */
    public Veiculo RecuperarVeiculosPorID(int id) throws Exception {
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
