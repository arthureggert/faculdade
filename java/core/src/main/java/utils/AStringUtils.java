package utils;

import java.util.Arrays;
import java.util.List;


public class AStringUtils {

	private final static String VOGAIS = "[A|E|I|O|U]";
	
	private final static List<String> ALFABETO = Arrays.asList( "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z" );
	
	public static boolean isTerminaEmVogal(String palavra){
		return palavra.substring(palavra.length() -1 , palavra.length()).toUpperCase().matches(VOGAIS);	
	}

	public static String removeLastCharFomString(String palavra) {
		return palavra.substring(0, palavra.length()-1);
	}
	
	public static String getLetraAlfabeto(int indice) {
		if ( indice < 1 || indice > ALFABETO.size() + 1 ) {
	        throw new IllegalArgumentException("Indice inválido");
        }
		return ALFABETO.get( indice -1 );
	}
}
