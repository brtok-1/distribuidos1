namespace ClienteWebService
{
    partial class JanelaRelatorioLocacoes
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.panelCarro = new System.Windows.Forms.Panel();
            this.listaVeiculos = new System.Windows.Forms.CheckedListBox();
            this.botaoAvancar = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.panelLocacoes = new System.Windows.Forms.Panel();
            this.botaoVoltar = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.listaLocacoes = new System.Windows.Forms.ListView();
            this.panelCarro.SuspendLayout();
            this.panelLocacoes.SuspendLayout();
            this.SuspendLayout();
            // 
            // panelCarro
            // 
            this.panelCarro.Controls.Add(this.listaVeiculos);
            this.panelCarro.Controls.Add(this.botaoAvancar);
            this.panelCarro.Controls.Add(this.label1);
            this.panelCarro.Location = new System.Drawing.Point(0, 0);
            this.panelCarro.Name = "panelCarro";
            this.panelCarro.Size = new System.Drawing.Size(551, 363);
            this.panelCarro.TabIndex = 1;
            // 
            // listaVeiculos
            // 
            this.listaVeiculos.CheckOnClick = true;
            this.listaVeiculos.FormattingEnabled = true;
            this.listaVeiculos.HorizontalScrollbar = true;
            this.listaVeiculos.Location = new System.Drawing.Point(12, 46);
            this.listaVeiculos.Name = "listaVeiculos";
            this.listaVeiculos.Size = new System.Drawing.Size(527, 304);
            this.listaVeiculos.TabIndex = 2;
            // 
            // botaoAvancar
            // 
            this.botaoAvancar.Location = new System.Drawing.Point(464, 9);
            this.botaoAvancar.Name = "botaoAvancar";
            this.botaoAvancar.Size = new System.Drawing.Size(75, 23);
            this.botaoAvancar.TabIndex = 1;
            this.botaoAvancar.Text = "Avançar >>";
            this.botaoAvancar.UseVisualStyleBackColor = true;
            this.botaoAvancar.Click += new System.EventHandler(this.botaoAvancar_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(8, 8);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(279, 20);
            this.label1.TabIndex = 0;
            this.label1.Text = "Selecione um Veículo Cadastrado";
            // 
            // panelLocacoes
            // 
            this.panelLocacoes.Controls.Add(this.listaLocacoes);
            this.panelLocacoes.Controls.Add(this.botaoVoltar);
            this.panelLocacoes.Controls.Add(this.label2);
            this.panelLocacoes.Location = new System.Drawing.Point(0, 0);
            this.panelLocacoes.Name = "panelLocacoes";
            this.panelLocacoes.Size = new System.Drawing.Size(551, 363);
            this.panelLocacoes.TabIndex = 3;
            // 
            // botaoVoltar
            // 
            this.botaoVoltar.Location = new System.Drawing.Point(464, 9);
            this.botaoVoltar.Name = "botaoVoltar";
            this.botaoVoltar.Size = new System.Drawing.Size(75, 23);
            this.botaoVoltar.TabIndex = 1;
            this.botaoVoltar.Text = "<< Voltar";
            this.botaoVoltar.UseVisualStyleBackColor = true;
            this.botaoVoltar.Click += new System.EventHandler(this.botaoVoltar_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(8, 8);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(279, 20);
            this.label2.TabIndex = 0;
            this.label2.Text = "Selecione um Veículo Cadastrado";
            // 
            // listaLocacoes
            // 
            this.listaLocacoes.Location = new System.Drawing.Point(12, 46);
            this.listaLocacoes.Name = "listaLocacoes";
            this.listaLocacoes.Size = new System.Drawing.Size(526, 305);
            this.listaLocacoes.TabIndex = 2;
            this.listaLocacoes.UseCompatibleStateImageBehavior = false;
            // 
            // JanelaRelatorioLocacoes
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(550, 363);
            this.Controls.Add(this.panelCarro);
            this.Controls.Add(this.panelLocacoes);
            this.MaximizeBox = false;
            this.Name = "JanelaRelatorioLocacoes";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Relatório de Locacoes";
            this.panelCarro.ResumeLayout(false);
            this.panelCarro.PerformLayout();
            this.panelLocacoes.ResumeLayout(false);
            this.panelLocacoes.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panelCarro;
        private System.Windows.Forms.CheckedListBox listaVeiculos;
        private System.Windows.Forms.Button botaoAvancar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panelLocacoes;
        private System.Windows.Forms.Button botaoVoltar;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ListView listaLocacoes;
    }
}