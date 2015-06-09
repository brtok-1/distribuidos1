using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteWebService
{
    public partial class JanelaLocarVeiculo : Form
    {
        private List<Veiculo> veiculos;
        private Veiculo selecionado;

        public JanelaLocarVeiculo()
        {
            InitializeComponent();
            WebServiceCliente wsc = new WebServiceCliente();
            veiculos = wsc.RecuperarVeiculos();
            if (veiculos.Count != 0)
            {
                foreach (Veiculo v in veiculos)
                {
                    comboVeiculos.Items.Add(v);
                }
            }
        }

        private void botaoAvancar_Click(object sender, EventArgs e)
        {
            if (comboVeiculos.SelectedItem == null)
            {
                MessageBox.Show("Selecione um carro", "Cliente", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
            else
            {
                selecionado = (Veiculo) comboVeiculos.SelectedItem;
                dadosCarro.Text = selecionado.getIdVeiculo() + " - " + selecionado.getFabricante() + " - "
                        + selecionado.getModelo() + " - " + selecionado.getAno() + " - " + selecionado.getPlaca();
                panelCarro.Visible = false;
                panelDados.Visible = true;
            }
        }

        private void botaoVoltar_Click(object sender, EventArgs e)
        {
            panelDados.Visible = false;
            panelCarro.Visible = true;
        }

        private void botaoConfirmar_Click(object sender, EventArgs e)
        {
            Locacao loc = new Locacao();
            DateTime retirada = dateDataRetirada.Value.Date;
            int retiradaHora = dateHoraRetirada.Value.Hour;
            int retiradaMinuto = dateHoraRetirada.Value.Minute;
            TimeSpan tsRetirada = new TimeSpan(retiradaHora, retiradaMinuto, 0);
            retirada = retirada.Date + tsRetirada;
            DateTime devolucao = dateDataDevolucao.Value.Date;
            int devolucaoHora = dateHoraDevolucao.Value.Hour;
            int devolucaoMinuto = dateHoraDevolucao.Value.Minute;
            TimeSpan tsDevolucao = new TimeSpan(devolucaoHora, devolucaoMinuto, 0);
            devolucao = devolucao.Date + tsDevolucao;
            loc.setDataHoraRetirada(retirada);
            loc.setDataHoraDevolucao(devolucao);
            loc.setIdadeCondutor(Convert.ToInt32(spinnerIdadeCondutor.Text));
            loc.setLocalDevolucao(boxLocalDevolucao.Text);
            loc.setLocalRetirada(boxLocalRetirada.Text);
            loc.setNomeCondutor(boxNomeMotorista.Text);
            loc.setNumeroCartao(boxNumeroCartao.Text);
            loc.setParcelasCartao(Convert.ToInt32(spinnerNumeroParcelas.Text));
            loc.setIdVeiculoReferencia(selecionado.getIdVeiculo());
            int comparacao = devolucao.CompareTo(retirada);
            if (comparacao <= 0)
            {
                MessageBox.Show("A devolução está sendo agendada para antes da data de retirada.", "Incorreto!", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                DateTime hoje = DateTime.Today;
                comparacao = hoje.CompareTo(retirada);
                if (comparacao >= 1)
                {
                    MessageBox.Show("A retirada está sendo marcada para antes de agora.", "Incorreto!", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                {
                    WebServiceCliente wsc = new WebServiceCliente();
                    int sucesso = wsc.EfetuarLocacao(loc);
                    if (sucesso == 1)
                    {
                        MessageBox.Show("Locação efetuada com sucesso.", "Finalizado!", MessageBoxButtons.OK, MessageBoxIcon.Information);
                        this.Dispose();
                    }
                    else
                    {
                        MessageBox.Show("Locação não realizada. Na data e horário solicitados já há uma reserva.", "Tente novamete", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    }
                }
            }
        }
    }
}
