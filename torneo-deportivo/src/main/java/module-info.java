module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.logging;

    opens co.edu.uniquindio.poo.torneodeportivo to javafx.fxml;
    exports co.edu.uniquindio.poo.torneodeportivo;
    opens co.edu.uniquindio.poo.torneodeportivo.gui to javafx.fxml;
    exports co.edu.uniquindio.poo.torneodeportivo.gui;
}