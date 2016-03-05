package br.com.ahe.sd.trabalho.corba;


/**
* corba/CarteiraHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from carteiradao.idl
* Quarta-feira, 6 de Agosto de 2014 20h43min48s BRT
*/

abstract public class CarteiraHelper
{
  private static String  _id = "IDL:corba/Carteira:1.0";

  public static void insert (org.omg.CORBA.Any a, br.com.ahe.sd.trabalho.corba.Carteira that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static br.com.ahe.sd.trabalho.corba.Carteira extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "idAcao",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_double);
          _members0[1] = new org.omg.CORBA.StructMember (
            "valorReal",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (CarteiraHelper.id (), "Carteira", _members0);
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

  public static br.com.ahe.sd.trabalho.corba.Carteira read (org.omg.CORBA.portable.InputStream istream)
  {
    br.com.ahe.sd.trabalho.corba.Carteira value = new br.com.ahe.sd.trabalho.corba.Carteira ();
    value.idAcao = istream.read_long ();
    value.valorReal = istream.read_double ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, br.com.ahe.sd.trabalho.corba.Carteira value)
  {
    ostream.write_long (value.idAcao);
    ostream.write_double (value.valorReal);
  }

}
