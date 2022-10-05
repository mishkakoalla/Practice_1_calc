module calc.calc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens calc.calc to javafx.fxml;
    exports calc.calc;
}