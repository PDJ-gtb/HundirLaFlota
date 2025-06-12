package es.studium.HundirLaFlota;

public class Modelo
{
	private int progreso;

    public Modelo() {
        this.progreso = 0;
    }

    public int getProgreso() {
        return progreso;
    }

    public void incrementarProgreso(int cantidad) {
        progreso += cantidad;
        if (progreso > 100) {
            progreso = 100;
        }
    }

    public boolean estaCompleto() {
        return progreso >= 100;
    }
}



    

