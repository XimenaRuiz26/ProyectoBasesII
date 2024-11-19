package multinivel.controller;

import java.net.URL;
import java.sql.Date;
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
import multinivel.connection.Aplicacion;
import multinivel.model.Envio;
import multinivel.model.EstadoEnvio;
import multinivel.model.MetodoEnvio;
import multinivel.model.Venta;

public class DespachoController {
	Aplicacion aplicacion;
	Envio envioSeleccionado;
	ObservableList<Envio> listaEnviosData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Envio> tableEnvios;

    @FXML
    private TableColumn<Date, Envio> colFechaEnvio;

    @FXML
    private TableColumn<Date, Envio> colFechaEntrega;

    @FXML
    private TableColumn<String, Envio> colDireccion;

    @FXML
    private TableColumn<EstadoEnvio, Envio> colEstado;

    @FXML
    private TableColumn<Float, Envio> colCosto;

    @FXML
    private TableColumn<MetodoEnvio, Envio> colMetodo;

    @FXML
    private TableColumn<Integer, Envio> colId;

    @FXML
    void abrirVentanaEmergenteDetallesVenta(ActionEvent event) {
    	if (envioSeleccionado!=null) {
    		Venta ventaEnvio = envioSeleccionado.getVenta();
        	aplicacion.abrirVentanaEmergenteDetallesVenta(ventaEnvio);
		}else{
			JOptionPane.showMessageDialog(null, "Primero seleccione un envio");
		}
    }

    @FXML
    void atrasVentana(ActionEvent event) {
    	aplicacion.abrirVentanaAdministracion();
    }

    @FXML
    void initialize() {
    	 this.colCosto.setCellValueFactory(new PropertyValueFactory<>("costo_envio"));
    	 this.colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
    	 this.colEstado.setCellValueFactory(new PropertyValueFactory<>("estado_envio"));
    	 this.colFechaEntrega.setCellValueFactory(new PropertyValueFactory<>("fecha_entrega"));
    	 this.colFechaEnvio.setCellValueFactory(new PropertyValueFactory<>("fecha_envio"));
    	 this.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	 this.colMetodo.setCellValueFactory(new PropertyValueFactory<>("metodo_envio"));
		 tableEnvios.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> {
			 envioSeleccionado = newSelection;
		 });
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;

        tableEnvios.getItems().clear();
        tableEnvios.setItems(getListaEnviosData());
    }

    private ObservableList<Envio> getListaEnviosData() {
		 ArrayList<Envio> listaEnvios = new ArrayList<Envio>(aplicacion.obtenerListaEnvios());
		 this.listaEnviosData.addAll(listaEnvios);
		 return listaEnviosData;
	}
}
