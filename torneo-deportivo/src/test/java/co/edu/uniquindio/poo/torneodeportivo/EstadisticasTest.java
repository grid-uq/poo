/**
 * Clase para probar el registro de las estadísticas
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class EstadisticasTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(EstadisticasTest.class.getName());

    private Map<String,Torneo> torneos;  
    private Map<String,Jugador> jugadores;  
    private Map<String,Equipo> equipos;

    private Map<String,Participante> participantes;
    private Estadistica efectividad;
    private Estadistica errores;

    /**
     * Resgistrar estadísticas a un participante
     *
     */
    @Test
    public void registrarEstadisticasTest() {
        LOG.info("Inicio de prueba registrarEstadisticasTest...");

        var participante = participantes.values().stream().filter(p->p instanceof Jugador).findAny().orElse(null);

        assertNotNull(participante);

        var participanteRegistrado = torneos.get("Copa Mundo Ajedrez")
                .buscarParticipantePorNombre(participante.getNombreCompleto());

        assertEquals(participante,participanteRegistrado.orElse(null));

        var estadisticasRegistradas = participanteRegistrado.map( Participante::getEstadisticas )
                .orElseGet(Collections::emptyList);

        assertEquals( 2 , estadisticasRegistradas.size());
        var estadisticas = estadisticasRegistradas.stream().map(RegistroEstadistica::estadistica).toList();
        assertTrue(estadisticas.contains(efectividad));
        assertTrue(estadisticas.contains(errores));

        LOG.info("Fin de prueba registrarEstadisticasTest...");
    }



    /**
     * Método que permite inicializar el conjunto de datos de prueba que será usado en las pruebas
     * 
     * 
     */
    @BeforeEach
    public void inicizalizarDatosPrueba(){

        torneos = new HashMap<>();
        participantes = new HashMap<>();

        efectividad = new Estadistica("Efectividad",TipoEstadistica.POSITIVA);
        errores = new Estadistica("Errores",TipoEstadistica.NEGATIVA);

        var copaMundoA = inicizalizarDatosPruebaTorneo1();
        torneos.put(copaMundoA.getNombre(), copaMundoA);

        var copaMundoB = inicizalizarDatosPruebaTorneo2();
        torneos.put(copaMundoB.getNombre(), copaMundoB);


    }

    private Torneo inicizalizarDatosPruebaTorneo1() {
        //{nombre:"Copa Mundo Ajedrez","fechaInicio":"fechaActual + 1mes", "fechaInicioInscripciones": "fechaActual - 15 días", "fechaCierreInscripciones": "fechaActual+15 días", "numeroParticipante": 24, "limiteEdad":0,"valorInscripcion":0, "tipoTorneo":"LOCAL","caracter":"INDIVIDUAL",
        var torneo = new Torneo("Copa Mundo Ajedrez",  LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), (byte)24, (byte)0, 0,TipoTorneo.LOCAL,CaracterTorneo.INDIVIDUAL);

        crearParticipante1A(torneo);
        crearParticipante1B(torneo);
        crearParticipante1C(torneo);

        return torneo;
    }

    private void crearParticipante1A(Torneo torneo) {
        // "nombre":"ParticipanteA","apellido":"JugadorA","email":"jugadora@email.com","telefono":"6067431234", "fechaNacimiento":"fechaActual - 15 años", "estadisticas":[
        //{"valor":3.3 , "Estadistica":{"nombre":"Efectividad","tipo":"POSITIVA"}},
        //{"valor":4.5 , "Estadistica":{"nombre":"Errores","tipo":"NEGATIVA"}}]},
        var participante = new Jugador("ParticipanteA", "JugadorA", "jugadora@email.com", "6067431234", LocalDate.now().minusDays(15));
        crearParticipante(torneo,participante,3.3,4.5);
    }

    private void crearParticipante1B(Torneo torneo) {
        // {"nombre":"ParticipanteB","apellido":"JugadorB","email":"jugadorb@email.com","telefono":"6067431235", "fechaNacimiento":"fechaActual - 16 años", "estadisticas":[
        //        {"valor":4.3 , "Estadistica":{"nombre":"Efectividad","tipo":"POSITIVA"}},
        //        {"valor":3.5 , "Estadistica":{"nombre":"Errores","tipo":"NEGATIVA"}}]},

        var participante = new Jugador("ParticipanteB", "JugadorB", "jugadorb@email.com", "6067431235", LocalDate.now().minusDays(16));
        crearParticipante(torneo,participante,4.3,3.5);
    }

    private void crearParticipante1C(Torneo torneo) {
        // {"nombre":"ParticipanteC","apellido":"JugadorC","email":"jugadorc@email.com","telefono":"6067431236", "fechaNacimiento":"fechaActual - 17 años", "estadisticas":[
        //        {"valor":2.3 , "Estadistica":{"nombre":"Efectividad","tipo":"POSITIVA"}},
        //        {"valor":2.5 , "Estadistica":{"nombre":"Errores","tipo":"NEGATIVA"}}]}]},

        var participante = new Jugador("ParticipanteC", "JugadorC", "jugadorc@email.com", "6067431236", LocalDate.now().minusDays(17));
        crearParticipante(torneo,participante,2.3,2.5);
    }

    private void crearParticipante(Torneo torneo, Participante participante, double valorEfectividad,double valorErrores ) {
        torneo.registrarParticipante(participante);
        var registroEstadistica = new RegistroEstadistica(valorEfectividad, efectividad);
        torneo.registrarEstadisticaParticipante(participante,registroEstadistica);
        registroEstadistica = new RegistroEstadistica(valorErrores, errores);
        torneo.registrarEstadisticaParticipante(participante,registroEstadistica);

        participantes.put(participante.getNombreCompleto(),participante);
    }

    private Torneo inicizalizarDatosPruebaTorneo2() {
        //{nombre:"Copa Mundo Futbol","fechaInicio":"fechaActual + 1mes", "fechaInicioInscripciones": "fechaActual - 15 días", "fechaCierreInscripciones": "fechaActual+15 días", "numeroParticipante": 24, "limiteEdad":0,"valorInscripcion":0, "tipoTorneo":"MUNDIAL","caracter":"GRUPAL", 
        var torneo = new Torneo("Copa Mundo Futbol",  LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), (byte)24, (byte)0, 0,TipoTorneo.MUNDIAL,CaracterTorneo.GRUPAL);

        crearParticipante2A(torneo);
        crearParticipante2B(torneo);
        crearParticipante2C(torneo);
        crearParticipante2D(torneo);

        return torneo;
    }

    private void crearParticipante2A(Torneo torneo) {
        //{"nombre":"Uniquindio","representante":{"nombre":"robinson","apellido":"pulgarin","email":"rpulgarin@email.com","telefono":"6067359300"},"estadisticas":[
        //        {"valor":3.3 , "Estadistica":{"nombre":"Efectividad","tipo":"POSITIVA"}},
        //        {"valor":4.5 , "Estadistica":{"nombre":"Errores","tipo":"NEGATIVA"}}]},
        var participante = new Equipo("Uniquindio",new Persona("robinson","pulgarin","rpulgarin@email.com","6067359300"));
        crearParticipante(torneo,participante,3.3,4.5);
    }

    private void crearParticipante2B(Torneo torneo) {
        //{"nombre":"Armenia","representante":{"nombre":"alcalde","apellido":"politico","email":"politico@email.com","telefono":"6067369300"}, "estadisticas":[
        //        {"valor":4.3 , "Estadistica":{"nombre":"Efectividad","tipo":"POSITIVA"}},
        //        {"valor":3.5 , "Estadistica":{"nombre":"Errores","tipo":"NEGATIVA"}}]},
        var participante = new Equipo("Armenia",new Persona("alcalde","politico","politico@email.com","6067369300"));
        crearParticipante(torneo,participante,4.3,3.5);
    }

    private void crearParticipante2C(Torneo torneo) {
        //{"nombre":"Cafeteros","representante":{"nombre":"representante","apellido":"cafetero","email":"rcafetero@email.com","telefono":"6067379300"}, "estadisticas":[
        //        {"valor":2.3 , "Estadistica":{"nombre":"Efectividad","tipo":"POSITIVA"}},
        //        {"valor":2.5 , "Estadistica":{"nombre":"Errores","tipo":"NEGATIVA"}}]},
        var participante = new Equipo("Cafeteros",new Persona("representante","cafetero","rcafetero@email.com","6067379300"));
        crearParticipante(torneo,participante,2.3,2.5);
    }

    private void crearParticipante2D(Torneo torneo) {
        //{"nombre":"Novatos","representante":{"nombre":"novato","apellido":"cafetero","email":"novato@email.com","telefono":"6067389300"}
        var participante = new Equipo("Novatos",new Persona("novato","cafetero","novato@email.com","6067389300"));
        torneo.registrarParticipante(participante);
    }




}
