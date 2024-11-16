module org.example.proyectobases {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;
    requires com.oracle.database.jdbc;
    exports connection; // Exporta el paquete 'connection' para que JavaFX pueda acceder a 'Aplicacion'
    exports controller; // Exporta el paquete 'controller' para que JavaFX pueda acceder a 'InicioController'
    opens controller to javafx.fxml; // Permite el acceso de reflexión al paquete 'controller' para cargar FXML
    exports services;
    exports dto;
    exports model;
}