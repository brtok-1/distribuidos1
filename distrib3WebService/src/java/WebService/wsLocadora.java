/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Comunicacao.RMIServer;
import Modelo.Locacao;
import Modelo.Veiculo;
import java.util.ArrayList;
import java.util.Calendar;
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
                            + veiculos.get(i).getValorDiariaString() + "@";
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
                    locacoesVeiculo = locacoesVeiculo
                            + locacoes.get(i).getLocalDevolucao() + "#"
                            + locacoes.get(i).getLocalRetirada() + "#"
                            + locacoes.get(i).getDataDevolucao() + "#"
                            + locacoes.get(i).getDataRetirada() + "#"
                            + locacoes.get(i).getHoraDevolucao() + "#"
                            + locacoes.get(i).getHoraRetirada() + "#";
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
}
