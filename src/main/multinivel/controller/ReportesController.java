package multinivel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import multinivel.connection.Aplicacion;

public class ReportesController {
	Aplicacion aplicacion;

    @FXML
    void abrirReporte1(ActionEvent event) {
    	aplicacion.abrirVentanaEmergenteReporte(1);
    }

    @FXML
    void atrasVentana(ActionEvent event) {
    	aplicacion.abrirVentanaAdministracion();
    }

    @FXML
    void abrirReporte2(ActionEvent event) {
    	aplicacion.abrirVentanaEmergenteReporte(2);
    }

    @FXML
    void abrirReporte4(ActionEvent event) {
    	aplicacion.abrirVentanaEmergenteReporte(4);
    }

    @FXML
    void abrirReporte5(ActionEvent event) {
    	aplicacion.abrirVentanaEmergenteReporte(5);
    }

    @FXML
    void abrirReporte3(ActionEvent event) {
    	aplicacion.abrirVentanaEmergenteReporte(3);
    }

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

}

