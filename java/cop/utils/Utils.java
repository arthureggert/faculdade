package br.com.ahe.cop.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import net.vidageek.mirror.dsl.Mirror;
import br.com.ahe.cop.copilador.gals2.LexicalError;
import br.com.ahe.cop.copilador.gals2.SemanticError;
import br.com.ahe.cop.copilador.gals2.Token;
import br.com.ahe.cop.copilador.gals3.Constants;
import br.com.ahe.cop.copilador.gals3.ScannerConstants;

public class Utils {
	
	public static final String EOL = "\r\n";

	public static final String TAB = "  ";

	public static final String DOUBLE_TAB = TAB + TAB;

	public static final String READ_INT = "call int64 [mscorlib]System.Int64::Parse(string)";
	
	public static final String READ_FLOAT = "call float64 [mscorlib]System.Double::Parse(string)";

	public static final String WRITE_INT = "call void [mscorlib]System.Console::Write(int64)";
	
	public static final String WRITE_FLOAT = "call void [mscorlib]System.Console::Write(float64)";
	
	public static final String WRITE_BOOL = "call void [mscorlib]System.Console::Write(bool)";
	
	public static final String WRITE_STRING = "call void [mscorlib]System.Console::Write(string)";

	private static Utils instancia;
	
	private MyJTextPane editor;
	
	public static Utils getInstance() {
		if( instancia == null ) {
			instancia = new Utils();
		}
		return instancia;
	}
	
	public void setEditor(MyJTextPane editor) {
		this.editor = editor;
	}

	public String getClasse(Token token){
		Class<?> classe = new Mirror().reflectClass("Constants");
		List<Field> fields = new Mirror().on(classe).reflectAll().fields();
		for (Field field : fields) {
			int tipo = (int) new Mirror().on(classe).get().field(field);
			if(tipo == token.getId()){
				for (int id : Constants.SPECIAL_CASES_VALUES) {
					if (tipo == id) {
						return "Palavra Reservada";
					}
				}
				return getNomeCorreto(field.getName());
			}
		}
		return "";
	}

	private String getNomeCorreto(String name) {
		if (name.matches(".*(identificador).*")){
			return "Identificador";		
		}

		if(name.matches(".*(palavra).*")){
			return "Palavra Reservada";
		}

		if(name.matches(".*(TOKEN).*")){
			return "Simbolo Especial ";
		}
		if(name.matches(".*(constante).*")){
			if(name.matches(".*(string).*")){
				return "Constante Literal";
			}
			if(name.matches(".*(float).*")){
				return "Constante Real  ";
			}
			if(name.matches(".*(int).*")){
				return "Constante Inteira";
			}
		}

		return "";
	}

	public boolean verificaPalavaraReservada(Token t) throws LexicalError {
		if(t.getId() == Constants.t_palavra_reservada) {
			for (String lexema : ScannerConstants.SPECIAL_CASES_KEYS) {
				if(!t.getLexeme().equals(lexema)){
					return false;
				} 
			} 
		}
		return true;
	}

	public int getLinha(int possicao) {
		return this.editor.getLineOfOffset(possicao);
	}

	public String getToken(int start, int position) {
		return this.editor.getText(start, position);
	}
	
	public String getPath(String arq){
		String[] pathName = arq.split("\\\\");
		String retorno = "";
		for (int i = 0; i < pathName.length - 1; i++) {
			retorno+=pathName[i]+"\\";
		}
		return retorno;
	}
	
	public String getFileName(String caminho) throws SemanticError{
		if(!caminho.isEmpty()){
			String[] fileName = caminho.split("\\\\");
			return fileName[fileName.length-1];			
		} 
		throw new SemanticError("Arquivo n�o esta salvo.");
	}
	
	public void gravaArquivo(String codigo, String path, String fileName) throws IOException{
		
		File arquivo = new File(path ,fileName+".il");
		
		FileWriter writer = new FileWriter(arquivo);
		
		writer.write(codigo);
		writer.close();
		
	}

	public static void verificaCompatibilidadeTipos(String typeOfID, String typeOfStack) throws SemanticError {
		if(!typeOfID.equals(typeOfStack)){
			throw new SemanticError("Tipos incop�tiveis para realiza��o da opera��o");
		} 
	}

}
