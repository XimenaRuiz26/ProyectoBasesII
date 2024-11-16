package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import connection.Aplicacion;

public class ReporteIndividualController {
	Aplicacion aplicacion;
	int numReporte;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtReporte;

    @FXML
    private Text lbNumeroReporte;

    @FXML
    private Text txtEnunciado;

	public void setAplicacion(Aplicacion aplicacion, int numReporte) {
		this.aplicacion = aplicacion;
		this.numReporte = numReporte;
		showReporte();
	}

	private void showReporte() {
		this.lbNumeroReporte.setText(String.valueOf(numReporte));
		String enunciado = "";
		String reporte = "";
		switch (numReporte) {
		case 1:
			enunciado = "Reporte de la cantidad de empleados\n"
					+ "que hay en cada nivel.";
			reporte = aplicacion.reporte1();
			break;
		case 2:
			enunciado = "Total de ventas por categor�a de producto y m�todo de pago";
			reporte = aplicacion.reporte2();
			break;
		case 3:
			enunciado = "Ventas totales por estado de venta y nivel de empleado:";
			reporte = aplicacion.reporte3();
			break;
		case 4:
			enunciado = "Ventas promedio por empleado y mes de venta:";
			reporte = aplicacion.reporte4();
			break;
		case 5:
			enunciado = "Total de ventas por estado de env�o y m�todo de env�o";
			reporte = aplicacion.reporte5();
			break;
		default:
			break;
		}
		this.txtEnunciado.setText(enunciado);
		this.txtReporte.setText(reporte);
	}
}
