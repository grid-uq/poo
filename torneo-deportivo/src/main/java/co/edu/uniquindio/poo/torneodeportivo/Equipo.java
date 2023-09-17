package co.edu.uniquindio.poo.torneodeportivo;

public record Equipo(String nombre,Representante representante) {
    public Equipo{
        assert nombre != null && !nombre.isBlank() : "El nombre es requerido";
        assert representante != null : "El representante es requerido";
    }
}
