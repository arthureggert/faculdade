using MathQuiz.Classes;
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
    public partial class FrmPontuacao : Form
    {
        public FrmPontuacao()
        {
            InitializeComponent();
        }

        public FrmPontuacao(Pontuacao pontuacao)
        {
            InitializeComponent();

            pontuacao.Contabilizar();

            foreach (var jogador in pontuacao.Resultado.OrderBy(r => r.Value))
            {
                var lblJogador = new Label();
                lblJogador.Dock = DockStyle.Top;
                lblJogador.Text = string.Format("{0} : {1} pontos", jogador.Key.Nome, jogador.Value);
                this.Controls.Add(lblJogador);
            }
        }
    }
}
