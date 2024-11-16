package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import connection.Aplicacion;
import dto.MapeoDTO;
import dto.ProductoDTO;
import model.Producto;

public class InventarioController {
	Aplicacion aplicacion;

	ProductoDTO productoSeleccionado;
	ObservableList<ProductoDTO> listaProductosData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ProductoDTO> tableProductosInventario;

    @FXML
    private TableColumn<String, ProductoDTO> colDescripcion;

    @FXML
    private TableColumn<String, ProductoDTO> colFabricante;

    @FXML
    private TableColumn<Integer, ProductoDTO> colUnidadesDisponibles;

    @FXML
    private TableColumn<String, ProductoDTO> colNombre;

    @FXML
    private TableColumn<Float, ProductoDTO> colPrecioUnitario;

    @FXML
    private TableColumn<Integer, ProductoDTO> colId;

    @FXML
    private TableColumn<String, ProductoDTO> colCategoria;

    @FXML
    void abrirVentanaEmergenteNuevoProducto(ActionEvent event) {
    	aplicacion.abrirVentanaEmergenteNuevoProducto(this);
		tableProductosInventario.getItems().clear();
		tableProductosInventario.setItems(getListaProductosData());
    	tableProductosInventario.refresh();
    }

    @FXML
    void quitarProducto(ActionEvent event) {
    	if (productoSeleccionado != null) {
    		int verificacion = JOptionPane.showConfirmDialog(null, "�Est�s seguro de que desea eliminar el producto?\r\n");
        	if (verificacion == 0) {
        		aplicacion.eliminarProductoById(productoSeleccionado.getId());
        		listaProductosData.remove(productoSeleccionado);
        		tableProductosInventario.refresh();
        		JOptionPane.showMessageDialog(null, "Se ha eliminado el producto exitosamente");
    		}else{
    			JOptionPane.showMessageDialog(null, "Producto no eliminado");
    		}
		}else{
			JOptionPane.showMessageDialog(null, "Primero seleccione un producto");
		}
    }

    @FXML
    void abrirVentanaEmergenteActualizarProducto(ActionEvent event) {
    	if (productoSeleccionado!=null) {
    		aplicacion.abrirVentanaEmergenteActualizarProducto(productoSeleccionado.getProducto());
        	tableProductosInventario.getItems().clear();
    		tableProductosInventario.setItems(getListaProductosData());
        	tableProductosInventario.refresh();
		}else{
			JOptionPane.showMessageDialog(null, "Primero seleccione un producto");
		}
    }

    @FXML
    void atrasVentana(ActionEvent event) {
    	aplicacion.abrirVentanaAdministracion();
    }

    @FXML
	void initialize() {
		 this.colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		 this.colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		 this.colFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
		 this.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		 this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		 this.colPrecioUnitario.setCellValueFactory(new PropertyValueFactory<>("precio_unitario"));
		 this.colUnidadesDisponibles.setCellValueFactory(new PropertyValueFactory<>("unidades_disponibles"));

		 tableProductosInventario.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> {
			 productoSeleccionado = newSelection;
		 });
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;

        tableProductosInventario.getItems().clear();
        tableProductosInventario.setItems(getListaProductosData());
    }

	private ObservableList<ProductoDTO> getListaProductosData() {
		 ArrayList<Producto> listaProductos = new ArrayList<Producto>(aplicacion.obtenerListaProductos());
		 ArrayList<ProductoDTO> listaProductosDTO = MapeoDTO.mapearProductosDTO(listaProductos);
		 this.listaProductosData.addAll(listaProductosDTO);
		 return listaProductosData;
	}
}
