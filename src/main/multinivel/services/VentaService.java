package multinivel.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import multinivel.dto.DetalleVentaDTO;
import multinivel.model.Cliente;
import multinivel.model.Empleado;
import multinivel.model.EstadoVenta;
import multinivel.model.MetodoPago;
import multinivel.model.Venta;
import oracle.jdbc.OracleTypes;

public class VentaService {
	public static ArrayList<Venta> obtenerListaVentas(Connection cx){
		ArrayList<Venta> listaVentas = new ArrayList<>();
		try {
			String query = "SELECT * FROM VENTA";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			MetodoPago metodo_pago;
			EstadoVenta estado_venta;
			Cliente cliente;
			Empleado empleado;
			float valor_venta;
			Date fecha_venta;

			while(result.next()){
				id = result.getInt("id");
				metodo_pago = MetodoPagoService.obtenerMetodoPagoById(cx, result.getInt("id_metodo_pago"));
				estado_venta = EstadoVentaService.obtenerEstadoVentaById(cx, result.getInt("id_estado_venta"));
				cliente = ClienteService.obtenerClienteById(cx, result.getInt("id_cliente"));
				empleado = EmpleadoService.obtenerEmpleadoById(cx, result.getInt("id_empleado"));
				valor_venta = result.getFloat("valor_venta");
				fecha_venta = result.getDate("fecha_venta");

				Venta venta = new Venta(id, metodo_pago, estado_venta, cliente, empleado, valor_venta, fecha_venta);
				listaVentas.add(venta);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaVentas;
	}

	public static Venta obtenerVentaById(Connection cx, int idBuscar){
		Venta venta = null;
		try {
			String query = "SELECT * FROM VENTA "
					+ "WHERE id = "+idBuscar;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			MetodoPago metodo_pago;
			EstadoVenta estado_venta;
			Cliente cliente;
			Empleado empleado;
			float valor_venta;
			Date fecha_venta;

			while(result.next()){
				id = result.getInt("id");
				metodo_pago = MetodoPagoService.obtenerMetodoPagoById(cx, result.getInt("id_metodo_pago"));
				estado_venta = EstadoVentaService.obtenerEstadoVentaById(cx, result.getInt("id_estado_venta"));
				cliente = ClienteService.obtenerClienteById(cx, result.getInt("id_cliente"));
				empleado = EmpleadoService.obtenerEmpleadoById(cx, result.getInt("id_empleado"));
				valor_venta = result.getFloat("valor_venta");
				fecha_venta = result.getDate("fecha_venta");

				venta = new Venta(id, metodo_pago, estado_venta, cliente, empleado, valor_venta, fecha_venta);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return venta;
	}

	public static int obtenerCantidadVentasEmpleado(Connection cx, int idEmpleado) {
		int numeroVentas = 0;
		try {
			String query = "SELECT COUNT(*) FROM VENTA v "
					+ "JOIN EMPLEADO e ON v.id_empleado = e.id "
					+ "WHERE e.id = "+idEmpleado;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			while(result.next()){
				numeroVentas = result.getInt(1);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return numeroVentas;
	}

	public static boolean agregarVenta(Connection cx, int idCliente, int idEmpleado, int idMetodoPago,
			ObservableList<DetalleVentaDTO> listaDetallesVentaData) {
		try {
			PreparedStatement ps =
					cx.prepareStatement("INSERT INTO "
					+ "VENTA (ID, ID_METODO_PAGO, ID_ESTADO_VENTA, ID_CLIENTE,"
					+ "ID_EMPLEADO,FECHA_VENTA,VALOR_VENTA) "
					+ "VALUES(NULL, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, idMetodoPago);
			ps.setInt(2, 1);
			ps.setInt(3, idCliente);
			ps.setInt(4, idEmpleado);
			ps.setDate(5, Date.valueOf(LocalDate.now()));
			ps.setFloat(6, 0);
			ps.executeUpdate();
			ps.close();
			int id_venta = obtenerUltimoIdInsertado(cx);
			for (DetalleVentaDTO detalleVentaDTO : listaDetallesVentaData) {
				DetalleVentaService.agregarDetalleVenta(cx, id_venta, detalleVentaDTO);}
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"No se puede registrar la venta por la siguiente razon:\n"+
					"C�digo de error: "+e.getErrorCode()+"\n"
					+ "Mensaje: "+e.getMessage());
		}
		return false;
	}

	private static int obtenerUltimoIdInsertado(Connection cx) {
		int ultimo_id_insertado = 0;
		try {
			String query = "SELECT MAX(id) FROM VENTA v";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			while(result.next()){
				ultimo_id_insertado = result.getInt(1);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ultimo_id_insertado;
	}


	//REVISAR ESTE
	public static float obtenerTotalComisionesDirectas(Connection cx, int id_empleado) {
		float total_comisiones_directas = 0;
		try {
			CallableStatement callableStatement = cx.prepareCall("{? = call TOTAL_COMISIONES_DIRECTAS(?)}");

			// Configurar los par�metros de entrada
			callableStatement.setInt(2, id_empleado);

            // Definir el par�metro de salida
			callableStatement.registerOutParameter(1, OracleTypes.FLOAT); // El primer par�metro es el cursor de salida

			callableStatement.execute();

			// Obtener el resultado de la funci�n
			total_comisiones_directas = callableStatement.getFloat(1);

			callableStatement.close();

			return total_comisiones_directas;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Errorcito:\n"+
					"C�digo de error: "+e.getErrorCode()+"\n"
					+ "Mensaje: "+e.getMessage());
		}
		return total_comisiones_directas;
	}



	public static float obtenerTotalComisionesIndirectas(Connection cx, int id_empleado) {
		float total_comisiones_indirectas = 0;
		try {
			CallableStatement callableStatement = cx.prepareCall("{? = call TOTAL_COMISIONES_INDIRECTAS(?)}");

			// Configurar los par�metros de entrada
			callableStatement.setInt(2, id_empleado);

            // Definir el par�metro de salida
			callableStatement.registerOutParameter(1, OracleTypes.FLOAT); // El primer par�metro es el float de salida

			callableStatement.execute();

			// Obtener el resultado de la funci�n
			total_comisiones_indirectas = callableStatement.getFloat(1);

			callableStatement.close();

			return total_comisiones_indirectas;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Errorcito:\n"+
					"C�digo de error: "+e.getErrorCode()+"\n"
					+ "Mensaje: "+e.getMessage());
		}
		return total_comisiones_indirectas;
	}

	public static float obtenerTotalVendidoYear(Connection cx, int id_empleado) {
		float total_vendido_year = 0;
		try {
			CallableStatement callableStatement = cx.prepareCall("{? = call CALCULAR_TOTAL_VENDIDO_YEAR(?)}");

			// Configurar los par�metros de entrada
			callableStatement.setInt(2, id_empleado);

            // Definir el par�metro de salida
			callableStatement.registerOutParameter(1, OracleTypes.FLOAT); // El primer par�metro es el cursor de salida

			callableStatement.execute();

			// Obtener el resultado de la funci�n
			total_vendido_year = callableStatement.getFloat(1);

			callableStatement.close();

			return total_vendido_year;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Errorcito:\n"+
					"C�digo de error: "+e.getErrorCode()+"\n"
					+ "Mensaje: "+e.getMessage());
		}
		return total_vendido_year;
	}
}
