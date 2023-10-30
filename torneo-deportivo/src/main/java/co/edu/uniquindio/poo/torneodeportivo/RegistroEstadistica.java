package co.edu.uniquindio.poo.torneodeportivo;

import java.util.Comparator;

public record RegistroEstadistica(double valor, Estadistica estadistica) implements Comparable<RegistroEstadistica>{
    public int compareTo(RegistroEstadistica registroEstadistica) {
        int resultado = 1;
        if(registroEstadistica != null){
            var comparador = Comparator.comparing(RegistroEstadistica::valor);
            if (estadistica.tipo() == TipoEstadistica.NEGATIVA) {
                comparador = comparador.reversed();
            }
            resultado = comparador.compare(this,registroEstadistica);
        }
        return resultado;
    }

}
