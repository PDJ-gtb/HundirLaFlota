package es.studium.HundirLaFlota;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo
{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tiro_al_barco";
	String login = "admin1";
	String password = "Studium2025#";
	String sentencia = "";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
//
	public Connection conectar() {
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return connection;

	}
	public void desconectar (Connection connection) {
		if (connection!=null) {
			try
			{
				connection.close();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean comprobarCredenciales(Connection conexion, String usuario, String clave) {

		boolean credencialesCorrectas= false;
		String claveEncriptada = hashSha256(clave);
		sentencia = "SELECT * FROM usuarios WHERE nombreJugador= '"+usuario + "' AND passJugador = SHA2('"+ claveEncriptada + "',256);";

		try
		{
			statement = conexion.createStatement();
			rs = statement.executeQuery(sentencia);

			if (rs.next()) {
				credencialesCorrectas=true;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return credencialesCorrectas;
	}
	private String hashSha256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            StringBuilder hashtext = new StringBuilder(no.toString(16));

            // Add leading zeros to get a 64-character hash
            while (hashtext.length() < 64) {
                hashtext.insert(0, '0');
            }
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}



    

