using MathQuiz.Common;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Serialization;

namespace MathQuiz.Classes
{
    public class Jogador : Persistent<Jogador>
    {
        public string Nome { get; set; }

        public Jogador() : base()
        {
            Nome = string.Empty;
            //Codigo = DBApplication.Jogadores.Count() + 1;
        }

        public object[] ToGridRow()
        {
            return new object[] { this, Codigo, Nome };
        }
    }
}
