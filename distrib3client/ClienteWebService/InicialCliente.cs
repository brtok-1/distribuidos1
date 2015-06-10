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
    /// <summary>
    /// Código com as operações da Janela exibida inicialmente e permanentemente para o usuário
    /// </summary>
    public partial class InicialCliente : Form
    {
        /// <summary>
        /// Método de inicialização da janela.
        /// </summary>
        public InicialCliente()
        {
            InitializeComponent();
        }

        private void InicialCliente_Load(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// Método de inicialização e exibição da janela de Locação de Veículos
        /// </summary>
        private void button1_Click(object sender, EventArgs e)
        {
            JanelaLocarVeiculo jlv = new JanelaLocarVeiculo();
            jlv.ShowDialog();
        }

        /// <summary>
        /// Método de inicialização e exibição da janela de Consulta de Locações
        /// </summary>
        private void button2_Click(object sender, EventArgs e)
        {
            JanelaRelatorioLocacoes jrl = new JanelaRelatorioLocacoes();
            jrl.ShowDialog();
        }
    }
}
