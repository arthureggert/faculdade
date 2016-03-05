package br.com.ahe.aed.tavares.lista;

public class UsaListaDupla
{

      public static void main(String args[])
      {
          ListaEncadeadaDuplamente l = new ListaEncadeadaDuplamente();
          
          @SuppressWarnings("resource")
		java.util.Scanner s = new java.util.Scanner(System.in);
          
          System.out.println("Inserir uma sequ�nncia de numeros numa lista enncadeada.\n");
          
          System.out.println("Informe valor a ser inserido - 0 encerra:");
          
          int valor;
          
          valor = s.nextInt();
          
          while (valor != 0 )
          {
              if(l.insereListaDupla(new Integer(valor))) 
                 System.out.println("valor inserido.\n");
                 
              else
                 System.out.println("valor n�o inserido.\n");
              System.out.println("Informe valor a ser inserido - 0 encerra:");                 
              valor = s.nextInt();                
          }
          
          l.imprimeListaDupla();
          
          NodoListaDupla p;
          p = l.pesquisaListaDupla(new Integer(5));
          if( p == null )
             System.out.println("N�o achado.\n");
          else
             System.out.println("Achado.\n");

          l.desinstalaNododoMeio(p);
          l.imprimeListaDupla();          
          
 
      }
      
}
