package models;

import enums.Categoria;
import enums.Opcion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BancoPregunta {
    private Map<Categoria, List<Pregunta>> todasLasPreguntas;

    public BancoPregunta() {
        this.todasLasPreguntas = new LinkedHashMap<>();
        creacionPreguntas();
    }

    public Map<Categoria, List<Pregunta>> getTodasLasPreguntas() {
        return todasLasPreguntas;
    }

    public void creacionPreguntas() {

        Pregunta tecnoPregunta001 = new Pregunta("¿Qué es la herencia en Java?", Opcion.B);
        Pregunta tecnoPregunta002 = new Pregunta("¿Cuál de las siguientes opciones representa el concepto de polimorfismo?", Opcion.C);
        Pregunta tecnoPregunta003 = new Pregunta("¿Qué palabra clave en Java se utiliza para evitar que una clase sea heredada?", Opcion.C);

        //AGREGANDO LISTADO DE POSIBLES RESPUESTAS ****************************
        tecnoPregunta001.agregarPosiblesRespuestas(
                "Es un tipo de clase que no puede ser instanciada",
                "Es el proceso mediante el cual una clase adquiere las propiedades y comportamientos de otra clase",
                "Es un bloque de código que se ejecuta cuando ocurre una excepción",
                "Es una manera de encapsular datos en variables privadas"
        );

        tecnoPregunta002.agregarPosiblesRespuestas(
                "La capacidad de una clase de tener múltiples constructores",
                "La habilidad de una clase de cambiar su clase padre en tiempo de ejecución",
                "La capacidad de un objeto de tomar muchas formas, como métodos sobrescritos o sobrecargados",
                "La posibilidad de una clase de heredar de múltiples clases al mismo tiempo"
        );

        tecnoPregunta003.agregarPosiblesRespuestas(
                "private",
                "static",
                "final",
                "abstract"
        );
        // -> Hasta este punto hemos creado 3 preguntas y con respectivas posibles respuestas correctas.


        // vamos a crear el arrayList que necesita nuestro mapa que contendrá todas las preguntas de varias categorías
        List<Pregunta> preguntasTecno = new ArrayList<>();
        preguntasTecno.add(tecnoPregunta001);
        preguntasTecno.add(tecnoPregunta002);
        preguntasTecno.add(tecnoPregunta003);


        todasLasPreguntas.putIfAbsent(Categoria.TECNOLOGIA, preguntasTecno);

    }


    /**  FICHEROS->
     *
     *
     * M() en BancoPregunta que lea desde el archivo y llene el mapa.
     * 
     *  */

    public void cargarPreguntasDesdeArchivo(String nombreArchivo, Categoria categoria) {
        // Empezamos creando una nueva lista vacía (listaPreguntas) que almacenará las preguntas de la categoría específica mencionada en los argumentos
        List<Pregunta> listaPreguntas = new ArrayList<>();


        // Para abrir y leer archivo en la ubicación [Usamos un BufferedReader envuelto en un FileReader]
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/" + nombreArchivo))) {
            String linea;
            String enunciado = "";
            String[] opciones = new String[4];
            String respuestaCorrecta = "";
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("PREGUNTA:")) {
                    enunciado = linea.substring(9).trim();
                    contador = 0;
                } else if (linea.matches("^[A-D]:.*")) {
                    opciones[contador++] = linea.substring(3).trim(); // Solo el texto
                } else if (linea.startsWith("CORRECTA:")) {
                    respuestaCorrecta = linea.substring(9).trim();
                } else if (linea.equals("---")) {

                    // Creamos una pregunta [Si las condiciones son correctas]
                    Pregunta p = new Pregunta(enunciado, Opcion.valueOf(respuestaCorrecta));
                    p.agregarPosiblesRespuestas(opciones[0], opciones[1], opciones[2], opciones[3]);

                    //Se agrega la pregunta al nuevo ArrayList [listaPreguntas]
                    listaPreguntas.add(p);
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        // Asociar lista a la categoría
        todasLasPreguntas.putIfAbsent(categoria, listaPreguntas);
    }

}


