package br.com.ahe.dscd.projeto.thread.quimica.atomo;

import java.util.List;
import java.util.Scanner;

import utils.AFileUtils;
import utils.AObjectUtils;

public class AtomoFactory {

	private static AtomoFactory instance;
	
	private static final String ARQUIVO = "C:\\Users\\roa\\workspace\\git\\furb-all\\furb-all\\furb5\\src\\main\\resources\\thread\\dados.txt"; 
	
	private List<Atomo> atomos;
	
	public static AtomoFactory getInstance() {
		return AObjectUtils.isObjectNull(instance) ? new AtomoFactory() : instance;
	}
	
	private AtomoFactory() {
		Scanner scan = AFileUtils.getScannerFromFileWithSeparator(ARQUIVO, "\\n");
		AtomoReader reader = new AtomoReader(scan);
		this.atomos = reader.getElementos();
	}
	
	public List<Atomo> getAtomos() {
		return this.atomos;
	}

}
