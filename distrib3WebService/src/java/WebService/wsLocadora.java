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
     * @return 
     */
    @WebMethod(operationName = "ListarVeiculos")
    public String ListarVeiculos() {
        
        String veiculosString = "";
        try
        {
            RMIServer rmis = new RMIServer();
            
            ArrayList<Veiculo> veiculos = rmis.ConsultarVeiculos();
            
            for (Veiculo v : veiculos)
            {
                veiculosString = veiculosString + 
                        v.getIdVeiculo() + "#" +
                        v.getPlaca() + "#" +
                        v.getModelo() + "#" +
                        v.getFabricante() + "#" +
                        v.getAno() + "#" +
                        v.getValorDiariaString() + "@";
                        
            }
            
        } catch (Exception e)
        {
            return "Ocorreu um erro e não foi possível obter a lista de veículos: " 
                    + e.getMessage();
        }       
        
        return veiculosString;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "ConsultarLocacoesVeiculo")
    public String ConsultarLocacoesVeiculo(@WebParam(name = "idVeiculo") int idVeiculo) {
        
        String locacoesVeiculo = "";
        
        try
        {
            RMIServer rmis = new RMIServer();
            
            ArrayList<Locacao> locacoes = rmis.RecuperarLocacoesPorVeiculo(idVeiculo);
            
            for(Locacao l : locacoes)
            {
                locacoesVeiculo = locacoesVeiculo +
                        l.getLocalDevolucao() + "#" +
                        l.getLocalRetirada() + "#" +
                        l.getNomeCondutor() + "#" +
                        l.getNumeroCartao() + "#" +
                        l.getDataDevolucao() + "#" +
                        l.getDataRetirada() + "#" +
                        l.getHoraDevolucao() + "#" +
                        l.getHoraRetirada() + "#" +
                        l.getIdadeCondutor() + "#" +
                        l.getParcelasCartao() + "#" +
                        l.getVeiculo().getIdVeiculo() + "@";
            }
            
        }catch(Exception e)
        {
            return "Não foi possível consultar as locações: " + e.getMessage();
        }
        
        return locacoesVeiculo;
        
    }
}
