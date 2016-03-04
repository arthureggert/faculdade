using System;
using System.Collections;

namespace L1211B05
{
	class MainClass
	{
		static FilaCircular<string> fcNomes;
		static bool fcNomesExist = false;
		static FilaCircular<Montadoras> fcMontadoras;
		static bool fcMontadorasExist = false;
		static FilaCircular<int> fcInteger;
		static bool fcIntegerExist = false;
		
		private static void Main (string[] args)	
		{
			Console.WriteLine("L1211A05 - Arthur Henrique Eggert");
			imprimeMenu1();
		}
		
		private static void imprimeMenu1()
		{
			try
			{
				string menu1 = "" +  "1 - fila de nomes \n" +  "2 - fila de inteiros \n" +  "3 - fila de montadoras \n" +  "9 - finaliza\n" +  "Filas existentes:  " + totalListas() +"\n" +	  "Tipos de filas existentes: " + tiposListas() ;
				Console.WriteLine(menu1);
				int opcao = int.Parse(pedeDados("a opção"));
				switch (opcao) {
					case 1:
						imprimeMenu2("String");
						break;
					case 2:
						imprimeMenu2("Integer");
						break;
					case 3:
						imprimeMenu2("Montadoras");
						break;
					case 9:
						finaliza();
						imprimeMenu1();
						break;		
				default:
					Console.WriteLine("Valor Invalido"+"\n");
					imprimeMenu1();
					break;
				}
			} 
			catch
			{
				Console.WriteLine("Informe apenas numeros"+"\n");
				imprimeMenu1();
			}		
		}
		
		private static void imprimeMenu2(string tipo)
		{
			try
			{
				string menu2 = "" + "Tipo da fila: " +tipo + "\n" + "Total de Elemento: " + quantidadeElementosFila(tipo) + "\n" + "Tamanho da fila: " + tamanhoFila(tipo) + "\n" +	"1 - criar fila\n" + "2 - destruir fila\n" + "3 - inserir\n" + "4 - mostrar\n" + "5 - excluir\n" + "9 - retorna ao menu 1";
				Console.WriteLine(menu2);
				int opcao = int.Parse(pedeDados("a opção"));
				switch (opcao) {
					case 1:
						criafila(tipo);
						imprimeMenu2(tipo);
						break;
					case 2:
						destroiFila(tipo);
						imprimeMenu2(tipo);
						break;
					case 3:
						inserir(tipo);
						imprimeMenu2(tipo);
						break;
					case 4:
						imprime(tipo);
						imprimeMenu2(tipo);
						break;
					case 5:
						excluir(tipo);
						imprimeMenu2(tipo);
						break;
					case 9:
						imprimeMenu1();
						break;
				default:
					Console.WriteLine("Valor Invalido"+"\n");
					imprimeMenu2(tipo);
					break;
				}
			}
			catch
			{
				Console.WriteLine("Informe apenas numeros"+"\n");
				imprimeMenu2(tipo);
			}
		}
			
		
		private static string pedeDados(string imprime)
		{
			Console.WriteLine("Informe "+imprime);
			string str = Console.ReadLine();	
			return str;
			
		}
	
		private static void finaliza() 
		{
			if(semListas())
			{				
				Environment.Exit(0);
			} 
			Console.WriteLine("Existem lista(s) criada(s)");
			
		}
	
		private static bool semListas()
		{
			if ((!fcIntegerExist) && (!fcNomesExist) && (!fcMontadorasExist))
			{
				return true;
			}
			return false;
		}
		
		
		private static int totalListas() 
		{	
			int totalListas = 0;
			if (fcIntegerExist)
			{
				totalListas+=1;
			}
			if (fcMontadorasExist)
			{
				totalListas+=1;
			}
			if (fcNomesExist)
			{
				totalListas+=1;
			}
			return totalListas;
		}
		
		private static void criafila(String tipo)
		{
			int tam = int.Parse(pedeDados("o tamanho"));
			if(tipo == "String")
			{
				if(!fcNomesExist)
				{
					fcNomesExist = true;
					fcNomes = new FilaCircular<String>(tam);
					return;
				}
			}
			if(tipo == "Integer")
			{
				if(!fcIntegerExist)
				{
					fcIntegerExist = true;
					fcInteger = new FilaCircular<int>(tam);
					return;
				}
			}		
			if(tipo == "Montadoras")
			{
				if(!fcMontadorasExist)
				{
					fcMontadorasExist = true;
					fcMontadoras= new FilaCircular<Montadoras>(tam);
					return;
				}
			}
			Console.WriteLine("Fila ja existe não pode ser criada novamente");
		}
	
		private static String tamanhoFila(String tipo)
		{
			String tamanhoFila = "";
			if(!fcNomesExist && !fcIntegerExist && !fcMontadorasExist)
			{
				tamanhoFila = "Não Criada";
			} 
			else 
			{
				if (fcNomesExist)
				{
					tamanhoFila = fcNomes.getTamanho().ToString(); 
				}
				if (fcIntegerExist)
				{
					tamanhoFila = fcInteger.getTamanho().ToString();
				}
				if (fcMontadorasExist)
				{
					tamanhoFila = fcMontadoras.getTamanho().ToString();
				}
			}
			return tamanhoFila;
		}
	
		private static void destroiFila(String tipo) 
		{
			if(tipo == "String")
			{
				if(fcNomesExist )
				{
					if(fcNomes.getQtdEmelento() == 0)
					{
						fcNomes = null;
						fcNomesExist =false;
						return;
					} 
					else 
					{
						Console.WriteLine("fila não esta vazia");
						return;
					}
				}
			}
			
			if(tipo == "Integer")
			{
				if(fcIntegerExist)
				{
					if(fcInteger.getQtdEmelento() == 0)
					{
						fcInteger =null;
						fcIntegerExist =false;
						return;	
					}
					else 
					{
						Console.WriteLine("fila não esta vazia");
						return;
					}
				}
			}		
			if(tipo == "Montadoras")
			{
				if(fcMontadorasExist)
				{
					if(fcMontadoras.getQtdEmelento() == 0)
					{
						fcMontadoras= null;
						fcMontadorasExist = false;	
						return;	
					} 
					else 
					{
						Console.WriteLine("Fila não esta vazia");
						return;
					}
				}
			}
			Console.WriteLine("fila não existe");
		}
	
		
		private static void inserir(String tipo)
		{
			imprimeMontadoras();
			string obj = pedeDados("o valor a ser inserido");
			if(tipo == "String")
			{
				if(fcNomesExist)
				{
					if(fcNomes.getQtdEmelento() < fcNomes.getTamanho())
					{
						fcNomes.insere(obj);
						return;	
					}
					else
					{
						Console.WriteLine("Fila esta cheia");
						return;
					}
				}
			}
			if(tipo == "Integer")
			{
				if(fcIntegerExist)
				{
					if(fcInteger.getQtdEmelento() < fcInteger.getTamanho())
					{
						fcInteger.insere(int.Parse(obj));
						return;
					}
					else
					{
						Console.WriteLine("Fila esta cheia");
						return;
					}
				}
			}		
			if(tipo == "Montadoras")
			{
				if(fcMontadorasExist)
					{
						if(fcMontadoras.getQtdEmelento() < fcMontadoras.getTamanho())
						{
							if(verificaMontadoras(obj))
							{
								fcMontadoras.insere((Montadoras)Enum.Parse(typeof(Montadoras),obj));
								return;		
							}		
							else
							{
							Console.WriteLine("Montadora Invalida");
							return;
							}
						}
						else
						{
							Console.WriteLine("fila esta cheia");
							return;
						}
					}
				}
				Console.WriteLine("fila não existe");		
			}
		
		private static void imprimeMontadoras()
		{
			Montadoras[] monta = Enum.GetValues(typeof(Montadoras)) as Montadoras[];
			string listaMonta = "";
			foreach(Montadoras mon in monta)
			{
				listaMonta += mon + " ";
			}
			Console.WriteLine("Montadoras Possiveis: "+listaMonta);
		}
		
		private static bool verificaMontadoras(string obj)
		{
			Montadoras[] monta = Enum.GetValues(typeof(Montadoras)) as Montadoras[];
			foreach(Montadoras mon in monta)
			{
				if(mon.ToString().Equals(obj))
				{
					return true;
				}
			}
			return false;
		}
		
		private static void imprime(String tipo) 
		{
			if(tipo == "String")
			{
				if(fcNomesExist)
				{
					if(fcNomes.getQtdEmelento() > 0)
					{
						fcNomes.imprime();
						return;		
					} 
					else
					{
						Console.WriteLine(" Fila Vazia");
						return;
					}
				}
			}
			if(tipo == "Integer")
			{
				if(fcIntegerExist)
				{
					if(fcInteger.getQtdEmelento() > 0)
					{
						fcInteger.imprime();
						return;		
					} 
					else 
					{
					Console.WriteLine(" Fila Vazia");
					return;
					}
				}
			}		
			if(tipo == "Montadoras")
			{
				if(fcMontadorasExist)
				{
					if(fcMontadoras.getQtdEmelento() > 0)
					{
						fcMontadoras.imprime();
						return;	
					} 
					else 
					{
						Console.WriteLine(" Fila Vazia");
						return;
					}
				}
			}
			Console.WriteLine("fila não existe");
		}
		
		private static void excluir(String tipo) 
		{
			if(tipo == "String")
			{
				if(fcNomesExist)
				{
					fcNomes.retira();
					return;
				}
			}
			if(tipo == "Integer")
			{
				if(fcIntegerExist)
				{
					fcInteger.retira();
					return;
				}
			}		
			if(tipo == "Montadoras")
			{
				if(fcMontadorasExist)
				{
					fcMontadoras.retira();
					return;
				}
			}
			Console.WriteLine("fila não existe");
		}
		
		private static String quantidadeElementosFila(String tipo) 
		{
			String qtdElementos = "";
			if(!fcNomesExist && !fcIntegerExist && !fcMontadorasExist)
			{
				qtdElementos = "Não Criada";
			} else {
				if (fcNomesExist)
				{
					qtdElementos = fcNomes.getQtdEmelento().ToString(); 
				}
				if (fcIntegerExist)
				{
					qtdElementos = fcInteger.getQtdEmelento().ToString();
				}
				if (fcMontadorasExist)
				{
					qtdElementos = fcMontadoras.getQtdEmelento().ToString();
				}
			}
		return qtdElementos;
		}
		
		private static String tiposListas() 
		{
			String filas = "";
				if(!fcNomesExist && !fcIntegerExist && !fcMontadorasExist)
				{
					filas += "Nenhuma";
				} 
				else
				{
					if (fcNomesExist)
					{
						filas+="Nomes ";
					}
					if (fcIntegerExist)
					{
						filas+="Inteiros ";
					}
					if (fcMontadorasExist)
					{
						filas+="Montadoras ";
					}	
				}
			return filas;
		}
	}
}
