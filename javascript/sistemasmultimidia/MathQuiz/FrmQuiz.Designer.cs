namespace MathQuiz
{
    partial class FrmQuiz
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

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.fpnlSuperior = new System.Windows.Forms.FlowLayoutPanel();
            this.fpnlInferior = new System.Windows.Forms.FlowLayoutPanel();
            this.tableLayoutPanel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.BackColor = System.Drawing.SystemColors.HotTrack;
            this.tableLayoutPanel1.ColumnCount = 1;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Controls.Add(this.fpnlSuperior, 0, 0);
            this.tableLayoutPanel1.Controls.Add(this.fpnlInferior, 0, 1);
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel1.Margin = new System.Windows.Forms.Padding(0);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 2;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(1329, 615);
            this.tableLayoutPanel1.TabIndex = 1;
            // 
            // fpnlSuperior
            // 
            this.fpnlSuperior.BackColor = System.Drawing.SystemColors.HotTrack;
            this.fpnlSuperior.Dock = System.Windows.Forms.DockStyle.Fill;
            this.fpnlSuperior.Location = new System.Drawing.Point(0, 0);
            this.fpnlSuperior.Margin = new System.Windows.Forms.Padding(0);
            this.fpnlSuperior.Name = "fpnlSuperior";
            this.fpnlSuperior.Size = new System.Drawing.Size(1329, 307);
            this.fpnlSuperior.TabIndex = 0;
            // 
            // fpnlInferior
            // 
            this.fpnlInferior.BackColor = System.Drawing.SystemColors.HotTrack;
            this.fpnlInferior.Dock = System.Windows.Forms.DockStyle.Fill;
            this.fpnlInferior.Location = new System.Drawing.Point(0, 307);
            this.fpnlInferior.Margin = new System.Windows.Forms.Padding(0);
            this.fpnlInferior.Name = "fpnlInferior";
            this.fpnlInferior.Size = new System.Drawing.Size(1329, 308);
            this.fpnlInferior.TabIndex = 1;
            // 
            // FrmQuiz
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.HotTrack;
            this.ClientSize = new System.Drawing.Size(1329, 615);
            this.Controls.Add(this.tableLayoutPanel1);
            this.MinimizeBox = false;
            this.Name = "FrmQuiz";
            this.ShowIcon = false;
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Math Quiz";
            this.Load += new System.EventHandler(this.FrmQuiz_Load);
            this.KeyDown += new System.Windows.Forms.KeyEventHandler(this.FrmQuiz_KeyDown);
            this.tableLayoutPanel1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TableLayoutPanel tableLayoutPanel1;
        private System.Windows.Forms.FlowLayoutPanel fpnlSuperior;
        private System.Windows.Forms.FlowLayoutPanel fpnlInferior;

    }
}