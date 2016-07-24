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
    public partial class FrmQuiz : Form
    {
        /// <summary>
        /// Tempo para responder em minutos
        /// </summary>
        public int TempoResposta { get; set; }
        private int SegundosRestantes { get; set; }
        /// <summary>
        /// Lista de jogadores participantes
        /// </summary>
        public List<Jogador> Jogadores { get; set; }
        /// <summary>
        /// Quantidade de perguntas do quiz
        /// </summary>
        public int QuantidadePerguntas { get; set; }
        public int PerguntaAtual { get; set; }
        private List<ucPergunta> ControlesPergunta { get; set; }
        private Timer Temporizador { get; set; }
        public List<Questao> Questoes { get; set; }
        public Pontuacao PontuacaoQuiz = new Pontuacao();

        public FrmQuiz()
        {
            InitializeComponent();
        }

        private void InicializarQuestoes()
        {
            Questoes = new List<Questao>();
            Questoes.AddRange(DBApplication.Questoes.Take(QuantidadePerguntas));

            foreach (var q in Questoes)
                PontuacaoQuiz.Questoes.Add(q);
        }

        private void InicializarContador()
        {
            Temporizador = new Timer();
            Temporizador.Interval = 1000;
            Temporizador.Tick += Temporizador_Tick;
            Temporizador.Start();
        }

        private void Temporizador_Tick(object sender, EventArgs e)
        {
            SegundosRestantes--;
            ControlesPergunta.ForEach(cp => cp.AtualizarCronometro(TimeSpan.FromSeconds(SegundosRestantes)));

            if (SegundosRestantes > 0)
                return;

            PerguntaAtual++;

            if (PerguntaAtual == Questoes.Count)
            {
                Temporizador.Stop();

                this.DialogResult = System.Windows.Forms.DialogResult.OK;
                this.Close();
            }
            else
            {
                SegundosRestantes = TempoResposta;

                foreach (var uc in ControlesPergunta)
                    uc.AtualizarQuestao(Questoes[PerguntaAtual]);
            }
        }

        private void MontarCenario()
        {
            try
            {
                ControlesPergunta = new List<ucPergunta>();

                for (int i = 0; i < Jogadores.Count; i++)
                {
                    var objPergunta = new ucPergunta(Jogadores[i], i % 2 == 0);
                    objPergunta.AtualizarCronometro(TimeSpan.FromSeconds(TempoResposta));
                    objPergunta.OnResponder += objPergunta_OnResponder;
                    ControlesPergunta.Add(objPergunta);

                    if (i % 2 == 0)
                        fpnlSuperior.Controls.Add(objPergunta);
                    else
                        fpnlInferior.Controls.Add(objPergunta);
                    
                }

                var larguraS = fpnlSuperior.Width / fpnlSuperior.Controls.Count;

                foreach (Control uc in fpnlSuperior.Controls)
                {
                    uc.Height = fpnlSuperior.Height - 5;
                    uc.Width = larguraS - 7;
                }

                var larguraI = fpnlInferior.Width / fpnlInferior.Controls.Count;

                foreach (Control uc in fpnlInferior.Controls)
                {
                    uc.Height = fpnlInferior.Height - 5;
                    uc.Width = larguraI - 7;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(string.Format("Erro ao montar cenário: {0}.", ex.Message));
            }
        }

        void objPergunta_OnResponder(Jogador jogador, DateTime dataHora, string alternativa)
        {
            PontuacaoQuiz.QuestaoRepondida(jogador, Questoes[PerguntaAtual], dataHora, alternativa);
            foreach (var controle in ControlesPergunta)
            {
                controle.Log(jogador, dataHora);
            }
        }

        private void FrmQuiz_Load(object sender, EventArgs e)
        {
            PerguntaAtual = 0;
            SegundosRestantes = TempoResposta;
            MontarCenario();
            InicializarQuestoes();

            foreach (var j in Jogadores)
                PontuacaoQuiz.Jogadores.Add(j);

            foreach (var uc in ControlesPergunta)
                uc.AtualizarQuestao(Questoes.First());

            InicializarContador();
        }

        private void FrmQuiz_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Escape)
                this.Close();
        }
    }
}
