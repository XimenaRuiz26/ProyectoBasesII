package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import connection.Aplicacion;

public class InicioController {
	Aplicacion aplicacion;

    @FXML
    void abrirVentanaAdministracion(ActionEvent event) {
    	aplicacion.abrirVentanaAdministracion();
    }

    @FXML
    void abrirVentanaPerfilAfiliado(ActionEvent event) {
    	aplicacion.abrirVentanaLoginAfiliado();
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

}
