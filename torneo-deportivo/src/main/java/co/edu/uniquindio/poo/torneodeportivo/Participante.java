package co.edu.uniquindio.poo.torneodeportivo;

import java.util.Collection;
import java.util.Optional;

public interface Participante {
    String getNombreCompleto();

    EstadisticaParticipanteRegister getEstadisticaParticipanteRegister();

    default Collection<RegistroEstadistica> getEstadisticas(){
        return getEstadisticaParticipanteRegister().getEstadisticas();
    }

    default Optional<RegistroEstadistica> getEstadistica(Estadistica estadistica){
        return getEstadisticaParticipanteRegister().getEstadistica(estadistica);
    }

    default void registrarEstadistica(RegistroEstadistica estadistica){
        getEstadisticaParticipanteRegister().registrarEstadistica(this,estadistica);
    }

    default int comparar(Participante participante,Estadistica estadistica){
        var estadisticaInterna = getEstadistica(estadistica);
        var estadisticaExterna = participante.getEstadistica(estadistica);

        // TODO Terminar la comparacion
    }


}
