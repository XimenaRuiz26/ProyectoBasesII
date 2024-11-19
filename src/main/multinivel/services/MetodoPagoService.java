package multinivel.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import multinivel.model.MetodoPago;

public class MetodoPagoService {

	public static ArrayList<MetodoPago> obtenerListaMetodosPago(Connection cx){
		ArrayList<MetodoPago> listaMetodosPago = new ArrayList<>();
		try {
			String query = "SELECT * FROM MetodoPago";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			String descripcion;

			while(result.next()){
				id = result.getInt("id");
				descripcion = result.getString("descripcion");
				MetodoPago metodoPago = new MetodoPago(id, descripcion);
				listaMetodosPago.add(metodoPago);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaMetodosPago;
	}

	public static MetodoPago obtenerMetodoPagoById(Connection cx, int idBuscar){
		MetodoPago metodoPago = null;
		try {
			String query = "SELECT * FROM MetodoPago WHERE id = "+idBuscar;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			String descripcion;

			while(result.next()){
				id = result.getInt("id");
				descripcion = result.getString("descripcion");
				metodoPago = new MetodoPago(id, descripcion);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return metodoPago;
	}
}
