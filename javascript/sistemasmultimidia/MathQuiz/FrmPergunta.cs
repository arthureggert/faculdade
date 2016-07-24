using MathQuiz.Classes;
using MathQuiz.Common;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace MathQuiz
{
    public partial class FrmPergunta : Form
    {
        private Questao Questao { get; set; }

        public FrmPergunta()
        {
            InitializeComponent();
            rbPergunta.Checked = true;
        }

        public FrmPergunta(Questao questao)
        {
            InitializeComponent();
            rbPergunta.Checked = true;

            if (questao != null)
            {
                Questao = questao;

                edtPergunta.Text = questao.Pergunta;
                edtResposta.Text = questao.Resposta;
                rbGrafico.Checked = questao.Tipo == TipoQuestao.Grafico;
                rbPergunta.Checked = questao.Tipo == TipoQuestao.Funcao;

                grdFuncoes.Rows.Clear();
                foreach (var funcao in Questao.Respostas)
                    grdFuncoes.Rows.Add(funcao);
            }
        }

        private void grdFuncoes_RowEnter(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && grdFuncoes.Rows[e.RowIndex].IsNewRow)
                return;

            try
            {
                ucGrafico1.AtualizarFuncao(grdFuncoes.Rows[e.RowIndex].Cells["Funcao"].Value.ToString());
            }
            catch (Exception ex)
            {
                MessageBox.Show("Erro ao plotar função: " + ex.Message);
            }
        }

        private void btnSalvar_Click(object sender, EventArgs e)
        {
            var p = new Questao();
            if (Questao != null)
                p.Codigo = Questao.Codigo;
            p.Pergunta = edtPergunta.Text;
            p.Resposta = edtResposta.Text;
            p.Tipo = (rbPergunta.Checked ? TipoQuestao.Funcao : TipoQuestao.Grafico);

            foreach (DataGridViewRow linha in grdFuncoes.Rows)
                if (!linha.IsNewRow)
                    p.Respostas.Add(linha.Cells[0].Value.ToString());
            
            p.Salvar();
            DBApplication.Questoes.Add(p);

            this.Close();
        }
    }
}
