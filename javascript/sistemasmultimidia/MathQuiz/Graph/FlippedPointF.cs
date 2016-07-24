using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;

namespace MathQuiz.Graph
{
    public class FlippedPointF
    {
        public float X { get; set; }
        public float Y { get; set; }

        public FlippedPointF(float x, float y)
        {
            this.X = x;
            this.Y = y;
        }

        public PointF toPoint()
        {
            return new PointF(this.X, -this.Y);
        }
    }
}
