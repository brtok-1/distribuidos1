/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Veiculo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
     */
    public void SalvaVeiculo(Veiculo veiculo) throws Exception {

        FileOutputStream arquivoGrav = new FileOutputStream("C:/Distrib2/Veiculo.dst");        

        ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
        objGravar.writeObject(veiculos);
        objGravar.flush();
        objGravar.close();
        arquivoGrav.flush();
        arquivoGrav.close();
    }

    /**
     * Recuperar o objeto veículo salvo
     *
     */
    public Veiculo RecuperarVeiculo() throws Exception {
        FileInputStream arquivoLeitura = new FileInputStream("C:/Distrib2/Veiculo.dst");

        ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
        
        veiculos = (ArrayList<Veiculo>) objLeitura.readObject();        
        
        Veiculo veiculo = new Veiculo();
        
        objLeitura.close();

        arquivoLeitura.close();
        
        return veiculo;
    }

}
