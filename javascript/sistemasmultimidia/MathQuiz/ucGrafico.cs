using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing.Drawing2D;
using MathQuiz.Graph;

namespace MathQuiz
{
    public partial class ucGrafico : UserControl
    {
        static int size = 733;
        static int sizeHalf = (int)(size / 2);
        Graphics g;
        CoordSystem csys = new CoordSystem();
        Matrix translation;
        public string Equacao { get; set; }

        public ucGrafico()
        {
            InitializeComponent();
        }

        public void AtualizarFuncao(string equacao)
        {
            Equacao = equacao;
            if (g == null)
            {
                g = this.CreateGraphics();
                g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;
                g.CompositingQuality = CompositingQuality.GammaCorrected;
                translation = new Matrix();
                translation.Translate(sizeHalf, sizeHalf);
                translation.Scale(22, 22);
                g.Transform = translation;
            }

            var f = new Function(equacao);
            csys.functions.Clear();
            csys.addFunction(f);

            g.Clear(Color.White);
            csys.Draw(g, sizeHalf);
        }
    }
}
