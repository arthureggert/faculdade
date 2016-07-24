using MathQuiz.Common;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MathQuiz.Classes
{
    public enum TipoQuestao
    {
        Funcao, Grafico
    }
    public class Questao : Persistent<Questao>
    {
        public string Pergunta { get; set; }
        public string Resposta { get; set; }
        public TipoQuestao Tipo { get; set; }
        public List<string> Respostas { get; set; }

        public Questao() : base()
        {
            Pergunta = string.Empty;
            Respostas = new List<string>();
            Tipo = TipoQuestao.Funcao;
        }

        public override string ToString()
        {
            return Pergunta;
        }

        public object[] ToGridRow()
        {
            return new object[] { this, Codigo, Tipo.ToString(), Pergunta };
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }
}
