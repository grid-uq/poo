/**
 * Registro que agrupa los datos de un Equipo
 * @author Área de programación UQ
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import java.util.*;
import java.util.function.Predicate;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public final class Equipo extends Participante {
    private final String nombre;
    private final Persona representante;
    private final Collection<Jugador> jugadores;

    public Equipo(String nombre, Persona representante, Collection<Jugador> jugadores) {
        ASSERTION.assertion(nombre != null && !nombre.isBlank(), "El nombre es requerido");
        ASSERTION.assertion(representante != null, "El representante es requerido");
        this.nombre = nombre;
        this.representante = representante;
        this.jugadores = jugadores;
    }

    public Equipo(String nombre, Persona representante) {
        this(nombre, representante, new LinkedList<>());
    }

    /**
     * Permite registrar un jugador en un equipo siempre y cuando no exista ya un jugador registrado en el equipo con el mismo nombre y apellido
     *
     * @param jugador Jugador que se desea registrar.
     */
    public void registrarJugador(Jugador jugador) {
        validarJugadorExiste(jugador);
        jugadores.add(jugador);
    }

    /**
     * Permimte buscar un jugador en el equipo basado en su nombre y apellido.
     *
     * @param jugador Jugador que se desea buscar
     * @return Optional con el jugador que coincida con el nombre y apellido del jugador buscado,
     * o Optinal vacío en caso de no encontrar un jugador en el equipo con dicho nombre y apellido.
     */
    public Optional<Jugador> buscarJugador(Jugador jugador) {
        Predicate<Jugador> nombreIgual = j -> j.getNombre().equals(jugador.getNombre());
        Predicate<Jugador> apellidoIgual = j -> j.getApellido().equals(jugador.getApellido());
        return jugadores.stream().filter(nombreIgual.and(apellidoIgual)).findAny();
    }

    /**
     * Valida que no exista ya un jugador registrado con el mismo nombre y apellido, en caso de haberlo genera un assertion error.
     */
    private void validarJugadorExiste(Jugador jugador) {
        boolean existeJugador = buscarJugador(jugador).isPresent();
        ASSERTION.assertion(!existeJugador, "El jugador ya esta registrado");
    }

    @Override
    public String getNombreCompleto() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getRepresentante() {
        return representante;
    }

    public Collection<Jugador> getJugadores() {
        return Collections.unmodifiableCollection(jugadores);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Equipo) obj;
        return Objects.equals(this.nombre, that.nombre) &&
                Objects.equals(this.representante, that.representante) &&
                Objects.equals(this.jugadores, that.jugadores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, representante, jugadores);
    }

    @Override
    public String toString() {
        return "Equipo[" +
                "nombre=" + nombre + ", " +
                "representante=" + representante + ", " +
                "jugadores=" + jugadores + ']';
    }

}
