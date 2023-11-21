package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Enfrentamientos {
    
    public static RegistroEstadistica add;
    private String nombre;
    private String ubicacion;
    private LocalDate fecha;
    private LocalDate hora;
    private final int puntosA;
    private final int puntosB;
    private final Equipo equipo;
    private final Jueces jueces;
    private EstadoEnfrentamiento estadoEnfrentamiento;
    private List<Enfrentamientos> enfrentamientos;

    public Enfrentamientos(String nombre, String ubicacion, LocalDate fecha, LocalDate hora, Equipo equipo, Jueces jueces,
                        int puntosA, int puntosB, EstadoEnfrentamiento estadoEnfrentamiento, List<Enfrentamientos> enfrentamientos){

        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.hora = hora;
        this.equipo = equipo;
        this.jueces = jueces;
        this.puntosA = puntosA;
        this.puntosB= puntosB;
        this.estadoEnfrentamiento = estadoEnfrentamiento;
        this.enfrentamientos=enfrentamientos;

    }

    public String calculalEstadoEnfrentamiento(EstadoEnfrentamiento estadoEnfrentamiento){

        switch (estadoEnfrentamiento) {
            case PENDIENTE:
                if(fecha.isBefore(LocalDate.now())){
                    return "el enfrentamiento todavia no a empezado";
                }else if(fecha.isAfter(LocalDate.now())){
                    this.estadoEnfrentamiento= EstadoEnfrentamiento.APLAZADO;
                    return "el enfrentamiento fue aplazado";
                }else if(fecha.isEqual(LocalDate.now())){
                    this.estadoEnfrentamiento= EstadoEnfrentamiento.ENJUEGO;
                    return "el enfrentamiento esta en curso";
                }else 
                this.estadoEnfrentamiento= EstadoEnfrentamiento.FINALIZADO;
                    return "el enfrentamiento ya finalizo"; 
               

            case ENJUEGO:
                if(fecha.isAfter(LocalDate.now())){
                    this.estadoEnfrentamiento= EstadoEnfrentamiento.APLAZADO;
                    return "el enfrentamiento fue aplazado";
                }else if(fecha.isEqual(LocalDate.now())){
                    return "el enfrentamiento esta en curso";
                }else 
                    this.estadoEnfrentamiento= EstadoEnfrentamiento.FINALIZADO;
                    return "el enfrentamiento ya finalizo"; 
               

            case APLAZADO:
                if(fecha.isAfter(LocalDate.now())){
                    return "el enfrentamiento fue aplazado";
                }

            case FINALIZADO:
                return "el enfrentamiento ya finalizo";
                
            default:
                return "no se encontro el enfrentamiento";
                
        }

    }

    public void agregarEnfrentamiento(Enfrentamientos enfrentamiento) {
    if (this.enfrentamientos == null) {
        this.enfrentamientos = new ArrayList<>();
    }
        this.enfrentamientos.add(enfrentamiento);
    }


    public String getNombre() {
        return nombre;

    }public void setNombre(String nombre) {
        this.nombre = nombre;

    } public String getUbicacion() {
        return ubicacion;

    }public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;

    }public LocalDate getFecha() {
        return fecha;

    }public void setFecha(LocalDate fecha) {
        this.fecha = fecha;

    }public LocalDate getHora() {
        return hora;

    }public void setHora(LocalDate hora) {
        this.hora = hora;

    }public Equipo getEquipo() {
        return equipo;

    }public Jueces getJueces() {
        return jueces;
        
    } public int getPuntosA() {
        return puntosA;

    }public int getPuntosB() {
        return puntosB;

    }public EstadoEnfrentamiento getEstadoEnfrentamiento() {
        return estadoEnfrentamiento;

    }public void setEstadoEnfrentamiento(EstadoEnfrentamiento estadoEnfrentamiento) {
        this.estadoEnfrentamiento = estadoEnfrentamiento;
    }
        public List<Enfrentamientos> getEnfrentamiento() {
        return enfrentamientos;
    }
    public void setEnfrentamientos(List<Enfrentamientos> enfrentamientos) {
       this.enfrentamientos= enfrentamientos;
    }

    public void add(Enfrentamientos enfrentamiento) {

        this.enfrentamientos.add(enfrentamiento);
    }
}