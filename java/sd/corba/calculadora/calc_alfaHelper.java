package br.com.ahe.sd.corba.calculadora;


/**
 * calculadora/calc_alfaHelper.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from C:/Users/roa/Documents/Workspaces/git/faculdade/src/main/java/sd/corba/calculadora/Calculadora.idl
 * Quarta-feira, 4 de Junho de 2014 19h16min05s BRT
 */
@SuppressWarnings({"all"})
abstract public class calc_alfaHelper
{
	private static String  _id = "IDL:calculadora/calc_alfa:1.0";

	public static void insert (org.omg.CORBA.Any a, calc_alfa that)
	{
		org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
		a.type (type ());
		write (out, that);
		a.read_value (out.create_input_stream (), type ());
	}

	public static calc_alfa extract (org.omg.CORBA.Any a)
	{
		return read (a.create_input_stream ());
	}

	private static org.omg.CORBA.TypeCode __typeCode = null;
	synchronized public static org.omg.CORBA.TypeCode type ()
	{
		if (__typeCode == null)
		{
			__typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (calc_alfaHelper.id (), "calc_alfa");
		}
		return __typeCode;
	}

	public static String id ()
	{
		return _id;
	}

	public static calc_alfa read (org.omg.CORBA.portable.InputStream istream)
	{
		return narrow (istream.read_Object (_calc_alfaStub.class));
	}

	public static void write (org.omg.CORBA.portable.OutputStream ostream, calc_alfa value)
	{
		ostream.write_Object ((org.omg.CORBA.Object) value);
	}

	public static calc_alfa narrow (org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		else if (obj instanceof calc_alfa)
			return (calc_alfa)obj;
		else if (!obj._is_a (id ()))
			throw new org.omg.CORBA.BAD_PARAM ();
		else
		{
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
			_calc_alfaStub stub = new _calc_alfaStub ();
			stub._set_delegate(delegate);
			return stub;
		}
	}

	public static calc_alfa unchecked_narrow (org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		else if (obj instanceof calc_alfa)
			return (calc_alfa)obj;
		else
		{
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
			_calc_alfaStub stub = new _calc_alfaStub ();
			stub._set_delegate(delegate);
			return stub;
		}
	}

}
