package multinivel.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import multinivel.model.EstadoVenta;

public class EstadoVentaService {
	public static EstadoVenta obtenerEstadoVentaById(Connection cx, int idBuscar){
		EstadoVenta estadoVenta = null;
		try {
			String query = "SELECT * FROM EstadoVenta WHERE id = "+idBuscar;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			String estado;

			while(result.next()){
				id = result.getInt("id");
				estado = result.getString("descripcion");
				estadoVenta = new EstadoVenta(id, estado);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return estadoVenta;
	}
}
