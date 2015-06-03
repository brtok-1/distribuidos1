using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClienteWebService
{
    class Veiculo
    {

        private int idVeiculo;
        private int ano;
        private double valorDiaria;
        private String fabricante;
        private String modelo;
        private String placa;


        public int getIdVeiculo()
        {
            return idVeiculo;
        }

        public void setIdVeiculo(int idVeiculo)
        {
            this.idVeiculo = idVeiculo;
        }

        public String getFabricante()
        {
            return fabricante;
        }

        public void setFabricante(String fabricante)
        {
            this.fabricante = fabricante;
        }

        public String getModelo()
        {
            return modelo;
        }

        public void setModelo(String modelo)
        {
            this.modelo = modelo;
        }

        public String getPlaca()
        {
            return placa;
        }

        public void setPlaca(String placa)
        {
            this.placa = placa;
        }

        public int getAno()
        {
            return ano;
        }

        public void setAno(int ano)
        {
            this.ano = ano;
        }

        public double getValorDiaria()
        {
            return valorDiaria;
        }

        public void setValorDiaria(double valorDiaria)
        {
            this.valorDiaria = valorDiaria;
        }

        public String getValorDiariaString()
        {
            String valor = valorDiaria.ToString().Replace(".", ",");
            return valor;
        }

        public void setValorDiariaString(String valor)
        {
            valor = valor.Trim().Replace(",", ".");
            this.valorDiaria = Double.Parse(valor);
        }
    }
}
