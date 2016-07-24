using MathQuiz.Classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MathQuiz.Common
{
    public abstract class Persistent<T>
    {
        public int Codigo { get; set; }
        
        public Persistent()
        {
            Codigo = 0;
        }

        public void Salvar()
        {
            if (Codigo == 0)
            {
                if (this.GetType() == typeof(Jogador))
                    Codigo = DBApplication.Jogadores.Count() + 1;
                else if (this.GetType() == typeof(Questao))
                    Codigo = DBApplication.Questoes.Count() + 1;
            }
            DBApplication.Salvar(this);
        }

        public override int GetHashCode()
        {
            return Codigo;
        }
    }
}
