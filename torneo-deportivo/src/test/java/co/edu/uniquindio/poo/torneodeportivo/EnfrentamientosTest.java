package co.edu.uniquindio.poo.torneodeportivo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class EnfrentamientosTest {
    private static final Logger LOG = Logger.getLogger(EquipoTest.class.getName());
    
    /**
     * Agregar enfrentamiento 
     */
    @Test
    public void agregarEnfrentamiento(){
        LOG.info("Inicio prueba agregar Enfrentamiento...");

        List<Enfrentamientos> enfrentamientos = new ArrayList<>();

        //enfrentamientos.add(new Enfrentamientos("Enfrentamiento 1", "Estadio", LocalDate.now(), LocalDate.now(), new Equipo("Equipo 1"), new Jueces("Juez 1"), 0, 0, EstadoEnfrentamiento.PENDIENTE));
        enfrentamientos.add(new Enfrentamientos("Enfrentamiento 1", "Estadio1", LocalDate.of(2023, 11, 25), LocalDate.now(), new Equipo("Los mas", new Persona("Yorman", "Arias", "yotu@gmail.com", "7454252")), new Jueces("Sara", "Faustino", "sara@gmail.com", "62425", "202-222", null), 0, 0, EstadoEnfrentamiento.PENDIENTE, enfrentamientos));
        enfrentamientos.add(new Enfrentamientos("Enfrentamiento 2", "Estadio2", LocalDate.of(2023, 11, 26), LocalDate.now(), new Equipo("Los+", new Persona("Yorman2", "Arias2", "yot2u@gmail.com", "7754252")), new Jueces("Julian", "Naranjo", "julian@gmail.com", "62428", "202-333", null), 0, 0, EstadoEnfrentamiento.PENDIENTE, enfrentamientos));

        enfrentamientos.addAll(enfrentamientos);

        // Recuperación y verificación de datos
        LOG.info("Fin de prueba agregar Enfrentamientos...");
    }

    @Test
    public void agregarEnfrentamientoYaExistente() {

    LOG.info("Inicio prueba agregar Enfrentamiento Ya Existente...");

    List<Enfrentamientos> enfrentamientos = new ArrayList<>();



    enfrentamientos.add(new Enfrentamientos("Enfrentamiento 1", "Estadio1", LocalDate.of(2023, 11, 25), LocalDate.now(), new Equipo("Los mas", new Persona("Yorman", "Arias", "yotu@gmail.com", "7454252")), new Jueces("Sara", "Faustino", "sara@gmail.com", "62425", "202-222", null), 0, 0, EstadoEnfrentamiento.PENDIENTE, enfrentamientos));
    enfrentamientos.add(new Enfrentamientos("Enfrentamiento 2", "Estadio2", LocalDate.of(2023, 11, 26), LocalDate.now(), new Equipo("Los+", new Persona("Yorman2", "Arias2", "yot2u@gmail.com", "7754252")), new Jueces("Julian", "Naranjo", "julian@gmail.com", "62428", "202-333", null), 0, 0, EstadoEnfrentamiento.PENDIENTE, enfrentamientos));
    enfrentamientos.add(new Enfrentamientos("Enfrentamiento 1", "Estadio3", LocalDate.of(2023, 11, 27), LocalDate.now(), new Equipo("Los menos", new Persona("Yorman3", "Arias3", "yot3u@gmail.com", "7854252")), new Jueces("Juan", "Faustino", "juan@gmail.com", "62426", "202-444", null), 0, 0, EstadoEnfrentamiento.PENDIENTE, enfrentamientos));

    // Agregar el enfrentamiento con el mismo nombre
    Enfrentamientos enfrentamiento = new Enfrentamientos("Enfrentamiento 1", "Estadio3", LocalDate.of(2023, 11, 27), LocalDate.now(), new Equipo("Los menos", new Persona("Yorman3", "Arias3", "yot3u@gmail.com", "7854252")), new Jueces("Juan", "Faustino", "juan@gmail.com", "62426", "202-444", null), 0, 0, EstadoEnfrentamiento.PENDIENTE, enfrentamientos);
    enfrentamientos.add(enfrentamiento);

    // Verificar que el enfrentamiento se haya agregado correctamente
    boolean existeEnfrentamiento = false;
    for (Enfrentamientos enfrentamientoActual : enfrentamientos) {
        if (enfrentamientoActual.getNombre().equals("Enfrentamiento 1")) {
            existeEnfrentamiento = true;
            break;
        }
    }

    // Assert
    assertThat(Boolean.valueOf(existeEnfrentamiento)).isTrue();

    LOG.info("Fin de prueba agregar Enfrentamiento Ya Existente...");
}

    private Boolean assertThat(boolean existeEnfrentamiento) {
    return Boolean.valueOf(existeEnfrentamiento);
    }
}
