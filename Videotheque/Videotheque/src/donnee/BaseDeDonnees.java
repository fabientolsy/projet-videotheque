package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnees {

	private Connection connection = null;
	
	private BaseDeDonnees() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ecole", "postgres", "testtest");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// SINGLETON - DEBUT
		private static BaseDeDonnees instance = null;
		public static BaseDeDonnees getInstance()
		{
			if(null == instance) instance = new BaseDeDonnees();
			return instance;
		}
		// SINGLETON - FIN

		public Connection getConnection()
		{
			
			return this.connection;
		}
}