package br.com.ahe.poo.dois.prova.Imovel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ImovelPesquisaModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private ArrayList<Imovel> listaDeImoveis = new ArrayList<Imovel>();
	private int qtdColunas = 7;
	private String[] nomeColunas;
	
	public ImovelPesquisaModel() {
		this.nomeColunas = new String[this.qtdColunas];
        this.nomeColunas[0] = "Tipo";
        this.nomeColunas[1] = "Opera��o";
        this.nomeColunas[2] = "Endere�o";
        this.nomeColunas[3] = "Bairro";
        this.nomeColunas[4] = "Cidade";
        this.nomeColunas[5] = "Quartos";
        this.nomeColunas[6] = "Valor";
	}
	
	public int getRowCount() {
		return this.listaDeImoveis.size();
	}

	    public int getColumnCount() {
	        return this.qtdColunas;
	    }
	    
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        Object objImovel = null;
	        Imovel imovel = this.listaDeImoveis.get(rowIndex);
	        
	        switch (columnIndex) {
	        case 0:
	            objImovel = imovel.getTipo();
	            break;
	        case 1:
	        	objImovel = imovel.getOperacao();
	            break;
	        case 2:
	            objImovel = imovel.getNome();
	            break;
	        case 3:
	        	objImovel = imovel.getTelefone();
	        	break;
	        case 4:
	        	objImovel = imovel.getEndereco();
	        	break;
	        case 5:
	        	objImovel = imovel.getBairro();
	        	break;
	        case 6:
	        	objImovel = imovel.getCidade();
	        	break;
	        case 7:
	        	objImovel = imovel.getQtdComodos();
	        	break;
	        case 8:
	        	objImovel = imovel.getValor();
	        	break;
	        }
	        return objImovel;
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
	        Imovel objImovel = this.listaDeImoveis.get(rowIndex);
	        
	        switch (columnIndex) {
		        case 0:
		        	char chTipo = valor.charAt(1);
		        	System.out.println(chTipo);
				objImovel.setTipo(chTipo);
		            break;
		            
		        case 1:
		        	char chOperacao = valor.charAt(1);
				objImovel.setOperacao(chOperacao);
		            break;
		            
		        case 2:
				objImovel.setNome(valor);
		            break;
		            
		        case 3:
				objImovel.setTelefone(valor);
		        	break;
		        	
		        case 4:
				objImovel.setEndereco(valor);
		        	break;
		        	
		        case 5:
				objImovel.setBairro(valor);
		        	break;
		        	
		        case 6:
				objImovel.setCidade(valor);
		        	break;
		        	
		        case 7:
				objImovel.setQtdComodos(Integer.parseInt(valor));
		        	break;
		        	
		        case 8:
				try {
					objImovel.setValor(Double.parseDouble(valor));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
		        	break;
	        }
	    }

	    public void addImovel(Imovel imovel) {
	    	this.listaDeImoveis.add(imovel);
	        fireTableRowsInserted(this.listaDeImoveis.size() - 1, this.listaDeImoveis.size() - 1);
	    }

	    public ArrayList<Imovel> getImoveis() {
	        return this.listaDeImoveis;
	    }

	    public void setImoveis(ArrayList<Imovel> imoveis) {
	        this.listaDeImoveis = imoveis;
	        fireTableDataChanged();
	    }

	    public void removeImovel(int selectedRow) {
	        this.listaDeImoveis.remove(selectedRow);
	        fireTableRowsDeleted(selectedRow, selectedRow);
	    }

		public void limpaTabela() {  
		    int size = getRowCount();  
		    this.listaDeImoveis.clear();  
		    fireTableRowsDeleted(0,size);  
		}  
	
}
