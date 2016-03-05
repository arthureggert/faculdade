package br.com.ahe.so.mutuaexclusao.main;

import br.com.ahe.so.mutuaexclusao.swap.Processo1;
import br.com.ahe.so.mutuaexclusao.swap.Processo2;
import br.com.ahe.so.mutuaexclusao.swap.RegiaoCritica;


public class SistemaComSwap {
	public static void main( String args[]){
		
		RegiaoCritica RC = new RegiaoCritica();
		Processo1 P1 =  new Processo1(RC);
		Processo2 P2 = new Processo2(RC);
		System.out.println("SWAP");
		P1.start();
		P2.start();
	}
}
