package br.com.ahe.poo.dois.prova.automovel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class AutomovelModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private ArrayList<Automovel> listaDeAutomoveis = new ArrayList<Automovel>();
	private ArrayList<Automovel> listaDeAutomoveisPesquisa = new ArrayList<Automovel>();
	private int qtdColunas = 8;
	private String[] nomeColunas;
	
	public AutomovelModel() {
		this.nomeColunas = new String[this.qtdColunas];
        this.nomeColunas[0] = "Renavan";
        this.nomeColunas[1] = "Propriet�rio";
        this.nomeColunas[2] = "Placa";
        this.nomeColunas[3] = "Marca";
        this.nomeColunas[4] = "Modelo";
        this.nomeColunas[5] = "Ano";
        this.nomeColunas[6] = "Estado";
        this.nomeColunas[7] = "Combustivel";
	}
	
    public int getRowCount() {
        return this.listaDeAutomoveis.size();
    }

    public int getColumnCount() {
        return this.qtdColunas;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objAuto = null;
        Automovel auto = this.listaDeAutomoveis.get(rowIndex);
        
        switch (columnIndex) {
        case 0:
            objAuto = auto.getRenavan();
            break;
        case 1:
        	objAuto = auto.getProprietario();
            break;
        case 2:
            objAuto = auto.getPlaca();
            break;
        case 3:
        	objAuto = auto.getMarca();
        	break;
        case 4:
        	objAuto = auto.getModelo();
        	break;
        case 5:
        	objAuto = auto.getAno();
        	break;
        case 6:
        	objAuto = auto.getEstado();
        	break;
        case 7:
        	objAuto = auto.getCombustivel();
        	break;
        }
        return objAuto;
    }
    
    @Override
    public String getColumnName(int column) {
        return this.nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String valor = (String) aValue;
        Automovel objAuto = this.listaDeAutomoveis.get(rowIndex);
        
        switch (columnIndex) {
	        case 0:
			objAuto.setRenavan(Integer.parseInt(valor));
	            break;
	            
	        case 1:
			objAuto.setProprietario(valor);
	            break;
	            
	        case 2:
			objAuto.setPlaca(valor);
	            break;
	            
	        case 3:
			objAuto.setMarca(valor);
	        	break;
	        	
	        case 4:
			objAuto.setModelo(valor);
	        	break;
	        	
	        case 5:
			objAuto.setAno(Integer.parseInt(valor));
	        	break;
	        	
	        case 6:
			objAuto.setEstado(valor);
	        	break;
	        	
	        case 7:
			objAuto.setCombustivel(valor);
	        	break;
        }
    }

    public void addAutomovel(Automovel auto) {
    	this.listaDeAutomoveis.add(auto);
        fireTableRowsInserted(this.listaDeAutomoveis.size() - 1, this.listaDeAutomoveis.size() - 1);
    }

    public void addAutomovelPesquisa(Automovel auto) {
    	this.listaDeAutomoveisPesquisa.add(auto);
        fireTableRowsInserted(this.listaDeAutomoveisPesquisa.size() - 1, this.listaDeAutomoveisPesquisa.size() - 1);
    }

    public ArrayList<Automovel> getAutomoveis() {
        return this.listaDeAutomoveis;
    }

    public void setImoveis(ArrayList<Automovel> automoveis) {
        this.listaDeAutomoveis = automoveis;
        fireTableDataChanged();
    }

    public void removeAutomovel(int selectedRow) {
        this.listaDeAutomoveis.remove(selectedRow);
        fireTableRowsDeleted(selectedRow, selectedRow);
    }

	public void limpaTabela() {
	    int size = getRowCount();  
	    this.listaDeAutomoveisPesquisa.clear();  
	    fireTableRowsDeleted(0,size);
		
	}
	
	
}
