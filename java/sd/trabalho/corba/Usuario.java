package br.com.ahe.sd.trabalho.corba;


/**
 * br.com.ahe.sd.trabalho.corba/Usuario.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from funcorescorba.idl
 * Sábado, 28 de Junho de 2014 20h27min04s BRT
 */

public final class Usuario implements org.omg.CORBA.portable.IDLEntity
{
	
	private static final long serialVersionUID = 1L;
	public String nome = null;
	public String senha = null;
	public int numeroCarteira = (int)0;
	
	public Usuario ()
	{
	} // ctor
	
	public Usuario (String _nome, String _senha, int _numeroCarteira)
	{
		this.nome = _nome;
		this.senha = _senha;
		this.numeroCarteira = _numeroCarteira;
	} // ctor
	
} // class Usuario