package DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	private static DbConnect istanza = null;
	private Connection conn = null;
	private static final String URL ="jdbc:postgresql://localhost:5432/Progetto";
	private static final String USERNAME="postgres";
	private static final String PASSWORD = "Pass1234";
	
	private DbConnect() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Errore caricamento drive: "+e);
		}
		
		try {
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			System.out.println("Errore: "+e);
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public static DbConnect getIstanza() throws SQLException {
		if(istanza == null) {
			istanza = new DbConnect();
		}else
			if(istanza.getConnection().isClosed()) {
				istanza = new DbConnect();
			}
		return istanza;
	}
}
