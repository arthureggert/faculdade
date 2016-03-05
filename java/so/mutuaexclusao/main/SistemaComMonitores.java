package br.com.ahe.so.mutuaexclusao.main;

import br.com.ahe.so.mutuaexclusao.monitores.Processo1;
import br.com.ahe.so.mutuaexclusao.monitores.Processo2;
import br.com.ahe.so.mutuaexclusao.monitores.RegiaoCritica;


public class SistemaComMonitores {
	
	public static void main( String args[]){
		
		RegiaoCritica RC = new RegiaoCritica();
		Processo1 P1 =  new Processo1(RC);
		Processo2 P2 = new Processo2(RC);
		System.out.println("Monitores");
		P1.start();
		P2.start();
	}
}
