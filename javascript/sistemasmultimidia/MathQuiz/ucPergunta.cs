using System;
using System.Windows.Forms;
using MathQuiz.Classes;
using CustomControl.OrientAbleTextControls;
using MathQuiz.Common;
using System.Threading.Tasks;
using System.Threading;
using System.Drawing;

namespace MathQuiz
{
    public partial class ucPergunta : UserControl
    {
        /// <summary>
        /// Objeto jogador
        /// </summary>
        public Jogador Jogador { get; set; }
        /// <summary>
        /// Delegate usado pelo evento de responder
        /// </summary>
        public delegate void ResponderHandler(Jogador jogador, DateTime dataHora, string alternativa);   
        /// <summary>
        /// Evento assinado pelo formulário consumidor
        /// </summary>
        public event ResponderHandler OnResponder;
        /// <summary>
        /// Indica se formulário deve ser desenho invertido
        /// </summary>
        public bool Invertido { get; set; }
        public string AlternativaSelecionada { get; set; }

        public void AtualizarQuestao(Questao questao)
        {
            edtLog.Visible = false;

            pnlAlternativas.SuspendLayout();
            pnlAlternativas.Controls.Clear();
            AlternativaSelecionada = string.Empty;

            if (questao.Tipo == TipoQuestao.Funcao)
                lblPergunta.Text = string.Format("Qual é o gráfico gerado pela função f(x)={0}?", questao.Pergunta);
            else
                lblPergunta.Text = string.Format("Qual é a função geradora do gráfico abaixo?", questao.Pergunta);
            
            foreach (var resposta in questao.Respostas)
            {
                if (questao.Tipo == TipoQuestao.Funcao)
                {
                    var grafico = new ucGrafico();
                    grafico.Click += alternativa_Click;
                    grafico.AtualizarFuncao(resposta);
                    pnlAlternativas.Controls.Add(grafico);
                }
                else
                {
                    var alternativa = new OrientedTextLabel();
                    alternativa.Dock = DockStyle.Top;
                    alternativa.Height = (pnlAlternativas.Height / questao.Respostas.Count);
                    alternativa.Click += alternativa_Click;
                    if (Invertido)
                        InverterComponente(alternativa);
                    alternativa.Text = resposta;

                    pnlAlternativas.Controls.Add(alternativa);
                }
            }

            AtivarResposta(true);
            pnlAlternativas.ResumeLayout();
        }

        void alternativa_Click(object sender, EventArgs e)
        {
            if (sender.GetType() == typeof(OrientedTextLabel))
                AlternativaSelecionada = (sender as Label).Text;
            else if (sender.GetType() == typeof(ucGrafico))
                AlternativaSelecionada = (sender as ucGrafico).Equacao;
            else
                AlternativaSelecionada = string.Empty;
        }

        public void AtualizarCronometro(TimeSpan dataHora)
        {
            lblCronometro.Text = string.Format("{0}:{1}", 
                dataHora.Minutes.ToString("00"), dataHora.Seconds.ToString("00"));
        }

        public void Log(Jogador jogador, DateTime tempo)
        {
            edtLog.Text = string.Format("{0} {1}{2}{3}", jogador.Nome, tempo, Environment.NewLine, edtLog.Text);
        }

        public ucPergunta(Jogador jogador, bool invertido)
        {
            InitializeComponent();

            this.Jogador = jogador;
            lblNomeJogador.Text = jogador.Nome;

            if (invertido)
            {
                InverterComponente(lblPergunta, lblCronometro, lblNomeJogador, lblResponder);
                pnlPergunta.Dock = DockStyle.Bottom;
                pnlJogador.Dock = DockStyle.Top;
            }
        }

        public ucPergunta()
        {
            
        }

        private void btnResponder_Click(object sender, EventArgs e)
        {
            //Task.Factory.StartNew(Resp);
            //btnResponder.Enabled = false;
            AtivarResposta(false);
            Resp();
        }

        private void Resp()
        {
            if (OnResponder != null)
                OnResponder(this.Jogador, DateTime.Now, AlternativaSelecionada);
        }

        private void InverterComponente(params OrientedTextLabel[] component)
        {
            foreach (var c in component)
            {
                c.RotationAngle = 180;
                c.TextDirection = CustomControl.OrientAbleTextControls.Direction.Clockwise;
                c.TextOrientation = CustomControl.OrientAbleTextControls.Orientation.Rotate;
            }
        }

        private void AtivarResposta(bool ativar)
        {
            lblResponder.Enabled = ativar;
            pnlResponder.Enabled = ativar;
            if (ativar)
            {
                lblResponder.ForeColor = Color.White;
            }
            else
            {
                lblResponder.ForeColor = Color.DarkGray;
            }
        }

        private void pnlResponder_Paint(object sender, PaintEventArgs e)
        {

        }
    }
}
