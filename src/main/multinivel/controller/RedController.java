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
import multinivel.dto.EmpleadoDTO;
import multinivel.dto.MapeoDTO;
import multinivel.model.Empleado;

public class RedController {
	Aplicacion aplicacion;

	EmpleadoDTO empleadoSeleccionado;
	EmpleadoDTO afiliadoSeleccionado;
	ObservableList<EmpleadoDTO> listaEmpleadosData = FXCollections.observableArrayList();
	ObservableList<EmpleadoDTO> listaAfiliadosData = FXCollections.observableArrayList();

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<String, EmpleadoDTO> colNombresAfiliado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colCorreoEmpleado;

    @FXML
    private TableColumn<Integer, EmpleadoDTO> colAfiliadorEmpleado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colCorreoAfiliado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colNivelEmpleado;

    @FXML
    private TableColumn<Date, EmpleadoDTO> colFechaNacimientoEmpleado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colNivelAfiliado;

    @FXML
    private TableColumn<Integer, EmpleadoDTO> colAfiliadorAfiliado;

    @FXML
    private TableColumn<Integer, EmpleadoDTO> colIdEmpleado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colNombreEmpleado;

    @FXML
    private TableView<EmpleadoDTO> tableAfiliadosEmpleado;

    @FXML
    private TableColumn<Integer, EmpleadoDTO> colIdAfiliado;

    @FXML
    private TableView<EmpleadoDTO> tableEmpleados;

    @FXML
    private TableColumn<String, EmpleadoDTO> colDireccionEmpleado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colDireccionAfiliado;

    @FXML
    private TableColumn<Date, EmpleadoDTO> colFechaNacimientoAfiliado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colTelefonoEmpleado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colApellidosEmpleado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colApellidosAfiliado;

    @FXML
    private TableColumn<String, EmpleadoDTO> colTelefonoAfiliado;

    @FXML
    void desafiliar(ActionEvent event) {
    	int verificacion = JOptionPane.showConfirmDialog(null, "Estas seguro de que desea desafiliar al empleado?");
    	if (verificacion == 0) {
    		int idEmpleado = empleadoSeleccionado.getId();
    		boolean eliminado = aplicacion.desafiliar(idEmpleado);
    		if (eliminado) {
    			JOptionPane.showMessageDialog(null, "Se ha desafiliado al empleado: "+empleadoSeleccionado.getNombres()+"\n"
        				+ "Todos los afiliados de este empleado eliminado pasaran a ser afiliados del empleado: "+empleadoSeleccionado.getEmpleado().getAfiliador().getNombres());
        		tableEmpleados.getItems().clear();
                tableEmpleados.setItems(getListaEmpleadosData());
                tableAfiliadosEmpleado.refresh();
			}
    	}else{
			JOptionPane.showMessageDialog(null, "Has cancelado la desafiliacion");
		}
    }

    @FXML
    void atrasVentana(ActionEvent event) {
    	aplicacion.abrirVentanaAdministracion();
    }

    @FXML
   	void initialize() {
		 this.colIdEmpleado.setCellValueFactory(new PropertyValueFactory<>("id"));
		 this.colNivelEmpleado.setCellValueFactory(new PropertyValueFactory<>("nivel_empleado"));
		 this.colFechaNacimientoEmpleado.setCellValueFactory(new PropertyValueFactory<>("fecha_nacimiento"));
		 this.colNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombres"));
		 this.colApellidosEmpleado.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
		 this.colDireccionEmpleado.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		 this.colCorreoEmpleado.setCellValueFactory(new PropertyValueFactory<>("correo"));
		 this.colTelefonoEmpleado.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		 this.colAfiliadorEmpleado.setCellValueFactory(new PropertyValueFactory<>("afiliador"));

		 tableEmpleados.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> {
			 empleadoSeleccionado = newSelection;
			 if (empleadoSeleccionado!=null) {
				 mostrarAfiliadosEmpleado(empleadoSeleccionado.getId());
			 }
		 });

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

    private void mostrarAfiliadosEmpleado(int idAfiliador) {
    	tableAfiliadosEmpleado.getItems().clear();
    	tableAfiliadosEmpleado.setItems(getListaAfiliadosData(idAfiliador));
    	tableAfiliadosEmpleado.refresh();
	}

	private ObservableList<EmpleadoDTO> getListaAfiliadosData(int idAfiliador) {
		ArrayList<Empleado> listaAfiliados = new ArrayList<Empleado>(aplicacion.obtenerListaAfiliados(idAfiliador));
		ArrayList<EmpleadoDTO> listaAfiliadosDTO = MapeoDTO.mapearEmpleadosDTO(listaAfiliados);
		this.listaAfiliadosData.addAll(listaAfiliadosDTO);
		return listaAfiliadosData;
	}

	public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;

        tableEmpleados.getItems().clear();
        tableEmpleados.setItems(getListaEmpleadosData());

    }

	private ObservableList<EmpleadoDTO> getListaEmpleadosData() {
		 ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>(aplicacion.obtenerListaEmpleados());
		 ArrayList<EmpleadoDTO> listaEmpleadosDTO = MapeoDTO.mapearEmpleadosDTO(listaEmpleados);
		 this.listaEmpleadosData.addAll(listaEmpleadosDTO);
		 return listaEmpleadosData;
	}


}
