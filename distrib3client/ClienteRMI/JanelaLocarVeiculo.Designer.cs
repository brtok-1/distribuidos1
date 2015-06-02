namespace ClienteRMI
{
    partial class JanelaLocarVeiculo
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
            this.panelDados = new System.Windows.Forms.Panel();
            this.label3 = new System.Windows.Forms.Label();
            this.spinnerNumeroParcelas = new System.Windows.Forms.DomainUpDown();
            this.dateHoraDevolucao = new System.Windows.Forms.DateTimePicker();
            this.dateDataDevolucao = new System.Windows.Forms.DateTimePicker();
            this.dateHoraRetirada = new System.Windows.Forms.DateTimePicker();
            this.dateDataRetirada = new System.Windows.Forms.DateTimePicker();
            this.textBox9 = new System.Windows.Forms.TextBox();
            this.nomeMotorista = new System.Windows.Forms.TextBox();
            this.boxLocalDevolucao = new System.Windows.Forms.TextBox();
            this.boxLocalRetirada = new System.Windows.Forms.TextBox();
            this.botaoConfirmar = new System.Windows.Forms.Button();
            this.botaoVoltar = new System.Windows.Forms.Button();
            this.dadosCarro = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.spinnerIdadeCondutor = new System.Windows.Forms.DomainUpDown();
            this.panelCarro.SuspendLayout();
            this.panelDados.SuspendLayout();
            this.SuspendLayout();
            // 
            // panelCarro
            // 
            this.panelCarro.Controls.Add(this.listaVeiculos);
            this.panelCarro.Controls.Add(this.botaoAvancar);
            this.panelCarro.Controls.Add(this.label1);
            this.panelCarro.Location = new System.Drawing.Point(3, 3);
            this.panelCarro.Name = "panelCarro";
            this.panelCarro.Size = new System.Drawing.Size(551, 363);
            this.panelCarro.TabIndex = 0;
            // 
            // listaVeiculos
            // 
            this.listaVeiculos.CheckOnClick = true;
            this.listaVeiculos.FormattingEnabled = true;
            this.listaVeiculos.HorizontalScrollbar = true;
            this.listaVeiculos.Items.AddRange(new object[] {
            "Chua",
            "Locura",
            "Oi",
            "Tchau"});
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
            // panelDados
            // 
            this.panelDados.Controls.Add(this.label12);
            this.panelDados.Controls.Add(this.spinnerIdadeCondutor);
            this.panelDados.Controls.Add(this.label11);
            this.panelDados.Controls.Add(this.label10);
            this.panelDados.Controls.Add(this.label9);
            this.panelDados.Controls.Add(this.label8);
            this.panelDados.Controls.Add(this.label7);
            this.panelDados.Controls.Add(this.label6);
            this.panelDados.Controls.Add(this.label5);
            this.panelDados.Controls.Add(this.label4);
            this.panelDados.Controls.Add(this.label3);
            this.panelDados.Controls.Add(this.spinnerNumeroParcelas);
            this.panelDados.Controls.Add(this.dateHoraDevolucao);
            this.panelDados.Controls.Add(this.dateDataDevolucao);
            this.panelDados.Controls.Add(this.dateHoraRetirada);
            this.panelDados.Controls.Add(this.dateDataRetirada);
            this.panelDados.Controls.Add(this.textBox9);
            this.panelDados.Controls.Add(this.nomeMotorista);
            this.panelDados.Controls.Add(this.boxLocalDevolucao);
            this.panelDados.Controls.Add(this.boxLocalRetirada);
            this.panelDados.Controls.Add(this.botaoConfirmar);
            this.panelDados.Controls.Add(this.botaoVoltar);
            this.panelDados.Controls.Add(this.dadosCarro);
            this.panelDados.Controls.Add(this.label2);
            this.panelDados.Location = new System.Drawing.Point(3, 3);
            this.panelDados.Name = "panelDados";
            this.panelDados.Size = new System.Drawing.Size(548, 360);
            this.panelDados.TabIndex = 1;
            this.panelDados.Visible = false;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(28, 66);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(149, 13);
            this.label3.TabIndex = 18;
            this.label3.Text = "Local de Retirada do Veículo:";
            // 
            // spinnerNumeroParcelas
            // 
            this.spinnerNumeroParcelas.Items.Add("12");
            this.spinnerNumeroParcelas.Items.Add("11");
            this.spinnerNumeroParcelas.Items.Add("10");
            this.spinnerNumeroParcelas.Items.Add("9");
            this.spinnerNumeroParcelas.Items.Add("8");
            this.spinnerNumeroParcelas.Items.Add("7");
            this.spinnerNumeroParcelas.Items.Add("6");
            this.spinnerNumeroParcelas.Items.Add("5");
            this.spinnerNumeroParcelas.Items.Add("4");
            this.spinnerNumeroParcelas.Items.Add("3");
            this.spinnerNumeroParcelas.Items.Add("2");
            this.spinnerNumeroParcelas.Items.Add("1");
            this.spinnerNumeroParcelas.Location = new System.Drawing.Point(466, 246);
            this.spinnerNumeroParcelas.Name = "spinnerNumeroParcelas";
            this.spinnerNumeroParcelas.Size = new System.Drawing.Size(62, 20);
            this.spinnerNumeroParcelas.TabIndex = 17;
            this.spinnerNumeroParcelas.Text = "1";
            // 
            // dateHoraDevolucao
            // 
            this.dateHoraDevolucao.Checked = false;
            this.dateHoraDevolucao.Format = System.Windows.Forms.DateTimePickerFormat.Time;
            this.dateHoraDevolucao.Location = new System.Drawing.Point(179, 193);
            this.dateHoraDevolucao.Name = "dateHoraDevolucao";
            this.dateHoraDevolucao.ShowUpDown = true;
            this.dateHoraDevolucao.Size = new System.Drawing.Size(349, 20);
            this.dateHoraDevolucao.TabIndex = 16;
            // 
            // dateDataDevolucao
            // 
            this.dateDataDevolucao.Checked = false;
            this.dateDataDevolucao.Location = new System.Drawing.Point(179, 167);
            this.dateDataDevolucao.Name = "dateDataDevolucao";
            this.dateDataDevolucao.Size = new System.Drawing.Size(349, 20);
            this.dateDataDevolucao.TabIndex = 15;
            // 
            // dateHoraRetirada
            // 
            this.dateHoraRetirada.Checked = false;
            this.dateHoraRetirada.Format = System.Windows.Forms.DateTimePickerFormat.Time;
            this.dateHoraRetirada.Location = new System.Drawing.Point(179, 118);
            this.dateHoraRetirada.Name = "dateHoraRetirada";
            this.dateHoraRetirada.ShowUpDown = true;
            this.dateHoraRetirada.Size = new System.Drawing.Size(349, 20);
            this.dateHoraRetirada.TabIndex = 14;
            // 
            // dateDataRetirada
            // 
            this.dateDataRetirada.Checked = false;
            this.dateDataRetirada.Location = new System.Drawing.Point(179, 92);
            this.dateDataRetirada.Name = "dateDataRetirada";
            this.dateDataRetirada.Size = new System.Drawing.Size(349, 20);
            this.dateDataRetirada.TabIndex = 13;
            // 
            // textBox9
            // 
            this.textBox9.Location = new System.Drawing.Point(179, 272);
            this.textBox9.Name = "textBox9";
            this.textBox9.Size = new System.Drawing.Size(349, 20);
            this.textBox9.TabIndex = 12;
            // 
            // nomeMotorista
            // 
            this.nomeMotorista.Location = new System.Drawing.Point(179, 219);
            this.nomeMotorista.Name = "nomeMotorista";
            this.nomeMotorista.Size = new System.Drawing.Size(349, 20);
            this.nomeMotorista.TabIndex = 8;
            // 
            // boxLocalDevolucao
            // 
            this.boxLocalDevolucao.Location = new System.Drawing.Point(179, 144);
            this.boxLocalDevolucao.Name = "boxLocalDevolucao";
            this.boxLocalDevolucao.Size = new System.Drawing.Size(349, 20);
            this.boxLocalDevolucao.TabIndex = 5;
            // 
            // boxLocalRetirada
            // 
            this.boxLocalRetirada.Location = new System.Drawing.Point(179, 63);
            this.boxLocalRetirada.Name = "boxLocalRetirada";
            this.boxLocalRetirada.Size = new System.Drawing.Size(349, 20);
            this.boxLocalRetirada.TabIndex = 4;
            // 
            // botaoConfirmar
            // 
            this.botaoConfirmar.Location = new System.Drawing.Point(415, 331);
            this.botaoConfirmar.Name = "botaoConfirmar";
            this.botaoConfirmar.Size = new System.Drawing.Size(113, 23);
            this.botaoConfirmar.TabIndex = 3;
            this.botaoConfirmar.Text = "Confirmar Locação";
            this.botaoConfirmar.UseVisualStyleBackColor = true;
            // 
            // botaoVoltar
            // 
            this.botaoVoltar.Location = new System.Drawing.Point(9, 331);
            this.botaoVoltar.Name = "botaoVoltar";
            this.botaoVoltar.Size = new System.Drawing.Size(168, 23);
            this.botaoVoltar.TabIndex = 2;
            this.botaoVoltar.Text = "<< Voltar e escolher outro carro";
            this.botaoVoltar.UseVisualStyleBackColor = true;
            this.botaoVoltar.Click += new System.EventHandler(this.botaoVoltar_Click);
            // 
            // dadosCarro
            // 
            this.dadosCarro.AutoSize = true;
            this.dadosCarro.Location = new System.Drawing.Point(12, 30);
            this.dadosCarro.Name = "dadosCarro";
            this.dadosCarro.Size = new System.Drawing.Size(61, 13);
            this.dadosCarro.TabIndex = 1;
            this.dadosCarro.Text = "dadosCarro";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(11, 8);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(166, 20);
            this.label2.TabIndex = 0;
            this.label2.Text = "Locação de Veículo";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(16, 147);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(161, 13);
            this.label4.TabIndex = 19;
            this.label4.Text = "Local de Devolução do Veículo:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(86, 98);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(91, 13);
            this.label5.TabIndex = 20;
            this.label5.Text = "Data de Retirada:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(74, 173);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(103, 13);
            this.label6.TabIndex = 21;
            this.label6.Text = "Data de Devolução:";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(75, 124);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(102, 13);
            this.label7.TabIndex = 22;
            this.label7.Text = "Horário de Retirada:";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(63, 199);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(114, 13);
            this.label8.TabIndex = 23;
            this.label8.Text = "Horário de Devolução:";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(78, 222);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(99, 13);
            this.label9.TabIndex = 24;
            this.label9.Text = "Nome do Condutor:";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(81, 275);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(96, 13);
            this.label10.TabIndex = 25;
            this.label10.Text = "Número do Cartão:";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(354, 248);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(106, 13);
            this.label11.TabIndex = 26;
            this.label11.Text = "Número de Parcelas:";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(81, 247);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(98, 13);
            this.label12.TabIndex = 28;
            this.label12.Text = "Idade do Condutor:";
            // 
            // spinnerIdadeCondutor
            // 
            this.spinnerIdadeCondutor.Items.Add("90");
            this.spinnerIdadeCondutor.Items.Add("89");
            this.spinnerIdadeCondutor.Items.Add("88");
            this.spinnerIdadeCondutor.Items.Add("87");
            this.spinnerIdadeCondutor.Items.Add("86");
            this.spinnerIdadeCondutor.Items.Add("85");
            this.spinnerIdadeCondutor.Items.Add("84");
            this.spinnerIdadeCondutor.Items.Add("83");
            this.spinnerIdadeCondutor.Items.Add("82");
            this.spinnerIdadeCondutor.Items.Add("81");
            this.spinnerIdadeCondutor.Items.Add("80");
            this.spinnerIdadeCondutor.Items.Add("79");
            this.spinnerIdadeCondutor.Items.Add("78");
            this.spinnerIdadeCondutor.Items.Add("77");
            this.spinnerIdadeCondutor.Items.Add("76");
            this.spinnerIdadeCondutor.Items.Add("75");
            this.spinnerIdadeCondutor.Items.Add("74");
            this.spinnerIdadeCondutor.Items.Add("73");
            this.spinnerIdadeCondutor.Items.Add("72");
            this.spinnerIdadeCondutor.Items.Add("71");
            this.spinnerIdadeCondutor.Items.Add("70");
            this.spinnerIdadeCondutor.Items.Add("69");
            this.spinnerIdadeCondutor.Items.Add("68");
            this.spinnerIdadeCondutor.Items.Add("67");
            this.spinnerIdadeCondutor.Items.Add("66");
            this.spinnerIdadeCondutor.Items.Add("65");
            this.spinnerIdadeCondutor.Items.Add("64");
            this.spinnerIdadeCondutor.Items.Add("63");
            this.spinnerIdadeCondutor.Items.Add("62");
            this.spinnerIdadeCondutor.Items.Add("61");
            this.spinnerIdadeCondutor.Items.Add("60");
            this.spinnerIdadeCondutor.Items.Add("59");
            this.spinnerIdadeCondutor.Items.Add("58");
            this.spinnerIdadeCondutor.Items.Add("57");
            this.spinnerIdadeCondutor.Items.Add("56");
            this.spinnerIdadeCondutor.Items.Add("55");
            this.spinnerIdadeCondutor.Items.Add("54");
            this.spinnerIdadeCondutor.Items.Add("53");
            this.spinnerIdadeCondutor.Items.Add("52");
            this.spinnerIdadeCondutor.Items.Add("51");
            this.spinnerIdadeCondutor.Items.Add("50");
            this.spinnerIdadeCondutor.Items.Add("49");
            this.spinnerIdadeCondutor.Items.Add("48");
            this.spinnerIdadeCondutor.Items.Add("47");
            this.spinnerIdadeCondutor.Items.Add("46");
            this.spinnerIdadeCondutor.Items.Add("45");
            this.spinnerIdadeCondutor.Items.Add("44");
            this.spinnerIdadeCondutor.Items.Add("43");
            this.spinnerIdadeCondutor.Items.Add("42");
            this.spinnerIdadeCondutor.Items.Add("41");
            this.spinnerIdadeCondutor.Items.Add("40");
            this.spinnerIdadeCondutor.Items.Add("39");
            this.spinnerIdadeCondutor.Items.Add("38");
            this.spinnerIdadeCondutor.Items.Add("37");
            this.spinnerIdadeCondutor.Items.Add("36");
            this.spinnerIdadeCondutor.Items.Add("35");
            this.spinnerIdadeCondutor.Items.Add("34");
            this.spinnerIdadeCondutor.Items.Add("33");
            this.spinnerIdadeCondutor.Items.Add("32");
            this.spinnerIdadeCondutor.Items.Add("31");
            this.spinnerIdadeCondutor.Items.Add("30");
            this.spinnerIdadeCondutor.Items.Add("29");
            this.spinnerIdadeCondutor.Items.Add("28");
            this.spinnerIdadeCondutor.Items.Add("27");
            this.spinnerIdadeCondutor.Items.Add("26");
            this.spinnerIdadeCondutor.Items.Add("25");
            this.spinnerIdadeCondutor.Items.Add("24");
            this.spinnerIdadeCondutor.Items.Add("23");
            this.spinnerIdadeCondutor.Items.Add("22");
            this.spinnerIdadeCondutor.Items.Add("21");
            this.spinnerIdadeCondutor.Items.Add("20");
            this.spinnerIdadeCondutor.Items.Add("19");
            this.spinnerIdadeCondutor.Items.Add("18");
            this.spinnerIdadeCondutor.Location = new System.Drawing.Point(179, 245);
            this.spinnerIdadeCondutor.Name = "spinnerIdadeCondutor";
            this.spinnerIdadeCondutor.Size = new System.Drawing.Size(62, 20);
            this.spinnerIdadeCondutor.TabIndex = 27;
            this.spinnerIdadeCondutor.Text = "18";
            // 
            // JanelaLocarVeiculo
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(554, 369);
            this.Controls.Add(this.panelDados);
            this.Controls.Add(this.panelCarro);
            this.MaximizeBox = false;
            this.Name = "JanelaLocarVeiculo";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Locar Veículo";
            this.panelCarro.ResumeLayout(false);
            this.panelCarro.PerformLayout();
            this.panelDados.ResumeLayout(false);
            this.panelDados.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panelCarro;
        private System.Windows.Forms.Button botaoAvancar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panelDados;
        private System.Windows.Forms.Label dadosCarro;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textBox9;
        private System.Windows.Forms.TextBox nomeMotorista;
        private System.Windows.Forms.TextBox boxLocalDevolucao;
        private System.Windows.Forms.TextBox boxLocalRetirada;
        private System.Windows.Forms.Button botaoConfirmar;
        private System.Windows.Forms.Button botaoVoltar;
        private System.Windows.Forms.DateTimePicker dateDataRetirada;
        private System.Windows.Forms.CheckedListBox listaVeiculos;
        private System.Windows.Forms.DateTimePicker dateHoraRetirada;
        private System.Windows.Forms.DateTimePicker dateHoraDevolucao;
        private System.Windows.Forms.DateTimePicker dateDataDevolucao;
        private System.Windows.Forms.DomainUpDown spinnerNumeroParcelas;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.DomainUpDown spinnerIdadeCondutor;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
    }
}