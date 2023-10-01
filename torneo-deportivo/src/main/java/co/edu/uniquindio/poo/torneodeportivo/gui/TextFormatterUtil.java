package co.edu.uniquindio.poo.torneodeportivo.gui;

import javafx.scene.control.TextFormatter.Change;

public class TextFormatterUtil {
    public static Change upperCaseFormat(Change change){
        change.setText(change.getText().toUpperCase());
        return change;
    }

    public static Change integerFormat(Change change){
        if (change.getText().matches("[0-9]*")) {
            return change;
        }
        return null;
    }

    public static Change decimalFormat(Change change){
        if (change.getControlNewText().matches("^\\d*\\.\\d+|\\d+\\.\\d*|\\d*$")) {
            return change;
        }
        return null;
    }

}
