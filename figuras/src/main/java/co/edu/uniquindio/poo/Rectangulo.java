package co.edu.uniquindio.poo;

public class Rectangulo extends Figura{
    private final double alto;
    private final double ancho;

    public Rectangulo(double alto, double ancho) {
        super(Rectangulo.class.getName());
        this.alto = alto;
        this.ancho = ancho;
    }

    @Override
    public double calcularArea() {
        return alto * ancho;
    }

    public double getAlto() {
        return alto;
    }

    public double getAncho() {
        return ancho;
    }
}
