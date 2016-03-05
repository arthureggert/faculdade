package br.com.ahe.sd.trabalho.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class CotacoesPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTable table;

    private CotacoesTableModel modelo;

    public CotacoesPanel() {
        this.modelo = new CotacoesTableModel();
        setLayout(null);
        JScrollPane scrollPanePrincipal = new JScrollPane();
        scrollPanePrincipal.setBounds(12, 12, 493, 183);
        add(scrollPanePrincipal);
        this.table = new JTable();
        scrollPanePrincipal.setViewportView(this.table);
        this.table.setBorder(new LineBorder(new Color(0, 0, 0)));
        this.table.setFillsViewportHeight(true);
        this.table.setColumnSelectionAllowed(true);
        this.table.setCellSelectionEnabled(true);
        this.table.setPreferredScrollableViewportSize(new Dimension(0,100));
        this.table.setModel(this.modelo);

    }
}
