using CustomControl.OrientAbleTextControls;
using System;
using System.Threading.Tasks;
using System.Windows.Forms;
namespace MathQuiz
{
    partial class ucPergunta
    {
        /// <summary> 
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.pnlJogador = new System.Windows.Forms.Panel();
            this.panel7 = new System.Windows.Forms.Panel();
            this.lblNomeJogador = new CustomControl.OrientAbleTextControls.OrientedTextLabel();
            this.pnlResponder = new System.Windows.Forms.Panel();
            this.lblResponder = new CustomControl.OrientAbleTextControls.OrientedTextLabel();
            this.lblPergunta = new CustomControl.OrientAbleTextControls.OrientedTextLabel();
            this.lblCronometro = new CustomControl.OrientAbleTextControls.OrientedTextLabel();
            this.pnlPergunta = new System.Windows.Forms.Panel();
            this.panel5 = new System.Windows.Forms.Panel();
            this.panel4 = new System.Windows.Forms.Panel();
            this.pnlAlternativas = new System.Windows.Forms.Panel();
            this.edtLog = new System.Windows.Forms.TextBox();
            this.pnlJogador.SuspendLayout();
            this.panel7.SuspendLayout();
            this.pnlResponder.SuspendLayout();
            this.pnlPergunta.SuspendLayout();
            this.panel5.SuspendLayout();
            this.panel4.SuspendLayout();
            this.pnlAlternativas.SuspendLayout();
            this.SuspendLayout();
            // 
            // pnlJogador
            // 
            this.pnlJogador.Controls.Add(this.panel7);
            this.pnlJogador.Controls.Add(this.pnlResponder);
            this.pnlJogador.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.pnlJogador.Location = new System.Drawing.Point(0, 199);
            this.pnlJogador.Name = "pnlJogador";
            this.pnlJogador.Size = new System.Drawing.Size(359, 37);
            this.pnlJogador.TabIndex = 0;
            // 
            // panel7
            // 
            this.panel7.Controls.Add(this.lblNomeJogador);
            this.panel7.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel7.Location = new System.Drawing.Point(0, 0);
            this.panel7.Name = "panel7";
            this.panel7.Size = new System.Drawing.Size(271, 37);
            this.panel7.TabIndex = 3;
            // 
            // lblNomeJogador
            // 
            this.lblNomeJogador.AutoSize = true;
            this.lblNomeJogador.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblNomeJogador.ForeColor = System.Drawing.SystemColors.Control;
            this.lblNomeJogador.Location = new System.Drawing.Point(12, 7);
            this.lblNomeJogador.Margin = new System.Windows.Forms.Padding(0);
            this.lblNomeJogador.Name = "lblNomeJogador";
            this.lblNomeJogador.RotationAngle = 0D;
            this.lblNomeJogador.Size = new System.Drawing.Size(74, 20);
            this.lblNomeJogador.TabIndex = 1;
            this.lblNomeJogador.Text = "Jogador";
            this.lblNomeJogador.TextDirection = CustomControl.OrientAbleTextControls.Direction.Clockwise;
            this.lblNomeJogador.TextOrientation = CustomControl.OrientAbleTextControls.Orientation.Rotate;
            // 
            // pnlResponder
            // 
            this.pnlResponder.Controls.Add(this.lblResponder);
            this.pnlResponder.Dock = System.Windows.Forms.DockStyle.Right;
            this.pnlResponder.Location = new System.Drawing.Point(271, 0);
            this.pnlResponder.Name = "pnlResponder";
            this.pnlResponder.Size = new System.Drawing.Size(88, 37);
            this.pnlResponder.TabIndex = 2;
            this.pnlResponder.Click += new System.EventHandler(this.btnResponder_Click);
            this.pnlResponder.Paint += new System.Windows.Forms.PaintEventHandler(this.pnlResponder_Paint);
            // 
            // lblResponder
            // 
            this.lblResponder.AutoSize = true;
            this.lblResponder.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblResponder.ForeColor = System.Drawing.SystemColors.Control;
            this.lblResponder.Location = new System.Drawing.Point(1, 9);
            this.lblResponder.Name = "lblResponder";
            this.lblResponder.RotationAngle = 0D;
            this.lblResponder.Size = new System.Drawing.Size(90, 18);
            this.lblResponder.TabIndex = 1;
            this.lblResponder.Text = "Responder";
            this.lblResponder.TextDirection = CustomControl.OrientAbleTextControls.Direction.Clockwise;
            this.lblResponder.TextOrientation = CustomControl.OrientAbleTextControls.Orientation.Rotate;
            this.lblResponder.Click += new System.EventHandler(this.btnResponder_Click);
            // 
            // lblPergunta
            // 
            this.lblPergunta.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lblPergunta.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPergunta.ForeColor = System.Drawing.SystemColors.Control;
            this.lblPergunta.Location = new System.Drawing.Point(0, 0);
            this.lblPergunta.Name = "lblPergunta";
            this.lblPergunta.RotationAngle = 0D;
            this.lblPergunta.Size = new System.Drawing.Size(300, 51);
            this.lblPergunta.TabIndex = 0;
            this.lblPergunta.Text = "Quem era o apresentador que reprovada os calouros tocando uma buzina?";
            this.lblPergunta.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.lblPergunta.TextDirection = CustomControl.OrientAbleTextControls.Direction.Clockwise;
            this.lblPergunta.TextOrientation = CustomControl.OrientAbleTextControls.Orientation.Rotate;
            // 
            // lblCronometro
            // 
            this.lblCronometro.AutoSize = true;
            this.lblCronometro.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblCronometro.ForeColor = System.Drawing.SystemColors.Control;
            this.lblCronometro.Location = new System.Drawing.Point(3, 15);
            this.lblCronometro.Name = "lblCronometro";
            this.lblCronometro.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.lblCronometro.RotationAngle = 0D;
            this.lblCronometro.Size = new System.Drawing.Size(54, 20);
            this.lblCronometro.TabIndex = 1;
            this.lblCronometro.Text = "00:00";
            this.lblCronometro.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            this.lblCronometro.TextDirection = CustomControl.OrientAbleTextControls.Direction.Clockwise;
            this.lblCronometro.TextOrientation = CustomControl.OrientAbleTextControls.Orientation.Rotate;
            // 
            // pnlPergunta
            // 
            this.pnlPergunta.BackColor = System.Drawing.SystemColors.Highlight;
            this.pnlPergunta.Controls.Add(this.panel5);
            this.pnlPergunta.Controls.Add(this.panel4);
            this.pnlPergunta.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlPergunta.Location = new System.Drawing.Point(0, 0);
            this.pnlPergunta.Name = "pnlPergunta";
            this.pnlPergunta.Size = new System.Drawing.Size(359, 51);
            this.pnlPergunta.TabIndex = 1;
            // 
            // panel5
            // 
            this.panel5.Controls.Add(this.lblPergunta);
            this.panel5.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel5.Location = new System.Drawing.Point(0, 0);
            this.panel5.Name = "panel5";
            this.panel5.Size = new System.Drawing.Size(300, 51);
            this.panel5.TabIndex = 3;
            // 
            // panel4
            // 
            this.panel4.Controls.Add(this.lblCronometro);
            this.panel4.Dock = System.Windows.Forms.DockStyle.Right;
            this.panel4.Location = new System.Drawing.Point(300, 0);
            this.panel4.Name = "panel4";
            this.panel4.Size = new System.Drawing.Size(59, 51);
            this.panel4.TabIndex = 2;
            // 
            // pnlAlternativas
            // 
            this.pnlAlternativas.Controls.Add(this.edtLog);
            this.pnlAlternativas.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pnlAlternativas.Location = new System.Drawing.Point(0, 51);
            this.pnlAlternativas.Name = "pnlAlternativas";
            this.pnlAlternativas.Size = new System.Drawing.Size(359, 148);
            this.pnlAlternativas.TabIndex = 0;
            // 
            // edtLog
            // 
            this.edtLog.Location = new System.Drawing.Point(3, 6);
            this.edtLog.Multiline = true;
            this.edtLog.Name = "edtLog";
            this.edtLog.Size = new System.Drawing.Size(335, 116);
            this.edtLog.TabIndex = 0;
            // 
            // ucPergunta
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.HotTrack;
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Controls.Add(this.pnlAlternativas);
            this.Controls.Add(this.pnlPergunta);
            this.Controls.Add(this.pnlJogador);
            this.Name = "ucPergunta";
            this.Size = new System.Drawing.Size(359, 236);
            this.pnlJogador.ResumeLayout(false);
            this.panel7.ResumeLayout(false);
            this.panel7.PerformLayout();
            this.pnlResponder.ResumeLayout(false);
            this.pnlResponder.PerformLayout();
            this.pnlPergunta.ResumeLayout(false);
            this.panel5.ResumeLayout(false);
            this.panel4.ResumeLayout(false);
            this.panel4.PerformLayout();
            this.pnlAlternativas.ResumeLayout(false);
            this.pnlAlternativas.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel pnlJogador;
        private System.Windows.Forms.Panel pnlPergunta;
        private OrientedTextLabel lblPergunta;
        private System.Windows.Forms.Panel pnlAlternativas;
        private OrientedTextLabel lblNomeJogador;
        private OrientedTextLabel lblCronometro;
        private System.Windows.Forms.Panel panel5;
        private System.Windows.Forms.Panel panel4;
        private System.Windows.Forms.Panel panel7;
        private System.Windows.Forms.Panel pnlResponder;
        private System.Windows.Forms.TextBox edtLog;
        private OrientedTextLabel lblResponder;
    }
}
