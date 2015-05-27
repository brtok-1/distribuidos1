/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Locacao;
import java.util.ArrayList;
import java.util.Date;

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
    public boolean verificaDisponibilidade(Locacao minhaLocacao) {
        ArrayList<Locacao> locacoesVeiculo = getLocacoesPorVeiculo(minhaLocacao.getVeiculo().getIdVeiculo());
        Date hoje = new Date();
        
        for(Locacao outraLocacao : locacoesVeiculo)
        {
            //Se a data de retirada da outra for antes da minha, a data de devolução da outra deve ser antes da minha retirada 
            if(!(outraLocacao.getDataRetirada().before(minhaLocacao.getDataRetirada()) && 
                    outraLocacao.getDataDevolucao().before(minhaLocacao.getDataRetirada())))
            {
                return false;
            }
            
            //Se a data de retirada da outra for depois da minha, a minha data de devolução deve ser antes da de retirada da outra
            if(!(outraLocacao.getDataRetirada().after(minhaLocacao.getDataRetirada()) && 
                    outraLocacao.getDataRetirada().after(minhaLocacao.getDataDevolucao())))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean addLocacao(Locacao locacao) {
        boolean disponivel = verificaDisponibilidade(locacao);
        if (disponivel) {
            
            ControleLocacao controleLocacao = ControleLocacao.getInstancia();
            controleLocacao.getLocacoes().add(locacao);
            
        }      
        
        return disponivel;
    }

    public ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(ArrayList<Locacao> locacoes) {
        this.locacoes = locacoes;
    }
    
    

}
