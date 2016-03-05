package br.com.ahe.dscd.projeto.omp.quimica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import utils.AFileUtils;
import utils.AObjectUtils;
import br.com.ahe.dscd.projeto.thread.quimica.reacao.ReacaoQuimica;

public class ReacaoQuimicaFactory {

	private static ReacaoQuimicaFactory instance;
	
	private static final String ARQUIVO = "C:\\Users\\roa\\workspace\\git\\furb-all\\furb-all\\furb5\\src\\main\\resources\\omp\\saida"; 
	
	private List<ReacaoQuimica> reacoes;
	
	private Map<String, ReacaoQuimica> mapReacoes = new HashMap<String, ReacaoQuimica>();
	
	public static ReacaoQuimicaFactory getInstance() {
		return AObjectUtils.isObjectNull(instance) ? new ReacaoQuimicaFactory() : instance;
	}
	
	private ReacaoQuimicaFactory() {
		Scanner scan = AFileUtils.getScannerFromFileWithSeparator(ARQUIVO, "\\n");
		ReacaoQuimicaReader reader = new ReacaoQuimicaReader(scan);
		this.reacoes = reader.getReacoes();
	}
	
	public ReacaoQuimica[] getReacoes() {
		for (ReacaoQuimica reacao : this.reacoes) {
			if(!this.mapReacoes.containsKey(reacao.getResultos())){
				if(!reacao.getAcido().getNome().equalsIgnoreCase("Acido Litico")){
					this.mapReacoes.put(reacao.getResultos(), reacao);					
				}
			}
		}
		return new ArrayList<>(this.mapReacoes.values()).toArray(new ReacaoQuimica[this.mapReacoes.values().size()]);
	}

}
