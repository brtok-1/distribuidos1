/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacao;

import Interface.ComunicacaoClient;
import Interface.ComunicacaoServer;
import Modelo.Cartao;
import Modelo.Colecionador;
import Modelo.Troca;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class RMIClient extends UnicastRemoteObject implements ComunicacaoClient
{
    
    private Registry reg;
    private ComunicacaoServer obj;
    private RMIClient rmic;
    
    public RMIClient() throws Exception {
        super();
        
        Colecionador logado = Colecionador.getInstancia();
        
        reg = LocateRegistry.getRegistry("localhost", 1099);
        obj = (ComunicacaoServer) reg.lookup("servidor" + logado.getIdColecionador());
    }
    
    /**
     * Conecata-se no servidor RMI do participante
     * @param idColecionador
     * @throws Exception 
     */
    public void ConectaRMI(int idColecionador) throws Exception {
        
        reg = LocateRegistry.getRegistry("localhost", 1099);
        obj = (ComunicacaoServer) reg.lookup("servidor" + idColecionador);
        
    }

    @Override
    public void EnviaPresenca(Colecionador colecionador) {
        try
        {
            IniciaRMI();
            obj.ReceberParticipante(colecionador);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }

    @Override
    public void EnviaProposta(Troca troca, ComunicacaoClient cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Troca RespondeProposta(Troca troca, ComunicacaoClient cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cartao> SolicitaListaCartoes(int idColecionador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Início da comunicação RMI
     * @throws InterruptedException
     */
    public void IniciaRMI() throws Exception {
        rmic = new RMIClient();
    }

}
