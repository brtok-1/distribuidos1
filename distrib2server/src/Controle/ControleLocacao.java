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
 * Classe que faz o controle das Locações para inserir e verificar em arquivo novas e antigas locações
 * 
 * @author Bruno Tokarski e Rafael Vidal
 */
public class ControleLocacao {

    private static ControleLocacao instancia;
    private ArrayList<Locacao> locacoes = new ArrayList<>();
    private boolean sistemaDisponivel = true;
    
    /**
     * Método que após recuperar todas as locações, filtra apenas aquelas que o Veículo do parâmetro se faz presente
     * 
     * @param idVeiculo Identificação do Veiculo a qual se desejam as locações
     * @return ArrayList de Locacoes filtrados pela identificação do Veiculo fornecida
     * @throws Exception 
     */
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

    /**
     * Método que verifica se a disponibilidade do horário para a locação de parâmetro
     * 
     * @param minhaLocacao Locacao que vai ser feita e que pretende-se validar
     * @return disponivel Retorna um boolean que responde se a locação para aquele momento está disponível
     * @throws Exception 
     */
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

    /**
     * Classe que recebe a locação para salvá-la, realizando essa operação após realizar as suas verificações
     * 
     * @param locacao Locacao que se deseja fazer
     * @return sucesso Retorna um boolean que indica o sucesso da operação
     * @throws Exception 
     */
    public boolean addLocacao(Locacao locacao) throws Exception {
        ControleLocacao controle = ControleLocacao.getInstancia();
        while (true) {
            if (controle.sistemaDisponivel) {
                //Locka o sistema
                controle.setSistemaDisponivel(false);
                System.out.println("Sistema disponível");
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

    /**
     * Salva a locação de parâmetro em arquivo
     * 
     * @param locacao Locacao que se deseja gravar em arquivo
     * @throws Exception 
     */
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

    /**
     * Lê o arquivo de Locações para ser processado
     * 
     * @return ArrayList com todas as Locações
     * @throws Exception 
     */
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

    /**
     * Método retorna uma instância Estática de ControleLocacao, no caso de primeira execução, declara uma nova
     * 
     * @return Instância Estática de ControleLocacao
     */
    public static ControleLocacao getInstancia() {
        if (instancia == null) {
            instancia = new ControleLocacao();
        }
        return instancia;
    }

    /**
     * Método que verifica de o Sistema está marca como disponível ou não
     * 
     * @return disponivel Retorna se o sistema está disponível para mais acessos ou não
     */
    public boolean isSistemaDisponivel() {
        return sistemaDisponivel;
    }

    /**
     * Método que muda a disponibilidade do sistema de acordo com o parâmetro recebido
     * 
     * @param sistemaDisponivel Parâmetro que vai tornar o sistema disponível ou indisponível
     */
    public void setSistemaDisponivel(boolean sistemaDisponivel) {
        this.sistemaDisponivel = sistemaDisponivel;
    }
}
