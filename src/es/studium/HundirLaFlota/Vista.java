package es.studium.HundirLaFlota;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista 
{
	Font fuente = new Font("Wrecked Ship", Font.BOLD, 24);
	
	Frame login = new Frame("Login");
	Frame carga = new Frame("Pantalla de Carga");
	JFrame menuPrincipal = new JFrame("Menú Principal");
	JPanel distribucionPanel = new JPanel();
	Frame nuevaPartida = new Frame("Partida");
	
	Dimension tamanoFijo = new Dimension(100, 40); // Ancho, Alto
	
	
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
		login.setBackground(Color.pink);
		login.setVisible(false);
		
		distribucionPanel.add(lblTitulo);
		
		distribucionPanel.setLayout(new BoxLayout(distribucionPanel, BoxLayout.Y_AXIS));
		distribucionPanel.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100)); // Top, Left, Bottom, Right

		distribucionPanel.add(new Button("Nueva Partida"));
		distribucionPanel.add(Box.createVerticalStrut(10));
		distribucionPanel.add(new Button("Ranking"));
		distribucionPanel.add(Box.createVerticalStrut(10));
		distribucionPanel.add(new Button("Ayuda"));
		distribucionPanel.add(Box.createVerticalStrut(10));
		distribucionPanel.add(new Button("Salir"));

		menuPrincipal.add(distribucionPanel);
		menuPrincipal.setSize(800, 400);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setVisible(true);
		
		
		

	}
	public static void main(String[] args)
	{
		new Vista();
	}
}


