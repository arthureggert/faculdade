package utils;


import java.util.ArrayList;
import java.util.List;

public class AListUtils {
	
	public static <T> T getFirstObjectFromList(List<T> lista){
		if(!AObjectUtils.isObjectNull(lista)){
			return lista.get(0);			
		}
		return null;
	}

	public static <T> T getLastObjectFromList(List<T> lista) {
		if(!AObjectUtils.isObjectNull(lista)){
			return lista.get(lista.size()-1);			
		}
		return null;
	}

	public static <T> T getRandomElementFromList(List<T> lista) {
		return lista.get(ANumberUtils.getRandomNumberWithMaxNumber(lista.size()));		
	}

	public static String getStringFromList(ArrayList<String> vfrase) {
		String text = "";
		for (String string : vfrase) {
			text += string + " ";
		}
		return text;
	}

	public static <T> T getObjectFromList(List<T> lista, int possicao) {
		return lista.get(possicao);
	}
}
