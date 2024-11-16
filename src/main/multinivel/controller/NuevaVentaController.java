package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import connection.Aplicacion;
import dto.DetalleVentaDTO;
import dto.MapeoDTO;
import dto.ProductoDTO;
import model.Cliente;
import model.MetodoPago;
import model.Producto;

public class NuevaVentaController {
	Aplicacion aplicacion;

	private ProductoDTO productoSeleccionadoInventario;
	private ObservableList<ProductoDTO> listaProductosInventarioData = FXCollections.observableArrayList();
	private DetalleVentaDTO detalleVentaSeleccionada;
	private ObservableList<DetalleVentaDTO> listaDetallesVentaData = FXCollections.observableArrayList();
	private ObservableList<MetodoPago> listaMetodosPago= FXCollections.observableArrayList();
	private ObservableList<Cliente> listaClientesData = FXCollections.observableArrayList();
	private Cliente clienteSeleccionado;
	private int idEmpleado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCantidadProducto;

    @FXML
    private Text lbValorVenta;

    @FXML
    private TableView<ProductoDTO> tableProductosInventario;

    @FXML
    private TableColumn<Float, ProductoDTO> colPrecioUnitarioProductoInventario;

    @FXML
    private TableColumn<String, ProductoDTO> colNombreProductoInventario;

    @FXML
    private TableColumn<String, ProductoDTO> colCategoriaProductoInventario;

    @FXML
    private TableColumn<String, ProductoDTO> colFabricanteProductoInventario;

    @FXML
    private TableColumn<Integer, ProductoDTO> colIdProductoInventario;

    @FXML
    private TableView<DetalleVentaDTO> tableDetallesVenta;

    @FXML
    private TableColumn<Producto, DetalleVentaDTO> colProductoVenta;

    @FXML
    private TableColumn<Integer, DetalleVentaDTO> colUnidadesVenta;

    @FXML
    private TableColumn<Float, DetalleVentaDTO> colSubtotalVenta;

    @FXML
    private ComboBox<MetodoPago> comboMetodoPago;

    @FXML
    private TextField txtIdCliente;

    @FXML
    private TableColumn<String, ProductoDTO> colDescripcionProductoInventario;

    @FXML
    private TableColumn<Integer, ProductoDTO> colUnidadesDisponiblesProductoInventario;

    @FXML
    private TableView<Cliente> tableClientes;

    @FXML
    private TableColumn<Integer, Cliente> colIdCliente;
    @FXML
    private TableColumn<String, Cliente> colNombresCliente;
    @FXML
    private TableColumn<String, Cliente> colApellidosCliente;
    @FXML
    private TableColumn<String, Cliente> colCorreoCliente;
    @FXML
    private TableColumn<String, Cliente> colTelefonoCliente;
    @FXML
    private TableColumn<String, Cliente> colDireccionCliente;

    @FXML
    void registrarVenta(ActionEvent event) {
    	String idCliente = txtIdCliente.getText();
    	MetodoPago metodoPago = comboMetodoPago.getValue();

    	if (validarVenta(idCliente, metodoPago)) {
    		boolean registrado = aplicacion.registrarVenta(Integer.valueOf(idCliente), idEmpleado, metodoPago.getId(), listaDetallesVentaData);
    		if (registrado) {
    			JOptionPane.showMessageDialog(null, "Venta registrada con exito");
    			limpiarPantalla();
    		}else{
				JOptionPane.showMessageDialog(null, "La venta no se ha realizado");
			}
    	}
    }

    private void limpiarPantalla() {
		listaDetallesVentaData.clear();
		tableDetallesVenta.refresh();
		txtCantidadProducto.setText("");
		txtIdCliente.setText("");
		comboMetodoPago.setValue(null);
		lbValorVenta.setText("0");
	}

	private boolean validarVenta(String idCliente, MetodoPago metodoPago) {
		if (listaDetallesVentaData.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Porfavor primero agregue un producto a la venta");
			return false;
		}
		if (idCliente == null || idCliente.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Porfavor ingrese el id de un cliente");
			return false;
		}
		try {
			Integer.valueOf(idCliente);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese un id valido numerico");
			return false;
		}
		if (metodoPago == null) {
			JOptionPane.showMessageDialog(null, "Porfavor elija primero un metodo de pago");
			return false;
		}
		return true;
	}

	@FXML
    void agregarProducto(ActionEvent event) {
    	String cantidad = txtCantidadProducto.getText();
    	if (validarAgregar(cantidad)) {
    		agregarDetalleVenta(Integer.parseInt(cantidad));
    		actualizarValorVenta();
    		JOptionPane.showMessageDialog(null, "Has agregado un producto a la venta");
		}
    }

	private void actualizarValorVenta() {
		float nuevoValorVenta = 0;
		for (DetalleVentaDTO detalleVentaDTO : listaDetallesVentaData) {
			nuevoValorVenta += detalleVentaDTO.getSubtotal();
		}
		lbValorVenta.setText(String.valueOf(nuevoValorVenta));
	}

	private void agregarDetalleVenta(int cantidadAgregar) {
		//Reducir cantidad visual de producto en la tabla
		int cantidadActual = productoSeleccionadoInventario.getUnidades_disponibles();
		int cantidadNueva = cantidadActual - cantidadAgregar;
		productoSeleccionadoInventario.setUnidades_disponibles(cantidadNueva);
		productoSeleccionadoInventario.getProducto().setUnidades_disponibles(cantidadNueva);
		tableProductosInventario.refresh();

		float subtotal = productoSeleccionadoInventario.getPrecio_unitario() * cantidadAgregar;
		DetalleVentaDTO nuevo = new DetalleVentaDTO(productoSeleccionadoInventario.getProducto(), cantidadAgregar, subtotal);
		listaDetallesVentaData.add(nuevo);
		tableDetallesVenta.refresh();
	}

	private boolean validarAgregar(String cantidad) {
    	try {
    		int cant = Integer.parseInt(cantidad);
    		for (DetalleVentaDTO detalleVentaDTO : listaDetallesVentaData) {
    			if (detalleVentaDTO.getProducto() == productoSeleccionadoInventario.getProducto()) {
    				JOptionPane.showMessageDialog(null, "El producto seleccionado ya se encuentra en la venta\n"
    						+ "Si desea cambiar la cantidad, quite el producto y vuelva a agregarlo con la nueva cantidad deseada");
        			return false;
				}
			}
    		if (cant > productoSeleccionadoInventario.getUnidades_disponibles()) {
    			JOptionPane.showMessageDialog(null, "La cantidad ingresada supera la cantidad de unidades disponibles del producto");
    			return false;
			}
    		if (productoSeleccionadoInventario != null && cantidad.isEmpty()) {
    			JOptionPane.showMessageDialog(null, "Porfavor ingrese una cantidad del producto seleccionado");
    			return false;
    		}
    		if (productoSeleccionadoInventario == null) {
    			JOptionPane.showMessageDialog(null, "Porfavor seleccione un producto primero");
    			return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese una cantidad numerica valida");
			return false;
		}
    	return true;
	}

	@FXML
    void quitarProducto(ActionEvent event) {
		if (detalleVentaSeleccionada != null) {
			eliminarDetalleVenta();
			actualizarValorVenta();
    		JOptionPane.showMessageDialog(null, "Has quitado el producto de la venta");
		}else{
			JOptionPane.showMessageDialog(null, "Porfavor seleccione primero el producto que desea quitar");
		}
    }

	private void eliminarDetalleVenta() {
		//Reducir cantidad visual de producto en la tabla
		int cantidadActual = productoSeleccionadoInventario.getUnidades_disponibles();
		int cantidadNueva = cantidadActual + detalleVentaSeleccionada.getUnidades();
		productoSeleccionadoInventario.setUnidades_disponibles(cantidadNueva);
		tableProductosInventario.refresh();

		listaDetallesVentaData.remove(detalleVentaSeleccionada);
		tableDetallesVenta.refresh();
	}

	@FXML
	void initialize() {
		 this.colCategoriaProductoInventario.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		 this.colDescripcionProductoInventario.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		 this.colFabricanteProductoInventario.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
		 this.colIdProductoInventario.setCellValueFactory(new PropertyValueFactory<>("id"));
		 this.colNombreProductoInventario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		 this.colPrecioUnitarioProductoInventario.setCellValueFactory(new PropertyValueFactory<>("precio_unitario"));
		 this.colUnidadesDisponiblesProductoInventario.setCellValueFactory(new PropertyValueFactory<>("unidades_disponibles"));

		 tableProductosInventario.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> {
			 productoSeleccionadoInventario = newSelection;
		 });

		 this.colProductoVenta.setCellValueFactory(new PropertyValueFactory<>("producto"));
		 this.colUnidadesVenta.setCellValueFactory(new PropertyValueFactory<>("unidades"));
		 this.colSubtotalVenta.setCellValueFactory(new PropertyValueFactory<>("subtotal"));

		 tableDetallesVenta.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> {
			 detalleVentaSeleccionada = newSelection;
		 });

		 this.colIdCliente.setCellValueFactory(new PropertyValueFactory<>("id"));
		 this.colNombresCliente.setCellValueFactory(new PropertyValueFactory<>("nombres"));
		 this.colApellidosCliente.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
		 this.colCorreoCliente.setCellValueFactory(new PropertyValueFactory<>("correo"));
		 this.colTelefonoCliente.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		 this.colDireccionCliente.setCellValueFactory(new PropertyValueFactory<>("direccion"));

		 tableClientes.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> {
			 clienteSeleccionado = newSelection;
			 txtIdCliente.setText(String.valueOf(clienteSeleccionado.getId()));
		 });
    }

	public void setAplicacion(Aplicacion aplicacion, int idEmpleado) {
		this.aplicacion = aplicacion;
		this.idEmpleado = idEmpleado;

		llenarComboMetodosPago();

		tableProductosInventario.getItems().clear();
	    tableProductosInventario.setItems(getListaProductosData());

	    tableDetallesVenta.getItems().clear();
	    tableDetallesVenta.setItems(listaDetallesVentaData);

	    tableClientes.getItems().clear();
	    tableClientes.setItems(getListaClientesData());
	}

	private void llenarComboMetodosPago() {
		listaMetodosPago.addAll(aplicacion.obtenerMetodosPago());
		this.comboMetodoPago.setItems(listaMetodosPago);
	}

	private ObservableList<ProductoDTO> getListaProductosData() {
		 ArrayList<Producto> listaProductos = new ArrayList<Producto>(aplicacion.obtenerListaProductos());
		 ArrayList<ProductoDTO> listaProductosDTO = MapeoDTO.mapearProductosDTO(listaProductos);
		 this.listaProductosInventarioData.addAll(listaProductosDTO);
		 return listaProductosInventarioData;
	}

	private ObservableList<Cliente> getListaClientesData() {
		 ArrayList<Cliente> listaClientes = new ArrayList<Cliente>(aplicacion.obtenerListaClientes());
		 this.listaClientesData.addAll(listaClientes);
		 return listaClientesData;
	}

}
