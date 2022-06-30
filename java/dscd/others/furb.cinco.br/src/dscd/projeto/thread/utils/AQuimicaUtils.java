package dscd.projeto.thread.utils;

import java.util.List;

import core.utils.AListUtils;
import core.utils.ANumberUtils;
import dscd.projeto.thread.quimica.atomo.Atomo;
import dscd.projeto.thread.quimica.atomo.AtomoNaoEncontradoException;
import dscd.projeto.thread.quimica.molecula.Molecula;
import dscd.projeto.thread.quimica.molecula.MoleculaInvalidaException;

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

}
