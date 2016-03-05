package br.com.ahe.sd.trabalho.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class HistoricoTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private int qtdColunas;

    private String[] nomeColunas;

    private List<Object> dados;

    public HistoricoTableModel() {
        this.qtdColunas = 3;
        this.dados = new ArrayList<>();
        this.nomeColunas = new String[this.qtdColunas];
        this.nomeColunas[0] = "Dia";
        this.nomeColunas[1] = "Hora";
        this.nomeColunas[2] = "Descrição";
    }

    @Override
    public int getRowCount() {
        return this.dados.size();
    }

    @Override
    public int getColumnCount() {
        return this.nomeColunas.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return this.nomeColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public void setDados(List<Object> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public void addDado(Object dado) {
        this.dados.add(dado);
        fireTableRowsInserted(this.dados.size() - 1, this.dados.size() - 1);
    }
    public void limpaTabela() {
        int size = getRowCount();
        this.dados.clear();
        fireTableRowsDeleted(0,size);
    }

}
