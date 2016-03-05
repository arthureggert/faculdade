package br.com.ahe.dscd.projeto.thread.geradados;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import utils.AFileUtils;
import utils.ANumberUtils;

public class GeraDadosEntrada {

	public void geraDados(List<String> dados, int qtdDados){
		BufferedWriter bufferedWriter = AFileUtils.getBufferedWriterFromFile("/home/arthur/dados");
		try {
			for (int i = 0; i < qtdDados; i++) {
				int maxNumero = dados.size();
				Integer numerToGet = ANumberUtils.getRandomNumberWithMaxNumber(maxNumero);
				String dadotoWrite = dados.get(numerToGet);
				bufferedWriter.write(dadotoWrite);
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
