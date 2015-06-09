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
            this.comboVeiculos = new System.Windows.Forms.ComboBox();
            this.botaoAvancar = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.panelLocacoes = new System.Windows.Forms.Panel();
            this.listaLocacoes = new System.Windows.Forms.ListView();
            this.botaoVoltar = new System.Windows.Forms.Button();
            this.labelLocVeic = new System.Windows.Forms.Label();
            this.panelCarro.SuspendLayout();
            this.panelLocacoes.SuspendLayout();
            this.SuspendLayout();
            // 
            // panelCarro
            // 
            this.panelCarro.Controls.Add(this.comboVeiculos);
            this.panelCarro.Controls.Add(this.botaoAvancar);
            this.panelCarro.Controls.Add(this.label1);
            this.panelCarro.Location = new System.Drawing.Point(0, 0);
            this.panelCarro.Name = "panelCarro";
            this.panelCarro.Size = new System.Drawing.Size(643, 363);
            this.panelCarro.TabIndex = 1;
            // 
            // comboVeiculos
            // 
            this.comboVeiculos.FormattingEnabled = true;
            this.comboVeiculos.Location = new System.Drawing.Point(12, 46);
            this.comboVeiculos.Name = "comboVeiculos";
            this.comboVeiculos.Size = new System.Drawing.Size(626, 21);
            this.comboVeiculos.TabIndex = 2;
            // 
            // botaoAvancar
            // 
            this.botaoAvancar.Location = new System.Drawing.Point(563, 8);
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
            this.panelLocacoes.Controls.Add(this.labelLocVeic);
            this.panelLocacoes.Location = new System.Drawing.Point(0, 0);
            this.panelLocacoes.Name = "panelLocacoes";
            this.panelLocacoes.Size = new System.Drawing.Size(646, 363);
            this.panelLocacoes.TabIndex = 3;
            // 
            // listaLocacoes
            // 
            this.listaLocacoes.GridLines = true;
            this.listaLocacoes.Location = new System.Drawing.Point(12, 46);
            this.listaLocacoes.Name = "listaLocacoes";
            this.listaLocacoes.Size = new System.Drawing.Size(626, 305);
            this.listaLocacoes.TabIndex = 2;
            this.listaLocacoes.UseCompatibleStateImageBehavior = false;
            this.listaLocacoes.View = System.Windows.Forms.View.List;
            // 
            // botaoVoltar
            // 
            this.botaoVoltar.Location = new System.Drawing.Point(563, 8);
            this.botaoVoltar.Name = "botaoVoltar";
            this.botaoVoltar.Size = new System.Drawing.Size(75, 23);
            this.botaoVoltar.TabIndex = 1;
            this.botaoVoltar.Text = "<< Voltar";
            this.botaoVoltar.UseVisualStyleBackColor = true;
            this.botaoVoltar.Click += new System.EventHandler(this.botaoVoltar_Click);
            // 
            // labelLocVeic
            // 
            this.labelLocVeic.AutoSize = true;
            this.labelLocVeic.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelLocVeic.Location = new System.Drawing.Point(8, 8);
            this.labelLocVeic.Name = "labelLocVeic";
            this.labelLocVeic.Size = new System.Drawing.Size(216, 20);
            this.labelLocVeic.TabIndex = 0;
            this.labelLocVeic.Text = "Locações para o Veículo: ";
            // 
            // JanelaRelatorioLocacoes
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(645, 363);
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
        private System.Windows.Forms.Button botaoAvancar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panelLocacoes;
        private System.Windows.Forms.Button botaoVoltar;
        private System.Windows.Forms.Label labelLocVeic;
        private System.Windows.Forms.ListView listaLocacoes;
        private System.Windows.Forms.ComboBox comboVeiculos;
    }
}