package co.edu.uniquindio.poo.torneodeportivo;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public record Representante(String nombre,String apellido,String email, String celular) {
    public Representante{
        assert nombre != null && !nombre.isBlank() : "El nombre es requerido";
        assert apellido != null && !apellido.isBlank() : "El apellido es requerido";
        assert celular != null && !celular.isBlank() : "El celular es requerido";
        assert email != null && !email.isBlank() : "El email es requerido";
        ASSERTION.assertion( nombre != null && !nombre.isBlank() , "El nombre es requerido");
        ASSERTION.assertion( apellido != null && !apellido.isBlank() , "El apellido es requerido");
        ASSERTION.assertion( celular != null && !celular.isBlank() , "El celular es requerido");
        ASSERTION.assertion( email != null && !email.isBlank() , "El email es requerido");
    }
}
