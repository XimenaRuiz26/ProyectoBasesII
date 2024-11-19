package multinivel.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import multinivel.model.DescripcionBeneficios;
import multinivel.model.DescripcionRequisitos;
import multinivel.model.NivelEmpleado;

public class NivelEmpleadoService {
	public static NivelEmpleado obtenerNivelEmpleadoById(Connection cx, int idEmpleadoBuscar){
		NivelEmpleado nivelEmpleado = null;
		try {
			String query =
					"SELECT * FROM NIVELEMPLEADO n "
					+ "JOIN EMPLEADO e ON n.id = e.id_nivel "
					+ "WHERE e.id = "+idEmpleadoBuscar;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			String nombre;
			DescripcionRequisitos descripcionRequisitos;
			DescripcionBeneficios descripcionBeneficios;

			while(result.next()){
				id = result.getInt("id");
				nombre = result.getString("nombre");
				descripcionRequisitos = DescripcionRequisitosService.obtenerDescripcionRequisitosById(cx, id);
				descripcionBeneficios = DescripcionBeneficiosService.obtenerDescripcionBeneficiosById(cx, id);
				nivelEmpleado = new NivelEmpleado(id, nombre, descripcionRequisitos, descripcionBeneficios);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return nivelEmpleado;
	}
}
