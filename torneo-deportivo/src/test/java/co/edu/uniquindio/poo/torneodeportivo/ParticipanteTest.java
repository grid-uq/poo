/**
 * Clase para probar el registro de los participantes
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class ParticipanteTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(ParticipanteTest.class.getName());

    /**
     * Verificar que sea posible registrar un participante en un torneo 
     * 
     */
    @Test
    public void registrarParticipanteTorneo() {
        LOG.info("Inicio de prueba registrarParticipanteTorneo...");
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|18\|0\|LOCAL|INDIVIDUAL}   Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años}

        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), (byte)24, (byte)18, 0,TipoTorneo.LOCAL,CaracterTorneo.INDIVIDUAL);

        
        
        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",LocalDate.now().minusYears(15));

        torneo.registrarParticipante(jugador);
        

        // Recuperación y verificación de datos
        assertTrue(torneo.getParticipantes().contains(jugador));
        assertEquals(1, torneo.getParticipantes().size());
        LOG.info("Fin de prueba registrarParticipanteTorneo...");
    }

    /**
     * Verificar que no sea posible registrar dos participantes con el mismo nombre completo en un mismo  torneo 
     * 
     */
    @Test
    public void registrarParticipanteRepetidosTorneo() {
        LOG.info("Inicio de prueba registrarParticipanteRepetidosTorneo...");
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|18\|0\|LOCAL|INDIVIDUAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300},  Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años}, Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años}, Equipo{Quindío}

        var torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), (byte)24, (byte)18, 0,TipoTorneo.LOCAL,CaracterTorneo.INDIVIDUAL);

        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",LocalDate.now().minusYears(15));
        var jugador2 = new Jugador("Christian", "Candela", "ccandela@email.com", "6067431235",LocalDate.now().minusYears(15));
                
        torneo.registrarParticipante(jugador);
        assertThrows(Throwable.class,()->torneo.registrarParticipante(jugador2));

        // Recuperación y verificación de datos
        
        LOG.info("Fin de prueba registrarParticipanteRepetidosTorneo...");
    }

    /**
     * Verificar que no sea posible registrar un jugador como participante en un torneo grupal. 
     * 
     */
    @Test
    public void registrarParticipanteIndividualTorneoGrupal() {
        LOG.info("Inicio de prueba registrarParticipanteIndividualTorneoGrupal...");
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|18\|0\|LOCAL|GRUPAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300},  Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años}, Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años}, Equipo{Quindío}

        var torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), (byte)24, (byte)18, 0,TipoTorneo.LOCAL,CaracterTorneo.GRUPAL);

        var jugador = new Jugador("Christian", "Candela", "chrcandela@email.com", "6067431234",LocalDate.now().minusYears(15));
                
        
        assertThrows(Throwable.class,()->torneo.registrarParticipante(jugador));
        
        LOG.info("Fin de prueba registrarParticipanteIndividualTorneoGrupal...");
    }

    /**
     * Verificar que no sea posible registrar un equipo en un torneo de carácter individual
     * 
     */
    @Test
    public void registrarEquipoTorneoIndividual() {
        LOG.info("Inicio de prueba registrarEquipoTorneoIndividual...");
        // Almacenar los datos de prueba Torneo{Copa Mundo\|fechaActual+ 1mes\| fechaActual - 15 días\|fechaActual+15 días\|24\|18\|0\|LOCAL|INDIVIDUAL}  Equipo{Uniquindio} Representante{Robinson,Pulgarin,rpulgarin@email.com,6067359300},  Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años}, Jugador {Christian,Candela,chrcandela@email.com,6067431234, fechaActual - 15 años}, Equipo{Quindío}

        var torneo = new Torneo("Copa Mundo", LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), (byte)24, (byte)18, 0,TipoTorneo.LOCAL,CaracterTorneo.INDIVIDUAL);
        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300");
        var equipo = new Equipo("Uniquindio", representante);
                
        
        assertThrows(Throwable.class,()->torneo.registrarParticipante(equipo));
        
        LOG.info("Fin de prueba registrarEquipoTorneoIndividual...");
    }

    


}
