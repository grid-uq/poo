/**
 * Clase para probar el funcionamiento del Torneo
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://www.gnu.org/licenses/lgpl-3.0.html#license-text) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class TorneoTest {
    /**
     * Instacia para el menejo de logs
     */
    private static final Logger log = Logger.getLogger(TorneoTest.class.getName());
    /**
     * Verificar que la clase Torneo almacene y recupere los datos 
     * 
     */
    @Test
    public void datosCompletos() {
        log.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|24|0|0
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 01), LocalDate.of(2023, 10, 15), (byte)0, (byte)0, 0);

        // Recuperación y verificación de datos
        assertEquals("Copa Mundo",torneo.nombre());
        assertEquals(LocalDate.of(2023, 10, 1),torneo.fechaInicio());
        assertEquals(LocalDate.of(2023, 8, 1),torneo.fechaInicioInscripciones());
        assertEquals(LocalDate.of(2023, 10, 15),torneo.fechaCierreInscripciones());
        assertEquals(0,torneo.numeroParticipantes());
        assertEquals(0,torneo.limiteEdad());
        assertEquals(0,torneo.valorInscripcion());
        
        log.info("Fin de prueba datos completos...");
    }

    /**
     * Verificar que la clase Torneo almacene y recupere los datos 
     * 
     */
    @Test
    public void soloNombre() {
        log.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|24|0|0
        Torneo torneo = new Torneo("Copa Mundo");

        // Recuperación y verificación de datos
        assertEquals("Copa Mundo",torneo.nombre());
        assertEquals(null,torneo.fechaInicio());
        assertEquals(null,torneo.fechaInicioInscripciones());
        assertEquals(null,torneo.fechaCierreInscripciones());
        assertEquals(null,torneo.numeroParticipantes());
        assertEquals(null,torneo.limiteEdad());
        assertEquals(null,torneo.valorInscripcion());
        
        log.info("Fin de prueba datos completos...");
    }

}
