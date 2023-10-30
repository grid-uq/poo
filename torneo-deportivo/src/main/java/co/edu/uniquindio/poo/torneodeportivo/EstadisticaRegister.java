package co.edu.uniquindio.poo.torneodeportivo;

import java.util.Collection;
import java.util.Optional;

public interface EstadisticaRegister {
    Collection<RegistroEstadistica> getEstadisticas();
    Optional<RegistroEstadistica> getEstadistica(Estadistica estadistica);
    void registrarEstadistica(RegistroEstadistica estadistica);
}
