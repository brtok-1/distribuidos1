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
    public partial class JanelaRelatorioLocacoes : Form
    {
        public JanelaRelatorioLocacoes()
        {
            InitializeComponent();
            panelLocacoes.Visible = false;
            /*
            RMICliente rmic = new RMICliente();
            veiculos = rmic.RecuperarVeiculos();
            tabelaVeiculos = new Object[veiculos.size()][6];
            for (int i = 0; i < veiculos.size(); i++)
            {
                tabelaVeiculos[i][0] = veiculos.get(i).getIdVeiculo();
                tabelaVeiculos[i][1] = veiculos.get(i).getPlaca();
                tabelaVeiculos[i][2] = veiculos.get(i).getFabricante();
                tabelaVeiculos[i][3] = veiculos.get(i).getModelo();
                tabelaVeiculos[i][4] = veiculos.get(i).getAno();
                tabelaVeiculos[i][5] = veiculos.get(i).getValorDiariaString();
            }
            fazTabela1(tabelaVeiculos);
            */
        }

        private void botaoAvancar_Click(object sender, EventArgs e)
        {
            /*
                        DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                        int linha = jTable1.getSelectedRow();
                        if (linha < 0)
                        {
                            JOptionPane.showMessageDialog(null, "É necessário selecionar um veículo, clicando na sua linha");
                        }
                        else
                        {
                            int codigo = (int)dtm.getValueAt(linha, 0);
                            for (Veiculo v : veiculos)
                            {
                                if (v.getIdVeiculo() == codigo)
                                {
                                    selecionado = v;
                                }
                            }
                            jLabel13.setText("Relatório de Locações para o Veículo" + selecionado.getIdVeiculo() + "-" + selecionado.getModelo());
                            RMICliente rmic = new RMICliente();
                            ArrayList<Locacao> locacoes = rmic.RecuperarLocacoesPorVeiculo(selecionado.getIdVeiculo());
                            Object[][] tabelaLocacao = new Object[locacoes.size()][4];
                            for (int i = 0; i < locacoes.size(); i++)
                            {

                                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

                                String dataRetirada = out.format(locacoes.get(i).getDataRetirada());
                                String horaRetirada = locacoes.get(i).getHoraRetirada().toString();

                                String dataDevolucao = out.format(locacoes.get(i).getDataDevolucao());
                                String horaDevolucao = locacoes.get(i).getHoraRetirada().toString();

                                tabelaLocacao[i][0] = dataRetirada + " " + horaRetirada;
                                tabelaLocacao[i][1] = dataDevolucao + " " + horaDevolucao;
                                tabelaLocacao[i][2] = locacoes.get(i).getLocalRetirada();
                                tabelaLocacao[i][3] = locacoes.get(i).getLocalDevolucao();
                            }
                            fazTabela2(tabelaLocacao);
                        }
            */
            panelCarro.Visible = false;
            panelLocacoes.Visible = true;
        }

        private void botaoVoltar_Click(object sender, EventArgs e)
        {
            panelLocacoes.Visible = false;
            panelCarro.Visible = true;
        }
    }
}
