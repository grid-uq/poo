package co.edu.uniquindio.poo.torneodeportivo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Jueces extends Persona{

    private final String Licencia; 

    public Jueces (String nombre, String apellido, String email, String celular, String Licencia)
    {
        super(nombre, apellido, email, celular);

        ASSERTION.assertion( Licencia != null && !Licencia.isBlank() , "La licencia es requerida");
        assert Licencia.length() == 7 : "La licencia debe tener 7 dígitos.";
        this.Licencia=Licencia;

    }
    //GET Y SET
    public String getLicencia() {
        return Licencia;
    }
}
