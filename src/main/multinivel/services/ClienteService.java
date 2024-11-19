package multinivel.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import multinivel.model.Cliente;

public class ClienteService {
	public static ArrayList<Cliente> obtenerListaClientes(Connection cx){
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		try {
			String query = "SELECT * FROM CLIENTE";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			Date fecha_nacimiento;
			String telefono;
			String correo;
			String nombres;
			String apellidos;
			String direccion;

			while(result.next()){
				id = result.getInt("id");
				fecha_nacimiento = result.getDate("fecha_nacimiento");
				telefono = result.getString("telefono");
				correo = result.getString("correo");
				nombres = result.getString("nombres");
				apellidos = result.getString("apellidos");
				direccion = result.getString("direccion");
				Cliente cliente = new Cliente(id, fecha_nacimiento, telefono, correo, nombres, apellidos, direccion);
				listaClientes.add(cliente);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaClientes;
	}

	public static Cliente obtenerClienteById(Connection cx, int idBuscar){
		Cliente cliente = null;
		try {
			String query = "SELECT * FROM CLIENTE WHERE id = "+idBuscar;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			Date fecha_nacimiento;
			String telefono;
			String correo;
			String nombres;
			String apellidos;
			String direccion;
			while(result.next()){
				id = result.getInt("id");
				fecha_nacimiento = result.getDate("fecha_nacimiento");
				telefono = result.getString("telefono");
				correo = result.getString("correo");
				nombres = result.getString("nombres");
				apellidos = result.getString("apellidos");
				direccion = result.getString("direccion");
				cliente = new Cliente(id, fecha_nacimiento, telefono, correo, nombres, apellidos, direccion);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return cliente;
	}
}
