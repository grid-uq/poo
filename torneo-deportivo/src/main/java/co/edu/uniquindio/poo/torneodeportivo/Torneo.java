package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;

public record Torneo(String nombre, LocalDate fechaInicio, LocalDate fechaInicioInscripciones,
        LocalDate fechaCierreInscripciones, byte numeroParticipantes, byte limiteEdad, int valorInscripcion) {

}
