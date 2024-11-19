package multinivel.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import multinivel.dto.DetalleVentaDTO;
import multinivel.model.DetalleVenta;
import multinivel.model.Producto;
import multinivel.model.Venta;

import static multinivel.services.VentaService.obtenerVentaById;

public class DetalleVentaService {
	public static ArrayList<DetalleVenta> obtenerListaDetallesVenta(Connection cx){
		ArrayList<DetalleVenta> listaDetallesVenta = new ArrayList<>();
		try {
			String query = "SELECT * FROM DETALLEVENTA";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			Venta venta;
			Producto producto;
			int unidades;
			float subtotal;

			while(result.next()){
				venta = obtenerVentaById(cx, result.getInt("id_venta"));
				producto = ProductoService.obtenerProductoById(cx, result.getInt("id_producto"));
				unidades = result.getInt("unidades");
				subtotal = result.getFloat("subtotal");

				DetalleVenta detalleVenta = new DetalleVenta(venta, producto, unidades, subtotal);
				listaDetallesVenta.add(detalleVenta);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaDetallesVenta;
	}

	public static ArrayList<DetalleVenta> obtenerListaDetallesVentaByIdVenta(Connection cx, int idVenta){
		ArrayList<DetalleVenta> listaDetallesVenta = new ArrayList<>();
		try {
			String query = "SELECT * FROM DETALLEVENTA "
					+ "WHERE id_venta ="+idVenta;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			Venta venta;
			Producto producto;
			int unidades;
			float subtotal;

			while(result.next()){
				venta = obtenerVentaById(cx, result.getInt("id_venta"));
				producto = ProductoService.obtenerProductoById(cx, result.getInt("id_producto"));
				unidades = result.getInt("unidades");
				subtotal = result.getFloat("subtotal");

				DetalleVenta detalleVenta = new DetalleVenta(venta, producto, unidades, subtotal);
				listaDetallesVenta.add(detalleVenta);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaDetallesVenta;
	}

	public static ArrayList<DetalleVenta> obtenerListaDetallesVentaByIdProducto(Connection cx, int idProducto){
		ArrayList<DetalleVenta> listaDetallesVenta = new ArrayList<>();
		try {
			String query = "SELECT * FROM DETALLEVENTA "
					+ "WHERE id_producto ="+idProducto;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			Venta venta;
			Producto producto;
			int unidades;
			float subtotal;

			while(result.next()){
				venta = obtenerVentaById(cx, result.getInt("id_venta"));
				producto = ProductoService.obtenerProductoById(cx, result.getInt("id_producto"));
				unidades = result.getInt("unidades");
				subtotal = result.getFloat("subtotal");

				DetalleVenta detalleVenta = new DetalleVenta(venta, producto, unidades, subtotal);
				listaDetallesVenta.add(detalleVenta);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaDetallesVenta;
	}

	public static void agregarDetalleVenta(Connection cx, int id_venta, DetalleVentaDTO detalleVentaDTO) {
		try {
			PreparedStatement ps =
					cx.prepareStatement("INSERT INTO "
					+ "DETALLEVENTA (ID_VENTA, ID_PRODUCTO, UNIDADES, SUBTOTAL) "
					+ "VALUES(?, ?, ?, ?)");

			ps.setInt(1, id_venta);
			ps.setInt(2, detalleVentaDTO.getProducto().getId());
			ps.setInt(3, detalleVentaDTO.getUnidades());
			ps.setFloat(4, 0);

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
