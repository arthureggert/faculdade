package br.com.ahe.sd.trabalho.corba;


/**
* corba/CarteiraDAOOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from carteiradao.idl
* Quarta-feira, 6 de Agosto de 2014 20h43min48s BRT
*/

public interface CarteiraDAOOperations 
{
  br.com.ahe.sd.trabalho.corba.Carteira criaCarteira (String nomeUsuario);
  br.com.ahe.sd.trabalho.corba.Carteira buscaCarteira (String nomeUsuario);
  void criaMovimentacaoCarteira (Acao acao, br.com.ahe.sd.trabalho.corba.Carteira carteira, double valor, double qtd, String tipo);
  boolean isAcaoComprada (Acao acao, br.com.ahe.sd.trabalho.corba.Carteira carteira, int qtd);
} // interface CarteiraDAOOperations
