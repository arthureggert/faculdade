package br.com.ahe.cop.copilador.gals3.acao;

import java.util.ArrayList;
import java.util.List;

import br.com.ahe.cop.copilador.gals2.SemanticError;
import br.com.ahe.cop.copilador.gals2.Token;
import br.com.ahe.cop.utils.Utils;

public class SemanticAction {

	public void getAction(int semanticAction, SemanticRegister semanticRegister, Token token) throws SemanticError{
		switch (semanticAction) {
		case 1:
			executeSemanticAction1(semanticRegister);
			break;
		case 2:
			executeSemanticAction2(semanticRegister);
			break;
		case 3:
			executeSemanticAction3(semanticRegister);
			break;
		case 4:
			executeSemanticAction4(semanticRegister, token);
			break;
		case 5:
			executeSemanticAction5(semanticRegister);
			break;
		case 6:
			executeSemanticAction6(semanticRegister);
			break;
		case 7:
			executeSemanticAction7(semanticRegister);
			break;
		case 8:
			executeSemanticAction8(semanticRegister);
			break;
		case 9:
			executeSemanticAction9(semanticRegister, token);
			break;
		case 10:
			executeSemanticAction10(semanticRegister);
			break;
		case 11:
			executeSemanticAction11(semanticRegister, token);
			break;
		case 12:
			executeSemanticAction12(semanticRegister);
			break;
		case 13:
			executeSemanticAction13(semanticRegister, token);
			break;
		case 14:
			executeSemanticAction14(semanticRegister);
			break;
		case 15:
			executeSemanticAction15(semanticRegister);
			break;
		case 16:
			executeSemanticAction16(semanticRegister);
			break;
		case 17:
			executeSemanticAction17(semanticRegister);
			break;
		case 18:
			executeSemanticAction18(semanticRegister, token);
			break;
		case 19:
			executeSemanticAction19(semanticRegister);
			break;
		case 22:
			executeSemanticAction22(semanticRegister, token);
			break;
		case 23:
			executeSemanticAction23(semanticRegister, token);
			break;
		case 24:
			executeSemanticAction24(semanticRegister);
			break;
		case 25:
			executeSemanticAction25(semanticRegister, token);
			break;
		case 26:
			executeSemanticAction26(semanticRegister);
			break;
		case 27:
			executeSemanticAction27(semanticRegister, token);
			break;
		case 28:
			executeSemanticAction28(semanticRegister, token);
			break;
		case 29:
			executeSemanticAction29(semanticRegister, token);
			break;
		case 30:
			executeSemanticAction30(semanticRegister, token);
			break;
		case 31:
			executeSemanticAction31(semanticRegister);
			break;
		case 32:
			executeSemanticAction32(semanticRegister);
			break;
		case 33:
			executeSemanticAction33(semanticRegister);
			break;
		case 34:
			executeSemanticAction34(semanticRegister, token);
			break;
		case 35:
			executeSemanticAction35(semanticRegister, token);
			break;
		case 36:
			executeSemanticAction36(semanticRegister, token);
			break;
		default:
			executeSemanticActionErrorAction(semanticAction,token);
			break;
		}
	}


	private void executeSemanticActionErrorAction(int semanticAction, Token token) {
		//System.out.println("A��o #"+semanticAction+", Token: "+token);
	}

	private void executeSemanticAction1(SemanticRegister semanticRegister) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = new Modulo(semanticRegister.getArquivo());
				semanticRegister.addCode(".assembly extern mscorlib{}",".assembly " + semanticRegister.getArquivo() + "{}",".module " + semanticRegister.getArquivo() + ".exe", ".class public " + semanticRegister.getArquivo() + "{");
				module.setMain(true);
				semanticRegister.addEscopo(module);
				semanticRegister.addModule(module);
			}

		}.executeSemanticAction(semanticRegister);		
	}

	private void executeSemanticAction2(SemanticRegister semanticRegister) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				module.addCode(Utils.TAB + ".method static public void principal(){", Utils.TAB + ".entrypoint");
			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction3(SemanticRegister semanticRegister) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects )	throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
			
				List<String> listModulos = new ArrayList<String>(semanticRegister.getModulos().keySet());
				for (int i = listModulos.size() - 1; i >= 0; i--) {
					String key = listModulos.get(i);
					Modulo module = semanticRegister.getModule(key);
					semanticRegister.addCode(module.getCode());
					if (module.isMain()) {
						semanticRegister.addCode("ret", "}");
					}
				}
				semanticRegister.addCode("}");
			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction4(SemanticRegister semanticRegister, Token token) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {	
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Token token = (Token) objects[1];

				if (semanticRegister.containsSymbol(token.getLexeme())) {
					throw new SemanticError("identificador (" + token.getLexeme() +") j� declarado");
				}
				Modulo modulo = new Modulo(token.getLexeme());

				semanticRegister.addSymbol(token);
				semanticRegister.addEscopo(modulo);
				semanticRegister.addModule(modulo);

				modulo.addCode(".method static public " + token.getMsilType() + " " + token.getLexeme());

			}
		}.executeSemanticAction(semanticRegister, token);
	}

	private void executeSemanticAction5(SemanticRegister semanticRegister) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				module.addCode("{");
			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction6(SemanticRegister semanticRegister) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				module.addCode("ret", "}");
				semanticRegister.removeLastModule();
			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction7(SemanticRegister semanticRegister) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				module.addCode(" (");
				String tempCodigo = new String();
				Token t = module.getFirstId();
				while (t != null) {
					if (module.containsSymbol(t.getLexeme())) {
						throw new SemanticError("Identificador (" + t.getLexeme() + ") j� declarado");
					}
					module.addSymbol(t);
					module.addParameter(t);
					if (tempCodigo.length() > 0) {
						tempCodigo += ", /n";
					}
					tempCodigo += t.getMsilType() + " " + t.getLexeme();
					t = module.getFirstId();
				}
				module.addCode(tempCodigo + " )");	
			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction8(SemanticRegister semanticRegister) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				module.addCode(Utils.TAB + ".locals(");
				String tempCode = "";
				Token t = module.getFirstId();
				while (t != null) {
					if(module.containsSymbol(t.getLexeme())){
						throw new SemanticError("Identificador (" + t.getLexeme() + ") j� declarado");						
					} else {
						module.addSymbol(t);
						if(tempCode.length() > 0){
							tempCode += ", \n";
						}
						tempCode += Utils.DOUBLE_TAB + t.getMsilType() + " " + t.getLexeme();

						t = module.getFirstId();
					}
				}
				module.addCode(tempCode, Utils.TAB + ")");
			}
		}.executeSemanticAction(semanticRegister);
	}


	private void executeSemanticAction9(SemanticRegister semanticRegister, Token token) throws SemanticError {
		new MySemanticAction() {
			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Token token = (Token) objects[1];
				Modulo module = semanticRegister.getLastModule();
				module.addIdentifier(token);
			}
		}.executeSemanticAction(semanticRegister, token);
	}

	private void executeSemanticAction10(SemanticRegister semanticRegister) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				Token id = module.getLastId();
				if(!module.containsSymbol(id.getLexeme())){
					throw new SemanticError("Identificador (" + id.getLexeme() + ") n�o declarado");
				} else {
					module.addCode(Utils.DOUBLE_TAB + "stloc " + id.getLexeme());
				}
			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction11(SemanticRegister semanticRegister, Token token) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Token token = (Token) objects[1];
				Modulo module = semanticRegister.getLastModule();
				module.addCode(Utils.DOUBLE_TAB + "call string [mscorlib]System.Console::ReadLine()");

				Token t = module.getFirstId();
				while (t != null) {

					if(!module.containsSymbol(t.getLexeme())){
						throw new SemanticError("Identificador (" + token.getLexeme() + ") n�o declarado");
					} else {
						if(t.getMsilType().equals("bool")){
							throw new SemanticError("Identificador (" + t.getLexeme() + ") � do tipo bool e n�o pode ser utilizado na entrada de dados");
						}
						if(semanticRegister.containsSymbol(t.getLexeme())){
							throw new SemanticError("Identificador (" + t.getLexeme() + ") � um identificador de modulo e n�o pode ser utilizado na entrada de dados");
						}
						if(t.getMsilType().equals("int64")){
							module.addCode(Utils.DOUBLE_TAB + Utils.READ_INT);
						} else if(t.getMsilType().equals("float64")){
							module.addCode(Utils.DOUBLE_TAB + Utils.READ_FLOAT);	
						}

						module.addCode(Utils.DOUBLE_TAB + "stloc " + t.getLexeme());
						t = module.getFirstId();
					}
				}
			}
		}.executeSemanticAction(semanticRegister, token);
	}


	private void executeSemanticAction12(SemanticRegister semanticRegister) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				module.setTipoExp("OUT");
			}
		}.executeSemanticAction(semanticRegister);

	}

	private void executeSemanticAction13(SemanticRegister semanticRegister, Token token) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Token token = (Token) objects[1];
				Modulo module = semanticRegister.getLastModule();
				if(module.getTipoExp().equals("OUT")){
					if(!module.containsSymbol(token.getLexeme()) && !token.isConstantate()){
						throw new SemanticError("Identificador (" + token.getLexeme() + ") n�o declarado");
					} else {
						if(token.getMsilType().equals("int64")){
							module.addCode(Utils.DOUBLE_TAB + Utils.WRITE_INT);
						} else if(token.getMsilType().equals("float64")){
							module.addCode(Utils.DOUBLE_TAB + Utils.WRITE_FLOAT);
						} else if(token.getMsilType().equals("bool")){
							module.addCode(Utils.DOUBLE_TAB + Utils.WRITE_BOOL);
						} else if(token.getMsilType().equals("string")){
							module.addCode(Utils.DOUBLE_TAB + Utils.WRITE_STRING);
						}
					}
				}
			}
		}.executeSemanticAction(semanticRegister, token);
	}

	private void executeSemanticAction14(SemanticRegister semanticRegister) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				String label = "rfalse" + module.getLabelsSize();
				module.addCode(Utils.DOUBLE_TAB + "brfalse " + label);
				module.addLabel(label);
			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction15(SemanticRegister semanticRegister) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {	
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				module.addCode(Utils.DOUBLE_TAB + module.removeLastLabel() + ":");
			}
		}.executeSemanticAction(semanticRegister);

	}

	private void executeSemanticAction16(SemanticRegister semanticRegister) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {	
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				String label = "rtrue" + module.getLabelsSize();
				module.addCode(Utils.DOUBLE_TAB + "br " + label) ;
				module.addCode(Utils.DOUBLE_TAB + module.removeLastLabel() + ":");
				module.addLabel(label);
			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction17(SemanticRegister semanticRegister) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				String label = "r" + module.getLabelsSize();
				module.addCode(Utils.DOUBLE_TAB + label + ":");
				module.addLabel(label);
			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction18(SemanticRegister semanticRegister, Token token) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Token token = (Token) objects[1];
				Modulo module = semanticRegister.getLastModule();
				String label = "r" + module.getLabelsSize();
				String type = token.getLexeme().equals("isTrueDo") ? "brfalse " : "brtrue ";
				module.addCode(Utils.DOUBLE_TAB + type + label);
				module.addLabel(label);
			}
		}.executeSemanticAction(semanticRegister, token);
	}

	private void executeSemanticAction19(SemanticRegister semanticRegister) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				String label2 = module.removeLastLabel();
				String label1 = module.removeLastLabel();
				module.addCode(Utils.DOUBLE_TAB + "br " + label1, Utils.DOUBLE_TAB + label2 + ":");
			}
		}.executeSemanticAction(semanticRegister);
	}
	
	private void executeSemanticAction22(SemanticRegister semanticRegister, Token token) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Token token = (Token) objects[1];
				Modulo module = semanticRegister.getLastModule();
				module.typeStackPush(token.getMsilType());
				module.addCode("ldc.i4.1");
			}
		}.executeSemanticAction(semanticRegister, token);
	}
	
	private void executeSemanticAction23(SemanticRegister semanticRegister, Token token) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Token token = (Token) objects[1];
				Modulo module = semanticRegister.getLastModule();
				module.typeStackPush(token.getMsilType());
				module.addCode("ldc.i4.0");
			}
		}.executeSemanticAction(semanticRegister, token);
	}
	
	private void executeSemanticAction24(SemanticRegister semanticRegister) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				
				String t = module.typeStatckPop();
				if(!t.equals("bool")){
					throw new SemanticError("Esperado tipo booleano encontrado " + t);
				} else {
					module.addCode("ldc.i4.1 XOR");
				}
				
			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction25(SemanticRegister semanticRegister, Token token) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Token token = (Token) objects[1];
				Modulo modulo = semanticRegister.getLastModule();
				modulo.addOperador(token);
			}
		}.executeSemanticAction(semanticRegister, token);
	}

	private void executeSemanticAction26(SemanticRegister semanticRegister) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];

				Modulo modulo = semanticRegister.getLastModule();

				String operador = modulo.getOperador();

				if (operador.equals("==")) {
					modulo.addCode(Utils.DOUBLE_TAB + "ceq");
				}
				if (operador.equals("!=")) {
					modulo.addCode(Utils.DOUBLE_TAB + "ceq", Utils.DOUBLE_TAB + "ldc.i4.1", Utils.DOUBLE_TAB + "xor");
				}
				if (operador.equals("<")) {
					modulo.addCode(Utils.DOUBLE_TAB + "clt");
				}
				if (operador.equals("<=")) {
					modulo.addCode(Utils.DOUBLE_TAB + "cgt", Utils.DOUBLE_TAB + "ldc.i4.1", Utils.DOUBLE_TAB + "xor");
				}
				if (operador.equals(">")) {
					modulo.addCode(Utils.DOUBLE_TAB + "cgt");
				}
				if (operador.equals(">=")) {
					modulo.addCode(Utils.DOUBLE_TAB + "clt",Utils.DOUBLE_TAB + "ldc.i4.1",Utils.DOUBLE_TAB + "xor");
				}	

				modulo.setOperador("");
			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction27(SemanticRegister regSemantico, Token token) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				String tipo1 = module.typeStatckPop();
				String tipo2 = module.typeStatckPop();
				if(tipo1.equals(tipo2)){
					module.typeStackPush(tipo1);
				} else {
					throw new SemanticError("Tipos Inv�lidos para opera��o");
				}
				module.addCode(Utils.DOUBLE_TAB + "add");
			}
		};
	}

	private void executeSemanticAction28(SemanticRegister regSemantico, Token token) throws SemanticError{
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				String tipo1 = module.typeStatckPop();
				String tipo2 = module.typeStatckPop();
				if(tipo1.equals(tipo2)){
					module.typeStackPush(tipo1);
				} else {
					throw new SemanticError("Tipos Inv�lidos para opera��o");
				}
				module.addCode(Utils.DOUBLE_TAB + "sub");
			}
		};
	}

	private void executeSemanticAction29(SemanticRegister semanticRegister, Token token) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				String tipo1 = module.typeStatckPop();
				String tipo2 = module.typeStatckPop();
				if(tipo1.equals(tipo2)){
					module.typeStackPush(tipo1);
				} else {
					throw new SemanticError("Tipos Inv�lidos para opera��o");
				}
				module.addCode(Utils.DOUBLE_TAB + "mul");
			}
		}.executeSemanticAction(semanticRegister, token);
	}

	private void executeSemanticAction30(SemanticRegister semanticRegister, Token token) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				String tipo1 = module.typeStatckPop();
				String tipo2 = module.typeStatckPop();
				if(tipo1.equals(tipo2)){
					module.typeStackPush(tipo1);
				} else {
					throw new SemanticError("Tipos Inv�lidos para opera��o");
				}
				module.addCode(Utils.DOUBLE_TAB + "div");
			}
		}.executeSemanticAction(semanticRegister, token);
	}

	private void executeSemanticAction31(SemanticRegister semanticRegister) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				Token token = module.getFirstId(); 
				if (!module.containsSymbol(token.getLexeme())) {
					throw new SemanticError("Identificador (" + token.getLexeme() + ") n�o declarado");
				}
				module.typeStackPush(token.getMsilType());
				if(!module.containsParameter(token)){
					module.addCode(Utils.DOUBLE_TAB + "ldloc " + token.getLexeme());					
				} else {
					module.addCode(Utils.DOUBLE_TAB + "ldarg " + token.getLexeme());
				}

			}
		}.executeSemanticAction(semanticRegister);
	}

	private void executeSemanticAction32(SemanticRegister semanticRegister) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				module.setTipoExp("MODULO");
			}
		}.executeSemanticAction(semanticRegister);

	}

	private void executeSemanticAction33(SemanticRegister semanticRegister) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Modulo module = semanticRegister.getLastModule();
				if (module.getTipoExp().equalsIgnoreCase("MODULO")) {
					Token t = module.getLastId();
					module.addCode("call " + t.getMsilType() + " " + semanticRegister.getArquivo() + "::" + t.getLexeme() + "(" +t.getMsilType() + ")");
				}
			}
		}.executeSemanticAction(semanticRegister);

	}

	private void executeSemanticAction34(SemanticRegister semanticRegister, Token token) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Token token = (Token) objects[1];
				Modulo module = semanticRegister.getLastModule();
				module.addCode(Utils.DOUBLE_TAB + "ldc.i8 " + token.getLexeme());

			}
		}.executeSemanticAction(semanticRegister, token);
	}
	
	private void executeSemanticAction35(SemanticRegister semanticRegister, Token token) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Token token = (Token) objects[1];
				Modulo module = semanticRegister.getLastModule();
				module.addCode(Utils.DOUBLE_TAB + "ldc.r8 " + token.getLexeme());

			}
		}.executeSemanticAction(semanticRegister, token);
	}

	private void executeSemanticAction36(SemanticRegister semanticRegister, Token token) throws SemanticError {
		new MySemanticAction() {

			@Override
			public void executeSemanticAction(Object ... objects) throws SemanticError {
				SemanticRegister semanticRegister = (SemanticRegister) objects[0];
				Token token = (Token) objects[1];
				Modulo module = semanticRegister.getLastModule();
				module.addCode(Utils.DOUBLE_TAB + "ldstr " + token.getLexeme());

			}
		}.executeSemanticAction(semanticRegister, token);
	}




}
