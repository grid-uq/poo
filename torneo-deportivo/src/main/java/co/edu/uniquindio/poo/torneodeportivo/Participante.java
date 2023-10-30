package co.edu.uniquindio.poo.torneodeportivo;

import java.util.Collection;
import java.util.Optional;

public interface Participante extends EstadisticaRegister {
    String getNombreCompleto();

    EstadisticaRegister getEstadisticaRegister();

    @Override
    default Collection<RegistroEstadistica> getEstadisticas(){
        return getEstadisticaRegister().getEstadisticas();
    }

    @Override
    default Optional<RegistroEstadistica> getEstadistica(Estadistica estadistica){
        return getEstadisticaRegister().getEstadistica(estadistica);
    }

    @Override
    default void registrarEstadistica(RegistroEstadistica estadistica){
        getEstadisticaRegister().registrarEstadistica(estadistica);
    }

    default int comparar(Participante participante,Estadistica estadistica){
        var estadisticaInterna = getEstadistica(estadistica);
        var estadisticaExterna = participante.getEstadistica(estadistica);

        int resultado = 0;
        if( estadisticaInterna.isPresent() ){
            resultado = estadisticaInterna.get().compareTo( estadisticaExterna.orElse(null) );
        } else if( estadisticaExterna.isPresent() ){
            resultado = 1;
        }
        return resultado;
    }

}
