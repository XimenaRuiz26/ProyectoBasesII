package multinivel.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import oracle.jdbc.OracleTypes;

public class ReportesService {
	public static String reporte1(Connection cx) {
		String reporte = "";
		try {
			CallableStatement callableStatement = cx.prepareCall("{? = call CANTIDAD_EMPLEADOS_NIVELES()}");
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR); // El primer par�metro es el cursor de salida
			callableStatement.execute();
			ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
			resultSet.next();
			reporte += "|  Nivel Afiliado: "+resultSet.getInt("'Afiliado'_CANTIDAD")+"  |  \n";
			reporte += "|  Nivel Bronce: "+resultSet.getInt("'Bronce'_CANTIDAD")+"  |  \n";
			reporte += "|  Nivel Cobre: "+resultSet.getInt("'Cobre'_CANTIDAD")+"  |  \n";
			reporte += "|  Nivel Plata: "+resultSet.getInt("'Plata'_CANTIDAD")+"  |  \n";
			reporte += "|  Nivel Oro: "+resultSet.getInt("'Oro'_CANTIDAD")+"  |  \n";
			reporte += "|  Nivel Diamante: "+resultSet.getInt("'Diamante'_CANTIDAD")+"  |\n";
			resultSet.close();
			callableStatement.close();
			return reporte;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Errorcito:\n"+
					"C�digo de error: "+e.getErrorCode()+"\n"
					+ "Mensaje: "+e.getMessage());
		}
		return reporte;
	}
	public static String reporte2(Connection cx) {
		String reporte = "Nombre	|	Descripcion		| Total Ventas\n\n";
		try {
			CallableStatement callableStatement = cx.prepareCall("{? = call REPORTE2()}");

			callableStatement.registerOutParameter(1, OracleTypes.CURSOR); // El primer par�metro es el cursor de salida

			callableStatement.execute();
			ResultSet resultSet = (ResultSet) callableStatement.getObject(1);

			while (resultSet.next()) {
				reporte += resultSet.getString("NOMBRE")+" | ";
				reporte += resultSet.getString("DESCRIPCION")+" | ";
				reporte += resultSet.getInt("TOTAL_VENTAS")+"\n";
			}
			resultSet.close();
			callableStatement.close();

			return reporte;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Errorcito:\n"+
					"C�digo de error: "+e.getErrorCode()+"\n"
					+ "Mensaje: "+e.getMessage());
		}
		return reporte;
	}

	public static String reporte3(Connection cx) {
		String reporte = "DESCRIPCION	|	NIVEL		| TOTAL VENTAS\n\n";
		try {
			CallableStatement callableStatement = cx.prepareCall("{? = call REPORTE3()}");

			callableStatement.registerOutParameter(1, OracleTypes.CURSOR); // El primer par�metro es el cursor de salida

			callableStatement.execute();
			ResultSet resultSet = (ResultSet) callableStatement.getObject(1);

			while (resultSet.next()) {
				reporte += resultSet.getString("DESCRIPCION")+" | ";
				reporte += resultSet.getString("NOMBRE")+" | ";
				reporte += resultSet.getInt("TOTAL_VENTAS")+"\n";
			}

			resultSet.close();
			callableStatement.close();

			return reporte;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Errorcito:\n"+
					"C�digo de error: "+e.getErrorCode()+"\n"
					+ "Mensaje: "+e.getMessage());
		}
		return reporte;
	}

	public static String reporte4(Connection cx) {
		String reporte = "NOMBRE EMPLEADO | MES DE VENTA | PROMEDIO VENDIDO EN VENTAS\n\n";
		try {
			CallableStatement callableStatement = cx.prepareCall("{? = call REPORTE4()}");

			callableStatement.registerOutParameter(1, OracleTypes.CURSOR); // El primer par�metro es el cursor de salida

			callableStatement.execute();
			ResultSet resultSet = (ResultSet) callableStatement.getObject(1);

			while (resultSet.next()) {
				reporte += resultSet.getString("NOMBRES")+" | ";
				reporte += resultSet.getInt("MES_VENTA")+" | ";
				reporte += resultSet.getFloat("VENTA_PROMEDIO")+"\n";
			}
			resultSet.close();
			callableStatement.close();

			return reporte;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Errorcito:\n"+
					"C�digo de error: "+e.getErrorCode()+"\n"
					+ "Mensaje: "+e.getMessage());
		}
		return reporte;
	}

	public static String reporte5(Connection cx) {
		String reporte = "ESTADO ENVIO | METODO ENVIO | TOTAL VENTAS\n";
		try {
			CallableStatement callableStatement = cx.prepareCall("{? = call REPORTE5()}");

			callableStatement.registerOutParameter(1, OracleTypes.CURSOR); // El primer par�metro es el cursor de salida

			callableStatement.execute();
			ResultSet resultSet = (ResultSet) callableStatement.getObject(1);

			while (resultSet.next()) {
				reporte += resultSet.getString("ESTADO")+" | ";
				reporte += resultSet.getString("NOMBRE")+" | ";
				reporte += resultSet.getInt("TOTAL_VENTAS")+"\n";
			}
			resultSet.close();
			callableStatement.close();

			return reporte;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Errorcito:\n"+
					"C�digo de error: "+e.getErrorCode()+"\n"
					+ "Mensaje: "+e.getMessage());
		}
		return reporte;
	}
}
