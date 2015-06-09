using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClienteWebService
{
    class Locacao
    {
        private String localRetirada;
        private String localDevolucao;
        private DateTime dataHoraRetirada;
        private DateTime dataHoraDevolucao;
        private String nomeCondutor;
        private int idadeCondutor;
        private String numeroCartao;
        private int parcelasCartao;
        private int idVeiculoReferencia;

        public String getLocalRetirada()
        {
            return localRetirada;
        }

        public void setLocalRetirada(String localRetirada)
        {
            this.localRetirada = localRetirada;
        }

        public String getLocalDevolucao()
        {
            return localDevolucao;
        }

        public void setLocalDevolucao(String localDevolucao)
        {
            this.localDevolucao = localDevolucao;
        }

        public String getNomeCondutor()
        {
            return nomeCondutor;
        }

        public void setNomeCondutor(String nomeCondutor)
        {
            this.nomeCondutor = nomeCondutor;
        }

        public int getIdadeCondutor()
        {
            return idadeCondutor;
        }

        public void setIdadeCondutor(int idadeCondutor)
        {
            this.idadeCondutor = idadeCondutor;
        }

        public String getNumeroCartao()
        {
            return numeroCartao;
        }

        public void setNumeroCartao(String numeroCartao)
        {
            this.numeroCartao = numeroCartao;
        }

        public int getParcelasCartao()
        {
            return parcelasCartao;
        }

        public void setParcelasCartao(int parcelasCartao)
        {
            this.parcelasCartao = parcelasCartao;
        }

        public int getIdVeiculoReferencia()
        {
            return idVeiculoReferencia;
        }

        public void setIdVeiculoReferencia(int idVeiculoReferencia)
        {
            this.idVeiculoReferencia = idVeiculoReferencia;
        }

        public DateTime getDataHoraRetirada()
        {
            return dataHoraRetirada;
        }

        public void setDataHoraRetirada(DateTime dataHoraRetirada)
        {
            this.dataHoraRetirada = dataHoraRetirada;
        }
        
        public DateTime getDataHoraDevolucao()
        {
            return dataHoraDevolucao;
        }

        public void setDataHoraDevolucao(DateTime dataHoraDevolucao)
        {
            this.dataHoraDevolucao = dataHoraDevolucao;
        }
        
    }
}
