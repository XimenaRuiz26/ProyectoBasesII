package multinivel.connection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import multinivel.controller.ActualizarProductoController;
import multinivel.dto.DetalleVentaDTO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import multinivel.model.CategoriaProducto;
import multinivel.model.Producto;
import multinivel.controller.AdministracionController;
import multinivel.controller.AfiliacionController;
import multinivel.controller.DespachoController;
import multinivel.controller.DetallesVentaController;
import multinivel.controller.InicioController;
import multinivel.controller.InventarioController;
import multinivel.controller.LoginAfiliadoController;
import multinivel.controller.NuevaVentaController;
import multinivel.controller.NuevoProductoController;
import multinivel.controller.PerfilAfiliadoController;
import multinivel.controller.RedController;
import multinivel.controller.ReporteIndividualController;
import multinivel.controller.ReportesController;
import multinivel.model.Cliente;
import multinivel.model.Empleado;
import multinivel.model.Envio;
import multinivel.model.MetodoPago;
import multinivel.model.Venta;
import multinivel.services.CategoriaProductoService;
import multinivel.services.ClienteService;
import multinivel.services.EmpleadoService;
import multinivel.services.EnvioService;
import multinivel.services.MetodoPagoService;
import multinivel.services.ProductoService;
import multinivel.services.ReportesService;
import multinivel.services.VentaService;

public class Aplicacion extends Application{
	private Stage primaryStage;
	private static Connection cx;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Belleza Selecta");
		//this.primaryStage.getIcons().add(new Image("file:src/main/multinivel/view/images/logo.png"));
		mostrarInicio();
	}

	public static void main(String[] args) {
		conectarBaseDatos();
	    launch(args);
	}

	private static void conectarBaseDatos() {
		DatabaseConnection conexion = new DatabaseConnection();
		cx = conexion.conectar();
	}

	public void mostrarInicio() {
	    try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Aplicacion.class.getResource("/multinivel/view/InicioView.fxml"));

	        AnchorPane rootLayout = (AnchorPane)loader.load();

	        InicioController inicioControler = loader.getController();
	        inicioControler.setAplicacion(this);

	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Inicio");
	        primaryStage.setResizable(false);
			javafx.geometry.Rectangle2D screenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();

			// Calcular la posición centrada
			primaryStage.setX((screenBounds.getWidth() - rootLayout.getPrefWidth()) / 2);
			primaryStage.setY((screenBounds.getHeight() - rootLayout.getPrefHeight()) / 2);

	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void abrirVentanaAdministracion() {
		try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Aplicacion.class.getResource("/multinivel/view/AdministracionView.fxml"));

	        AnchorPane rootLayout = (AnchorPane)loader.load();

	        AdministracionController administracionController = loader.getController();
	        administracionController.setAplicacion(this);

	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Administracion");
	        primaryStage.setResizable(false);
			javafx.geometry.Rectangle2D screenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();

			// Calcular la posición centrada
			primaryStage.setX((screenBounds.getWidth() - rootLayout.getPrefWidth()) / 2);
			primaryStage.setY((screenBounds.getHeight() - rootLayout.getPrefHeight()) / 2);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void abrirVentanaLoginAfiliado() {
		try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Aplicacion.class.getResource("/multinivel/view/LoginAfiliadoView.fxml"));

	        AnchorPane rootLayout = (AnchorPane)loader.load();

	        LoginAfiliadoController loginController = loader.getController();
	        loginController.setAplicacion(this);

	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Login Afiliado");
	        primaryStage.setResizable(false);
			javafx.geometry.Rectangle2D screenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();

			// Calcular la posición centrada
			primaryStage.setX((screenBounds.getWidth() - rootLayout.getPrefWidth()) / 2);
			primaryStage.setY((screenBounds.getHeight() - rootLayout.getPrefHeight()) / 2);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void abrirVentanaInventario() {
		try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Aplicacion.class.getResource("/multinivel/view/InventarioView.fxml"));

	        AnchorPane rootLayout = (AnchorPane)loader.load();

	        InventarioController controller = loader.getController();
	        controller.setAplicacion(this);

	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Inventario");
	        primaryStage.setResizable(false);
			javafx.geometry.Rectangle2D screenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();

			// Calcular la posición centrada
			primaryStage.setX((screenBounds.getWidth() - rootLayout.getPrefWidth()) / 2);
			primaryStage.setY((screenBounds.getHeight() - rootLayout.getPrefHeight()) / 2);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void abrirVentanaDespachos() {
		try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Aplicacion.class.getResource("/multinivel/view/DespachoView.fxml"));

	        AnchorPane rootLayout = (AnchorPane)loader.load();

	        DespachoController controller = loader.getController();
	        controller.setAplicacion(this);

	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Despacho");
	        primaryStage.setResizable(false);
			javafx.geometry.Rectangle2D screenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();

			// Calcular la posición centrada
			primaryStage.setX((screenBounds.getWidth() - rootLayout.getPrefWidth()) / 2);
			primaryStage.setY((screenBounds.getHeight() - rootLayout.getPrefHeight()) / 2);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void abrirVentanaRed() {
		try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Aplicacion.class.getResource("/multinivel/view/RedView.fxml"));

	        AnchorPane rootLayout = (AnchorPane)loader.load();

	        RedController controller = loader.getController();
	        controller.setAplicacion(this);

	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Perfil Afiliado");
	        primaryStage.setResizable(false);
			javafx.geometry.Rectangle2D screenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();

			// Calcular la posición centrada
			primaryStage.setX((screenBounds.getWidth() - rootLayout.getPrefWidth()) / 2);
			primaryStage.setY((screenBounds.getHeight() - rootLayout.getPrefHeight()) / 2);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	public void abrirVentanaPerfilAfiliado(Empleado empleado) {
		try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Aplicacion.class.getResource("/multinivel/view/PerfilAfiliadoView.fxml"));

	        AnchorPane rootLayout = (AnchorPane)loader.load();

	        PerfilAfiliadoController controller = loader.getController();
	        controller.setAplicacion(this, empleado);

	        Scene scene = new Scene(rootLayout);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Perfil Afiliado");
	        primaryStage.setResizable(false);
			javafx.geometry.Rectangle2D screenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();

			// Calcular la posición centrada
			primaryStage.setX((screenBounds.getWidth() - rootLayout.getPrefWidth()) / 2);
			primaryStage.setY((screenBounds.getHeight() - rootLayout.getPrefHeight()) / 2);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void abrirVentanaAfiliacion() {
		try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Aplicacion.class.getResource("/multinivel/view/AfiliacionView.fxml"));

	        AnchorPane rootLayout = (AnchorPane)loader.load();

	        AfiliacionController afiliacionController = loader.getController();
	        afiliacionController.setAplicacion(this);

	        Scene scene = new Scene(rootLayout);
	        primaryStage.setTitle("Afiliate");
	        primaryStage.setScene(scene);
	        primaryStage.setResizable(false);
			javafx.geometry.Rectangle2D screenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();

			// Calcular la posición centrada
			primaryStage.setX((screenBounds.getWidth() - rootLayout.getPrefWidth()) / 2);
			primaryStage.setY((screenBounds.getHeight() - rootLayout.getPrefHeight()) / 2);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public Empleado ingresarAfiliado(String email, String password) {
		return EmpleadoService.obtenerEmpleadoByEmail(cx, email);
	}

	public Empleado afiliar(String nombres, String apellidos, String direccion, String email, String telefono,
			Date fechaNacimiento, String idAfiliador) {
		return EmpleadoService.afiliarEmpleado(cx, nombres, apellidos, direccion, email, telefono, fechaNacimiento, idAfiliador);
	}

	public void abrirVentanaEmergenteNuevaVenta(int idEmpleado) {
		try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/multinivel/view/NuevaVentaEmergenteView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nueva Venta");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setResizable(false);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            NuevaVentaController controller = loader.getController();
            controller.setAplicacion(this, idEmpleado);

            // Set the dialog icon.
            //dialogStage.getIcons().add(new Image("src/main/multinivel/view/images/logo.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public boolean desafiliar(int idEmpleado) {
		return EmpleadoService.desafiliarEmpleado(cx, idEmpleado);
	}

	public void abrirVentanaEmergenteNuevoProducto(InventarioController inventarioController) {
		try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/multinivel/view/NuevoProductoEmergenteView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Nuevo Producto");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setResizable(false);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            NuevoProductoController controller = loader.getController();
            controller.setAplicacion(this);

            // Set the dialog icon.
            //dialogStage.getIcons().add(new Image("src/main/multinivel/view/images/logo.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void abrirVentanaEmergenteActualizarProducto(Producto productoActualizar) {
		try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/multinivel/view/ActualizarProductoEmergenteView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Actualizacion de Producto");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setResizable(false);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ActualizarProductoController controller = loader.getController();
            controller.setAplicacion(this, productoActualizar, dialogStage);

            // Set the dialog icon.
            //dialogStage.getIcons().add(new Image("/view/images/logo.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void abrirVentanaEmergenteDetallesVenta(Venta ventaEnvio) {
		try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/multinivel/view/DetallesVentaEmergenteView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Detalles de la venta");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setResizable(false);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            DetallesVentaController controller = loader.getController();
            controller.setAplicacion(this, ventaEnvio);

            // Set the dialog icon.
            //dialogStage.getIcons().add(new Image("src/main/multinivel/view/images/logo.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void abrirVentanaReportes() {
		try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Aplicacion.class.getResource("/multinivel/view/ReportesView.fxml"));

	        AnchorPane rootLayout = (AnchorPane)loader.load();

	        ReportesController controller = loader.getController();
	        controller.setAplicacion(this);

	        Scene scene = new Scene(rootLayout);
	        primaryStage.setTitle("Reportes");
	        primaryStage.setScene(scene);
	        primaryStage.setResizable(false);
			javafx.geometry.Rectangle2D screenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();

			// Calcular la posición centrada
			primaryStage.setX((screenBounds.getWidth() - rootLayout.getPrefWidth()) / 2);
			primaryStage.setY((screenBounds.getHeight() - rootLayout.getPrefHeight()) / 2);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void abrirVentanaEmergenteReporte(int numReporte) {
		try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("/multinivel/view/ReporteEmergenteView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Reporte");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setResizable(false);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ReporteIndividualController controller = loader.getController();
	        controller.setAplicacion(this, numReporte);

            // Set the dialog icon.
            //dialogStage.getIcons().add(new Image("file:src/main/multinivel/view/images/logo.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public ArrayList<Producto> obtenerListaProductos() {
		return ProductoService.obtenerListaProductos(cx);
	}

	public void eliminarProductoById(int idEliminar) {
		ProductoService.eliminarProductoById(cx, idEliminar);
	}

	public ArrayList<CategoriaProducto> obtenerCategoriasProducto() {
		return CategoriaProductoService.obtenerListaCategoriasProducto(cx);
	}

	public void agregarProducto(int idCategoria, int unidadesDisponibles, float precioUnitario, String sNombre,
			String sDescripcion, String sFabricante) {
		ProductoService.agregarProducto(cx, idCategoria, unidadesDisponibles, precioUnitario, sNombre, sDescripcion, sFabricante);
	}

	public void actualizarProducto(int idProductoActualizar, int idCategoria, int unidadesDisponibles, float precioUnitario,
			String sNombre, String sDescripcion, String sFabricante) {
		ProductoService.actualizarProducto(cx, idProductoActualizar, idCategoria, unidadesDisponibles, precioUnitario, sNombre, sDescripcion, sFabricante);
	}

	public ArrayList<Empleado> obtenerListaEmpleados() {
		return EmpleadoService.obtenerListaEmpleados(cx);
	}

	public ArrayList<Empleado> obtenerListaAfiliados(int idAfiliador) {
		return EmpleadoService.obtenerListaAfiliados(cx, idAfiliador);
	}

	public int obtenerCantidadVentasEmpleado(int idEmpleado) {
		return VentaService.obtenerCantidadVentasEmpleado(cx, idEmpleado);
	}

	public ArrayList<Envio> obtenerListaEnvios() {
		return EnvioService.obtenerListaEnvios(cx);
	}

	public ArrayList<MetodoPago> obtenerMetodosPago() {
		return MetodoPagoService.obtenerListaMetodosPago(cx);
	}

	public boolean registrarVenta(int idCliente, int idEmpleado, int idMetodoPago,
			ObservableList<DetalleVentaDTO> listaDetallesVentaData) {
		return VentaService.agregarVenta(cx, idCliente, idEmpleado, idMetodoPago, listaDetallesVentaData);
	}

	public String reporte1() {
		return ReportesService.reporte1(cx);
	}

	public String reporte2() {
		return ReportesService.reporte2(cx);
	}

	public String reporte3() {
		return ReportesService.reporte3(cx);
	}

	public String reporte4() {
		return ReportesService.reporte4(cx);
	}

	public String reporte5() {
		return ReportesService.reporte5(cx);
	}

	public ArrayList<Cliente> obtenerListaClientes() {
		return ClienteService.obtenerListaClientes(cx);
	}

	public float obtenerTotalComisionesDirectas(int id_empleado) {
		return VentaService.obtenerTotalComisionesDirectas(cx, id_empleado);
	}

	public float obtenerTotalComisionesIndirectas(int id_empleado) {
		return VentaService.obtenerTotalComisionesIndirectas(cx, id_empleado);
	}

	public float obtenerTotalVendidoYear(int id_empleado) {
		return VentaService.obtenerTotalVendidoYear(cx, id_empleado);
	}
}
