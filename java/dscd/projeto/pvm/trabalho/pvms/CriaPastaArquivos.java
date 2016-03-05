package br.com.ahe.dscd.projeto.pvm.trabalho.pvms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import br.com.ahe.dscd.deamon.jpvmBuffer;
import br.com.ahe.dscd.deamon.jpvmEnvironment;
import br.com.ahe.dscd.deamon.jpvmException;
import br.com.ahe.dscd.deamon.jpvmMessage;
import br.com.ahe.dscd.deamon.jpvmTaskId;

public class CriaPastaArquivos {

	public static void main(String[] args) {

		try {
			jpvmEnvironment jpvm = new jpvmEnvironment();
			jpvmTaskId parent = jpvm.pvm_parent();
			jpvmMessage message = jpvm.pvm_recv();
			String file = criaPastasEArquivos(message);
			jpvmBuffer buf = new jpvmBuffer();
			int tag = 0;
			if(file.compareTo("erro") == 0){
				tag = 1;
			}
			jpvm.pvm_send(buf, parent, tag );
			jpvm.pvm_exit();
		} 
		catch (jpvmException jpe) {
			System.out.println("Error - jpvm exception");
		} 
	}

	private static String criaPastasEArquivos(jpvmMessage message) throws jpvmException {
		try {
			String[] reacao = message.buffer.upkstr().split("#");
			String nomeAcido = reacao[0].replaceAll("\\r", "");
			String moleculaAcido = reacao[1].replaceAll("\\r", "");
			String nomeBase = reacao[2].replaceAll("\\r", "");
			String moleculaBase = reacao[3].replaceAll("\\r", "");
			String nomeAgua = reacao[4].replaceAll("\\r", "");
			String moleculaAgua = reacao[5].replaceAll("\\r", "");
			String nomeSal = reacao[6].replaceAll("\\r", "");
			String moleculaSal = reacao[7].replaceAll("\\r", "");
			String nomePasta = ""+message.messageTag;


			File diretrio = new File("c:\\temp\\"+nomePasta);

			if(diretrio.exists()){
				diretrio.delete();
			}
			diretrio.mkdir();

			criaFile("acido", nomeAcido, moleculaAcido, diretrio);
			criaFile("base", nomeBase, moleculaBase, diretrio);
			criaFile("agua", nomeAgua, moleculaAgua, diretrio);
			criaFile("sal", nomeSal, moleculaSal, diretrio);
			return diretrio.getAbsolutePath();
		} catch (IOException e) {
			return "erro";
		} catch (Exception e) {
			return "erro";
		}

	}

	private static void criaFile(String tipo, String nome, String molecula, File diretrio) throws IOException {
		File file = new File(diretrio.getAbsolutePath()+"\\"+tipo+".txt");
		if(file.exists()){
			file.delete();
		}
		file.createNewFile();	
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(tipo + " " + nome + " " + molecula);
		bw.close();
	}
}