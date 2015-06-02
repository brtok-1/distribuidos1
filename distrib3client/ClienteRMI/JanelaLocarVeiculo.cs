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
    public partial class JanelaLocarVeiculo : Form
    {
        public JanelaLocarVeiculo()
        {
            InitializeComponent();
        }

        private void botaoAvancar_Click(object sender, EventArgs e)
        {
            panelCarro.Visible = false;
            panelDados.Visible = true;
        }

        private void botaoVoltar_Click(object sender, EventArgs e)
        {
            panelDados.Visible = false;
            panelCarro.Visible = true;
        }
        
    }
}
