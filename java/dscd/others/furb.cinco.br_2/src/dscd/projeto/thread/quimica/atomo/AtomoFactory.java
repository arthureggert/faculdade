package dscd.projeto.thread.quimica.atomo;

import java.util.List;
import java.util.Scanner;

import core.utils.AFileUtils;
import core.utils.AObjectUtils;

public class AtomoFactory {

	private static AtomoFactory instance;
	
	private static final String ARQUIVO = "resources/dados"; 
	
	private List<Atomo> atomos;
	
	public static AtomoFactory getInstance() {
		return AObjectUtils.isObjectNull(instance) ? new AtomoFactory() : instance;
	}
	
	private AtomoFactory() {
		Scanner scan = AFileUtils.getScannerFromFileWithSeparator(ARQUIVO, "\\n");
		AtomoReader reader = new AtomoReader(scan);
		atomos = reader.getElementos();
	}
	
	public List<Atomo> getAtomos() {
		return atomos;
	}

}
