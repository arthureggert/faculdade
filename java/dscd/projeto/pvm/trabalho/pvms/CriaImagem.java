package br.com.ahe.dscd.projeto.pvm.trabalho.pvms;

import java.io.File;
import java.io.IOException;

import br.com.ahe.dscd.deamon.jpvmBuffer;
import br.com.ahe.dscd.deamon.jpvmEnvironment;
import br.com.ahe.dscd.deamon.jpvmException;
import br.com.ahe.dscd.deamon.jpvmMessage;
import br.com.ahe.dscd.deamon.jpvmTaskId;
import br.com.ahe.dscd.projeto.pvm.trabalho.quimica.ReacaoToIAtomBuilder;

public class CriaImagem {

	public static void main(String[] args) {

		try {
			jpvmEnvironment jpvm = new jpvmEnvironment();
			jpvmTaskId parent = jpvm.pvm_parent();
			jpvmMessage message = jpvm.pvm_recv();
			createAtomContainer(message);
			jpvmBuffer buf = new jpvmBuffer();
			buf.pack("imagens criadas");
			jpvm.pvm_send(buf, parent, 0);
			jpvm.pvm_exit();
		} 
		catch (jpvmException jpe) {
			System.out.println("Error - jpvm exception");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createAtomContainer(jpvmMessage message) throws jpvmException, IOException {
		String[] reacao = message.buffer.upkstr().split("#");
		getReacaoQuimicaFromString(reacao,message);

	}

	private static void getReacaoQuimicaFromString(String[] reacao, jpvmMessage message) throws IOException {
		String nomeAcido = reacao[0].replaceAll("\\r", "");
		String moleculaAcido = reacao[1].replaceAll("\\r", "");
		String nomeBase = reacao[0].replaceAll("\\r", "");
		String moleculaBase = reacao[0].replaceAll("\\r", "");
		String nomeAgua = reacao[0].replaceAll("\\r", "");
		String moleculaAgua = reacao[0].replaceAll("\\r", "");
		String nomeSal = reacao[0].replaceAll("\\r", "");
		String moleculaSal = reacao[0].replaceAll("\\r", "");
		String nomePasta = ""+message.messageTag;

		File diretrio = new File("c:\\temp\\"+nomePasta);

		criaImagem("acido", nomeAcido, moleculaAcido, diretrio);
		criaImagem("base", nomeBase, moleculaBase, diretrio);
		criaImagem("agua", nomeAgua, moleculaAgua, diretrio);
		criaImagem("sal", nomeSal, moleculaSal, diretrio);


	}

	@SuppressWarnings("unused")
	private static void criaImagem(String tipo, String nome, String molecula, File diretrio) throws IOException {
		ReacaoToIAtomBuilder builder = new ReacaoToIAtomBuilder();
		//builder.criaMolecula(tipo, nome, molecula, diretrio);
	}



}
