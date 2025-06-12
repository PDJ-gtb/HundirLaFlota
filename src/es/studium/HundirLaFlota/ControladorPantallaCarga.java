package es.studium.HundirLaFlota;


import es.studium.ejemplos10.modelo.PantallaCargaModelo;
import es.studium.ejemplos10.vista.PantallaCargaVista;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class PantallaCargaControlador {
    private PantallaCargaModelo modelo;
    private PantallaCargaVista vista;
    private Timer timer;
    private Clip clip;

    public PantallaCargaControlador(PantallaCargaModelo modelo, PantallaCargaVista vista) {
        this.modelo = modelo;
        this.vista = vista;

        reproducirSonido("D:/PR/WorkSpacePR/Tema10/src/es/studium/ejemplos10/rayos.wav");

        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelo.incrementarProgreso(2);
                vista.actualizarProgreso(modelo.getProgreso());

                if (modelo.getProgreso() >= 82) {
                    modelo.incrementarProgreso(100 - modelo.getProgreso());
                    vista.actualizarProgreso(modelo.getProgreso());
                    timer.stop();
                    vista.mostrarMensajeFinal();
                }
            }
        });
        timer.start();
    }

    private void reproducirSonido(String ruta) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ruta));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

