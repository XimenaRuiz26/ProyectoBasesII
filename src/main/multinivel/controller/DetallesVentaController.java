package multinivel.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import multinivel.connection.Aplicacion;
import multinivel.model.Venta;

public class DetallesVentaController {
	Aplicacion aplicacion;
	Venta venta;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text lbValorVenta;

    @FXML
    private Text lbEstadoVenta;

    @FXML
    private Text lbId;

    @FXML
    private Text lbFechaVenta;

    @FXML
    private Text lbMetodoPago;

    @FXML
    private Text lbIdCliente;

    @FXML
    private Text lbIdEmpleado;

    public void setAplicacion(Aplicacion aplicacion, Venta ventaEnvio) {
        this.aplicacion = aplicacion;
        this.venta = ventaEnvio;
        mostrarDatosVenta();
    }

	private void mostrarDatosVenta() {
		lbEstadoVenta.setText(venta.getEstado_venta().getDescripcion());
        lbFechaVenta.setText(String.valueOf(venta.getFecha_venta()));
        lbId.setText(String.valueOf(venta.getId()));
        lbIdCliente.setText(String.valueOf(venta.getCliente().getId()));
        lbIdEmpleado.setText(String.valueOf(venta.getEmpleado().getId()));
        lbMetodoPago.setText(venta.getMetodo_pago().getNombre());
        lbValorVenta.setText(String.valueOf(venta.getValor_venta()));
	}
}
