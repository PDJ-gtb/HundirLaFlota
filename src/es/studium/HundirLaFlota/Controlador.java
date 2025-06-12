package es.studium.HundirLaFlota;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

public class Controlador implements ActionListener, WindowListener {
	
	Vista vista;
	Modelo modelo;

public  Controlador (Vista v, Modelo m){
    this.vista = v;
    this.modelo = m;
	
   vista.btnLogear.addActionListener(this);
   vista.errorLog.addWindowListener(this);
   vista.login.addWindowListener(this);
   vista.btnNuevaPartida.addActionListener(this);
    }

@Override
public void windowOpened(WindowEvent e)
{
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e)
{
	if (e.getSource().equals(vista.login)) {
		vista.login.setVisible(false);
	}
	else if (e.getSource().equals(vista.errorLog)) {
		vista.errorLog.setVisible(false);
	}
}

@Override
public void windowClosed(WindowEvent e)
{
	// TODO Auto-generated method stub
	
}

@Override
public void windowIconified(WindowEvent e)
{
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeiconified(WindowEvent e)
{
	// TODO Auto-generated method stub
	
}

@Override
public void windowActivated(WindowEvent e)
{
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeactivated(WindowEvent e)
{
	// TODO Auto-generated method stub
	
}

@Override
public void actionPerformed(ActionEvent e)
{
	
	if(e.getSource().equals(vista.btnLogear)) {
		Connection connection=	modelo.conectar();
		if(modelo.comprobarCredenciales(connection,vista.txtUsuario.getText(),vista.txtContrasena.getText())) {
			vista.login.setVisible(false);
			vista.menuPrincipal.setVisible(true);
			System.out.println("Datos correctos");
		} 
		else {
			vista.errorLog.setVisible(true);
			System.out.println("Comprobación");
		}
		modelo.desconectar(connection);
	}
	else if (e.getSource().equals(vista.btnNuevaPartida)) {
		vista.nuevaPartida.setLocationRelativeTo(null);
		vista.nuevaPartida.toFront();
		vista.nuevaPartida.setVisible(true);

		System.out.println("Nueva partida");
	}
}
}
   



