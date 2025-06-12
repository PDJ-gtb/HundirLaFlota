package es.studium.HundirLaFlota;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo
{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/practicaequipos";
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
	public boolean comprobrarCredenciales(Connection conexion, String usuario, String clave) {

		boolean credencialesCorrectas= false;
		sentencia = "SELECT * FROM usuarios WHERE nombreJugador= '"+usuario + "' AND passJugador = SHA2('"+ clave + "',256);";

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
}



    

