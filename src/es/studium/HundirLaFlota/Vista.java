package es.studium.HundirLaFlota;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

public class Vista 
{
	Frame login = new Frame("Login");
	Frame carga = new Frame("Pantalla de Carga");
	Frame menuPrincipal = new Frame("Menú Principal");
	Frame nuevaPartida = new Frame("Partida");
	
	//Elementos Login
	Label lblUsuario = new Label("Usuario:", Label.CENTER);
	TextField txtUsuario = new TextField(20);
	Label lblContrasena = new Label("Contraseña:", Label.CENTER);
	TextField txtContrasena = new TextField(20);
	Button btnLogear = new Button("Login");
	
	//Elementos Menu
	Label lblTitulo = new Label("Hundir La Flota", Label.CENTER);
	Button btnNuevaPartida = new Button("Nueva Partida");
	Button btnRanking = new Button("Ranking");
	Button btnAyuda = new Button("Ayuda");
	Button btnSalir = new Button("Salir");


	public Vista()
	{
		login.setLayout(new GridLayout(5, 5, 5, 5));
		login.add(lblUsuario);
		login.add(txtUsuario);
		login.add(lblContrasena);
		login.add(txtContrasena);
		login.add(btnLogear);
		

		login.setSize(400, 200);
		login.setResizable(false); // ← OJO: solo funciona con JFrame, no Frame
		login.setBackground(Color.pink);
		login.setVisible(true);
		
		menuPrincipal.setLayout(new GridLayout(5, 5, 10, 10));
		
		menuPrincipal.add(lblTitulo);
		menuPrincipal.add(btnNuevaPartida);
		menuPrincipal.add(btnRanking);
		menuPrincipal.add(btnAyuda);
		menuPrincipal.add(btnSalir);
		
		menuPrincipal.setSize(800, 400);
		menuPrincipal.setResizable(false); // ← OJO: solo funciona con JFrame, no Frame
		menuPrincipal.setBackground(Color.pink);
		menuPrincipal.setVisible(true);

	}
}


