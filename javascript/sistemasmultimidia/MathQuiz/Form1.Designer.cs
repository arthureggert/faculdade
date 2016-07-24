namespace MathQuiz
{
    partial class FrmPrincipal
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
            this.tabPrincipal = new System.Windows.Forms.TabControl();
            this.tabPerguntas = new System.Windows.Forms.TabPage();
            this.panel2 = new System.Windows.Forms.Panel();
            this.grdPerguntas = new System.Windows.Forms.DataGridView();
            this.panel1 = new System.Windows.Forms.Panel();
            this.btnIniciarQuiz = new System.Windows.Forms.Button();
            this.btnNovaPergunta = new System.Windows.Forms.Button();
            this.tabJogadores = new System.Windows.Forms.TabPage();
            this.grdJogadores = new System.Windows.Forms.DataGridView();
            this.JogadorObj = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.JogadorCodigo = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.JogadorNome = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnExcluirQuestao = new System.Windows.Forms.Button();
            this.QuestaoObjeto = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.QuestaoCodigo = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.QuestaoTipo = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.QuestaoPergunta = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.tabPrincipal.SuspendLayout();
            this.tabPerguntas.SuspendLayout();
            this.panel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.grdPerguntas)).BeginInit();
            this.panel1.SuspendLayout();
            this.tabJogadores.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.grdJogadores)).BeginInit();
            this.SuspendLayout();
            // 
            // tabPrincipal
            // 
            this.tabPrincipal.Controls.Add(this.tabPerguntas);
            this.tabPrincipal.Controls.Add(this.tabJogadores);
            this.tabPrincipal.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tabPrincipal.Location = new System.Drawing.Point(0, 0);
            this.tabPrincipal.Name = "tabPrincipal";
            this.tabPrincipal.SelectedIndex = 0;
            this.tabPrincipal.Size = new System.Drawing.Size(691, 429);
            this.tabPrincipal.TabIndex = 0;
            // 
            // tabPerguntas
            // 
            this.tabPerguntas.Controls.Add(this.panel2);
            this.tabPerguntas.Controls.Add(this.panel1);
            this.tabPerguntas.Location = new System.Drawing.Point(4, 22);
            this.tabPerguntas.Name = "tabPerguntas";
            this.tabPerguntas.Padding = new System.Windows.Forms.Padding(3);
            this.tabPerguntas.Size = new System.Drawing.Size(683, 403);
            this.tabPerguntas.TabIndex = 0;
            this.tabPerguntas.Text = "Perguntas";
            this.tabPerguntas.UseVisualStyleBackColor = true;
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.grdPerguntas);
            this.panel2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel2.Location = new System.Drawing.Point(3, 33);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(677, 367);
            this.panel2.TabIndex = 2;
            // 
            // grdPerguntas
            // 
            this.grdPerguntas.AllowUserToAddRows = false;
            this.grdPerguntas.AllowUserToDeleteRows = false;
            this.grdPerguntas.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.grdPerguntas.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.QuestaoObjeto,
            this.QuestaoCodigo,
            this.QuestaoTipo,
            this.QuestaoPergunta});
            this.grdPerguntas.Dock = System.Windows.Forms.DockStyle.Fill;
            this.grdPerguntas.Location = new System.Drawing.Point(0, 0);
            this.grdPerguntas.Name = "grdPerguntas";
            this.grdPerguntas.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.grdPerguntas.Size = new System.Drawing.Size(677, 367);
            this.grdPerguntas.TabIndex = 0;
            this.grdPerguntas.CellMouseDoubleClick += new System.Windows.Forms.DataGridViewCellMouseEventHandler(this.grdPerguntas_CellMouseDoubleClick);
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.btnExcluirQuestao);
            this.panel1.Controls.Add(this.btnIniciarQuiz);
            this.panel1.Controls.Add(this.btnNovaPergunta);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(3, 3);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(677, 30);
            this.panel1.TabIndex = 1;
            // 
            // btnIniciarQuiz
            // 
            this.btnIniciarQuiz.Location = new System.Drawing.Point(597, 3);
            this.btnIniciarQuiz.Name = "btnIniciarQuiz";
            this.btnIniciarQuiz.Size = new System.Drawing.Size(75, 23);
            this.btnIniciarQuiz.TabIndex = 2;
            this.btnIniciarQuiz.Text = "Iniciar Quiz";
            this.btnIniciarQuiz.UseVisualStyleBackColor = true;
            this.btnIniciarQuiz.Click += new System.EventHandler(this.btnIniciarQuiz_Click);
            // 
            // btnNovaPergunta
            // 
            this.btnNovaPergunta.Location = new System.Drawing.Point(5, 3);
            this.btnNovaPergunta.Name = "btnNovaPergunta";
            this.btnNovaPergunta.Size = new System.Drawing.Size(75, 23);
            this.btnNovaPergunta.TabIndex = 0;
            this.btnNovaPergunta.Text = "Novo";
            this.btnNovaPergunta.UseVisualStyleBackColor = true;
            this.btnNovaPergunta.Click += new System.EventHandler(this.btnNovaPergunta_Click);
            // 
            // tabJogadores
            // 
            this.tabJogadores.Controls.Add(this.grdJogadores);
            this.tabJogadores.Location = new System.Drawing.Point(4, 22);
            this.tabJogadores.Name = "tabJogadores";
            this.tabJogadores.Padding = new System.Windows.Forms.Padding(3);
            this.tabJogadores.Size = new System.Drawing.Size(683, 403);
            this.tabJogadores.TabIndex = 2;
            this.tabJogadores.Text = "Jogadores";
            this.tabJogadores.UseVisualStyleBackColor = true;
            // 
            // grdJogadores
            // 
            this.grdJogadores.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.grdJogadores.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.JogadorObj,
            this.JogadorCodigo,
            this.JogadorNome});
            this.grdJogadores.Dock = System.Windows.Forms.DockStyle.Fill;
            this.grdJogadores.Location = new System.Drawing.Point(3, 3);
            this.grdJogadores.Name = "grdJogadores";
            this.grdJogadores.Size = new System.Drawing.Size(677, 397);
            this.grdJogadores.TabIndex = 0;
            this.grdJogadores.RowValidated += new System.Windows.Forms.DataGridViewCellEventHandler(this.grdJogadores_RowValidated);
            // 
            // JogadorObj
            // 
            this.JogadorObj.HeaderText = "Objeto";
            this.JogadorObj.Name = "JogadorObj";
            this.JogadorObj.Visible = false;
            // 
            // JogadorCodigo
            // 
            this.JogadorCodigo.HeaderText = "Código";
            this.JogadorCodigo.Name = "JogadorCodigo";
            this.JogadorCodigo.ReadOnly = true;
            // 
            // JogadorNome
            // 
            this.JogadorNome.HeaderText = "Nome";
            this.JogadorNome.Name = "JogadorNome";
            this.JogadorNome.Width = 350;
            // 
            // btnExcluirQuestao
            // 
            this.btnExcluirQuestao.Location = new System.Drawing.Point(86, 3);
            this.btnExcluirQuestao.Name = "btnExcluirQuestao";
            this.btnExcluirQuestao.Size = new System.Drawing.Size(75, 23);
            this.btnExcluirQuestao.TabIndex = 3;
            this.btnExcluirQuestao.Text = "Excluir";
            this.btnExcluirQuestao.UseVisualStyleBackColor = true;
            this.btnExcluirQuestao.Click += new System.EventHandler(this.btnExcluirQuestao_Click);
            // 
            // QuestaoObjeto
            // 
            this.QuestaoObjeto.HeaderText = "Objeto";
            this.QuestaoObjeto.Name = "QuestaoObjeto";
            this.QuestaoObjeto.Visible = false;
            // 
            // QuestaoCodigo
            // 
            this.QuestaoCodigo.HeaderText = "Código";
            this.QuestaoCodigo.Name = "QuestaoCodigo";
            this.QuestaoCodigo.Width = 50;
            // 
            // QuestaoTipo
            // 
            this.QuestaoTipo.HeaderText = "Tipo";
            this.QuestaoTipo.Name = "QuestaoTipo";
            // 
            // QuestaoPergunta
            // 
            this.QuestaoPergunta.HeaderText = "Pergunta";
            this.QuestaoPergunta.Name = "QuestaoPergunta";
            this.QuestaoPergunta.Width = 450;
            // 
            // FrmPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(691, 429);
            this.Controls.Add(this.tabPrincipal);
            this.Name = "FrmPrincipal";
            this.ShowIcon = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Math Quiz";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.FrmPrincipal_FormClosing);
            this.tabPrincipal.ResumeLayout(false);
            this.tabPerguntas.ResumeLayout(false);
            this.panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.grdPerguntas)).EndInit();
            this.panel1.ResumeLayout(false);
            this.tabJogadores.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.grdJogadores)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabPrincipal;
        private System.Windows.Forms.TabPage tabPerguntas;
        private System.Windows.Forms.DataGridView grdPerguntas;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button btnNovaPergunta;
        private System.Windows.Forms.TabPage tabJogadores;
        private System.Windows.Forms.DataGridView grdJogadores;
        private System.Windows.Forms.DataGridViewTextBoxColumn JogadorObj;
        private System.Windows.Forms.DataGridViewTextBoxColumn JogadorCodigo;
        private System.Windows.Forms.DataGridViewTextBoxColumn JogadorNome;
        private System.Windows.Forms.Button btnIniciarQuiz;
        private System.Windows.Forms.Button btnExcluirQuestao;
        private System.Windows.Forms.DataGridViewTextBoxColumn QuestaoObjeto;
        private System.Windows.Forms.DataGridViewTextBoxColumn QuestaoCodigo;
        private System.Windows.Forms.DataGridViewTextBoxColumn QuestaoTipo;
        private System.Windows.Forms.DataGridViewTextBoxColumn QuestaoPergunta;
    }
}

