/**
 * Clase que agrupa los datos de un Jugador
 * @author Área de programación UQ
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.time.Period;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Jugador extends Persona implements Participante {
    private final LocalDate fechaNacimiento;
    private final RegistroEstadistica registroEstadistica;
    private final Genero genero;//se crea un atributo de tipo Genero

    public Jugador(String nombre, String apellido, String email, String celular, LocalDate fechaNacimiento,Genero genero) {
        super(nombre, apellido, email, celular);
        ASSERTION.assertion( fechaNacimiento != null , "La fecha de nacimiento es requerida");
        this.fechaNacimiento = fechaNacimiento;
        this.genero=genero;// se instancia el atributo Genero
        registroEstadistica = new RegistroEstadisticaImpl();
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    /**
     * Permite calcula la edad que tiene un jugador en una fecha dada.
     * @param fecha Fecha contra la cual se desea calcular la edad del jugador.
     * @return La edad que tiene en años en la fecha dada.
     */
    public byte calcularEdad(LocalDate fecha){
        return (byte) Period.between(fechaNacimiento, fecha).getYears();
    }

    @Override
    public String getNombreCompleto() {
        return getNombre()+ " "+getApellido();
    }

    @Override
    public RegistroEstadistica getEstadisticaRegister() {
        return registroEstadistica;
    }

    public RegistroEstadistica getRegistroEstadistica() {//faltaba este getRegistro
        return registroEstadistica;
    }

    public Genero getGenero() {//se crea el getGenero para saber que tiene genero
        return genero;
    }
}
