using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;

namespace MathQuiz.Graph
{
    public class CoordSystem
    {
        public List<Function> functions;
        public bool plotNumbers = true;
        public bool plotNumberLines = true;

        public CoordSystem()
        {
            functions = new List<Function>();
        }

        public void Draw(Graphics g, int pixelBounds)
        {
            Pen pen = new Pen(Color.Black, -1);
            Font font = new Font(FontFamily.GenericMonospace, 0.45f);
            g.DrawLine(pen, new Point(0 - pixelBounds, 0), new Point(0 + pixelBounds, 0));
            g.DrawLine(pen, new Point(0, 0 - pixelBounds), new Point(0, 0 + pixelBounds));
            for (int x = -50; x <= 50; x++)
            {
                if (plotNumbers)
                {
                    g.DrawString(x.ToString(), font, pen.Brush, new Point(x, 0));
                }
                if (plotNumberLines)
                {
                    g.DrawLine(pen, new PointF(x, 0.2f), new PointF(x, 0));
                }
            }
            for (int y = -50; y <= 50; y++)
            {
                if (y != 0)
                {
                    if (y < 0)
                    {
                        if (plotNumbers)
                        {
                            g.DrawString(y.ToString(), font, pen.Brush, new FlippedPointF(0, (y + 0.5f)).toPoint());
                        }
                    }
                    else
                    {
                        if (plotNumbers)
                        {
                            g.DrawString(" " + y.ToString(), font, pen.Brush, new FlippedPointF(0, (y + 0.5f)).toPoint());
                        }
                    }
                    if (plotNumberLines)
                    {
                        g.DrawLine(pen, new PointF(0.2f, y), new PointF(0, y));
                    }
                }
            }

            foreach (Function f in functions)
            {
                f.Draw(g);
            }
        }

        public void addFunction(Function f)
        {
            functions.Add(f);
        }

        public void removeFunction(Function f)
        {
            functions.Remove(f);
        }
    }
}
