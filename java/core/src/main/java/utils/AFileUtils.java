package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AFileUtils {
	
	public static BufferedReader getBufferedReaderFromFile(String filePath) {
		try {
			return new BufferedReader(getFileReaderFromFile(filePath));
		} catch (NullPointerException nullPointerException) {
			System.out.println(String.format("Arquivo %s não encontrado", filePath));
			return null;
		}
	}
	
	public static FileReader getFileReaderFromFile(String filePath){
		try {
			File file = new File(filePath);
			return new FileReader(file);
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println(String.format("Arquivo %s não encontrado", filePath));
			return null;
		}
	}
	
	public static Scanner getScannerFromFileWithSeparator(String filePath, String separator) {
		Scanner scanner = new Scanner(getFileReaderFromFile(filePath));
		scanner.useDelimiter(separator);
		return scanner;
	}
	
	public static BufferedWriter getBufferedWriterFromFile(String filePath) {
		try {
			return new BufferedWriter(getFileWriterFromFile(filePath));
		} catch (NullPointerException nullPointerException) {
			System.out.println(String.format("Arquivo %s não encontrado", filePath));
			return null;
		}		
	}
	
	public static FileWriter getFileWriterFromFile(String filePath){
		try {
			File file = new File(filePath);
			return new FileWriter(file);
		} catch (IOException e) {
			System.out.println(String.format("Problema na criação do arquivo %s", filePath));
			return null;
		}
		
	}
	
	public static void removeFile(File file) {
		boolean isDeleted = file.delete();
		System.out.println(isDeleted);
	}
	
	public static void criaDiretorio(String novoDiretorio){  
		String nomeDiretorio;
		String separador = File.separator;
		try {       
			nomeDiretorio = "C:\\users\\roa" + separador + novoDiretorio;   
			if (!new File(nomeDiretorio).exists()) {
				(new File(nomeDiretorio)).mkdir();
			}
		} catch (Exception ex) {   
			System.out.println(ex.getCause());   
		}  
	}
	
	public static File getFileFromFilePath(String filePath) {
		return new File(filePath);
	}  
	
	public static File createFileIfNotExist(String fileName , String path) throws IOException {
		File discoFile = new File( String.format( "%s%s%s" , path , File.separator , fileName ) );
			if( !discoFile.exists() ) {
				discoFile.createNewFile();
			}
		return discoFile;
	}
	
}
