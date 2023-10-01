package co.edu.uniquindio.poo.util;

import co.edu.uniquindio.poo.torneodeportivo.TipoTorneo;
import co.edu.uniquindio.poo.torneodeportivo.Torneo;

import java.util.function.Predicate;

public class TorneoBusquedaUtil {
    public static Predicate<Torneo> buscarPorNombre(String nombre){
        return torneo -> torneo.getNombre().contains(nombre);
    }
    public static Predicate<Torneo> buscarPorTipoTorneo(TipoTorneo tipoTorneo) {
        return torneo -> torneo.getTipoTorneo() == tipoTorneo;
    }
    public static Predicate<Torneo> buscarPorNumeroParticipantes(byte numeroParticipantes) {
        return torneo -> torneo.getNumeroParticipantes() == numeroParticipantes;
    }
    public static Predicate<Torneo> buscarPorLimiteEdad(byte limiteEdad) {
        return torneo -> torneo.getLimiteEdad() == limiteEdad;
    }
    public static Predicate<Torneo> buscarPorValorInscripcion(int valorInscripcion) {
        return torneo -> torneo.getValorInscripcion() == valorInscripcion;
    }

    public static Predicate<Torneo> buscarPorTodo(String nombre, Byte numeroParticipantes, Byte limiteEdad, Integer valorInscripcion, TipoTorneo tipoTorneo) {

        Predicate<Torneo> predicado = torneo -> true;
        
        if( nombre != null && !nombre.isEmpty() ){
            predicado = predicado.and(buscarPorNombre(nombre));
        }
        if( numeroParticipantes != null ){
            predicado = predicado.and(buscarPorNumeroParticipantes(numeroParticipantes));
        }
        if( limiteEdad != null ){
            predicado = predicado.and(buscarPorLimiteEdad(limiteEdad));
        }
        if( valorInscripcion != null ){
            predicado = predicado.and(buscarPorValorInscripcion(valorInscripcion));
        }
        if( tipoTorneo != null ){
            predicado = predicado.and(buscarPorTipoTorneo(tipoTorneo));
        }
        return predicado;
    }
}
