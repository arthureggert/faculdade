using MathQuiz.Classes;
using MathQuiz.Common;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace MathQuiz
{
    public partial class FrmPrincipal : Form
    {
        public FrmPrincipal()
        {
            InitializeComponent();

            CarregarGrids();
        }

        private void CarregarGrids()
        {
            try
            {
                grdPerguntas.Rows.Clear();
                grdJogadores.Rows.Clear();

                foreach (var questao in DBApplication.Questoes)
                    grdPerguntas.Rows.Add(questao.ToGridRow());

                foreach (var jogador in DBApplication.Jogadores)
                    grdJogadores.Rows.Add(jogador.ToGridRow());
            }
            catch (Exception ex)
            {
                MessageBox.Show(string.Format("Erro ao carregar grids: {0}.", ex.Message), "Erro", MessageBoxButtons.OK);
            }
        }

        private void FrmPrincipal_FormClosing(object sender, FormClosingEventArgs e)
        {
            try
            { 
                DBApplication.PersistirDados();
            }
            catch (Exception ex)
            {
                MessageBox.Show(string.Format("Erro ao persistir informações: {0}.", ex.Message), "Erro", MessageBoxButtons.OK);
            }
        }

        private void grdJogadores_RowValidated(object sender, DataGridViewCellEventArgs e)
        {
            var linha = grdJogadores.Rows[e.RowIndex];

            if (linha.IsNewRow)
                return;

            Jogador jogador = grdJogadores.Rows[e.RowIndex].Cells[0].Value as Jogador;

            if (jogador == null)
                jogador = new Jogador();

            jogador.Nome = linha.Cells["JogadorNome"].Value.ToString();
            jogador.Salvar();

            linha.Cells[0].Value = jogador;
            linha.Cells[1].Value = jogador.Codigo;
            linha.Cells[2].Value = jogador.Nome;
        }

        private void btnIniciarQuiz_Click(object sender, EventArgs e)
        {
            var frmIniciarQuiz = new FrmIniciarQuiz();
            frmIniciarQuiz.ShowDialog();
        }

        private void btnNovaPergunta_Click(object sender, EventArgs e)
        {
            var objFrmPergunta = new FrmPergunta();
            objFrmPergunta.ShowDialog();

            CarregarGrids();
        }

        private void grdPerguntas_CellMouseDoubleClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            if (grdPerguntas.Rows[e.RowIndex].IsNewRow)
                return;

            var objFrmPergunta = new FrmPergunta(grdPerguntas.Rows[e.RowIndex].Cells[0].Value as Questao);
            objFrmPergunta.ShowDialog();

            CarregarGrids();
        }

        private void btnExcluirQuestao_Click(object sender, EventArgs e)
        {
            var linha = grdPerguntas.SelectedRows.Count > 0 ? grdPerguntas.SelectedRows[0] : null;

            if (linha == null)
                return;

            if (MessageBox.Show(string.Format("Confirma exclusão da questão {1} do tipo {0}?",
                linha.Cells["QuestaoTipo"].Value, linha.Cells["QuestaoPergunta"].Value), "Confirmação", MessageBoxButtons.YesNo) == System.Windows.Forms.DialogResult.Yes)
            {
                DBApplication.Questoes.Remove(linha.Cells[0].Value as Questao);
                CarregarGrids();
            }
        }
    }
}
