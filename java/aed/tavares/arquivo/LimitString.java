/**
  * @author arthur
  *
 **/

package br.com.ahe.aed.tavares.arquivo;

public class LimitString {
	
	private char[] string;
	
	public LimitString(String string, int tam){
		char[] stringToChar = string.toCharArray();
		this.string = new char[tam];
		for (int i = 0 ; i < tam ; i++){
			if (i < stringToChar.length){
				this.string[i] = stringToChar[i];
			} else {
				this.string[i] = ' ';
			}
		}
	}
	
	public LimitString(char[] arrayChar){
		this.string = arrayChar;
	}

	public char[] getString() {
		return this.string;
	}

	public void setString(char[] string) {
		this.string = string;
	}

	@Override
	public String toString() {
		String tmp = "";
		for (int i = 0; i < this.string.length;i++){
			tmp+=this.string[i];
		}
		return tmp;
	}
	
	
	
}
