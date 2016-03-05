package br.com.ahe.poo.dois.prova.Imovel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class ImovelDAOTexto extends ImovelDAO {

    public ImovelDAOTexto(File arquivo) {
        super(arquivo);
    }

    @Override
    public void gravar(ArrayList<Imovel> listaDeImoveis) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(getArquivo());
            for (Imovel imo : listaDeImoveis) {
                out.print(imo.getBairro() +"#"+ imo.getCidade() +"#"+ imo.getTipo() +"#"+
                			imo.getEndereco() +"#"+ imo.getNome() +"#"+ imo.getOperacao() +"#"+ imo.getQtdComodos() +"#"+ 
                			imo.getTelefone() +"#"+ imo.getValor());
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    @Override
    public ArrayList<Imovel> ler() throws IOException, ClassNotFoundException {
        Scanner scan = null;
        ArrayList<Imovel> listaDeImoveis = new ArrayList<Imovel>();
        
        try {
            scan = new Scanner(getArquivo());
            scan.useDelimiter("#");
            
            while (scan.hasNext()) {
            	String bairro = scan.next();
            	String cidade = scan.next();
            	String tipo = scan.next();
            	String endereco = scan.next();
            	String nome = scan.next();
            	String operacao = scan.next();
            	int comodos = scan.nextInt();
            	String telefone = scan.next();
            	double valor = Double.parseDouble(scan.next());
            	Imovel imo = new Imovel();
            	imo.setBairro(bairro);
            	imo.setCidade(cidade);
            	imo.setEndereco(endereco);
            	imo.setNome(nome);
            	imo.setOperacao(operacao.charAt(0));
            	imo.setQtdComodos(comodos);
            	imo.setTelefone(telefone);
            	imo.setTipo(tipo.charAt(0));
            	imo.setValor(valor);
            	listaDeImoveis.add(imo);
            }
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return listaDeImoveis;
    }
}
