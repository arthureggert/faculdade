package br.com.ahe.sd.trabalho.corba;


/**
* corba/AcaoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from carteiradao.idl
* Quarta-feira, 6 de Agosto de 2014 20h43min48s BRT
*/

abstract public class AcaoHelper
{
  private static String  _id = "IDL:corba/Acao:1.0";

  public static void insert (org.omg.CORBA.Any a, Acao that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Acao extract (org.omg.CORBA.Any a)
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
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "idAcao",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[1] = new org.omg.CORBA.StructMember (
            "qtdNegocios",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[2] = new org.omg.CORBA.StructMember (
            "codigoEmpresa",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (AcaoHelper.id (), "Acao", _members0);
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

  public static Acao read (org.omg.CORBA.portable.InputStream istream)
  {
    Acao value = new Acao ();
    value.idAcao = istream.read_long ();
    value.qtdNegocios = istream.read_long ();
    value.codigoEmpresa = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Acao value)
  {
    ostream.write_long (value.idAcao);
    ostream.write_long (value.qtdNegocios);
    ostream.write_long (value.codigoEmpresa);
  }

}
