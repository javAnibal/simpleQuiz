package main;

import enums.Categoria;
import models.BancoPregunta;
import models.Jugador;
import models.Pregunta;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        BancoPregunta miBanco = new BancoPregunta();
        miBanco.cargarPreguntasDesdeArchivo("ciencias.txt",Categoria.CIENCIA);
        System.out.println("*** Juego Preguntas & Respuestas *** ");
        boolean flat = false;

        do {

            System.out.println("Ingrese su nombre: ");
            String nombre = sc.nextLine();
            Jugador jugador456 = new Jugador(nombre);
            System.out.println("Elija el Tema");

            String[] opciones = {"1.- Ciencias", "2.- Tecnología", "3.- Matemáticas"};
            for (String opt : opciones) {
                System.out.println(opt);
            }
            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {

                case 1 -> {
                    Categoria categoriaSeleccionada = Categoria.CIENCIA;
                    mostrarPreguntasPoCategoria(categoriaSeleccionada, miBanco);

                }
                case 2 -> {
                    Categoria categoriaSelecionada = Categoria.TECNOLOGIA;
                    mostrarPreguntasPoCategoria(categoriaSelecionada, miBanco);

                }

                case 3 -> {

                    Categoria categoriaSelecionada = Categoria.HISTORIA;
                    mostrarPreguntasPoCategoria(categoriaSelecionada, miBanco);

                }
            }
        } while (false);
        sc.close();

    }


    //M() para acceder a la información solicitada.


    private static void mostrarPreguntasPoCategoria(Categoria categoria, BancoPregunta bancoPregunta) {

        // 1) Accedemos a al Map de preguntas que está dentro del BancoPregunta
        //      Lo metemos tO en una nueva lista.
        List<Pregunta> preguntas = bancoPregunta.getTodasLasPreguntas().get(categoria);
        // 2) Preguntamos si la la lista esta vacía
        if ((preguntas == null) || preguntas.isEmpty()) {
            System.out.println("No hay preguntas para esta Categoría");
            return;
        }

        //Variables para acumular puntos
        int puntos = 0;

        // Recorremos las preguntas / mostramos una pregunta
        for (Pregunta pregunta : preguntas) {
            System.out.println(pregunta.getLaPregunta());
            // Mostramos las opciones posibles
            pregunta.getPosiblesRespuestas().forEach((opcion, respuesta) -> {
                System.out.println(opcion + ": " + respuesta);
            });


            // Capturamos la respuesta del jugador

            System.out.println("Seleccione una opcion [A,B,C,D]: ");
            String respuestaJugador = sc.nextLine().toUpperCase();

            // comprobamos si la respuesta del jugador es correcta

            if (respuestaJugador.equals(pregunta.getOpcionCorrecta().toString())) {
                System.out.println("¡Correcto!");
                puntos++; // aumentamos los puntos

            } else {
                System.out.println("Incorrecto!! La respuesta es: " + pregunta.getOpcionCorrecta());
            }
        }
        System.out.println("Has acertado : " + puntos);

    }

}
