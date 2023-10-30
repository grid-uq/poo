package co.edu.uniquindio.poo.torneodeportivo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RegistroEstadisticaImpl implements RegistroEstadistica {
    private final Map<Estadistica, ValorEstadistica> estadisticas;

    public RegistroEstadisticaImpl() {
        estadisticas = new HashMap<>();
    }

    public Collection<ValorEstadistica> getEstadisticas() {
        return estadisticas.values();
    }

    public Optional<ValorEstadistica> getEstadistica(Estadistica estadistica) {
        return Optional.of(estadisticas.get(estadistica));
    }

    public void registrarEstadistica(ValorEstadistica estadistica) {
        estadisticas.put(estadistica.estadistica(),estadistica);
    }
}
