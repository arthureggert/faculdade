package br.com.ahe.sd.trabalho.corba;


/**
* br.com.ahe.sd.trabalho.corba/EmpresaDAOPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from empresadao.idl
* Sábado, 28 de Junho de 2014 21h04min40s BRT
*/

public abstract class EmpresaDAOPOA extends org.omg.PortableServer.Servant
 implements br.com.ahe.sd.trabalho.corba.EmpresaDAOOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable<String, Integer> _methods = new java.util.Hashtable<String, Integer> ();
  static
  {
    _methods.put ("cadastraEmpresa", new java.lang.Integer (0));
    _methods.put ("isEmpresaCadastrada", new java.lang.Integer (1));
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
       case 0:  // br.com.ahe.sd.trabalho.corba/EmpresaDAO/cadastraEmpresa
       {
         br.com.ahe.sd.trabalho.corba.Empresa emp = br.com.ahe.sd.trabalho.corba.EmpresaHelper.read (in);
         this.cadastraEmpresa (emp);
         out = $rh.createReply();
         break;
       }

       case 1:  // br.com.ahe.sd.trabalho.corba/EmpresaDAO/isEmpresaCadastrada
       {
         br.com.ahe.sd.trabalho.corba.Empresa emp = br.com.ahe.sd.trabalho.corba.EmpresaHelper.read (in);
         boolean $result = false;
         $result = this.isEmpresaCadastrada (emp);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:br.com.ahe.sd.trabalho.corba/EmpresaDAO:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public EmpresaDAO _this() 
  {
    return EmpresaDAOHelper.narrow(
    super._this_object());
  }

  public EmpresaDAO _this(org.omg.CORBA.ORB orb) 
  {
    return EmpresaDAOHelper.narrow(
    super._this_object(orb));
  }


} // class EmpresaDAOPOA
