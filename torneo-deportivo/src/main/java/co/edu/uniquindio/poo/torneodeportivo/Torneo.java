/**
 * Registro que agrupa los datos de un Torneo
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;

public class Torneo {
    private final String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaInicioInscripciones;
    private LocalDate fechaCierreInscripciones;
    private final byte numeroParticipantes;
    private final byte limiteEdad;
    private final int valorInscripcion;
    private final TipoTorneo tipoTorneo;

    public Torneo(String nombre, LocalDate fechaInicio,
            LocalDate fechaInicioInscripciones,
            LocalDate fechaCierreInscripciones, byte numeroParticipantes,
            byte limiteEdad, int valorInscripcion,TipoTorneo tipoTorneo) {
        assert nombre != null: "El nombre es requerido";
        
        
        assert fechaCierreInscripciones != null: "La fecha de cierre de inscripciones del torneo es requerida";
        assert numeroParticipantes >= 0 : "El número de participantes debe ser mayor o igual a 0";
        assert limiteEdad >= 0: "El limite de edad debe ser mayor o igual a 0";;
        assert valorInscripcion >= 0 : "El valor de la inscripción debe ser mayor o igual a 0";
        
        assert fechaCierreInscripciones.isAfter(fechaInicioInscripciones) : "La fecha de cierre de inscripciones no puede ser anterior al inicio de las mismas";
        this.nombre = nombre;
        
        setFechaInicioInscripciones(fechaInicioInscripciones);
        this.fechaCierreInscripciones = fechaCierreInscripciones;
        setFechaInicio(fechaInicio);
        this.numeroParticipantes = numeroParticipantes;
        this.limiteEdad = limiteEdad;
        this.valorInscripcion = valorInscripcion;
        this.tipoTorneo = tipoTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaInicioInscripciones() {
        return fechaInicioInscripciones;
    }

    public LocalDate getFechaCierreInscripciones() {
        return fechaCierreInscripciones;
    }

    public byte getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public byte getLimiteEdad() {
        return limiteEdad;
    }

    public int getValorInscripcion() {
        return valorInscripcion;
    }

    public TipoTorneo getTipoTorneo() {
        return tipoTorneo;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        assert fechaInicio != null : "La fecha de inicio del torneo es requerida";
        assert ( fechaInicioInscripciones == null || fechaInicio.isAfter(fechaInicioInscripciones) ) &&
                ( fechaCierreInscripciones == null || fechaInicio.isAfter(fechaCierreInscripciones) ) : "La fecha de inicio del torneo debe ser posterior a las de inicio y cierre de inscripciones";
        this.fechaInicio = fechaInicio;
    }

    public void setFechaInicioInscripciones(LocalDate fechaInicioInscripciones) {
        assert fechaInicioInscripciones != null : "La fecha de inicio de inscripciones al torneo es requerida";
        this.fechaInicioInscripciones = fechaInicioInscripciones;
    }

    @Override
    public String toString() {
        return "Torneo [nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaInicioInscripciones="
                + fechaInicioInscripciones + ", fechaCierreInscripciones=" + fechaCierreInscripciones
                + ", numeroParticipantes=" + numeroParticipantes + ", limiteEdad=" + limiteEdad + ", valorInscripcion="
                + valorInscripcion + ", tipoTorneo=" + tipoTorneo + "]";
    }
}
