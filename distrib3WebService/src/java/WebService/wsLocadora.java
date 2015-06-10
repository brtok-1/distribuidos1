/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Comunicacao.RMIServer;
import Controle.ControleVeiculo;
import Modelo.Locacao;
import Modelo.Veiculo;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Rafael
 */
@WebService(serviceName = "wsLocadora")
public class wsLocadora {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Operação de Web service
     *
     * @return
     */
    @WebMethod(operationName = "ListarVeiculos")
    public String ListarVeiculos() {
        String veiculosString;
        try {
            RMIServer rmis = new RMIServer();
            ArrayList<Veiculo> veiculos = rmis.ConsultarVeiculos();
            veiculosString = veiculos.size() + "~";
            if (!(veiculos.isEmpty())) {
                for (int i = 0; i < veiculos.size(); i++) {
                    veiculosString = veiculosString
                            + veiculos.get(i).getIdVeiculo() + "#"
                            + veiculos.get(i).getPlaca() + "#"
                            + veiculos.get(i).getModelo() + "#"
                            + veiculos.get(i).getFabricante() + "#"
                            + veiculos.get(i).getAno() + "#"
                            + veiculos.get(i).getValorDiariaString();
                    if (i != (veiculos.size() - 1)) {
                        veiculosString = veiculosString + "@";
                    }
                }
            }
        } catch (Exception e) {
            return "0~Ocorreu um erro e não foi possível obter a lista de veículos: "
                    + e.getMessage();
        }
        return veiculosString;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "ConsultarLocacoesVeiculo")
    public String ConsultarLocacoesVeiculo(@WebParam(name = "idVeiculo") int idVeiculo) {
        String locacoesVeiculo;
        try {
            RMIServer rmis = new RMIServer();
            ArrayList<Locacao> locacoes = rmis.RecuperarLocacoesPorVeiculo(idVeiculo);
            locacoesVeiculo = locacoes.size() + "~";
            if (!(locacoes.isEmpty())) {
                for (int i = 0; i < locacoes.size(); i++) {
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                    String dataRetirada = out.format(locacoes.get(i).getDataRetirada());
                    String dataDevolucao = out.format(locacoes.get(i).getDataDevolucao());
                    locacoesVeiculo = locacoesVeiculo
                            + locacoes.get(i).getLocalDevolucao() + "#"
                            + locacoes.get(i).getLocalRetirada() + "#"
                            + dataDevolucao + "#"
                            + dataRetirada + "#"
                            + locacoes.get(i).getHoraDevolucao() + "#"
                            + locacoes.get(i).getHoraRetirada();
                    if (i != (locacoes.size() - 1)) {
                        locacoesVeiculo = locacoesVeiculo + "@";
                    }
                }
            }
        } catch (Exception e) {
            return "0~Não foi possível consultar as locações: " + e.getMessage();
        }
        return locacoesVeiculo;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "EfetuarLocacao")
    public boolean EfetuarLocacao(@WebParam(name = "locacao") String locacao) {
        try {
            //desmonta a String para fazer a locação
            String[] locacaoDesmontada = locacao.split("#");
            int idVeiculo = Integer.parseInt(locacaoDesmontada[0]);
            int parcelasCartao = Integer.parseInt(locacaoDesmontada[1]);
            String numeroCartao = locacaoDesmontada[2];
            String nomeCondutor = locacaoDesmontada[3];
            int idadeCondutor = Integer.parseInt(locacaoDesmontada[4]);
            String localRetirada = locacaoDesmontada[5];
            String localDevolucao = locacaoDesmontada[6];
            String[] dataHoraRetirada = locacaoDesmontada[7].split(" ");
            String[] dataHoraDevolucao = locacaoDesmontada[8].split(" ");
            DateFormat formatterData = new SimpleDateFormat("dd/MM/yyyy");
            Date dataRetirada = (Date) formatterData.parse(dataHoraRetirada[0]);
            dataRetirada.setHours(23);
            dataRetirada.setMinutes(59);
            Date dataDevolucao = (Date) formatterData.parse(dataHoraDevolucao[0]);
            Time horaRetirada = Time.valueOf(dataHoraRetirada[1]);
            Time horaDevolucao = Time.valueOf(dataHoraDevolucao[1]);
            
            //recupera o veiculo da locacao para salvar
            //(pois o parametro recebido do C# é somente o id e não um objeto)
            ControleVeiculo cv = new ControleVeiculo();
            Veiculo v = cv.RecuperarVeiculoPorID(idVeiculo);
            
            //Constrói um nova locacao
            Locacao loc = new Locacao();
            loc.setVeiculo(v);
            loc.setDataDevolucao(dataDevolucao);
            loc.setDataRetirada(dataRetirada);
            loc.setHoraDevolucao(horaDevolucao);
            loc.setHoraRetirada(horaRetirada);
            loc.setIdadeCondutor(idadeCondutor);
            loc.setLocalDevolucao(localDevolucao);
            loc.setLocalRetirada(localRetirada);
            loc.setNomeCondutor(nomeCondutor);
            loc.setNumeroCartao(numeroCartao);
            loc.setParcelasCartao(parcelasCartao);
            
            //tenta fazer a locacao através do mecanismo padrão e devolve a resposta
            RMIServer rmis = new RMIServer();
            boolean sucesso = rmis.EfetuarLocacao(loc);
            return sucesso;
        } catch (Exception e) {
            System.out.println("Falhou: " + e.getMessage());
            return false;
        }
    }

}
