package multinivel.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import multinivel.model.MetodoEnvio;

public class MetodoEnvioService {
	public static MetodoEnvio obtenerMetodoEnvioById(Connection cx, int idBuscar){
		MetodoEnvio metodoEnvio = null;
		try {
			String query = "SELECT * FROM MetodoEnvio WHERE id = "+idBuscar;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			String nombre;

			while(result.next()){
				id = result.getInt("id");
				nombre = result.getString("nombre");
				metodoEnvio = new MetodoEnvio(id, nombre);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return metodoEnvio;
	}
}
