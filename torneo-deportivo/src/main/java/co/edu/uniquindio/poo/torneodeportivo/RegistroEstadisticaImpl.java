package co.edu.uniquindio.poo.torneodeportivo;

import java.util.*;

public class RegistroEstadisticaImpl implements RegistroEstadistica {
    private final Map<Estadistica, ValorEstadistica> estadisticas;

    public RegistroEstadisticaImpl() {
        estadisticas = new HashMap<>();
    }

    public Collection<ValorEstadistica> getEstadisticas() {
        return estadisticas.values();
    }

    public Optional<ValorEstadistica> getEstadistica(Estadistica estadistica) {
        return Optional.ofNullable(estadisticas.get(estadistica));
    }

    public void registrarEstadistica(ValorEstadistica estadistica) {
        Objects.requireNonNull(estadistica,"La estadistica es requerida");
        estadisticas.put(estadistica.estadistica(),estadistica);
    }
}
