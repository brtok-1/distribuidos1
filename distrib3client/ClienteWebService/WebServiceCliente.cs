using ClienteWebService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ClienteWebService.WebServiceReferencia;

namespace ClienteWebService
{
    class WebServiceCliente
    {
        public List<Veiculo> RecuperarVeiculos()
        {
            WebServiceReferencia.wsLocadoraClient proxy = new WebServiceReferencia.wsLocadoraClient();
            String resultado = proxy.ListarVeiculos().ToString();
            String[] mensagem = resultado.Split('~');
            int tamanhoArray = Convert.ToInt32(mensagem[0]);
            List<Veiculo> veiculos = new List<Veiculo>();
            if (tamanhoArray > 0)
            {
                String[] veiculosString = mensagem[1].Split('@');
                foreach (String s in veiculosString)
                {
                    String[] dadosVeiculo = s.Split('#');
                    Veiculo v = new Veiculo();
                    v.setIdVeiculo(Convert.ToInt32(dadosVeiculo[0]));
                    v.setPlaca(dadosVeiculo[1]);
                    v.setModelo(dadosVeiculo[2]);
                    v.setFabricante(dadosVeiculo[3]);
                    v.setAno(Convert.ToInt32(dadosVeiculo[4]));
                    v.setValorDiariaString(dadosVeiculo[5]);
                    veiculos.Add(v);
                }
            }
            return veiculos;
        }

        public List<Locacao> RecuperarLocacoesPorVeiculo(int idVeiculo)
        {
            WebServiceReferencia.wsLocadoraClient proxy = new WebServiceReferencia.wsLocadoraClient();
            String resultado = proxy.ConsultarLocacoesVeiculo(idVeiculo).ToString();
            String[] mensagem = resultado.Split('~');
            int tamanhoArray = Convert.ToInt32(mensagem[0]);
            List<Locacao> locacoes = new List<Locacao>();
            if (tamanhoArray > 0)
            {
                String[] locacoesString = mensagem[1].Split('@');
                foreach (String s in locacoesString)
                {
                    String[] dadosLocacao = s.Split('#');
                    Locacao l = new Locacao();
                    l.setLocalDevolucao(dadosLocacao[0]);
                    l.setLocalRetirada(dadosLocacao[1]);
                    DateTime dtDevolucao = Convert.ToDateTime(dadosLocacao[2]);
                    DateTime dtRetirada = Convert.ToDateTime(dadosLocacao[3]);
                    String horaDevolucao = dadosLocacao[4];
                    String horaRetirada = dadosLocacao[5];
                    String[] devolucaoQuebrado = horaDevolucao.Split(':');
                    String[] retiradaQuebrado = horaRetirada.Split(':');
                    TimeSpan tsDevolucao = new TimeSpan(Convert.ToInt32(devolucaoQuebrado[0]), Convert.ToInt32(devolucaoQuebrado[1]), 0);
                    TimeSpan tsRetirada = new TimeSpan(Convert.ToInt32(retiradaQuebrado[0]), Convert.ToInt32(retiradaQuebrado[1]), 0);
                    dtDevolucao = dtDevolucao.Date + tsDevolucao;
                    dtRetirada = dtRetirada.Date + tsRetirada;
                    l.setDataHoraDevolucao(dtDevolucao);
                    l.setDataHoraRetirada(dtRetirada);
                    locacoes.Add(l);
                }
            }
            return locacoes;
        }

        public bool EfetuarLocacao(Locacao loc)
        {
            String locacao = loc.getIdVeiculoReferencia() + "#"
                + loc.getParcelasCartao() + "#"
                + loc.getNumeroCartao() + "#"
                + loc.getNomeCondutor() + "#"
                + loc.getIdadeCondutor() + "#"
                + loc.getLocalRetirada() + "#"
                + loc.getLocalDevolucao() + "#"
                + loc.getDataHoraRetirada() + "#"
                + loc.getDataHoraDevolucao();
            WebServiceReferencia.wsLocadoraClient proxy = new WebServiceReferencia.wsLocadoraClient();
            bool sucesso = Convert.ToBoolean(proxy.EfetuarLocacao(locacao));
            return sucesso;
        }
    }
}
