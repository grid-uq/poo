package co.edu.uniquindio.poo.torneodeportivo.gui;


import co.edu.uniquindio.poo.torneodeportivo.TipoTorneo;
import co.edu.uniquindio.poo.torneodeportivo.Torneo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

import static co.edu.uniquindio.poo.torneodeportivo.gui.AppController.INSTANCE;
import static co.edu.uniquindio.poo.torneodeportivo.gui.MessageFXUtil.mostrarInformacion;
import static co.edu.uniquindio.poo.torneodeportivo.gui.MessageFXUtil.mostrarMensaje;

public class TorneoController {
    @FXML
    private TableView<Torneo> tblTorneo;
    @FXML
    private TableColumn<Torneo, String> colNombre;
    @FXML
    private TableColumn<Torneo, LocalDate> colFechaInicio;
    @FXML
    private TableColumn<Torneo, LocalDate> colFechaInicioInscripciones;
    @FXML
    private TableColumn<Torneo, LocalDate> colFechaFinInscripciones;
    @FXML
    private TableColumn<Torneo, Byte> colNumeroParticipantes;
    @FXML
    private TableColumn<Torneo, Byte> colLimiteEdad;
    @FXML
    private TableColumn<Torneo, Integer> colValorInscripcion;
    @FXML
    private TableColumn<Torneo, TipoTorneo> colTipoTorneo;

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

    private Torneo torneoSeleccionado;

    @FXML
    public void initialize() {
        llenarTabla(INSTANCE.getTorneos());
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        colFechaInicioInscripciones.setCellValueFactory(new PropertyValueFactory<>("fechaInicioInscripciones"));
        colFechaFinInscripciones.setCellValueFactory(new PropertyValueFactory<>("fechaCierreInscripciones"));
        colNumeroParticipantes.setCellValueFactory(new PropertyValueFactory<>("numeroParticipantes"));
        colLimiteEdad.setCellValueFactory(new PropertyValueFactory<>("limiteEdad"));
        colValorInscripcion.setCellValueFactory(new PropertyValueFactory<>("valorInscripcion"));
        colTipoTorneo.setCellValueFactory(new PropertyValueFactory<>("tipoTorneo"));
        
        
        tblTorneo.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
        tfNumeroParticipantes.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        tfLimiteEdad.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        tfValorInscripcion.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        tfNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        cbTipoTorneo.setItems(FXCollections.observableArrayList(TipoTorneo.values()));
    
        torneoSeleccionado = null;
    }

    public void onRegistrarClick() {
        try {
            byte numeroParticipantes = valueOf(tfNumeroParticipantes.getText(), Byte::valueOf).orElseThrow(()->new Exception("El número de participantes es requerio"));
            byte limiteEdad = valueOf(tfLimiteEdad.getText(), Byte::valueOf).orElseThrow(()->new Exception("El límite de edad es requerio"));
            int valorInscripcion = valueOf(tfValorInscripcion.getText(), Integer::valueOf).orElseThrow(()->new Exception("El valor de la inscripción es requerio"));
            
            var torneo = new Torneo(tfNombre.getText(), dpFechaInicio.getValue(),dpFechaInicioInscripciones.getValue(), dpFechaFinInscripciones.getValue(), numeroParticipantes, limiteEdad, valorInscripcion, cbTipoTorneo.getValue() );

            INSTANCE.adicionar(torneo);
            llenarTabla(INSTANCE.getTorneos());
            limpiarCampos();
            mostrarInformacion("El torneo fue registrado");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }
    }

    public void onCancelarClick() {
        limpiarCampos();
        tblTorneo.getSelectionModel().clearSelection();
    }

    public void onRemoverClick() {
        try {
            INSTANCE.remover(torneoSeleccionado);
            llenarTabla(INSTANCE.getTorneos());
            limpiarCampos();
            mostrarInformacion("El estudiante fue retirado del diplomado");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }
    }

    public void onBuscarClick() {
        llenarTabla(
                INSTANCE.buscar(tfNombre.getText(),
                valueOf(tfNumeroParticipantes.getText(),Byte::valueOf).orElse((byte)0),
                valueOf(tfLimiteEdad.getText(),Byte::valueOf).orElse((byte)0),
                valueOf(tfValorInscripcion.getText(),Integer::valueOf).orElse(0),
                cbTipoTorneo.getValue())
        );
    }

    private <T> Optional<T> valueOf(String texto,Function<String,T> parser){
        T value = null;
        if( texto != null && !texto.isBlank() ){
            value = parser.apply(texto);
        }
        return Optional.ofNullable(value);
    }

    private void llenarCampos(Torneo torneo) {
        torneoSeleccionado = torneo;
        if (torneo != null) {
            tfNombre.setText(torneo.getNombre());
            dpFechaInicio.setValue(torneo.getFechaInicio());
            dpFechaInicioInscripciones.setValue(torneo.getFechaInicioInscripciones());
            dpFechaFinInscripciones.setValue(torneo.getFechaCierreInscripciones());
            tfNumeroParticipantes.setText(String.valueOf(torneo.getNumeroParticipantes()));
            tfLimiteEdad.setText(String.valueOf(torneo.getLimiteEdad()));
            tfValorInscripcion.setText(String.valueOf(torneo.getValorInscripcion()));
            cbTipoTorneo.setValue(torneo.getTipoTorneo());
        }
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

    private void llenarTabla(Collection<Torneo> torneos) {
        tblTorneo.setItems(FXCollections.observableArrayList(torneos));
        tblTorneo.refresh();
    }

}