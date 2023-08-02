/**
 * Clase para probar el funcionamiento del Torneo
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://www.gnu.org/licenses/lgpl-3.0.html#license-text) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class TorneoTest {
    /**
     * Instacia para el menejo de logs
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
     * Verificar que la clase Torneo permita almacenar solo el nombre 
     * 
     */
    @Test
    public void soloNombre() {
        LOG.info("Inicio de prueba solo nombre...");
        // Almacenar los datos de prueba Copa Mundo
        Torneo torneo = new Torneo("Copa Mundo");

        // Recuperación y verificación de datos
        assertEquals("Copa Mundo",torneo.nombre());
        assertEquals(null,torneo.fechaInicio());
        assertEquals(null,torneo.fechaInicioInscripciones());
        assertEquals(null,torneo.fechaCierreInscripciones());
        assertEquals(null,torneo.numeroParticipantes());
        assertEquals(null,torneo.limiteEdad());
        assertEquals(null,torneo.valorInscripcion());
        
        LOG.info("Fin de prueba solo nombre...");
    }

    /**
     * Verificar que la clase Torneo valide que se ingrese un nombre para el torneo 
     * 
     */
    @Test
    public void sinNombre() {
        LOG.info("Inicio de prueba sin nombre...");
        // Almacenar los datos de prueba null|2023-10-01|2023-08-01|2023-09-15|24|0|0
        assertThrows(Throwable.class, ()-> new Torneo(null, LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 01), LocalDate.of(2023, 10, 15), (byte)24, (byte)0, 0));
        
        // Almacenar los datos de prueba null
        assertThrows(Throwable.class, ()-> new Torneo(null));

        LOG.info("Fin de prueba sin nombre...");
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

    /**
     * Verificar que la clase Torneo valide que el ingreso de valor de inscripción negativa
     * 
     */
    @Test
    public void inscripcionNegativa() {
        LOG.info("Inicio de prueba inscripción negativa...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-08-01|2023-09-15|24|0|-1
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 01), LocalDate.of(2023, 10, 15), (byte)24, (byte)0, -1));
        
        LOG.info("Fin de prueba inscripción negativa...");
    }

    /**
     * Verificar que la clase Torneo valide que el ingreso de inscripciones posteriores a la fecha de inicio del torneo
     * 
     */
    @Test
    public void inscripcionTardia() {
        LOG.info("Inicio de prueba inscripción tardia...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-11-01|2023-11-15|24|0|0
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 11, 01), LocalDate.of(2023, 11, 15), (byte)24, (byte)0, 0));
        
        LOG.info("Fin de prueba inscripción tardia...");
    }

    /**
     * Verificar que la clase Torneo valide que el ingreso de inicio inscripciones posteriores a la fecha de cierre de inscripciones
     * 
     */
    @Test
    public void cierreInscripcionAnteriorInicio() {
        LOG.info("Inicio de prueba Cierre inscripción anterior al inicio...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-11-01|2023-11-15|24|0|0
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 15), LocalDate.of(2023, 8, 1), (byte)24, (byte)0, 0));
        
        LOG.info("Fin de prueba Cierre inscripción anterior al inicio...");
    }

        /**
     * Verificar que la clase Torneo valide que el ingreso de inicio inscripciones posteriores a la fecha de cierre de inscripciones
     * 
     */
    @Test
    public void test() {
        LOG.info("Inicio de prueba Cierre inscripción anterior al inicio...");
        // Almacenar los datos de prueba Copa Mundo|2023-10-01|2023-11-01|2023-11-15|24|0|0
        new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), null, LocalDate.of(2023, 8, 1), (byte)24, (byte)0, 0);
        
        LOG.info("Fin de prueba Cierre inscripción anterior al inicio...");
    }
}
