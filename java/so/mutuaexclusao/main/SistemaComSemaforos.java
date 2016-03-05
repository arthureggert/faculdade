package br.com.ahe.so.mutuaexclusao.main;

import br.com.ahe.so.mutuaexclusao.semaforo.Processo1;
import br.com.ahe.so.mutuaexclusao.semaforo.Processo2;
import br.com.ahe.so.mutuaexclusao.semaforo.RegiaoCritica;
import br.com.ahe.so.mutuaexclusao.semaforo.Semaforo;


public class SistemaComSemaforos {
	public static void main( String args[] ){
		RegiaoCritica RC = new RegiaoCritica();
		
		Semaforo s1 = new Semaforo(1); 
		Semaforo s2 = new Semaforo(0);
		
		Processo1 P1 =  new Processo1(RC,s1,s2 );
		Processo2 P2 = new Processo2(RC,s1,s2);
		System.out.println("Semaforos");
		P1.start();
		P2.start();
	}
}  
