package co.edu.uniquindio.poo.torneodeportivo;

import java.util.Comparator;

public record ValorEstadistica(double valor, Estadistica estadistica) implements Comparable<ValorEstadistica>{
    public int compareTo(ValorEstadistica valorEstadistica) {
        int resultado = 1;
        if(valorEstadistica != null){
            var comparador = Comparator.comparing(ValorEstadistica::valor);
            if (estadistica.tipo() == TipoEstadistica.NEGATIVA) {
                comparador = comparador.reversed();
            }
            resultado = comparador.compare(this, valorEstadistica);
        }
        return resultado;
    }

}
