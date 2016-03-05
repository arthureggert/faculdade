package br.com.ahe.poo.dois.prova.automovel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class AutomovelDAOTexto extends AutomovelDAO {

    public AutomovelDAOTexto(File arquivo) {
        super(arquivo);
    }

    @Override
    public void gravar(ArrayList<Automovel> listaDeAutomoveis) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(getArquivo());
            for (Automovel auto : listaDeAutomoveis) {
                out.print("#"+auto.getRenavan() +"#"+ auto.getProprietario() +"#"+ auto.getPlaca() +"#"+
                			auto.getMarca() +"#"+ auto.getModelo() +"#"+ auto.getAno() +"#"+ auto.getEstado() +"#"+ 
                			auto.getCombustivel());
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    @Override
    public ArrayList<Automovel> ler() throws IOException, ClassNotFoundException {
        Scanner scan = null;
        ArrayList<Automovel> listaDeAutomoveis = new ArrayList<Automovel>();
        
        try {
            scan = new Scanner(getArquivo());
            scan.useDelimiter("#");
            
            while (scan.hasNext()) {
            	int renavan = Integer.parseInt(scan.next());
            	String proprietario = scan.next();
            	String placa = scan.next();
            	String marca = scan.next();
            	String modelo = scan.next();
            	int ano = Integer.parseInt(scan.next());
            	String estado = scan.next();
            	String combustivel = scan.next();
           
            	Automovel auto = new Automovel();
            	
            	auto.setRenavan(renavan);
            	auto.setProprietario(proprietario);
            	auto.setPlaca(placa);
            	auto.setMarca(marca);
            	auto.setModelo(modelo);
            	auto.setAno(ano);
            	auto.setEstado(estado);
            	auto.setCombustivel(combustivel);
            	
            	listaDeAutomoveis.add(auto);
            }
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return listaDeAutomoveis;
    }
}
