package co.edu.uniquindio.poo.torneodeportivo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EstadisticaRegisterImpl implements EstadisticaRegister {
    private final Map<Estadistica,RegistroEstadistica> estadisticas;

    public EstadisticaRegisterImpl() {
        estadisticas = new HashMap<>();
    }

    public Collection<RegistroEstadistica> getEstadisticas() {
        return estadisticas.values();
    }

    public Optional<RegistroEstadistica> getEstadistica(Estadistica estadistica) {
        return Optional.of(estadisticas.get(estadistica));
    }

    public void registrarEstadistica(RegistroEstadistica estadistica) {
        estadisticas.put(estadistica.estadistica(),estadistica);
    }
}
