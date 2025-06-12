package es.studium.HundirLaFlota;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VistaPantallaCarga extends JFrame {
    private static final long serialVersionUID = 1L;
    private Image fondo;
    private int progreso = 0;
    private JPanel panel;

    public VistaPantallaCarga() {
        setTitle("Pantalla de Carga");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fondo = new ImageIcon("D:/PR/WorkSpacePR/Tema10/src/es/studium/ejemplos10/bVC.gif").getImage();

        panel = new JPanel() {
            private static final long serialVersionUID = 1L;
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

                g.setColor(Color.WHITE);
                g.setFont(new Font("Wrecked Ship", Font.BOLD, 48));
                g.drawString("HUNDIR LA FLOTA", 170, 250);

                g.setColor(Color.WHITE);
                g.drawRect(150, 400, 500, 30);
                g.setColor(Color.DARK_GRAY);
                g.fillRect(151, 401, progreso * 5 - 2, 28);

                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString(progreso + "%", 380, 425);
            }
        };

        setContentPane(panel);
        setVisible(true);
    }

    public void actualizarProgreso(int nuevoProgreso) {
        this.progreso = nuevoProgreso;
        repaint();
    }

    public void mostrarMensajeFinal() {
        JOptionPane.showMessageDialog(this, "¡¿Estás listo?!");
    }
}

