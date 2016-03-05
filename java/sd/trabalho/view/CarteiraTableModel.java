package br.com.ahe.sd.trabalho.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.ahe.sd.trabalho.model.MovimentacaoCarteira;

public class CarteiraTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private int qtdColunas;

    private String[] nomeColunas;

    private List<MovimentacaoCarteira> dados;

    public CarteiraTableModel() {
        this.qtdColunas = 5;
        this.dados = new ArrayList<>();
        this.nomeColunas = new String[this.qtdColunas];
        this.nomeColunas[0] = "Ativo";
        this.nomeColunas[1] = "Data Compra";
        this.nomeColunas[2] = "Qtde";
        this.nomeColunas[3] = "Valor Compra";
//        this.nomeColunas[4] = "Valor Atual";
        this.nomeColunas[4] = "Total Compra";
//        this.nomeColunas[6] = "Total Atual";
//        this.nomeColunas[7] = "Lucro/Prejuizo";
//        this.nomeColunas[8] = "%";
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

    public void setDados(List<MovimentacaoCarteira> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public void addDado(MovimentacaoCarteira dado) {
        this.dados.add(dado);
        fireTableRowsInserted(this.dados.size() - 1, this.dados.size() - 1);
    }
    public void limpaTabela() {
        int size = getRowCount();
        this.dados.clear();
        fireTableRowsDeleted(0,size);
    }

}
