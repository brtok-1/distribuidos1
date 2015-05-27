/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Locacao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Thread.sleep;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class ControleLocacao {

    private static ControleLocacao instancia;

    private ArrayList<Locacao> locacoes = new ArrayList<>();
    private boolean sistemaDisponivel = true;

    public ArrayList<Locacao> getLocacoesPorVeiculo(int idVeiculo) throws Exception {
        ArrayList<Locacao> resultado = new ArrayList<>();
        locacoes = RecuperarLocacoes();
        for (Locacao l : locacoes) {
            if (l.getVeiculo().getIdVeiculo() == idVeiculo) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    public boolean verificaDisponibilidade(Locacao minhaLocacao) throws Exception {
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
    }

    public boolean addLocacao(Locacao locacao) throws Exception {

        ControleLocacao controle = ControleLocacao.getInstancia();

        while (true) {
            if (controle.sistemaDisponivel) {
                System.out.println("Sistema disponível");
                //Locka o sistema
                controle.setSistemaDisponivel(false);
                boolean disponivel = verificaDisponibilidade(locacao);
                if (disponivel) {
                    SalvaLocacao(locacao);
                }
                //Deslocka o sistema
                controle.setSistemaDisponivel(true);
                
                return disponivel;
            }
            System.out.println("Sistema indisponível. Agurandando.");
            sleep(500);
        }        
    }

    public ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(ArrayList<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public void SalvaLocacao(Locacao locacao) throws Exception {
        File arquivo = new File("C:/Distrib2/Locacao.dst");
        if (arquivo.exists()) {
            locacoes = RecuperarLocacoes();
        } else {
            locacoes = new ArrayList<>();
        }
        locacoes.add(locacao);

        //Deleta o arquivo
        arquivo.delete();

        //Cria um arquivo novo para salvar o array atualizado
        FileOutputStream arquivoGrav = new FileOutputStream(arquivo);
        ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
        objGravar.writeObject(locacoes);
    }

    public ArrayList<Locacao> RecuperarLocacoes() throws Exception {
        File arquivo = new File("C:/Distrib2/Locacao.dst");
        if (arquivo.exists()) {
            FileInputStream arquivoLeitura = new FileInputStream("C:/Distrib2/Locacao.dst");
            if (arquivoLeitura.available() != 0) {
                ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
                locacoes = (ArrayList<Locacao>) objLeitura.readObject();
            }
        }
        return locacoes;
    }

    public static ControleLocacao getInstancia() {
        if (instancia == null) {
            instancia = new ControleLocacao();
        }

        return instancia;
    }

    public void setInstancia(ControleLocacao instancia) {
        this.instancia = instancia;
    }

    public boolean isSistemaDisponivel() {
        return sistemaDisponivel;
    }

    public void setSistemaDisponivel(boolean sistemaDisponivel) {
        this.sistemaDisponivel = sistemaDisponivel;
    }
}
