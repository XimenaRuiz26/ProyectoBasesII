package multinivel.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import multinivel.model.EstadoEnvio;

public class EstadoEnvioService {
	public static EstadoEnvio obtenerEstadoEnvioById(Connection cx, int idBuscar){
		EstadoEnvio estadoEnvio = null;
		try {
			String query = "SELECT * FROM EstadoEnvio WHERE id = "+idBuscar;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			String estado;

			while(result.next()){
				id = result.getInt("id");
				estado = result.getString("estado");
				estadoEnvio = new EstadoEnvio(id, estado);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return estadoEnvio;
	}
}
