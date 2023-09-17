/**
 * Registro que agrupa los datos de un Torneo
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

public class Torneo {
    private final String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaInicioInscripciones;
    private LocalDate fechaCierreInscripciones;
    private final byte numeroParticipantes;
    private final byte limiteEdad;
    private final int valorInscripcion;
    private final TipoTorneo tipoTorneo;
    private final Collection<Equipo> equipos;

    public Torneo(String nombre, LocalDate fechaInicio,
            LocalDate fechaInicioInscripciones,
            LocalDate fechaCierreInscripciones, byte numeroParticipantes,
            byte limiteEdad, int valorInscripcion,TipoTorneo tipoTorneo) {
        assert nombre != null;
        
        
        assert fechaCierreInscripciones != null;
        assert numeroParticipantes >= 0;
        assert limiteEdad >= 0;
        assert valorInscripcion >= 0;
        
        assert fechaCierreInscripciones.isAfter(fechaInicioInscripciones);
        this.nombre = nombre;
        
        setFechaInicioInscripciones(fechaInicioInscripciones);
        this.fechaCierreInscripciones = fechaCierreInscripciones;
        setFechaInicio(fechaInicio);
        this.numeroParticipantes = numeroParticipantes;
        this.limiteEdad = limiteEdad;
        this.valorInscripcion = valorInscripcion;
        this.tipoTorneo = tipoTorneo;
        this.equipos = new LinkedList<>();
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
        assert fechaInicio != null;
        assert ( fechaInicioInscripciones == null || fechaInicio.isAfter(fechaInicioInscripciones) ) &&
                ( fechaCierreInscripciones == null || fechaInicio.isAfter(fechaCierreInscripciones) );
        this.fechaInicio = fechaInicio;
    }

    public void setFechaInicioInscripciones(LocalDate fechaInicioInscripciones) {
        assert fechaInicioInscripciones != null;
        this.fechaInicioInscripciones = fechaInicioInscripciones;
    }

    public void registrarEquipo(Equipo equipo) {
        boolean existeEquipo = buscarEquipoPorNombre(equipo.nombre()).isPresent();
        assert !existeEquipo:"El equipo ya esta registrado"; 

        boolean inscripcionAbierta = fechaInicioInscripciones.isBefore(LocalDate.now()) && fechaCierreInscripciones.isAfter(LocalDate.now());
        assert inscripcionAbierta:"Las inscripciones no estan abiertas"; 

        equipos.add(equipo);
    }

    public Collection<Equipo> getEquipos() {
        return Collections.unmodifiableCollection(equipos);
    }
    
    public Optional<Equipo> buscarEquipoPorNombre(String nombre){
        Predicate<Equipo> condicion = equipo->equipo.nombre().equals(nombre);
        return equipos.stream().filter(condicion).findAny();
    }
}
