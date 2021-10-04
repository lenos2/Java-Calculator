module zw.co.appsareus.java_calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens zw.co.appsareus.java_calculator to javafx.fxml;
    exports zw.co.appsareus.java_calculator;
}