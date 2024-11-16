package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import connection.Aplicacion;
import model.Empleado;

public class LoginAfiliadoController {
	Aplicacion aplicacion;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void ingresar(ActionEvent event) {
    	String email = txtEmail.getText();
    	String password = txtPassword.getText();
    	if (validarDatos(email, password)) {
    		Empleado empleado = aplicacion.ingresarAfiliado(email, password);
    		if (empleado != null) {
    			aplicacion.abrirVentanaPerfilAfiliado(empleado);
			}else{
				JOptionPane.showMessageDialog(null, "El email ingresado no esta registrado a ningun empleado");
			}
		}else{
			JOptionPane.showMessageDialog(null, "Rellene todos los campos");
		}
    }

	private boolean validarDatos(String email, String password) {
		if (email.isEmpty()) {
			return false;
		}if (password.isEmpty()) {
			return false;
		}
		return true;
	}

	@FXML
    void abrirVentanaAfiliacion(ActionEvent event) {
		aplicacion.abrirVentanaAfiliacion();
    }

    @FXML
    void atrasVentana(ActionEvent event) {
    	aplicacion.mostrarInicio();
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }
}
