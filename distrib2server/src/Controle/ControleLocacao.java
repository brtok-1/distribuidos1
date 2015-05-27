/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Locacao;
import java.util.ArrayList;

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
        ControleLocacao controle = ControleLocacao.getInstancia();
        locacoes = controle.getLocacoes();

        for (Locacao l : locacoes) {
            if (l.getVeiculo().getIdVeiculo() == idVeiculo) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public boolean verificaDisponibilidade(Locacao minhaLocacao) {
        ArrayList<Locacao> locacoesVeiculo = getLocacoesPorVeiculo(minhaLocacao.getVeiculo().getIdVeiculo());
        if (locacoesVeiculo.isEmpty()) {
            return true;
        }
        boolean disponivel = true;
        for (Locacao outraLocacao : locacoesVeiculo) {
            if (outraLocacao.getDataRetirada().equals(minhaLocacao.getDataRetirada())
                    && outraLocacao.getDataDevolucao().equals(minhaLocacao.getDataDevolucao())) {
                
                if (outraLocacao.getHoraRetirada().equals(minhaLocacao.getHoraRetirada())
                    && outraLocacao.getHoraDevolucao().equals(minhaLocacao.getHoraDevolucao())) {
                    disponivel = false;
                    break;
                }
                if (outraLocacao.getHoraRetirada().equals(minhaLocacao.getHoraDevolucao())) {
                    disponivel = false;
                    break;
                }
                if (outraLocacao.getHoraDevolucao().equals(minhaLocacao.getHoraRetirada())) {
                    disponivel = false;
                    break;
                }
                if (minhaLocacao.getHoraRetirada().before(outraLocacao.getHoraDevolucao())
                        && minhaLocacao.getHoraDevolucao().after(outraLocacao.getHoraRetirada())) {
                    disponivel = false;
                    break;
                }
                if (minhaLocacao.getHoraDevolucao().after(outraLocacao.getHoraRetirada())
                        && minhaLocacao.getHoraRetirada().before(outraLocacao.getHoraDevolucao())) {
                    disponivel = false;
                    break;
                }
                
            } else {
                if (outraLocacao.getDataRetirada().equals(minhaLocacao.getDataDevolucao())
                        && minhaLocacao.getHoraDevolucao().after(outraLocacao.getHoraRetirada())) {
                    disponivel = false;
                    break;
                }
                if (outraLocacao.getDataDevolucao().equals(minhaLocacao.getDataRetirada())
                        && minhaLocacao.getHoraRetirada().before(outraLocacao.getHoraDevolucao())) {
                    disponivel = false;
                    break;
                }
                if (minhaLocacao.getDataRetirada().before(outraLocacao.getDataDevolucao())
                        && minhaLocacao.getDataDevolucao().after(outraLocacao.getDataRetirada())) {
                    disponivel = false;
                    break;
                }
                if (minhaLocacao.getDataDevolucao().after(outraLocacao.getDataRetirada())
                        && minhaLocacao.getDataRetirada().before(outraLocacao.getDataDevolucao())) {
                    disponivel = false;
                    break;
                }
            }
        }
        
        return disponivel;
        
//        return disponivel;
//        for (Locacao outraLocacao : locacoesVeiculo) {
//            
//            //Quando a data de retirada da outra é antes da minha
//            if (outraLocacao.getDataRetirada().before(minhaLocacao.getDataRetirada()))
//            {
//                //a data de devolução da outra deve ser antes da minha retirada
//                if(outraLocacao.getDataDevolucao().before(minhaLocacao.getDataRetirada()))
//                {
//                    return true;
//                }
//            }
//            
//            //Quando a data de retirada da outra é depois da minha
//            if (outraLocacao.getDataRetirada().after(minhaLocacao.getDataRetirada()))
//            {
//                //a minha data de devolução deve ser antes da de retirada da outra
//                if(outraLocacao.getDataRetirada().after(minhaLocacao.getDataDevolucao()))
//                {
//                    return true;
//                }                        
//            }
//        }
//        if(locacoesVeiculo.isEmpty())
//        {
//            return true;
//        }
//        
//        return false;
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
