using MathQuiz.Classes;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Web.Script.Serialization;
using System.Windows.Forms;

namespace MathQuiz.Common
{
    /// <summary>
    /// Classe estática acessada em todos formulários
    /// </summary>
    public class DBApplication
    {
        private static readonly string ArquivoQuestoes = "questoes.xml";
        private static readonly string ArquivoJogadores = "jogadores.xml";

        private static HashSet<Questao> _questoes;

        public static HashSet<Questao> Questoes
        {
            get 
            {
                if (_questoes == null)
                {
                    _questoes = Serializer.DeSerializeObject<HashSet<Questao>>(ArquivoQuestoes);
                    if (_questoes == null)
                        _questoes = new HashSet<Questao>();
                }

                return _questoes; 
            }
        }

        private static HashSet<Jogador> _jogadores;

        public static HashSet<Jogador> Jogadores
        {
            get 
            {
                if (_jogadores == null)
                {
                    _jogadores = Serializer.DeSerializeObject<HashSet<Jogador>>(ArquivoJogadores);
                    if (_jogadores == null)
                        _jogadores = new HashSet<Jogador>();
                }
                
                return _jogadores; 
            }
        }


        public static void PersistirDados()
        {
            Serializer.SerializeObject<HashSet<Questao>>(Questoes, ArquivoQuestoes);
            Serializer.SerializeObject<HashSet<Jogador>>(Jogadores, ArquivoJogadores);

            var jsonQuestoes = new JavaScriptSerializer().Serialize(Questoes);
            File.WriteAllText(@"D:\Google Drive\Faculdade\2015.2\Sistemas multimidia\MathQuiz\MathQuiz\web\questoes.txt", jsonQuestoes);

            var jsonJogadores = new JavaScriptSerializer().Serialize(Jogadores);
            File.WriteAllText(@"D:\Google Drive\Faculdade\2015.2\Sistemas multimidia\MathQuiz\MathQuiz\web\jogadores.txt", jsonJogadores);
        }

        public static void Salvar(object obj)
        {
            if (obj.GetType() == typeof(Jogador))
                Jogadores.Add(obj as Jogador);
            else if (obj.GetType() == typeof(Questao))
                Questoes.Add(obj as Questao);
        }

        public static void Remover(object obj)
        {
            if (obj.GetType() == typeof(Jogador))
                Jogadores.Remove(obj as Jogador);
            else if (obj.GetType() == typeof(Questao))
                Questoes.Remove(obj as Questao);
        }
    }
}
