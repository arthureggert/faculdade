package br.com.ahe.cop.copilador.gals2;


@SuppressWarnings( "deprecation" )
public class Token {
	private int id;
	private String lexeme;
	private int position;

	public Token(int id, String lexeme, int position) {
		this.id = id;
		this.lexeme = lexeme;
		this.position = position;
	}

	public final int getId() {
		return this.id;
	}

	public final String getLexeme() {
		return this.lexeme != "$" ? this.lexeme : "fim de programa";
	}

	public final int getPosition() {
		return this.position;
	}

	public String toString() {
		return this.id+" ( "+this.lexeme+" ) @ "+this.position;
	}

    public boolean isIdentificador() {
		switch (this.id) {
		case Constants.t_identificador_int:
			return true;
		case Constants.t_identificador_float:
			return true;
		case Constants.t_identificador_string:
			return true;
		case Constants.t_identificador_boolean:
			return true;
		case Constants.t_constante_int:
			return true;
		case Constants.t_constante_float:
			return true;
		case Constants.t_constante_string:
			return true;
		default:
			return false;
		}
	}

	public String getMsilType() {
		switch (this.id) {
		case Constants.t_identificador_int:
			return "int64";
		case Constants.t_identificador_float:
			return "float64";
		case Constants.t_identificador_string:
			return "string";
		case Constants.t_identificador_boolean:
			return "bool";
		case Constants.t_constante_int:
			return "int64";
		case Constants.t_constante_float:
			return "float64";
		case Constants.t_constante_string:
			return "string";
		case Constants.t_true:
			return "bool";
		case Constants.t_false:
			return "bool";
		default:
			return "";
		}
	}
	
	public boolean isConstantate() {
		switch (this.id) {
		case Constants.t_constante_int:
			return true;
		case Constants.t_constante_float:
			return true;
		case Constants.t_constante_string:
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		result = prime * result + ((this.lexeme == null) ? 0 : this.lexeme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (this.id != other.id)
			return false;
		if (this.lexeme == null) {
			if (other.lexeme != null)
				return false;
		} else if (!this.lexeme.equals(other.lexeme))
			return false;
		return true;
	}
	
	
	
	
}
