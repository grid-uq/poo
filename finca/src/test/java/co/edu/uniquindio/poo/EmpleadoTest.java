package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void calcularSalarioTest() {
        var datos = Map.of(
                new EmpleadoRecoleccion("Juan","Recolector",10,1),10,
                new EmpleadoTiempoParcial("Pedro","Contratista",20,2),40 ,
                new EmpleadoTiempoCompleto("Maria","Jefe",100),100);

        datos.entrySet().forEach(this::calcularSalarioEmpleadoTest);
    }

    private void calcularSalarioEmpleadoTest(Map.Entry<Empleado, Integer> empleadoIntegerEntry) {
        var empleado = empleadoIntegerEntry.getKey();
        var salarioEsperado = empleadoIntegerEntry.getValue();
        assertEquals(salarioEsperado,empleado.calcularSalario());
    }


}