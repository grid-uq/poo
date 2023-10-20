package co.edu.uniquindio.poo;

public abstract class Figura {
    private final String nombre;

    public Figura() {
        nombre = "none";
    }

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularArea();
    
}
