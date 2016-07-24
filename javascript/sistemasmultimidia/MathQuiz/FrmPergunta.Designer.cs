namespace MathQuiz
{
    partial class FrmPergunta
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
            this.label1 = new System.Windows.Forms.Label();
            this.edtPergunta = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.grdFuncoes = new System.Windows.Forms.DataGridView();
            this.Funcao = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.panel1 = new System.Windows.Forms.Panel();
            this.btnSalvar = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.rbGrafico = new System.Windows.Forms.RadioButton();
            this.rbPergunta = new System.Windows.Forms.RadioButton();
            this.panel2 = new System.Windows.Forms.Panel();
            this.ucGrafico1 = new MathQuiz.ucGrafico();
            this.label3 = new System.Windows.Forms.Label();
            this.edtResposta = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.grdFuncoes)).BeginInit();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(3, 38);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(50, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Pergunta";
            // 
            // edtPergunta
            // 
            this.edtPergunta.Location = new System.Drawing.Point(76, 35);
            this.edtPergunta.Multiline = true;
            this.edtPergunta.Name = "edtPergunta";
            this.edtPergunta.Size = new System.Drawing.Size(418, 42);
            this.edtPergunta.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(3, 112);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(57, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Respostas";
            // 
            // grdFuncoes
            // 
            this.grdFuncoes.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.grdFuncoes.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Funcao});
            this.grdFuncoes.Location = new System.Drawing.Point(76, 109);
            this.grdFuncoes.Name = "grdFuncoes";
            this.grdFuncoes.Size = new System.Drawing.Size(418, 124);
            this.grdFuncoes.TabIndex = 3;
            this.grdFuncoes.RowEnter += new System.Windows.Forms.DataGridViewCellEventHandler(this.grdFuncoes_RowEnter);
            // 
            // Funcao
            // 
            this.Funcao.HeaderText = "Função";
            this.Funcao.Name = "Funcao";
            this.Funcao.Width = 350;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.edtResposta);
            this.panel1.Controls.Add(this.label3);
            this.panel1.Controls.Add(this.btnSalvar);
            this.panel1.Controls.Add(this.label4);
            this.panel1.Controls.Add(this.rbGrafico);
            this.panel1.Controls.Add(this.rbPergunta);
            this.panel1.Controls.Add(this.grdFuncoes);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.edtPergunta);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(515, 269);
            this.panel1.TabIndex = 6;
            // 
            // btnSalvar
            // 
            this.btnSalvar.Location = new System.Drawing.Point(419, 239);
            this.btnSalvar.Name = "btnSalvar";
            this.btnSalvar.Size = new System.Drawing.Size(75, 23);
            this.btnSalvar.TabIndex = 8;
            this.btnSalvar.Text = "Salvar";
            this.btnSalvar.UseVisualStyleBackColor = true;
            this.btnSalvar.Click += new System.EventHandler(this.btnSalvar_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(3, 9);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(28, 13);
            this.label4.TabIndex = 7;
            this.label4.Text = "Tipo";
            // 
            // rbGrafico
            // 
            this.rbGrafico.AutoSize = true;
            this.rbGrafico.Location = new System.Drawing.Point(150, 12);
            this.rbGrafico.Name = "rbGrafico";
            this.rbGrafico.Size = new System.Drawing.Size(59, 17);
            this.rbGrafico.TabIndex = 6;
            this.rbGrafico.TabStop = true;
            this.rbGrafico.Text = "Gráfico";
            this.rbGrafico.UseVisualStyleBackColor = true;
            // 
            // rbPergunta
            // 
            this.rbPergunta.AutoSize = true;
            this.rbPergunta.Location = new System.Drawing.Point(76, 12);
            this.rbPergunta.Name = "rbPergunta";
            this.rbPergunta.Size = new System.Drawing.Size(68, 17);
            this.rbPergunta.TabIndex = 5;
            this.rbPergunta.TabStop = true;
            this.rbPergunta.Text = "Pergunta";
            this.rbPergunta.UseVisualStyleBackColor = true;
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.ucGrafico1);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel2.Location = new System.Drawing.Point(0, 269);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(515, 225);
            this.panel2.TabIndex = 7;
            // 
            // ucGrafico1
            // 
            this.ucGrafico1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucGrafico1.Equacao = null;
            this.ucGrafico1.Location = new System.Drawing.Point(0, 0);
            this.ucGrafico1.Name = "ucGrafico1";
            this.ucGrafico1.Size = new System.Drawing.Size(515, 225);
            this.ucGrafico1.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(3, 86);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(52, 13);
            this.label3.TabIndex = 9;
            this.label3.Text = "Resposta";
            // 
            // edtResposta
            // 
            this.edtResposta.Location = new System.Drawing.Point(76, 83);
            this.edtResposta.Name = "edtResposta";
            this.edtResposta.Size = new System.Drawing.Size(418, 20);
            this.edtResposta.TabIndex = 10;
            // 
            // FrmPergunta
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(515, 494);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.MinimizeBox = false;
            this.Name = "FrmPergunta";
            this.ShowIcon = false;
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Questão";
            ((System.ComponentModel.ISupportInitialize)(this.grdFuncoes)).EndInit();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox edtPergunta;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.DataGridView grdFuncoes;
        private System.Windows.Forms.DataGridViewTextBoxColumn Funcao;
        private ucGrafico ucGrafico1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.RadioButton rbGrafico;
        private System.Windows.Forms.RadioButton rbPergunta;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button btnSalvar;
        private System.Windows.Forms.TextBox edtResposta;
        private System.Windows.Forms.Label label3;
    }
}