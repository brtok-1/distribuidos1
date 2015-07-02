/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOarquivo;

import Modelo.Colecionador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class IOColecionador {
    
    public boolean SalvaColecionador(Colecionador colecionador) throws Exception {
        ArrayList<Colecionador> colecionadores;
        boolean duplicado = false;
        File arquivo = new File("C:/Distrib3/Colecionadores.dst");
        if (arquivo.exists()) {
            colecionadores = RecuperarColecionadores();
            for (Colecionador c : colecionadores) {
                if (c.getIdColecionador() == colecionador.getIdColecionador()) {
                    duplicado = true;
                }
            }
        } else {
            colecionadores = new ArrayList<>();
        }
        
        if (duplicado) {
            JOptionPane.showMessageDialog(null, "Já existe um colecionador com ID " + colecionador.getIdColecionador() + ".");
            return false;
        } else {
            colecionadores.add(colecionador);

            //Deleta o arquivo
            arquivo.delete();

            //Cria um arquivo novo para salvar o array atualizado
            FileOutputStream arquivoGrav = new FileOutputStream(arquivo);
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
            objGravar.writeObject(colecionadores);
            JOptionPane.showMessageDialog(null, "Colecionador ID " + colecionador.getIdColecionador() + " cadastrado com sucesso.");
            return true;
        }
    }
    
    public Colecionador RecuperaColecionadorPorID(int id) throws Exception {
        ArrayList<Colecionador> colecionadores = new ArrayList<>();
        Colecionador logado = Colecionador.getInstancia();
        File arquivo = new File("C:/Distrib3/Colecionadores.dst");
        if (arquivo.exists()) {
            colecionadores = RecuperarColecionadores();
            Colecionador colecionador = null;
            for (Colecionador c : colecionadores) {
                if (c.getIdColecionador() == id) {
                    colecionador = c;
                }
            }
            return colecionador;
        } else {
            JOptionPane.showMessageDialog(null, "Ainda não existe nenhum cartão cadastrado");
            return null;
        }
    }
    
    public ArrayList<Colecionador> RecuperarColecionadores() throws Exception {
        ArrayList<Colecionador> colecionadores = new ArrayList<>();
        File arquivo = new File("C:/Distrib3/Colecionadores.dst");
        if (arquivo.exists()) {
            FileInputStream arquivoLeitura = new FileInputStream("C:/Distrib3/Colecionadores.dst");
            if (arquivoLeitura.available() != 0) {
                ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
                colecionadores = (ArrayList<Colecionador>) objLeitura.readObject();
            }
        }
        return colecionadores;
    }
    
}
