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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import multinivel.connection.Aplicacion;
import multinivel.dto.EmpleadoDTO;
import multinivel.dto.MapeoDTO;
import multinivel.model.Empleado;

public class PerfilAfiliadoController {
	Aplicacion aplicacion;
	Empleado empleado;
	ObservableList<EmpleadoDTO> listaAfiliadosData = FXCollections.observableArrayList();

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbIdAfiliador;

    @FXML
    private Label lbNombres;

    @FXML
    private Label lbComisionesDirectas;

    @FXML
    private Label lbComisionesIndirectas;

    @FXML
    private Label lbTotalVendido;

    @FXML
    private TableColumn<String, EmpleadoDTO> colNombresAfiliado;

    @FXML
    private Label lbNivelEmpleado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colCorreoAfiliado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colNivelAfiliado;

    @FXML
    private TableColumn<Integer, EmpleadoDTO> colAfiliadorAfiliado;

    @FXML
    private TableColumn<Integer, EmpleadoDTO> colIdAfiliado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colDireccionAfiliado;

    @FXML
    private TableColumn<Date, EmpleadoDTO> colFechaNacimientoAfiliado;

    @FXML
    private TableView<EmpleadoDTO> tableAfiliados;

    @FXML
    private Label lbNumeroVentas;

    @FXML
    private Label lbEmail;

    @FXML
    private TableColumn<String, EmpleadoDTO> colApellidosAfiliado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colTelefonoAfiliado;

    @FXML
    private Label lbIdAfiliado;

    @FXML
    void atrasVentana(ActionEvent event) {
    	aplicacion.abrirVentanaLoginAfiliado();
    }

    @FXML
    void registrarVenta(ActionEvent event) {
    	String idEmpleado = lbIdAfiliado.getText();
    	aplicacion.abrirVentanaEmergenteNuevaVenta(Integer.parseInt(idEmpleado));
    	mostrarDatosEmpleado();
    }

    @FXML
    void desafiliarse(ActionEvent event) {
    	int verificacion = JOptionPane.showConfirmDialog(null, "Estas seguro de que deseas desafiliarte?\r\n"
    			+ "Ten en cuenta que si te desafilias y deseas volver en un futuro\r\n"
    			+ "volveras a comenzar en el nivel inicial.");
    	if (verificacion == 0) {
    		int idAfiliado = Integer.parseInt(lbIdAfiliado.getText());
			boolean eliminado = aplicacion.desafiliar(idAfiliado);
			if (eliminado) {
				JOptionPane.showMessageDialog(null, "Te has desafiliado exitosamente");
	    		aplicacion.abrirVentanaLoginAfiliado();
			}else{
				JOptionPane.showMessageDialog(null, "Usted es el gerente, se tiene que morir primero");
			}
		}else{
			JOptionPane.showMessageDialog(null, "Has cancelado la desafiliacion");
		}
    }

	@FXML
   	void initialize() {
    	this.colIdAfiliado.setCellValueFactory(new PropertyValueFactory<>("id"));
		 this.colNivelAfiliado.setCellValueFactory(new PropertyValueFactory<>("nivel_empleado"));
		 this.colFechaNacimientoAfiliado.setCellValueFactory(new PropertyValueFactory<>("fecha_nacimiento"));
		 this.colNombresAfiliado.setCellValueFactory(new PropertyValueFactory<>("nombres"));
		 this.colApellidosAfiliado.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
		 this.colDireccionAfiliado.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		 this.colCorreoAfiliado.setCellValueFactory(new PropertyValueFactory<>("correo"));
		 this.colTelefonoAfiliado.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		 this.colAfiliadorAfiliado.setCellValueFactory(new PropertyValueFactory<>("afiliador"));
    }

    public void setAplicacion(Aplicacion aplicacion, Empleado empleado) {
        this.aplicacion = aplicacion;
        this.empleado = empleado;
        mostrarDatosEmpleado();
        mostrarDatosTabla();
    }

	private void mostrarDatosTabla() {
		tableAfiliados.getItems().clear();
		tableAfiliados.setItems(getListaAfiliadosData(empleado.getId()));
		tableAfiliados.refresh();
	}

	private ObservableList<EmpleadoDTO> getListaAfiliadosData(int idAfiliador) {
		ArrayList<Empleado> listaAfiliados = new ArrayList<Empleado>(aplicacion.obtenerListaAfiliados(idAfiliador));
		ArrayList<EmpleadoDTO> listaAfiliadosDTO = MapeoDTO.mapearEmpleadosDTO(listaAfiliados);
		this.listaAfiliadosData.addAll(listaAfiliadosDTO);
		return listaAfiliadosData;
	}

	private void mostrarDatosEmpleado() {
		this.lbEmail.setText(empleado.getCorreo());
        this.lbIdAfiliado.setText(String.valueOf(empleado.getId()));
        if (empleado.getAfiliador()!=null) {
            this.lbIdAfiliador.setText(String.valueOf(empleado.getAfiliador().getId()));
		}else{
			this.lbIdAfiliador.setText("No tiene");
		}
        this.lbNivelEmpleado.setText(empleado.getNivel_empleado().getNombre());
        this.lbNombres.setText(empleado.getNombres());
        this.lbNumeroVentas.setText(String.valueOf(aplicacion.obtenerCantidadVentasEmpleado(empleado.getId())));
        this.lbComisionesDirectas.setText(String.valueOf(aplicacion.obtenerTotalComisionesDirectas(empleado.getId())));
        this.lbComisionesIndirectas.setText(String.valueOf(aplicacion.obtenerTotalComisionesIndirectas(empleado.getId())));
        this.lbTotalVendido.setText(String.valueOf(aplicacion.obtenerTotalVendidoYear(empleado.getId())));
	}
}
