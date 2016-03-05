package br.com.ahe.dscd.projeto.thread.utils;

import java.util.List;

import utils.AListUtils;
import utils.ANumberUtils;
import br.com.ahe.dscd.projeto.omp.quimica.ReacaoQuimica2;
import br.com.ahe.dscd.projeto.thread.quimica.atomo.Atomo;
import br.com.ahe.dscd.projeto.thread.quimica.atomo.AtomoNaoEncontradoException;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.Molecula;
import br.com.ahe.dscd.projeto.thread.quimica.molecula.MoleculaInvalidaException;

public class AQuimicaUtils {
	
	public static Atomo getFirstAtomoFromList(List<Atomo> atomos, String siglaAtomo) throws AtomoNaoEncontradoException {
		for (Atomo atomo : atomos) {
			if (isAtomoFromTipe(atomo, siglaAtomo)) {
				return atomo;
			}
		}
		throw new AtomoNaoEncontradoException("Nenhum Atomo de Hidrogenio Encontrado");		
	}
	
	public static boolean isAtomoFromTipe(Atomo atomo, String tipe) {
		return atomo.getSigla().equals(tipe);
	}

	public static Atomo getProximoAtomoFromList(List<Atomo> atomos) {
		Integer numeroRandom = ANumberUtils.getRandomNumberWithMaxNumber(atomos.size());
		return atomos.get(numeroRandom);
	}
	
	public static boolean hasOxigenio(Molecula molecula) {
		for (Atomo atomo : molecula.getAtomos()) {
			if(atomo.getSigla().equals("0")){
				return true;
			}
		}
		return false;
	}

	public static boolean isMoleculaAcido(Molecula molecula) {
		Atomo firstAtomo = AListUtils.getFirstObjectFromList(molecula.getAtomos());
		return isAtomoFromTipe(firstAtomo, "H");					
	}
	
	public static boolean isMoleculaBase(Molecula molecula) {
		Atomo firstAtomo = AListUtils.getLastObjectFromList(molecula.getAtomos());
		return isAtomoFromTipe(firstAtomo, "OH");					
	}

	public static ETipoAcido getTipoAcido(Molecula molecula) {
		for (Atomo atomo : molecula.getAtomos()) {
			if(isAtomoFromTipe(atomo, "O")){
				return ETipoAcido.OXIACIDO;
			}
		}
		return ETipoAcido.HIDRACIDO;
	}
	
	public static void validaMolecula(Molecula molecula) throws MoleculaInvalidaException {
		if(molecula.getSilgas().equals("HOH") ){
			throw new MoleculaInvalidaException("Molecula de Agua Encontrada!");
		}
		if(molecula.getNox().compareTo(0) != 0){
			throw new MoleculaInvalidaException("Molecula com Nox Invalido");
		}
	}

	public static boolean hasAcidoAtList(List<Molecula> moleculas) {
		for (Molecula molecula : moleculas) {
			if(isMoleculaAcido(molecula)){
				return true;
			}
		}
		return false;
	}

	public static boolean hasBaseAtList(List<Molecula> moleculas) {
		for (Molecula molecula : moleculas) {
			if(isMoleculaBase(molecula)){
				return true;
			}
		}
		return false;
	}

	public static Molecula getRandomMoleculaFromList(List<Molecula> acidos) {
		return AListUtils.getRandomElementFromList(acidos);
	}
	
	public static boolean isAtomoHidrogenio(Atomo atomo) {
		return isAtomoFromTipe(atomo, "H");
	}
	
	public static boolean isAtomoOxigenio(Atomo atomo) {
		return isAtomoFromTipe(atomo, "O");
	}
	
	public static boolean isMoleculaAgua(Molecula agua) {
		return agua.getSilgas().equals("OHH");
	
	}
	
	public static Molecula getMoleculaAgua(List<Molecula> moleculasResultantes) {
		Molecula agua = new Molecula();
		agua.setNome("Agua");
		for (Molecula molecula : moleculasResultantes) {
			for (int i = 0; i < 3; i++) {
				agua.addAtomoFirst(AListUtils.getObjectFromList(molecula.getAtomos(), i));
			}
		}
		return agua;
	}

	public static Molecula getMoleculaSal(List<Molecula> moleculasResultantes) {
		Molecula agua = new Molecula();
		for (Molecula molecula : moleculasResultantes) {
			for (int i = 3; i < molecula.getAtomos().size(); i++) {
				agua.addAtomoFirst(AListUtils.getObjectFromList(molecula.getAtomos(), i));
			}
		}
		return agua;
	}

	public static ReacaoQuimica2 classificaAcidoPorGrauDissociacaoIonica(ReacaoQuimica2 reacao) {
		Molecula acido = reacao.getAcido();
		if(getDissociacaoIonica(acido) > 1 ){
			acido.setClassificacao("Forte");
		} else if(getDissociacaoIonica(acido) == 1 ){
			acido.setClassificacao("Medio");
		} else {
			acido.setClassificacao("Fraco");
		}
		reacao.setAcido(acido);
		return reacao;
	}

	private static int getDissociacaoIonica(Molecula mol) {
		return getQtdOxigenios(mol) - getQtdHidroxegios(mol);
		
	}

	private static int getQtdOxigenios(Molecula mol) {
		int qtdOxi = 0;
		for (Atomo atomo : mol.getAtomos()) {
			if(isAtomoOxigenio(atomo)){
				qtdOxi++;
			}
		}
		return qtdOxi;
	}

	private static int getQtdHidroxegios(Molecula mol) {
		int qtdHidro = 0;
		for (Atomo atomo : mol.getAtomos()) {
			if(isAtomoHidrogenio(atomo)){
				qtdHidro++;
			}
		}
		return qtdHidro;
	}

	public static ReacaoQuimica2 classificaBasePorGrauDissociacaoIonica(ReacaoQuimica2 reacao) {
		Molecula base = reacao.getBase();
		if(getDissociacaoIonica(base) > 1 ){
			base.setClassificacao("Forte");
		} else if(getDissociacaoIonica(base) == 1 ){
			base.setClassificacao("Medio");
		} else {
			base.setClassificacao("Fraco");
		}
		reacao.setBase(base);
		return reacao;
	}

	public static ReacaoQuimica2 classificaBasePorOH(ReacaoQuimica2 reacao) {
		Molecula sal = reacao.getSal();
		if(isMoleculaPossuiOxigenio(sal)){
			sal.setClassificacao("Oxissais");
		} else {
			sal.setClassificacao("Hal�ides");
		}
		reacao.setSal(sal);
		return reacao;
	}

	private static boolean isMoleculaPossuiOxigenio(Molecula mol) {
		for (Atomo atomo : mol.getAtomos()) {
			if(isAtomoOxigenio(atomo)){
				return true;
			}
		}
		return false;
	}
	
	

}
