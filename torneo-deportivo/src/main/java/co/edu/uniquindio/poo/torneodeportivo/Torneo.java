package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;

public record Torneo(String nombre, LocalDate fechaInicio, LocalDate fechaInicioInscripciones,
        LocalDate fechaCierreInscripciones, Byte numeroParticipantes, Byte limiteEdad, Integer valorInscripcion) {

    public Torneo {
        assert nombre != null; 
        assert numeroParticipantes == null || numeroParticipantes >= 0;
        assert limiteEdad == null || limiteEdad >= 0;
        assert valorInscripcion == null || valorInscripcion >= 0;
        assert fechaInicio == null || fechaInicio.isAfter(fechaInicioInscripciones) && fechaInicio.isAfter(fechaCierreInscripciones);
        assert fechaCierreInscripciones == null || fechaCierreInscripciones.isAfter(fechaInicioInscripciones);
    }            

    public Torneo(String nombre) {
        this(nombre,null,null,null,null,null,null);
    }

}
