package co.edu.uniquindio.poo;

public class EmpleadoTiempoCompleto extends Empleado{
    private int salario;

    public EmpleadoTiempoCompleto(String nombre, String cargo, int salario) {
        super(nombre, cargo);
        this.salario = salario;
    }

    @Override
    int calcularSalario() {
        return salario;
    }
}
