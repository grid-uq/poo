package co.edu.uniquindio.poo.torneodeportivo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.util.ArrayList;

public class Jueces extends Persona{

    private final String Licencia; 
    private ArrayList<Enfrentamientos>enfrentamientosJueces = new ArrayList<Enfrentamientos>();

    public Jueces (String nombre, String apellido, String email, String celular, String Licencia,
                   ArrayList<Enfrentamientos>enfrentamientosJueces){

        super(nombre, apellido, email, celular);
        ASSERTION.assertion( Licencia != null && !Licencia.isBlank() , "La licencia es requerida");
        assert Licencia.length() == 7 : "La licencia debe tener 7 dígitos.";
        this.Licencia=Licencia;
        this.enfrentamientosJueces=enfrentamientosJueces;

    }
    //GET Y SET
    public String getLicencia() {
        return Licencia;
    }
    public ArrayList<Enfrentamientos> getEnfrentamientosJueces() {
        return enfrentamientosJueces;
    }
    public void setEnfrentamientosJueces(ArrayList<Enfrentamientos> enfrentamientosJueces) {
        this.enfrentamientosJueces = enfrentamientosJueces;
    }
}
