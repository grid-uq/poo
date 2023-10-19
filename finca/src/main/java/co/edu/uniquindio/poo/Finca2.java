package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Finca2 {

    private final String nombre;
    private final Collection<Empleado> empleados;

    private final Predicate<Empleado> filtroEmpleadosRecoleccion = empleado -> empleado instanceof EmpleadoRecoleccion;
    private final Predicate<Empleado> filtroEmpleadosTiempoParcial = empleado -> empleado instanceof EmpleadoTiempoParcial;
    private final Predicate<Empleado> filtroEmpleadosTiempoCompleto = empleado -> empleado instanceof EmpleadoTiempoCompleto;

    private final Function<Empleado,EmpleadoRecoleccion> toEmpleadoRecoleccion = empleado -> (EmpleadoRecoleccion) empleado;
    private final Function<Empleado,EmpleadoTiempoParcial> toEmpleadoTiempoParcial = empleado -> (EmpleadoTiempoParcial) empleado;
    private final Function<Empleado,EmpleadoTiempoCompleto> toEmpleadoTiempoCompleto = empleado -> (EmpleadoTiempoCompleto) empleado;

    public Finca2(String nombre) {
        this.nombre = nombre;
        empleados = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void adicionarEmpleados(Empleado empleado){
        validarEmpleado(empleado);
        empleados.add(empleado);
    }

    private void validarEmpleado(Empleado empleado) {
        Predicate<Empleado> condicion = e -> e.getNombre().equalsIgnoreCase( empleado.getNombre() );
        if( empleados.stream().anyMatch(condicion) ){
            throw new RuntimeException("Ya existe un empleado con el nombre"+empleado.getNombre());
        }
    }

    public Collection<EmpleadoRecoleccion> listarEmpleadosRecoleccion(int numeroKilos){
        Predicate<EmpleadoRecoleccion> condicion = empleado-> empleado.getNumeroKilos() > numeroKilos;
        return empleados.stream()
                .filter(filtroEmpleadosRecoleccion)
                .map(toEmpleadoRecoleccion)
                .filter(condicion)
                .sorted(Comparator.comparing(EmpleadoRecoleccion::getNumeroKilos))
                .toList();
    }

    public Collection<Empleado> listarEmpleadosSalarioMayorPromedio(){
        final double salarioPromedio = calcularPromedioSalario();
        Predicate<Empleado> condicion = empleado -> empleado.calcularSalario() > salarioPromedio;
        return empleados.stream()
                .filter(condicion)
                .sorted(Comparator.comparing(Empleado::getNombre))
                .toList();
    }

    private double calcularPromedioSalario() {
        return empleados.stream()
                .mapToInt(Empleado::calcularSalario)
                .summaryStatistics()
                .getAverage();
    }

    public Collection<EmpleadoTiempoParcial> listarEmpleadosTiempoParcial(){
        return empleados.stream()
                .filter(filtroEmpleadosTiempoParcial)
                .map(toEmpleadoTiempoParcial)
                .toList();
    }

    public Collection<Empleado> listarEmpleadosMenorRendimiento(){
        double promedioHorasLaboradas = calcularPromedioHorasLaboradas();
        double promedioKilosRecolectados = calcularPromedioKilosRecolectados();

        Predicate<Empleado> empleadoRecoleccionMenorRendimiento = filtroEmpleadosRecoleccion.and( e->((EmpleadoRecoleccion)e).getNumeroKilos()<promedioKilosRecolectados );

        Predicate<Empleado> empleadoTiempoParcialMenorRendimiento = filtroEmpleadosTiempoParcial.and( e-> ((EmpleadoTiempoParcial)e).getNumeroHoras()<promedioHorasLaboradas);


        Stream<Empleado> empleadosRecoleccion = empleados.stream()
                .filter(empleadoRecoleccionMenorRendimiento);

        Stream<Empleado> empleadoTiempoParcial = empleados.stream().filter(empleadoTiempoParcialMenorRendimiento);

        return Stream.concat(empleadosRecoleccion, empleadoTiempoParcial).toList();

    }

    private double calcularPromedioKilosRecolectados() {
        return empleados.stream()
                .filter(filtroEmpleadosRecoleccion)
                .map(toEmpleadoRecoleccion)
                .mapToInt(EmpleadoRecoleccion::getNumeroKilos)
                .summaryStatistics()
                .getAverage();
    }

    private double calcularPromedioHorasLaboradas() {
        return empleados.stream()
                .filter(filtroEmpleadosTiempoParcial)
                .map(toEmpleadoTiempoParcial)
                .mapToInt(EmpleadoTiempoParcial::getNumeroHoras)
                .summaryStatistics()
                .getAverage();
    }

}
