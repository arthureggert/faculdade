namespace MathQuiz
{
    partial class FrmIniciarQuiz
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
            this.grdJogadores = new System.Windows.Forms.DataGridView();
            this.JogadorObjeto = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.JogadorMarcado = new System.Windows.Forms.DataGridViewCheckBoxColumn();
            this.JogadorNome = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnIniciar = new System.Windows.Forms.Button();
            this.edtQtdePerguntas = new System.Windows.Forms.NumericUpDown();
            this.label2 = new System.Windows.Forms.Label();
            this.edtTempoResposta = new System.Windows.Forms.NumericUpDown();
            ((System.ComponentModel.ISupportInitialize)(this.grdJogadores)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.edtQtdePerguntas)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.edtTempoResposta)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(127, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Quantidade de perguntas";
            // 
            // grdJogadores
            // 
            this.grdJogadores.AllowUserToAddRows = false;
            this.grdJogadores.AllowUserToDeleteRows = false;
            this.grdJogadores.AllowUserToResizeColumns = false;
            this.grdJogadores.AllowUserToResizeRows = false;
            this.grdJogadores.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.grdJogadores.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.JogadorObjeto,
            this.JogadorMarcado,
            this.JogadorNome});
            this.grdJogadores.Location = new System.Drawing.Point(12, 38);
            this.grdJogadores.Name = "grdJogadores";
            this.grdJogadores.RowHeadersVisible = false;
            this.grdJogadores.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.grdJogadores.ShowCellErrors = false;
            this.grdJogadores.ShowCellToolTips = false;
            this.grdJogadores.ShowEditingIcon = false;
            this.grdJogadores.ShowRowErrors = false;
            this.grdJogadores.Size = new System.Drawing.Size(441, 180);
            this.grdJogadores.TabIndex = 1;
            this.grdJogadores.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.grdJogadores_CellClick);
            // 
            // JogadorObjeto
            // 
            this.JogadorObjeto.HeaderText = "Objeto";
            this.JogadorObjeto.Name = "JogadorObjeto";
            this.JogadorObjeto.Visible = false;
            // 
            // JogadorMarcado
            // 
            this.JogadorMarcado.HeaderText = "Marcado";
            this.JogadorMarcado.Name = "JogadorMarcado";
            this.JogadorMarcado.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.JogadorMarcado.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.JogadorMarcado.Width = 55;
            // 
            // JogadorNome
            // 
            this.JogadorNome.HeaderText = "Jogador";
            this.JogadorNome.Name = "JogadorNome";
            this.JogadorNome.Width = 300;
            // 
            // btnIniciar
            // 
            this.btnIniciar.Location = new System.Drawing.Point(378, 224);
            this.btnIniciar.Name = "btnIniciar";
            this.btnIniciar.Size = new System.Drawing.Size(75, 23);
            this.btnIniciar.TabIndex = 2;
            this.btnIniciar.Text = "Iniciar";
            this.btnIniciar.UseVisualStyleBackColor = true;
            this.btnIniciar.Click += new System.EventHandler(this.btnIniciar_Click);
            // 
            // edtQtdePerguntas
            // 
            this.edtQtdePerguntas.Location = new System.Drawing.Point(145, 7);
            this.edtQtdePerguntas.Name = "edtQtdePerguntas";
            this.edtQtdePerguntas.Size = new System.Drawing.Size(120, 20);
            this.edtQtdePerguntas.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(271, 9);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(83, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Tempo resposta";
            // 
            // edtTempoResposta
            // 
            this.edtTempoResposta.Location = new System.Drawing.Point(360, 7);
            this.edtTempoResposta.Minimum = new decimal(new int[] {
            10,
            0,
            0,
            0});
            this.edtTempoResposta.Name = "edtTempoResposta";
            this.edtTempoResposta.Size = new System.Drawing.Size(93, 20);
            this.edtTempoResposta.TabIndex = 5;
            this.edtTempoResposta.Value = new decimal(new int[] {
            10,
            0,
            0,
            0});
            // 
            // FrmIniciarQuiz
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(467, 257);
            this.Controls.Add(this.edtTempoResposta);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.edtQtdePerguntas);
            this.Controls.Add(this.btnIniciar);
            this.Controls.Add(this.grdJogadores);
            this.Controls.Add(this.label1);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "FrmIniciarQuiz";
            this.ShowIcon = false;
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Iniciar Quiz";
            ((System.ComponentModel.ISupportInitialize)(this.grdJogadores)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.edtQtdePerguntas)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.edtTempoResposta)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DataGridView grdJogadores;
        private System.Windows.Forms.Button btnIniciar;
        private System.Windows.Forms.NumericUpDown edtQtdePerguntas;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.NumericUpDown edtTempoResposta;
        private System.Windows.Forms.DataGridViewTextBoxColumn JogadorObjeto;
        private System.Windows.Forms.DataGridViewCheckBoxColumn JogadorMarcado;
        private System.Windows.Forms.DataGridViewTextBoxColumn JogadorNome;
    }
}