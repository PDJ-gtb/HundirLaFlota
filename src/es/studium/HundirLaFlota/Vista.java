package es.studium.HundirLaFlota;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Vista
/**
	 * 
	 */
{
	Font fuente = new Font("Wrecked Ship", Font.BOLD, 24);
	
	JFrame login = new JFrame("Login");
	Frame carga = new Frame("Pantalla de Carga");
	JFrame menuPrincipal = new JFrame("Menú Principal");
	JPanel distribucionPanel = new JPanel();
	JFrame nuevaPartida = new JFrame("Partida");
	JPanel tablero = new JPanel();
	
	Dimension tamanoFijo = new Dimension(100, 40); // Ancho, Alto
	
	Dialog errorLog = new Dialog(login, "Mensaje", true);
	Label mensajeFB = new Label("      ¡Error en los credenciales!");

	
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

		distribucionPanel.add(btnNuevaPartida);
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
		
		tablero.setLayout(new GridLayout(10, 10, 2, 2)); // filas, columnas, hgap, vgap

		for(int i = 0; i < 100; i++) {
		    JButton boton = new JButton();
		    boton.setPreferredSize(new Dimension(40, 40)); // tamaño opcional
		    tablero.add(boton);
		}

		// Añadir el panel al frame nuevaPartida
		nuevaPartida.add(tablero);

		
		nuevaPartida.setSize(563, 379);
		
		errorLog.add(mensajeFB);
		errorLog.setSize(200, 200);
		errorLog.setLocationRelativeTo(null);
		

	}
	
}


