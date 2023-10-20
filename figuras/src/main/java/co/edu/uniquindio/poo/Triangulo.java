package co.edu.uniquindio.poo;

public class Triangulo extends Figura{
    private final double base;
    private final double altura;

    public Triangulo(double base, double altura) {
        super(Triangulo.class.getName());
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura / 2;
    }    
}
