package br.com.ahe.sd.corba.boasvindas.stub;


/**
 * stub/MsgBoasVindasHelper.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from C:/Users/roa/Documents/Workspaces/git/faculdade/src/main/java/sd/corba/boasvindas/idl/BoasVindas.idl
 * Quarta-feira, 4 de Junho de 2014 18h53min34s BRT
 */
@SuppressWarnings({"all"})
abstract public class MsgBoasVindasHelper
{
	private static String  _id = "IDL:stub/MsgBoasVindas:1.0";

	public static void insert (org.omg.CORBA.Any a, MsgBoasVindas that)
	{
		org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
		a.type (type ());
		write (out, that);
		a.read_value (out.create_input_stream (), type ());
	}

	public static MsgBoasVindas extract (org.omg.CORBA.Any a)
	{
		return read (a.create_input_stream ());
	}

	private static org.omg.CORBA.TypeCode __typeCode = null;
	synchronized public static org.omg.CORBA.TypeCode type ()
	{
		if (__typeCode == null)
		{
			__typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (MsgBoasVindasHelper.id (), "MsgBoasVindas");
		}
		return __typeCode;
	}

	public static String id ()
	{
		return _id;
	}

	public static MsgBoasVindas read (org.omg.CORBA.portable.InputStream istream)
	{
		return narrow (istream.read_Object (MsgBoasVindasStub.class));
	}

	public static void write (org.omg.CORBA.portable.OutputStream ostream, MsgBoasVindas value)
	{
		ostream.write_Object ((org.omg.CORBA.Object) value);
	}

	public static MsgBoasVindas narrow (org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		else if (obj instanceof MsgBoasVindas)
			return (MsgBoasVindas)obj;
		else if (!obj._is_a (id ()))
			throw new org.omg.CORBA.BAD_PARAM ();
		else
		{
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
			MsgBoasVindasStub stub = new MsgBoasVindasStub ();
			stub._set_delegate(delegate);
			return stub;
		}
	}

	public static MsgBoasVindas unchecked_narrow (org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		else if (obj instanceof MsgBoasVindas)
			return (MsgBoasVindas)obj;
		else
		{
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
			MsgBoasVindasStub stub = new MsgBoasVindasStub ();
			stub._set_delegate(delegate);
			return stub;
		}
	}

}
