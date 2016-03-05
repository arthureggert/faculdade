package br.com.ahe.poo.um.lista.um.exercicio.exercicio1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImpostoRenda {
		
	private double getAliquota(Pessoa contribuinte){
		double aliq = 0.00d;
		if(contribuinte.getRendaAnual().compareTo(new BigDecimal("4001")) > 0 && contribuinte.getRendaAnual().compareTo(new BigDecimal("9000")) < 0){
			aliq = 5.8d;
		}
		if(contribuinte.getRendaAnual().compareTo(new BigDecimal("9001")) > 0 && contribuinte.getRendaAnual().compareTo(new BigDecimal("25000")) < 0){
			aliq = 15d;
		}
		if(contribuinte.getRendaAnual().compareTo(new BigDecimal("25001")) > 0 && contribuinte.getRendaAnual().compareTo(new BigDecimal("35000")) < 0){
			aliq = 27.5d;
		}
		if(contribuinte.getRendaAnual().compareTo(new BigDecimal("35001")) > 0 ){
			aliq = 30d;
		}
		return aliq;
	}
	
	public BigDecimal calculaImposto(Pessoa contribuinte) {
		BigDecimal rendaAnual = contribuinte.getRendaAnual();
		BigDecimal aliquota = new BigDecimal(this.getAliquota(contribuinte)).divide(new BigDecimal(100));
		BigDecimal tmp = rendaAnual.multiply(aliquota).setScale(0, RoundingMode.HALF_EVEN);
		return tmp;
	}
	
	
}
