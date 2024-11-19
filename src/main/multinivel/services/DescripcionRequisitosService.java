package multinivel.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import multinivel.model.DescripcionRequisitos;

public class DescripcionRequisitosService {
	public static DescripcionRequisitos obtenerDescripcionRequisitosById(Connection cx, int idBuscar){
		DescripcionRequisitos descripcionRequisitos = null;
		try {
			String query = "SELECT * FROM DESCRIPCIONREQUISITOS d "
					+ "JOIN NIVELEMPLEADO n ON d.id_nivel = n.id "
					+ "WHERE n.id = "+idBuscar;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id_nivel;
			String descripcion;

			while(result.next()){
				id_nivel = result.getInt("id_nivel");
				descripcion = result.getString("descripcion");
				descripcionRequisitos = new DescripcionRequisitos(id_nivel, descripcion);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return descripcionRequisitos;
	}
}
