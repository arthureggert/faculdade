package br.com.ahe.aed.tavares.arquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Arquivo {
	
	private String localArquivo;
	private String nomeArquivo;
	private String permissaoArquivo;
	private RandomAccessFile raf;
	
	public Arquivo(String localArquivo, String nomeArquivo,  String permissaoArquivo) {
		this.localArquivo = localArquivo;
		this.nomeArquivo = nomeArquivo;
		this.permissaoArquivo = permissaoArquivo;
	}

	public void criaRandomAcessFile() throws FileNotFoundException {
		File file = new File(this.localArquivo+this.nomeArquivo);
		if(file.exists()){
			file.delete();
			System.out.println("DELETANDO ARQUIVOS");
		}
		this.raf = new RandomAccessFile(this.localArquivo+this.nomeArquivo, this.permissaoArquivo);		
	}
	
	public void gravaAluno(Aluno aluno) throws IOException{
		this.raf.writeInt(aluno.getVinculo());
		this.raf.writeChars(aluno.getNome().toString());
		this.raf.writeChars(aluno.getEndreco().toString());
		this.raf.writeByte(aluno.getCurso());
	}
	
	private long retornaPonteiroInicio(int registro) throws IOException {
		long byteAluno = (registro-1) * 175;
		return byteAluno;
	}
	
	public Aluno recuperaAluno(int aluno) throws IOException { 	
		long ponteiro = retornaPonteiroInicio(aluno);
		this.raf.seek(ponteiro);
		Aluno tmp = new Aluno();
		tmp.setVinculo(recuperaVinculo());
		tmp.setNome(recuperaNome());
		tmp.setEndreco(recuperaEndereco());
		tmp.setCurso(recuperaCurso());
		return tmp;
		
	}

	private Byte recuperaCurso() throws IOException {
		return this.raf.readByte();
	}

	private LimitString recuperaEndereco() throws IOException {
		char[] tmp = new char[50];
		for(int i = 0 ; i < tmp.length ; i++){
			tmp[i] = this.raf.readChar();
		}
		return new LimitString(tmp);
	}

	private LimitString recuperaNome() throws IOException {
		char[] tmp = new char[35];
		for(int i = 0 ; i < tmp.length ; i++){
			tmp[i] = this.raf.readChar();
		}
		return new LimitString(tmp);
	}

	private int recuperaVinculo() throws IOException{
		return this.raf.readInt();
	}
	
}

