package co.edu.uniquindio.poo.torneodeportivo;
import static co.edu.uniquindio.poo.util.ESUtil.createCustomParser;
import static co.edu.uniquindio.poo.util.ESUtil.ingresarByte;
import static co.edu.uniquindio.poo.util.ESUtil.ingresarDato;
import static co.edu.uniquindio.poo.util.ESUtil.ingresarEntero;
import static co.edu.uniquindio.poo.util.ESUtil.ingresarFecha;
import static co.edu.uniquindio.poo.util.ESUtil.ingresarTexto;
import static co.edu.uniquindio.poo.util.ESUtil.mostrarError;
import static co.edu.uniquindio.poo.util.ESUtil.mostrarMensaje;

public class App {
    public static void main(String[] args) {
        mostrarMensaje("Bienvenido a TORNEO APP");
        var nombre = ingresarTexto("Ingrese el nombre del torneo");
        var fechaInicio = ingresarFecha("Ingresar fecha de inicio del torneo");
        var fechaInicioInscripciones = ingresarFecha("Ingresar la fecha de inicio de las inscripciones");
        var fechaCierreInscripciones = ingresarFecha("Ingresar la fecha de cierre de las inscripciones");
        var numeroParticipantes = ingresarByte("Ingresar el número de participantes");
        var limiteEdad = ingresarByte("Ingresar el limite de edad");
        var valorInscripcion = ingresarEntero("Ingresar el valor de la inscripción");
        var tipoTorneo = ingresarDato("Ingrese el tipo de torneo (LOCAL,REGIONAL,NACIONAL,MUNDIAL)", 
                createCustomParser(TipoTorneo::valueOf, "El valor debe ser (LOCAL,REGIONAL,NACIONAL,MUNDIAL)"));

        try {
            var torneo = new Torneo(nombre, fechaInicio, fechaInicioInscripciones, fechaCierreInscripciones, numeroParticipantes, limiteEdad, valorInscripcion, tipoTorneo);
            mostrarMensaje("El Torneo se creo con éxito \n"+torneo);    
        } catch (Throwable e) {
            mostrarError(e.getMessage());
        }
    }
}
