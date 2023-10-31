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
import java.util.function.Predicate;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class EstadisticasTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(EstadisticasTest.class.getName());

    private Map<String,Torneo> torneos;  
    private Map<String,Participante> participantes;
    private Estadistica efectividad;
    private Estadistica errores;
    private Estadistica mejor;
    private Participante noRegistrado;

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
        var estadisticas = estadisticasRegistradas.stream().map(ValorEstadistica::estadistica).toList();
        assertTrue(estadisticas.contains(efectividad));
        assertTrue(estadisticas.contains(errores));

        LOG.info("Fin de prueba registrarEstadisticasTest...");
    }


    /**
     * Resgistrar estadísticas a un participante que no esta registrado
     *
     */
    @Test
    public void registrarEstadisticasParticipanteNoRegistradoTest() {
        LOG.info("Inicio de prueba registrarEstadisticasParticipanteNoRegistradoTest...");
        //ValorEstadistica{3.3 , Estadistica{Efectividad,POSITIVA}
        var valorEstadistica = new ValorEstadistica(3.3,efectividad);
        var torneo = torneos.get("Copa Mundo Ajedrez");
        assertThrows(Throwable.class,()->torneo.registrarEstadisticaParticipante(noRegistrado,valorEstadistica));
        LOG.info("Fin de prueba registrarEstadisticasParticipanteNoRegistradoTest...");
    }

    /**
     * Resgistrar estadísticas nula a un participante
     *
     */
    @Test
    public void registrarEstadisticasNulaTest() {
        LOG.info("Inicio de prueba registrarEstadisticasNulaTest...");
        //ValorEstadistica{3.3 , Estadistica{Efectividad,POSITIVA}
        var torneo = torneos.get("Copa Mundo Ajedrez");
        var participante = participantes.values().stream().filter(p->p instanceof Jugador).findAny().orElse(null);
        assertThrows(Throwable.class,()->torneo.registrarEstadisticaParticipante(participante,null));
        LOG.info("Fin de prueba registrarEstadisticasNulaTest...");
    }

    /**
     * Resgistrar estadísticas a un participante null
     *
     */
    @Test
    public void registrarEstadisticaParticipanteNuloTest() {
        LOG.info("Inicio de prueba registrarEstadisticaParticipanteNuloTest...");
        //ValorEstadistica{3.3 , Estadistica{Efectividad,POSITIVA}
        var valorEstadistica = new ValorEstadistica(3.3,efectividad);
        var torneo = torneos.get("Copa Mundo Ajedrez");
        assertThrows(Throwable.class,()->torneo.registrarEstadisticaParticipante(null,valorEstadistica));
        LOG.info("Fin de prueba registrarEstadisticaParticipanteNuloTest...");
    }

    /**
     * Resgistrar estadística a un participante que ya la posee (actualizar)
     *
     */
    @Test
    public void actualizarEstadisticaTest() {
        LOG.info("Inicio de prueba actualizarEstadisticaTest...");
        //ValorEstadistica{4.3 , Estadistica{Efectividad,POSITIVA}
        var valorEstadistica = new ValorEstadistica(4.3,efectividad);
        var torneo = torneos.get("Copa Mundo Ajedrez");
        Predicate<Participante> condicion = p->p.getEstadisticas().stream().anyMatch(v->v.estadistica().equals(efectividad) );
        var participante = torneo.getParticipantes().stream().filter( condicion ).findAny();
        var valorOriginal = participante.map( p->p.getEstadistica(efectividad));
        torneo.registrarEstadisticaParticipante(participante.get(),valorEstadistica);
        assertNotEquals(valorOriginal.get(),participante.get().getEstadistica(efectividad).get());
        assertEquals(valorEstadistica,participante.get().getEstadistica(efectividad).get());
        LOG.info("Fin de prueba actualizarEstadisticaTest...");
    }

    /**
     * Obtener estadística a un participante
     *
     */
    @Test
    public void obtenerEstadisticasTest() {
        LOG.info("Inicio de prueba obtenerEstadisticasTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        var participante = torneo.getParticipantes().stream().findAny();
        var estadisticasOriginales = participante.map( p->p.getEstadisticas());
        var estadisticasObtenenidas = torneo.obtenerEstadisticas(participante.get());
        assertEquals(estadisticasOriginales.get(),estadisticasObtenenidas);
        LOG.info("Fin de prueba obtenerEstadisticasTest...");
    }

    /**
     * Obtener estadística a un participante que no tiene
     *
     */
    @Test
    public void obtenerEstadisticasVaciaTest() {
        LOG.info("Inicio de prueba obtenerEstadisticasVaciaTest...");
        var torneo = torneos.get("Copa Mundo Futbol");
        Predicate<Participante> condicion = p->p.getEstadisticas().isEmpty();
        var participante = torneo.getParticipantes().stream().filter(condicion).findAny();
        var estadisticasObtenenidas = torneo.obtenerEstadisticas(participante.get());
        assertTrue(estadisticasObtenenidas.isEmpty());
        LOG.info("Fin de prueba obtenerEstadisticasVaciaTest...");
    }

    /**
     * Obtener estadística a un participante que no esta registrado
     *
     */
    @Test
    public void obtenerEstadisticasParticipanteNoRegistradoTest() {
        LOG.info("Inicio de prueba obtenerEstadisticasParticipanteNoRegistradoTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        assertThrows(Throwable.class, ()-> torneo.obtenerEstadisticas(noRegistrado));
        LOG.info("Fin de prueba obtenerEstadisticasParticipanteNoRegistradoTest...");
    }

    /**
     * Obtener estadística a un participante null
     *
     */
    @Test
    public void obtenerEstadisticasParticipanteNullTest() {
        LOG.info("Inicio de prueba obtenerEstadisticasParticipanteNullTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        assertThrows(Throwable.class, ()-> torneo.obtenerEstadisticas(null));
        LOG.info("Fin de prueba obtenerEstadisticasParticipanteNullTest...");
    }

    /**
     * Obtener el participante con la mayor estadística (POSITIVA)
     */
    @Test
    public void obtenerParticipanteMejorEstadisticaPositivaTest() {
        LOG.info("Inicio de prueba obtenerParticipanteMejorEstadisticaPositivaTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        Predicate<Participante> condicion = p->p.getEstadisticas().stream().anyMatch(e->e.valor()==4.3&&e.estadistica().equals(efectividad));
        var participante = torneo.getParticipantes().stream().filter(condicion).findAny();
        var participanteObtenido = torneo.buscarMejor(efectividad);
        assertEquals(participante,participanteObtenido);
        LOG.info("Fin de prueba obtenerParticipanteMejorEstadisticaPositivaTest...");
    }

    /**
     * Obtener el participante con la mayor estadística (NEGATIVA)
     */
    @Test
    public void obtenerParticipanteMejorEstadisticaNegativaTest() {
        LOG.info("Inicio de prueba obtenerParticipanteMejorEstadisticaNegativaTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        Predicate<Participante> condicion = p->p.getEstadisticas().stream().anyMatch(e->e.valor()==2.5&&e.estadistica().equals(errores));
        var participante = torneo.getParticipantes().stream().filter(condicion).findAny();
        var participanteObtenido = torneo.buscarMejor(errores);
        assertEquals(participante,participanteObtenido);
        LOG.info("Fin de prueba obtenerParticipanteMejorEstadisticaNegativaTest...");
    }

    /**
     * Obtener el participante con la mayor estadística que no tiene ningún participante
     */
    @Test
    public void obtenerParticipanteMejorEstadisticaNoExisteTest() {
        LOG.info("Inicio de prueba obtenerParticipanteMejorEstadisticaNoExisteTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        var participanteObtenido = torneo.buscarMejor(mejor);
        assertTrue(participanteObtenido.isEmpty());
        LOG.info("Fin de prueba obtenerParticipanteMejorEstadisticaNoExisteTest...");
    }

    /**
     * Obtener el participante con la mayor estadística en un torneo sin participantes
     */
    @Test
    public void obtenerParticipanteMejorTorneoVacioTest() {
        LOG.info("Inicio de prueba obtenerParticipanteMejorTorneoVacioTest...");
        var torneo = torneos.get("Vacío");
        var participanteObtenido = torneo.buscarMejor(efectividad);
        assertTrue(participanteObtenido.isEmpty());
        LOG.info("Fin de prueba obtenerParticipanteMejorTorneoVacioTest...");
    }

    /**
     * Obtener los participantes con estadística superior o igual a la dada (POSITIVA)
     */
    @Test
    public void obtenerParticipantesEstadisticaSuperiorIgualPositivaTest() {
        LOG.info("Inicio de prueba obtenerParticipantesEstadisticaSuperiorIgualPositivaTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        Predicate<Participante> condicion = p->p.getEstadisticas().stream().anyMatch(e->e.valor()>=3.3&&e.estadistica().equals(efectividad));
        var participantes = torneo.getParticipantes().stream().filter(condicion).toList();
        var participantesObtenidos = torneo.buscarSuperiorIgualA(efectividad,3.3);
        assertTrue(participantes.containsAll(participantesObtenidos) && participantes.size() == participantesObtenidos.size());
        LOG.info("Fin de prueba obtenerParticipantesEstadisticaSuperiorIgualPositivaTest...");
    }

    /**
     * Obtener los participantes con estadística superior o igual a la dada (NEGATIVA)
     */
    @Test
    public void obtenerParticipantesEstadisticaSuperiorIgualNegativaTest() {
        LOG.info("Inicio de prueba obtenerParticipantesEstadisticaSuperiorIgualNegativaTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        Predicate<Participante> condicion = p->p.getEstadisticas().stream().anyMatch(e->e.valor()<=3.5&&e.estadistica().equals(errores));
        var participantes = torneo.getParticipantes().stream().filter(condicion).toList();
        var participantesObtenidos = torneo.buscarSuperiorIgualA(errores,3.5);
        assertTrue(participantes.containsAll(participantesObtenidos) && participantes.size() == participantesObtenidos.size());
        LOG.info("Fin de prueba obtenerParticipantesEstadisticaSuperiorIgualNegativaTest...");
    }

    /**
     * Obtener los participantes con estadística superior o igual de una estadística que no posee ningún participante
     */
    @Test
    public void obtenerParticipantesEstadisticaSuperiorIgualNoExisteTest() {
        LOG.info("Inicio de prueba obtenerParticipantesEstadisticaSuperiorIgualNoExisteTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        var participantesObtenidos = torneo.buscarSuperiorIgualA(mejor,3.3);
        assertTrue(participantesObtenidos.isEmpty());
        LOG.info("Fin de prueba obtenerParticipantesEstadisticaSuperiorIgualNoExisteTest...");
    }

    /**
     * Obtener los participantes con estadística inferior a la dada (POSITIVA)
     */
    @Test
    public void obtenerParticipantesEstadisticaInferiorPositivaTest() {
        LOG.info("Inicio de prueba obtenerParticipantesEstadisticaInferiorPositivaTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        Predicate<Participante> condicion = p->p.getEstadisticas().stream().anyMatch(e->e.valor()<3.3&&e.estadistica().equals(efectividad));
        var participantes = torneo.getParticipantes().stream().filter(condicion).toList();
        var participantesObtenidos = torneo.buscarInferiorA(efectividad,3.3);
        assertTrue(participantes.containsAll(participantesObtenidos) && participantes.size() == participantesObtenidos.size());
        LOG.info("Fin de prueba obtenerParticipantesEstadisticaInferiorPositivaTest...");
    }

    /**
     * Obtener los participantes con estadística inferior a la dada (NEGATIVA)
     */
    @Test
    public void obtenerParticipantesEstadisticaInferiorNegativaTest() {
        LOG.info("Inicio de prueba obtenerParticipantesEstadisticaInferiorNegativaTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        Predicate<Participante> condicion = p->p.getEstadisticas().stream().anyMatch(e->e.valor()>3.5&&e.estadistica().equals(errores));
        var participantes = torneo.getParticipantes().stream().filter(condicion).toList();
        var participantesObtenidos = torneo.buscarInferiorA(errores,3.5);
        assertTrue(participantes.containsAll(participantesObtenidos) && participantes.size() == participantesObtenidos.size());
        LOG.info("Fin de prueba obtenerParticipantesEstadisticaInferiorNegativaTest...");
    }

    /**
     * Obtener los participantes con estadística inferior a la dada de una estadística que no posee ningún participante
     */
    @Test
    public void obtenerParticipantesEstadisticaInferiorNoExisteTest() {
        LOG.info("Inicio de prueba obtenerParticipantesEstadisticaInferiorNoExisteTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        var participantesObtenidos = torneo.buscarInferiorA(mejor,3.3);
        assertTrue(participantesObtenidos.isEmpty());
        LOG.info("Fin de prueba obtenerParticipantesEstadisticaInferiorNoExisteTest...");
    }

    /**
     * Obtener la media de una estadistica
     */
    @Test
    public void obtenerMediaEstadisticaTest() {
        LOG.info("Inicio de prueba obtenerMediaEstadisticaTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");

        var promedio = torneo.promedioEstadistica(efectividad);
        assertEquals(3.3,promedio,0.00000001);
        LOG.info("Fin de prueba obtenerMediaEstadisticaTest...");
    }

    /**
     * Obtener la media de una estadística que no posee ningún participante
     */
    @Test
    public void obtenerMediaEstadisticaNoExisteTest() {
        LOG.info("Inicio de prueba obtenerMediaEstadisticaNoExisteTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");

        assertThrows(Throwable.class, ()->torneo.promedioEstadistica(mejor));
        LOG.info("Fin de prueba obtenerMediaEstadisticaNoExisteTest...");
    }

    /**
     * Permite comparar dos participantes según una estadística dada (POSITIVA)
     */
    @Test
    public void compararEstadisticaPositivaABTest() {
        LOG.info("Inicio de prueba compararEstadisticaPositivaABTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        var participantes = torneo.getParticipantes().stream().toList();
        var participanteA = participantes.get(0);
        var participanteB = participantes.get(1);
        var resultado = torneo.compararParticipantes(participanteA,participanteB,efectividad);

        assertTrue(resultado < 0 );
        LOG.info("Fin de prueba compararEstadisticaPositivaABTest...");
    }

    /**
     * Permite comparar dos participantes según una estadística dada (POSITIVA)
     */
    @Test
    public void compararEstadisticaPositivaBATest() {
        LOG.info("Inicio de prueba compararEstadisticaPositivaBATest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        var participantes = torneo.getParticipantes().stream().toList();
        var participanteA = participantes.get(0);
        var participanteB = participantes.get(1);
        var resultado = torneo.compararParticipantes(participanteB,participanteA,efectividad);

        assertTrue(resultado > 0 );
        LOG.info("Fin de prueba compararEstadisticaPositivaBATest...");
    }

    /**
     * Permite comparar dos participantes según una estadística dada (POSITIVA)
     */
    @Test
    public void compararEstadisticaNegativaABTest() {
        LOG.info("Inicio de prueba compararEstadisticaPositivaABTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        var participantes = torneo.getParticipantes().stream().toList();
        var participanteA = participantes.get(0);
        var participanteB = participantes.get(1);
        var resultado = torneo.compararParticipantes(participanteA,participanteB,errores);

        assertTrue(resultado < 0 );
        LOG.info("Fin de prueba compararEstadisticaPositivaABTest...");
    }

    /**
     * Permite comparar dos participantes según una estadística dada (POSITIVA)
     */
    @Test
    public void compararEstadisticaNegativaBATest() {
        LOG.info("Inicio de prueba compararEstadisticaPositivaABTest...");
        var torneo = torneos.get("Copa Mundo Ajedrez");
        var participantes = torneo.getParticipantes().stream().toList();
        var participanteA = participantes.get(0);
        var participanteB = participantes.get(1);
        var resultado = torneo.compararParticipantes(participanteB,participanteA,errores);

        assertTrue(resultado > 0 );
        LOG.info("Fin de prueba compararEstadisticaPositivaABTest...");
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
        mejor = new Estadistica("Mejor",TipoEstadistica.POSITIVA);

        var copaMundoA = inicizalizarDatosPruebaTorneo1();
        torneos.put(copaMundoA.getNombre(), copaMundoA);

        var copaMundoB = inicizalizarDatosPruebaTorneo2();
        torneos.put(copaMundoB.getNombre(), copaMundoB);


        crearParticipanteNoRegistrado();

        var torneoVacio = inicizalizarDatosTorneoVacio();
        torneos.put(torneoVacio.getNombre(), torneoVacio);
    }

    private void crearParticipanteNoRegistrado() {
        // {ParticipanteX,JugadorX,jugadorx@email.com,6067431239, fechaActual - 15 años} ValorEstadistica{3.3 , Estadistica{Efectividad,POSITIVA} }
        noRegistrado = new Jugador("ParticipanteX", "JugadorX", "jugadorx@email.com", "6067431239", LocalDate.now().minusYears(15));
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
        var participante = new Jugador("ParticipanteA", "JugadorA", "jugadora@email.com", "6067431234", LocalDate.now().minusYears(15));
        crearParticipante(torneo,participante,3.3,4.5);
    }

    private void crearParticipante1B(Torneo torneo) {
        // {"nombre":"ParticipanteB","apellido":"JugadorB","email":"jugadorb@email.com","telefono":"6067431235", "fechaNacimiento":"fechaActual - 16 años", "estadisticas":[
        //        {"valor":4.3 , "Estadistica":{"nombre":"Efectividad","tipo":"POSITIVA"}},
        //        {"valor":3.5 , "Estadistica":{"nombre":"Errores","tipo":"NEGATIVA"}}]},

        var participante = new Jugador("ParticipanteB", "JugadorB", "jugadorb@email.com", "6067431235", LocalDate.now().minusYears(16));
        crearParticipante(torneo,participante,4.3,3.5);
    }

    private void crearParticipante1C(Torneo torneo) {
        // {"nombre":"ParticipanteC","apellido":"JugadorC","email":"jugadorc@email.com","telefono":"6067431236", "fechaNacimiento":"fechaActual - 17 años", "estadisticas":[
        //        {"valor":2.3 , "Estadistica":{"nombre":"Efectividad","tipo":"POSITIVA"}},
        //        {"valor":2.5 , "Estadistica":{"nombre":"Errores","tipo":"NEGATIVA"}}]}]},

        var participante = new Jugador("ParticipanteC", "JugadorC", "jugadorc@email.com", "6067431236", LocalDate.now().minusYears(17));
        crearParticipante(torneo,participante,2.3,2.5);
    }

    private void crearParticipante(Torneo torneo, Participante participante, double valorEfectividad,double valorErrores ) {
        torneo.registrarParticipante(participante);
        var registroEstadistica = new ValorEstadistica(valorEfectividad, efectividad);
        torneo.registrarEstadisticaParticipante(participante,registroEstadistica);
        registroEstadistica = new ValorEstadistica(valorErrores, errores);
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


    private Torneo inicizalizarDatosTorneoVacio() {
        //{nombre:"Copa Mundo Futbol","fechaInicio":"fechaActual + 1mes", "fechaInicioInscripciones": "fechaActual - 15 días", "fechaCierreInscripciones": "fechaActual+15 días", "numeroParticipante": 24, "limiteEdad":0,"valorInscripcion":0, "tipoTorneo":"MUNDIAL","caracter":"GRUPAL",
        return new Torneo("Vacío",  LocalDate.now().plusMonths(1), LocalDate.now().minusDays(15), LocalDate.now().plusDays(15), (byte)24, (byte)0, 0,TipoTorneo.MUNDIAL,CaracterTorneo.GRUPAL);
    }

}
