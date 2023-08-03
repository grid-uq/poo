package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;

public record Torneo(String nombre, LocalDate fechaInicio, LocalDate fechaInicioInscripciones,
        LocalDate fechaCierreInscripciones, Byte numeroParticipantes, Byte limiteEdad, Integer valorInscripcion) {

    public Torneo{
        assert nombre != null;
        assert fechaInicio != null;
        assert fechaInicioInscripciones != null;
        assert fechaCierreInscripciones != null;
        assert numeroParticipantes >= 0;
    }
}
