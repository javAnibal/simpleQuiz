package models;

import enums.Opcion;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pregunta {
    private static int numPregunta = 0;
    private final int  numeroPregunta;
    private String laPregunta;
    private Opcion opcionCorrecta;
    private Map<Opcion, String> posiblesRespuestas;

    public Pregunta(String laPregunta, Opcion opcionCorrecta) {
        this.numeroPregunta = ++numPregunta;
        this.laPregunta = laPregunta;
        this.opcionCorrecta = opcionCorrecta;
        this.posiblesRespuestas = new LinkedHashMap<>();
    }

    public String getLaPregunta() {
        return laPregunta;
    }

    public Opcion getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public Map<Opcion, String> getPosiblesRespuestas() {
        return posiblesRespuestas;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(String.format("Pregunta %s Nº %d", laPregunta, numeroPregunta)).append("\n");
       posiblesRespuestas.forEach((clave, valor) ->
               sb.append(String.format("%s : %s%n", clave, valor))
               );
    return sb.toString();
    }


    // M() Propios ************************************************

    public void agregarPosiblesRespuestas(String A, String B, String C, String D ){

        posiblesRespuestas.putIfAbsent(Opcion.A, A);
        posiblesRespuestas.putIfAbsent(Opcion.B, B);
        posiblesRespuestas.putIfAbsent(Opcion.C, C);
        posiblesRespuestas.putIfAbsent(Opcion.D, D);

    }


}
