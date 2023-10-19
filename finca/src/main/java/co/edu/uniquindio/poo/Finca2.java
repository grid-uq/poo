package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;

public record Finca(String nombre, Collection<Empleado> empleados) {

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
        Predicate<Empleado> condicion = empleado -> empleado instanceof EmpleadoRecoleccion;
        Predicate<EmpleadoRecoleccion> condicion2 = empleado-> empleado.getNumeroKilos() > numeroKilos;
        return empleados.stream()
                .filter(condicion)
                .map(empleado -> (EmpleadoRecoleccion)empleado)
                .filter(condicion2)
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
        Predicate<Empleado> condicion = empleado -> empleado instanceof EmpleadoTiempoParcial;
        return empleados.stream()
                .filter(condicion)
                .map(empleado -> (EmpleadoTiempoParcial)empleado)
                .toList();
    }

    public Collection<Empleado> listarEmpleadosMenorRendimiento(){
        double promedioHorasLaboradas = calcularPromedioHorasLaboradas();
        double promedioKilosRecolectados = calcularPromedioKilosRecolectados();

        Predicate<Empleado> condicion = empleado -> {
            if( empleado instanceof EmpleadoTiempoParcial e && e.getNumeroHoras() < promedioHorasLaboradas ){
                return true;
            }
            if( empleado instanceof EmpleadoRecoleccion e && e.getNumeroKilos() < promedioKilosRecolectados ){
                return true;
            }
            return false;
        };

        return empleados.stream().filter(condicion).toList();

    }

    private double calcularPromedioKilosRecolectados() {
        Predicate<Empleado> condicion = empleado -> empleado instanceof EmpleadoRecoleccion;
        return empleados.stream()
                .filter(condicion)
                .map(empleado -> (EmpleadoRecoleccion)empleado)
                .mapToInt(EmpleadoRecoleccion::getNumeroKilos)
                .summaryStatistics()
                .getAverage();
    }

    private double calcularPromedioHorasLaboradas() {
        Predicate<Empleado> condicion = empleado -> empleado instanceof EmpleadoTiempoParcial;
        return empleados.stream()
                .filter(condicion)
                .map(empleado -> (EmpleadoTiempoParcial)empleado)
                .mapToInt(EmpleadoTiempoParcial::getNumeroHoras)
                .summaryStatistics()
                .getAverage();
    }

}
