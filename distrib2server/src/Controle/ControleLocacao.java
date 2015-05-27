/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Locacao;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class ControleLocacao {

    private static ControleLocacao instancia = new ControleLocacao();
    private ArrayList<Locacao> locacoes = new ArrayList<>();

    public static ControleLocacao getInstancia() {
        return instancia;
    }

    public static void setInstancia(ControleLocacao instancia) {
        ControleLocacao.instancia = instancia;
    }

    public ArrayList<Locacao> getLocacoesPorVeiculo(int idVeiculo) {
        ArrayList<Locacao> resultado = new ArrayList<>();
        for (Locacao l : locacoes) {
            if (l.getVeiculo().getIdVeiculo() == idVeiculo) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    //Date dataInicio, Time horaInicio, Date dataFim, Time horaFim, int idVeiculo
    public boolean verificaDisponibilidade(Locacao locacao) {
        ArrayList<Locacao> locacoesVeiculo = getLocacoesPorVeiculo(locacao.getVeiculo().getIdVeiculo());
        

        return true;
    }

    public boolean addLocacao(Locacao locacao) {
        boolean disponivel = verificaDisponibilidade(locacao);
        if (disponivel) {
            //CODIGO PARA ADICIONAR A LOCACAO
            return true;
        } else {
            //CODIGO QUE CONFIRMA QUE NÃO ESTÁ DISPONÍVEL
            return false;
        }
    }

}
