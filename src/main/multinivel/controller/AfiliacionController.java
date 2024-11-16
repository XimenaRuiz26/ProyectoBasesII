package controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import connection.Aplicacion;
import model.Empleado;

public class AfiliacionController {
	Aplicacion aplicacion;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtIdAfiliador;

    @FXML
    private DatePicker dateFechaNacimiento;

    @FXML
    void afiliarse(ActionEvent event) {
    	String nombres = txtNombres.getText();
    	String apellidos = txtApellidos.getText();
    	String direccion = txtDireccion.getText();
    	String email = txtEmail.getText();
    	String telefono = txtTelefono.getText();
    	String idAfiliador = txtIdAfiliador.getText();
    	LocalDate fechaNacimiento = dateFechaNacimiento.getValue();
    	if (validarCampos(nombres, apellidos, direccion, email, telefono, fechaNacimiento, idAfiliador)) {
			Empleado empleadoAfiliado = aplicacion.afiliar(nombres, apellidos, direccion, email, telefono, Date.valueOf(fechaNacimiento), idAfiliador);
    		if (empleadoAfiliado != null) {
    			JOptionPane.showMessageDialog(null, "Te has afiliado correctamente");
    			aplicacion.abrirVentanaPerfilAfiliado(empleadoAfiliado);
			}
    	}
    }

    private boolean validarCampos(String nombres, String apellidos, String direccion, String email, String telefono,
			LocalDate fechaNacimiento, String idAfiliador) {
		if (nombres.isEmpty() || apellidos.isEmpty() || direccion.isEmpty() || fechaNacimiento == null ||
			direccion.isEmpty() || email.isEmpty() || telefono.isEmpty() || idAfiliador.isEmpty()){
			JOptionPane.showMessageDialog(null, "Rellene todos los campos");
			return false;
		}
		try {
			Integer.parseInt(idAfiliador);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese un id valido (numerico)");
			return false;
		}
		return true;
	}

	@FXML
    void atrasVentana(ActionEvent event) {
    	aplicacion.abrirVentanaLoginAfiliado();
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

}
