/**
 * Registro que agrupa los datos de un Equipo
 * @author Área de programación UQ
 * @since 2023-09
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Equipo
{

    private final String nombre;
    private final Persona representante;
    private final Collection<Jugador> jugador;
    private final List<Enfrentamientos> enfrentamientos;
    private int victorias = 0;
    private int empates = 0;
    private int derrotas = 0;

    public Equipo(String nombre, Persona representante, Collection<Jugador> jugador, List<Enfrentamientos> enfrentamientos)
    {
        ASSERTION.assertion(nombre != null && !nombre.isBlank(), "El nombre es requerido");
        ASSERTION.assertion(representante != null, "El representante es requerido");

        this.nombre = nombre;
        this.representante = representante;
        this.jugador = jugador;
        this.enfrentamientos = enfrentamientos;
    }

    public String getNombre()
    { return nombre;}

    public Persona getRepresentante()
    { return representante;}

    public Collection<Jugador> getJugadores()
    { return jugador;}

    public List<Enfrentamientos> getEnfrentamientos()
    { return enfrentamientos;}


    public void registrarJugador(Jugador jugador)
    {
        validarJugadorExiste(jugador);
        Jugador.add(jugador);
    }

    public void agregarEnfrentamiento(Enfrentamientos enfrentamientos)
    {
        Enfrentamientos.add(enfrentamientos);
    }

    public Optional<Jugador> buscarJugador(Jugador jugador)
    {
        Predicate<Jugador> nombreIgual = j -> j.getNombre().equals(jugador.getNombre());
        Predicate<Jugador> apellidoIgual = j -> j.getApellido().equals(jugador.getApellido());
        
        return Jugador.stream().filter(nombreIgual.and(apellidoIgual)).findFirst();
        
    }

    private void validarJugadorExiste(Jugador jugador)
    {
        boolean existeJugador = buscarJugador(jugador).isPresent();
        ASSERTION.assertion(!existeJugador, "El jugador ya esta registrado");
    }

    public void incrementarVictorias()
    { victorias++;}

    public void incrementarEmpates()
    { empates++;}

    public void incrementarDerrotas()
    { derrotas++;}

    public int getVictorias()
    { return victorias;}

    public int getEmpates()
    { return empates;}

    public int getDerrotas()
    { return derrotas;}
    
}