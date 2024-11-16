package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import connection.Aplicacion;

public class AdministracionController {
	Aplicacion aplicacion;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void atrasVentana(ActionEvent event) {
    	aplicacion.mostrarInicio();
    }

    @FXML
    void abrirVentanaInventario(ActionEvent event) {
    	aplicacion.abrirVentanaInventario();
    }

    @FXML
    void abrirVentanaDespachos(ActionEvent event) {
    	aplicacion.abrirVentanaDespachos();
    }

    @FXML
    void abrirVentanaRed(ActionEvent event) {
    	aplicacion.abrirVentanaRed();
    }

    @FXML
    void abrirVentanaReportes(ActionEvent event) {
    	aplicacion.abrirVentanaReportes();
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }
}
