package br.com.ahe.sd.trabalho.corba;


/**
* br.com.ahe.sd.trabalho.corba/IFuncoesCorbaPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from funcorescorba.idl
* Sábado, 28 de Junho de 2014 20h27min04s BRT
*/

public abstract class IFuncoesCorbaPOA extends org.omg.PortableServer.Servant
 implements br.com.ahe.sd.trabalho.corba.IFuncoesCorbaOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  
private static java.util.Hashtable<String, Integer> _methods = new java.util.Hashtable<String, Integer> ();
  
  static
  {
    _methods.put ("formataValores", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = _methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // br.com.ahe.sd.trabalho.corba/IFuncoesCorba/formataValores
       {
         double textoValor = in.read_double ();
         String $result = null;
         $result = this.formataValores (textoValor);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:br.com.ahe.sd.trabalho.corba/IFuncoesCorba:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public IFuncoesCorba _this() 
  {
    return IFuncoesCorbaHelper.narrow(
    super._this_object());
  }

  public IFuncoesCorba _this(org.omg.CORBA.ORB orb) 
  {
    return IFuncoesCorbaHelper.narrow(
    super._this_object(orb));
  }


} // class IFuncoesCorbaPOA
