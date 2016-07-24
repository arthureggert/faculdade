package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

	public Connection connection = null;
	
	public Statement statement = null;

	public void connect(String base, String usuario, String senha){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}

		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+base,usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
	}

	public void insert(String numero, String status, String problema, String equipe ) throws SQLException{

		String insertTableSQL = "INSERT INTO chamado"
				+ "(numero, status, problema, equipe) " + "VALUES"
				+ "(" + "\"" + numero + "\"" + "," + "\"" + status + "\"" + "," + "\"" + problema + "\"" + "," + "\"" + equipe + "\"" +")";


		try {
			this.statement = this.connection.createStatement();

			System.out.println(insertTableSQL);

			// execute insert SQL stetement
			this.statement.executeUpdate(insertTableSQL);

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 


	}

	public void fechaConnection() throws SQLException{			 
		if (this.statement != null) {
			this.statement.close();
		}

		if (this.connection != null) {
			this.connection.close();
		}

	}


	public void insertStop(String linha) throws SQLException {
		String insertTableSQL = "INSERT INTO stopword(stopword) values (" + "\"" + linha + "\"" +")";
		
		try {
			this.statement = this.connection.createStatement();

			System.out.println(insertTableSQL);

			// execute insert SQL stetement
			this.statement.executeUpdate(insertTableSQL);

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}

}
