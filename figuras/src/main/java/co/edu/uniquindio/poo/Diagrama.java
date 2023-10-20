package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Diagrama {

    Collection<Figura> extraerCuadradosRectangulos( Collection<Figura> figuras ){
        Predicate<Figura> condicion = figura -> figura instanceof Rectangulo;
        
        return figuras.stream() // Vamos a recorrer las figuras
        .filter(condicion) // Filtrar por condición // solo rectangulos 
        .sorted( Comparator.comparing(Figura::calcularArea) ) // Ordenar las figuras que pasaron el filtro basado en su área
        .toList(); // Retorne esas figuras en forma de lista
    }

    Collection<Figura> extraerCuadradosRectangulos2( Collection<Figura> figuras ){
        List<Figura> resultado = new ArrayList<>();
        
        for (Figura figura : figuras) {
            if( figura instanceof Rectangulo ){
                resultado.add( figura );
            }
        }
        
        resultado.sort( Comparator.comparing( Figura::calcularArea ) );

        return resultado;
    }
}
