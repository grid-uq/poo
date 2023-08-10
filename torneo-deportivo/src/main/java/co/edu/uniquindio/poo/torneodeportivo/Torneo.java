/**
 * Registro que agrupa los datos de un Torneo
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;

public record Torneo(String nombre, LocalDate fechaInicio, LocalDate fechaInicioInscripciones,
        LocalDate fechaCierreInscripciones, byte numeroParticipantes, byte limiteEdad, int valorInscripcion) {

    public Torneo{
        assert nombre != null;
        assert fechaInicio != null;
        assert fechaInicioInscripciones != null;
        assert fechaCierreInscripciones != null;
        assert numeroParticipantes >= 0;
    }
}
