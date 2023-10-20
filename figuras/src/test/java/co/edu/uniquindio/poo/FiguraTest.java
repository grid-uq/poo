package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FiguraTest {

    @Test
    void extraerCuadradosRectangulosNullTest() {
        var diagrama = new Diagrama();

        assertThrows(Throwable.class, ()->diagrama.extraerCuadradosRectangulos(null));
        
    }

    @Test
    void extraerCuadradosRectangulosVaciaTest() {
        var diagrama = new Diagrama();
        var resultado = diagrama.extraerCuadradosRectangulos(Collections.emptyList());
        assertTrue( resultado.isEmpty());
        assertTrue( resultado.size() == 0);
    }

    @Test
    void extraerCuadradosRectangulosDatosTest() {
        //{ Triangulo{1,0;1,0}, Cuadrado{1,0;1,0}, Rectagulo{5,0;7,0}, Rectangulo{1,0;1,0} }
        var diagrama = new Diagrama();
        var f1 = new Triangulo(1.0,1.0);
        var f2 = new Cuadrado(1.0);
        var f3 = new Rectangulo(5.0,7.0);
        var f4 = new Rectangulo(1.0,1.0);
        var figuras = List.of(f1,f2,f3,f4);
        var listaEsperada = List.of(f2,f4,f3);
        var resultado = diagrama.extraerCuadradosRectangulos(figuras);
        assertEquals(listaEsperada,resultado);
    }


}