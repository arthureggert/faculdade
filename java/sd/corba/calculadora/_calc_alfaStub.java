package br.com.ahe.sd.corba.calculadora;


/**
* calculadora/_calc_alfaStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/roa/Documents/Workspaces/git/faculdade/src/main/java/sd/corba/calculadora/Calculadora.idl
* Quarta-feira, 4 de Junho de 2014 19h16min05s BRT
*/
@SuppressWarnings({"all"})
public class _calc_alfaStub extends org.omg.CORBA.portable.ObjectImpl implements calc_alfa
{

  public String soma_str (String str1, String str2)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("soma_str", true);
                $out.write_string (str1);
                $out.write_string (str2);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return soma_str (str1, str2        );
            } finally {
                _releaseReply ($in);
            }
  } // soma_str

  public String mistura_str (String str1, String str2)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("mistura_str", true);
                $out.write_string (str1);
                $out.write_string (str2);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return mistura_str (str1, str2        );
            } finally {
                _releaseReply ($in);
            }
  } // mistura_str

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:calculadora/calc_alfa:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _calc_alfaStub