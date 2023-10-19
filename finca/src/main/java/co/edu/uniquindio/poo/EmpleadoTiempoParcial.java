package co.edu.uniquindio.poo;

public class EmpleadoTiempoParcial extends Empleado{
    private final int numeroHoras;
    private final int valorHora;

    public EmpleadoTiempoParcial(String nombre, String cargo, int numeroHoras, int valorHora) {
        super(nombre, cargo);
        this.numeroHoras = numeroHoras;
        this.valorHora = valorHora;
    }

    @Override
    int calcularSalario() {
        return valorHora * numeroHoras;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public int getValorHora() {
        return valorHora;
    }
}
