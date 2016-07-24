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
    public partial class FrmIniciarQuiz : Form
    {
        public FrmIniciarQuiz()
        {
            InitializeComponent();

            edtQtdePerguntas.Minimum = 1;
            edtQtdePerguntas.Maximum = DBApplication.Questoes.Count();
            edtQtdePerguntas.Value = DBApplication.Questoes.Count();
            CarregarJogadores();
        }

        private void CarregarJogadores()
        {
            grdJogadores.Rows.Clear();

            foreach (var jogador in DBApplication.Jogadores)
            {
                grdJogadores.Rows.Add(new object[] { jogador, true, jogador.Nome });
            }
        }

        private void btnIniciar_Click(object sender, EventArgs e)
        {
            var frmQuiz = new FrmQuiz();
            var jogadoresMarcados = new List<Jogador>();

            foreach (DataGridViewRow linha in grdJogadores.Rows)
            {
                if (Convert.ToBoolean(linha.Cells["JogadorMarcado"].Value))
                    jogadoresMarcados.Add(linha.Cells[0].Value as Jogador);

            }
            frmQuiz.Jogadores = jogadoresMarcados;
            frmQuiz.TempoResposta = Convert.ToInt32(edtTempoResposta.Value);
            frmQuiz.QuantidadePerguntas = Convert.ToInt32(edtQtdePerguntas.Value);

            //frmQuiz.WindowState = FormWindowState.Maximized;
            //frmQuiz.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            frmQuiz.TopMost = true;
            frmQuiz.ShowDialog();

            if (frmQuiz.DialogResult == System.Windows.Forms.DialogResult.OK)
            {
                var resultadoQuiz = frmQuiz.PontuacaoQuiz;

                var frmPontuacao = new FrmPontuacao(resultadoQuiz);
                frmPontuacao.ShowDialog();
            }
        }
        
        private void grdJogadores_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            grdJogadores.Rows[e.RowIndex].Cells["JogadorMarcado"].Value =
                !Convert.ToBoolean(grdJogadores.Rows[e.RowIndex].Cells["JogadorMarcado"].Value);
        }
    }
}
