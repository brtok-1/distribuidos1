using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteRMI
{
    public partial class InicialCliente : Form
    {
        public InicialCliente()
        {
            InitializeComponent();
        }

        private void InicialCliente_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            JanelaLocarVeiculo jlv = new JanelaLocarVeiculo();
            jlv.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            JanelaRelatorioLocacoes jrl = new JanelaRelatorioLocacoes();
            jrl.ShowDialog();
        }
    }
}
