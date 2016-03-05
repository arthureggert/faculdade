package br.com.ahe.sd.corba.calculadora;


import org.omg.CORBA.ORB;
import org.omg.CORBA.ShortHolder;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class cliente {

  public static void main(String args[]) {
    try {
      // Cria e inicializa o ORB
      ORB orb = ORB.init(args, null);

      // Obtem referencia para o servico de nomes
      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
      NamingContextExt namecontextRef = NamingContextExtHelper.narrow(objRef);
 
      // Obtem referencia para o servidor
      String name = "CalculadoraNumerica";
      calc_numerica c_numerica = calc_numericaHelper.narrow(namecontextRef.resolve_str(name));

      while (true) {
	      // Obtem valores
	      System.out.print("Qual opera��o (+, -, /, *, f): ");
	      java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
	      String op = reader.readLine();
	      if (op.equals("f"))
	      	System.exit(0);
	      
	      System.out.print("Primeiro valor: ");
	      short p1 = new Short(reader.readLine()).shortValue();
	
	      System.out.print("Segundo valor: ");
	      short p2 = new Short(reader.readLine()).shortValue();
	      
	      ShortHolder ret = new ShortHolder(); 
	      if (op.equals("+"))
	         c_numerica.soma_int(p1, p2, ret);	
	      else if (op.equals("-"))	
	      	c_numerica.sub_int(p1, p2, ret);
	      else if (op.equals("/"))	
	      	c_numerica.div_double(p1, p2, ret);
	      else if (op.equals("*"))	
	      	c_numerica.mul_double(p1, p2, ret);
	      
	      System.out.println("Resultado: " + ret.value);
      }

    } catch (Exception e) {
        System.out.println("ERROR : " + e) ;
        e.printStackTrace(System.out);
    }
  }
}

