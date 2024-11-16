package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.CategoriaProducto;
import model.Producto;

public class ProductoService {
	public static ArrayList<Producto> obtenerListaProductos(Connection cx){
		ArrayList<Producto> listaProductos = new ArrayList<>();
		try {
			String query = "SELECT * FROM Producto";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			CategoriaProducto categoria;
			int unidades_disponibles;
			float precio_unitario;
			String nombre;
			String descripcion;
			String fabricante;

			while(result.next()){
				id = result.getInt("id");
				categoria = CategoriaProductoService.obtenerCategoriaById(cx, result.getInt("id_categoria"));
				unidades_disponibles = result.getInt("unidades_disponibles");
				precio_unitario = result.getFloat("precio_unitario");
				nombre = result.getString("nombre");
				descripcion = result.getString("descripcion");
				fabricante = result.getString("fabricante");
				Producto producto = new Producto(id, categoria, unidades_disponibles, precio_unitario, nombre, descripcion, fabricante);
				listaProductos.add(producto);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaProductos;
	}

	public static Producto obtenerProductoById(Connection cx, int idBuscar){
		Producto producto = null;
		try {
			String query = "SELECT * FROM Producto WHERE id = "+idBuscar;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			CategoriaProducto categoria;
			int unidades_disponibles;
			float precio_unitario;
			String nombre;
			String descripcion;
			String fabricante;

			while(result.next()){
				id = result.getInt("id");
				categoria = CategoriaProductoService.obtenerCategoriaById(cx, result.getInt("id_categoria"));
				unidades_disponibles = result.getInt("unidades_disponibles");
				precio_unitario = result.getFloat("precio_unitario");
				nombre = result.getString("nombre");
				descripcion = result.getString("descripcion");
				fabricante = result.getString("fabricante");

				producto = new Producto(id, categoria, unidades_disponibles, precio_unitario, nombre, descripcion, fabricante);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return producto;
	}

	public static void eliminarProductoById(Connection cx, int idEliminar) {
		try {
			Statement statement;
			statement = cx.createStatement();
			statement.executeQuery("DELETE FROM PRODUCTO WHERE ID = "+idEliminar);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void agregarProducto(Connection cx, int idCategoria, int unidadesDisponibles, float precioUnitario, String sNombre,
			String sDescripcion, String sFabricante) {
		try {
			PreparedStatement ps = cx.prepareStatement("INSERT INTO PRODUCTO VALUES(NULL, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, sNombre);
			ps.setString(2,sDescripcion);
			ps.setFloat(3,precioUnitario);
			ps.setString(4, sFabricante);
			ps.setInt(5,unidadesDisponibles);
			ps.setInt(6,idCategoria);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void actualizarProducto(Connection cx, int idProductoActualizar, int idCategoria, int unidadesDisponibles,
			float precioUnitario, String sNombre, String sDescripcion, String sFabricante) {
		try {
			PreparedStatement ps = cx.prepareStatement("UPDATE PRODUCTO SET nombre = ?, descripcion = ?, "
					+ "precio_unitario = ?, fabricante = ?, unidades_disponibles = ?, id_categoria = ? WHERE id = "+idProductoActualizar);

			ps.setString(1, sNombre);
			ps.setString(2,sDescripcion);
			ps.setFloat(3,precioUnitario);
			ps.setString(4, sFabricante);
			ps.setInt(5,unidadesDisponibles);
			ps.setInt(6,idCategoria);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
