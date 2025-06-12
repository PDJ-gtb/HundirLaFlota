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
    }

@Override
public void windowOpened(WindowEvent e)
{
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e)
{
	// TODO Auto-generated method stub
	
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
			vista.menuPrincipal.setVisible(true);
			System.out.println("Datos correctos");
		} 
		else {
			System.out.println("Comprobación");
		}
	}
}
}
   



