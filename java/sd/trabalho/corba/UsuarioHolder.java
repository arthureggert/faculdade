package br.com.ahe.sd.trabalho.corba;

/**
* br.com.ahe.sd.trabalho.corba/UsuarioHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from funcorescorba.idl
* Sábado, 28 de Junho de 2014 20h27min04s BRT
*/

public final class UsuarioHolder implements org.omg.CORBA.portable.Streamable
{
  public br.com.ahe.sd.trabalho.corba.Usuario value = null;

  public UsuarioHolder ()
  {
  }

  public UsuarioHolder (br.com.ahe.sd.trabalho.corba.Usuario initialValue)
  {
    this.value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    this.value = br.com.ahe.sd.trabalho.corba.UsuarioHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    br.com.ahe.sd.trabalho.corba.UsuarioHelper.write (o, this.value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return br.com.ahe.sd.trabalho.corba.UsuarioHelper.type ();
  }

}
