package multinivel.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import multinivel.model.Empleado;
import multinivel.model.NivelEmpleado;

public class EmpleadoService {
	public static ArrayList<Empleado> obtenerListaEmpleados(Connection cx){
		ArrayList<Empleado> listaEmpleados = new ArrayList<>();
		try {
			String query = "SELECT * FROM VIEW_EMPLEADO WHERE IS_ACTIVE = 1";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);
			int id;
			NivelEmpleado nivel_empleado;
			Date fecha_nacimiento;
			String nombres;
			String apellidos;
			String direccion;
			String correo;
			String telefono;
			Empleado afiliador;
			while(result.next()){
				id = result.getInt("id");;
				nivel_empleado = NivelEmpleadoService.obtenerNivelEmpleadoById(cx, id);
				fecha_nacimiento = result.getDate("fecha_nacimiento");
				nombres = result.getString("nombres");
				apellidos = result.getString("apellidos");
				direccion = result.getString("direccion");
				correo = result.getString("correo");
				telefono = result.getString("telefono");
				afiliador = obtenerEmpleadoById(cx, result.getInt("id_afiliador"));
				Empleado empleado = new Empleado(id, nivel_empleado, fecha_nacimiento, nombres, apellidos,
						direccion, correo, telefono, afiliador);
				listaEmpleados.add(empleado);}
			result.close();
		} catch (SQLException e1) {
			e1.printStackTrace();}
		return listaEmpleados;
	}

	public static Empleado obtenerEmpleadoById(Connection cx, int idBuscar){
		Empleado empleado = null;
		try {
			String query = "SELECT * FROM VIEW_EMPLEADO WHERE id = "+idBuscar;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);
			int id;
			NivelEmpleado nivel_empleado;
			Date fecha_nacimiento;
			String nombres;
			String apellidos;
			String direccion;
			String correo;
			String telefono;
			Empleado afiliador;
			while(result.next()){
				id = result.getInt("id");;
				nivel_empleado = NivelEmpleadoService.obtenerNivelEmpleadoById(cx, result.getInt("id_nivel"));
				fecha_nacimiento = result.getDate("fecha_nacimiento");
				nombres = result.getString("nombres");
				apellidos = result.getString("apellidos");
				direccion = result.getString("direccion");
				correo = result.getString("correo");
				telefono = result.getString("telefono");
				afiliador = obtenerEmpleadoById(cx, result.getInt("id_afiliador"));
				empleado = new Empleado(id, nivel_empleado, fecha_nacimiento, nombres, apellidos, direccion, correo, telefono, afiliador);}
			result.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();}
		return empleado;
	}

	public static boolean desafiliarEmpleado(Connection cx, int idEmpleado) {
		try {
			PreparedStatement ps = cx.prepareStatement("{call DESAFILIAR_EMPLEADO(?)}");
			ps.setInt(1, idEmpleado);

			ps.executeUpdate();
			ps.close();

			JOptionPane.showMessageDialog(null, "Empleado desafiliado exitosamente");
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"No se puede desafiliar el empleado por la siguiente razon:\n"+
					"C�digo de error: "+e.getErrorCode()+"\n"
					+ "Mensaje: "+e.getMessage());
			return false;
		}
	}

	public static ArrayList<Empleado> obtenerListaAfiliados(Connection cx, int idAfiliador) {
		ArrayList<Empleado> listaAfiliados = new ArrayList<>();
		try {
			String query = "SELECT * FROM VIEW_EMPLEADO WHERE id_afiliador = "+idAfiliador+
					" AND is_active = 1";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			NivelEmpleado nivel_empleado;
			Date fecha_nacimiento;
			String nombres;
			String apellidos;
			String direccion;
			String correo;
			String telefono;
			Empleado afiliador;

			while(result.next()){
				id = result.getInt("id");;
				nivel_empleado = NivelEmpleadoService.obtenerNivelEmpleadoById(cx, id);
				fecha_nacimiento = result.getDate("fecha_nacimiento");
				nombres = result.getString("nombres");
				apellidos = result.getString("apellidos");
				direccion = result.getString("direccion");
				correo = result.getString("correo");
				telefono = result.getString("telefono");
				afiliador = obtenerEmpleadoById(cx, result.getInt("id_afiliador"));
				Empleado empleado = new Empleado(id, nivel_empleado, fecha_nacimiento, nombres, apellidos, direccion, correo, telefono, afiliador);
				listaAfiliados.add(empleado);
			}
			result.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return listaAfiliados;
	}

	public static Empleado obtenerEmpleadoByEmail(Connection cx, String email) {
		Empleado empleado = null;
		try {
			String query = "SELECT * FROM VIEW_EMPLEADO WHERE correo = '"+email+"'";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			NivelEmpleado nivel_empleado;
			Date fecha_nacimiento;
			String nombres;
			String apellidos;
			String direccion;
			String correo;
			String telefono;
			Empleado afiliador;
			while(result.next()){
				id = result.getInt("id");;
				nivel_empleado = NivelEmpleadoService.obtenerNivelEmpleadoById(cx, id);
				fecha_nacimiento = result.getDate("fecha_nacimiento");
				nombres = result.getString("nombres");
				apellidos = result.getString("apellidos");
				direccion = result.getString("direccion");
				correo = result.getString("correo");
				telefono = result.getString("telefono");
				afiliador = obtenerEmpleadoById(cx, result.getInt("id_afiliador"));
				empleado = new Empleado(id, nivel_empleado, fecha_nacimiento, nombres, apellidos, direccion, correo, telefono, afiliador);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return empleado;
	}

	public static Empleado afiliarEmpleado(Connection cx, String nombres, String apellidos, String direccion,
			String correo, String telefono, Date fechaNacimiento, String idAfiliador) {
		Empleado empleado = null;
		try {
			PreparedStatement ps = cx.prepareStatement("INSERT INTO VIEW_EMPLEADO (ID, ID_NIVEL, ID_AFILIADOR, FECHA_NACIMIENTO,"
					+ "NOMBRES,APELLIDOS,DIRECCION,TELEFONO,CORREO) "
					+ "VALUES(NULL, 1, ?, ?, ?, ?, ?, ?, ?)");

			ps.setInt(1, Integer.parseInt(idAfiliador));
			ps.setDate(2, fechaNacimiento);
			ps.setString(3, nombres);
			ps.setString(4, apellidos);
			ps.setString(5, direccion);
			ps.setString(6, telefono);
			ps.setString(7, correo);
			ps.executeUpdate();
			ps.close();

			empleado = obtenerEmpleadoByEmail(cx, correo);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"No se puede afiliar el empleado por la siguiente razon:\n"+
					"C�digo de error: "+e.getErrorCode()+"\n"
					+ "Mensaje: "+e.getMessage());
		}
		return empleado;
	}

}
