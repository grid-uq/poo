/**
 * Clase para probar el funcionamiento del Torneo
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class TorneoTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(TorneoTest.class.getName());
    
    /**
     * Verificar que la clase Torneo almacene y recupere los datos 
     * 
     */
    @Test
    public void datosCompletos() {
        LOG.info("Inicio de prueba datos completos...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|24|0|0
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 9, 15), (byte)24, (byte)0, 0);

        // Recuperación y verificación de datos
        assertEquals("Copa Mundo",torneo.nombre());
        assertEquals(LocalDate.of(2023, 10, 1),torneo.fechaInicio());
        assertEquals(LocalDate.of(2023, 8, 1),torneo.fechaInicioInscripciones());
        assertEquals(LocalDate.of(2023, 9, 15),torneo.fechaCierreInscripciones());
        assertEquals((byte)24,torneo.numeroParticipantes());
        assertEquals((byte)0,torneo.limiteEdad());
        assertEquals(0,torneo.valorInscripcion());
        
        LOG.info("Fin de prueba datos completos...");
    }

    /**
     * Verificar que la clase Torneo valide que se ingrese los datos
     * 
     */
    @Test
    public void datosNulos() {
        LOG.info("Inicio de prueba datos nulos...");
        // Almacenar los datos de prueba null|null|null|null|24|0|0
        assertThrows(Throwable.class, ()-> new Torneo(null, null, null, null, (byte)24, (byte)0, 0));
        
        
        LOG.info("Fin de prueba datos nulos...");
    }

    /**
     * Verificar que la clase Torneo valide que el ingreso de número de participantes negativo 
     * 
     */
    @Test
    public void participantesNegativos() {
        LOG.info("Inicio de prueba número de participantes negativo...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|-24|0|0
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 01), LocalDate.of(2023, 10, 15), (byte)-24, (byte)0, 0));
        
        LOG.info("Fin de prueba  número de participantes negativo...");
    }

    /**
     * Verificar que la clase Torneo valide que el ingreso de limites de edades negativo 
     * 
     */
    @Test
    public void limiteEdadesNegativo() {
        LOG.info("Inicio de prueba limites de edades negativo...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|24|-1|0
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 01), LocalDate.of(2023, 10, 15), (byte)24, (byte)-1, 0));
        
        LOG.info("Fin de prueba  limites de edades negativo...");
    }
}
