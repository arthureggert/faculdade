package br.com.ahe.sd.trabalho.corba;


/**
* br.com.ahe.sd.trabalho.corba/UsuarioHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from funcorescorba.idl
* Sábado, 28 de Junho de 2014 20h27min04s BRT
*/

abstract public class UsuarioHelper
{
  private static String  _id = "IDL:br.com.ahe.sd.trabalho.corba/Usuario:1.0";

  public static void insert (org.omg.CORBA.Any a, br.com.ahe.sd.trabalho.corba.Usuario that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static br.com.ahe.sd.trabalho.corba.Usuario extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [3];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "nome",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "senha",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[2] = new org.omg.CORBA.StructMember (
            "numeroCarteira",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (br.com.ahe.sd.trabalho.corba.UsuarioHelper.id (), "Usuario", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static br.com.ahe.sd.trabalho.corba.Usuario read (org.omg.CORBA.portable.InputStream istream)
  {
    br.com.ahe.sd.trabalho.corba.Usuario value = new br.com.ahe.sd.trabalho.corba.Usuario ();
    value.nome = istream.read_string ();
    value.senha = istream.read_string ();
    value.numeroCarteira = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, br.com.ahe.sd.trabalho.corba.Usuario value)
  {
    ostream.write_string (value.nome);
    ostream.write_string (value.senha);
    ostream.write_long (value.numeroCarteira);
  }

}
