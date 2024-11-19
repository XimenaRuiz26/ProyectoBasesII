package multinivel.dto;

import java.util.ArrayList;

import multinivel.model.Empleado;
import multinivel.model.Producto;

public class MapeoDTO {

	public static ArrayList<ProductoDTO> mapearProductosDTO(ArrayList<Producto> listaProductos){
		ArrayList<ProductoDTO> listaProductosDTO = new ArrayList<>();
		for (Producto producto : listaProductos) {
			listaProductosDTO.add(new ProductoDTO(producto));
		}
		return listaProductosDTO;
	}

	public static ArrayList<EmpleadoDTO> mapearEmpleadosDTO(ArrayList<Empleado> listaEmpleados) {
		ArrayList<EmpleadoDTO> listaEmpleadosDTO = new ArrayList<>();
		for (Empleado empleado : listaEmpleados) {
			listaEmpleadosDTO.add(new EmpleadoDTO(empleado));
		}
		return listaEmpleadosDTO;
	}
}
