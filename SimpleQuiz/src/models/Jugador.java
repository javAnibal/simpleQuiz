package models;

public class Jugador {
    private static int numJugador = 0;
    private final int idJugador;
    private String nombre;
    private int puntos;

    public Jugador(String nombre) {
        this.idJugador = ++numJugador;
        this.nombre = nombre;
        this.puntos = 0;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        return String.format("%s", nombre);
    }
}
