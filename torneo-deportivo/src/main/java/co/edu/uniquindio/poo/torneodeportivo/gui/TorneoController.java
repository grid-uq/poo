package co.edu.uniquindio.poo.torneodeportivo.gui;


import co.edu.uniquindio.poo.torneodeportivo.TipoTorneo;
import co.edu.uniquindio.poo.torneodeportivo.Torneo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.poo.torneodeportivo.gui.MessageFXUtil.mostrarInformacion;
import static co.edu.uniquindio.poo.torneodeportivo.gui.MessageFXUtil.mostrarMensaje;

import java.util.Optional;
import java.util.function.Function;

public class TorneoController {
    @FXML
    private TextField tfNombre;
    @FXML
    private DatePicker dpFechaInicio;
    @FXML
    private DatePicker dpFechaInicioInscripciones;
    @FXML
    private DatePicker dpFechaFinInscripciones;
    @FXML
    private TextField tfNumeroParticipantes;
    @FXML
    private TextField tfLimiteEdad;
    @FXML
    private TextField tfValorInscripcion;
    @FXML
    private ComboBox<TipoTorneo> cbTipoTorneo;


    @FXML
    public void initialize() {
        tfNumeroParticipantes.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        tfLimiteEdad.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        tfValorInscripcion.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        tfNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        cbTipoTorneo.setItems(FXCollections.observableArrayList(TipoTorneo.values()));
    }

    public void onRegistrarClick() {
        try {
            byte numeroParticipantes = valueOf(tfNumeroParticipantes.getText(), Byte::valueOf).orElseThrow(()->new Exception("El número de participantes es requerio"));
            byte limiteEdad = valueOf(tfLimiteEdad.getText(), Byte::valueOf).orElseThrow(()->new Exception("El límite de edad es requerio"));
            int valorInscripcion = valueOf(tfValorInscripcion.getText(), Integer::valueOf).orElseThrow(()->new Exception("El valor de la inscripción es requerio"));
            
            var torneo = new Torneo(tfNombre.getText(), dpFechaInicio.getValue(),dpFechaInicioInscripciones.getValue(), dpFechaFinInscripciones.getValue(), numeroParticipantes, limiteEdad, valorInscripcion, cbTipoTorneo.getValue() );
            

            limpiarCampos();
            mostrarInformacion("El torneo fue creado");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }
    }

    private <T> Optional<T> valueOf(String texto,Function<String,T> parser){
        T value = null;
        if( texto != null && !texto.isBlank() ){
            value = parser.apply(texto);
        }
        return Optional.ofNullable(value);
    }

    private void limpiarCampos() {
        tfNombre.setText("");
        dpFechaInicio.setValue(null);
        dpFechaInicioInscripciones.setValue(null);
        dpFechaFinInscripciones.setValue(null);        
        tfNumeroParticipantes.setText("");
        tfLimiteEdad.setText("");
        tfValorInscripcion.setText("");
        cbTipoTorneo.setValue(null);
    }
}