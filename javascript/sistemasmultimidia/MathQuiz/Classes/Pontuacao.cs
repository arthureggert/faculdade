using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MathQuiz.Classes
{
    public struct RespostaQuestao
    {
        public Jogador Jogador { get; set; }
        public Questao Questao { get; set; }
        public DateTime DataHora { get; set; }
        public string Alternativa { get; set; }
    }

    public class Pontuacao
    {
        public HashSet<Jogador> Jogadores { get; private set; }
        public HashSet<Questao> Questoes { get; private set; }
        public List<RespostaQuestao> RespostasQuestoes { get; private set; }
        public Dictionary<Jogador, int> Resultado { get; private set; }

        public Pontuacao()
        {
            Resultado = new Dictionary<Jogador, int>();
            Jogadores = new HashSet<Jogador>();
            Questoes = new HashSet<Questao>();
            RespostasQuestoes = new List<RespostaQuestao>();
        }

        public void QuestaoRepondida(Jogador jogador, Questao questao, DateTime dataHora, string alternativa)
        {
            Jogadores.Add(jogador);
            Questoes.Add(questao);

            RespostasQuestoes.Add(new RespostaQuestao() { 
                Jogador = jogador, Questao = questao,
                DataHora = dataHora, Alternativa = alternativa
            });
        }

        public void Contabilizar()
        {
            // Inicializar pontuação para todos jogadores com 0
            Resultado = new Dictionary<Jogador, int>();
            foreach (var jogador in Jogadores)
                Resultado.Add(jogador, 0);

            int posicoesConsideradas = 3;
            foreach (var q in Questoes)
            {
                // Busca somente as respostas corretas da questão atual
                // Ordena pelo tempo de resposta e pega somente a quantidade de posições consideradas
                var respostasQuestao = RespostasQuestoes
                    .Where(rq => rq.Questao.Codigo == q.Codigo && rq.Questao.Pergunta.Equals(rq.Alternativa))
                    .OrderBy(rq => rq.DataHora).Take(posicoesConsideradas);

                int pontuacaoAtual = posicoesConsideradas;
                foreach (var resposta in respostasQuestao)
                {
                    Resultado[resposta.Jogador] += pontuacaoAtual;
                    pontuacaoAtual--;
                }
            }
        }
    }
}
