package multinivel.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import multinivel.connection.Aplicacion;
import multinivel.model.CategoriaProducto;

public class NuevoProductoController {
	Aplicacion aplicacion;
	private ObservableList<CategoriaProducto> listaCategorias = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private ComboBox<CategoriaProducto> comboCategoria;

    @FXML
    private TextField txtUnidadesDisponibles;

    @FXML
    private TextField txtFabricante;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtPrecioUnitario;

    @FXML
    void agregarProducto(ActionEvent event) {
    	CategoriaProducto categoria = comboCategoria.getValue();
    	String sUnidadesDisponibles = txtUnidadesDisponibles.getText();
    	String sPrecioUnitario = txtPrecioUnitario.getText();
    	String sNombre = txtNombre.getText();
    	String sDescripcion = txtDescripcion.getText();
    	String sFabricante = txtFabricante.getText();
    	if (validarDatos(categoria, sUnidadesDisponibles, sPrecioUnitario, sNombre, sDescripcion, sFabricante)) {
    		int unidadesDisponibles = Integer.parseInt(sUnidadesDisponibles);
    		float precioUnitario = Float.parseFloat(sPrecioUnitario);

    		aplicacion.agregarProducto(categoria.getId(), unidadesDisponibles, precioUnitario, sNombre, sDescripcion, sFabricante);
    		JOptionPane.showMessageDialog(null, "Se ha agregado un nuevo producto");
    		limpiarCampos();
    	}
    }

	private void limpiarCampos() {
		comboCategoria.setValue(null);
		txtDescripcion.setText("");
		txtFabricante.setText("");
		txtNombre.setText("");
		txtPrecioUnitario.setText("");
		txtUnidadesDisponibles.setText("");
	}

	private boolean validarDatos(CategoriaProducto categoria, String sUnidadesDisponibles,
			String sPrecioUnitario, String sNombre, String sDescripcion, String sFabricante) {
		if (categoria == null || sUnidadesDisponibles.isEmpty() || sPrecioUnitario.isEmpty() || sNombre.isEmpty()
				|| sDescripcion.isEmpty() || sFabricante.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");
			return false;
		}
		if (sNombre.length()>60 || sDescripcion.length()>60) {
			JOptionPane.showMessageDialog(null, "El campo de nombre y descripcion no debe sobrepasar 60 caracteres");
			return false;
		}
		if (sFabricante.length()>40) {
			JOptionPane.showMessageDialog(null, "El campo de fabricante no debe sobrepasar 40 caracteres");
			return false;
		}
		try {
			Integer.parseInt(sUnidadesDisponibles);
			Float.parseFloat(sPrecioUnitario);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
			return false;
		}
		return true;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		llenarComboCategorias();
	}

	private void llenarComboCategorias() {
		listaCategorias.addAll(aplicacion.obtenerCategoriasProducto());
		this.comboCategoria.setItems(listaCategorias);
	}
}
