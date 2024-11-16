package services;

import model.CategoriaProducto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class CategoriaProductoService {
	public static ArrayList<CategoriaProducto> obtenerListaCategoriasProducto(Connection cx){
		ArrayList<CategoriaProducto> listaCategoriasProducto = new ArrayList<>();
		try {
			String query = "SELECT * FROM CATEGORIAPRODUCTO";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			String nombre;
			String descripcion;
			while(result.next()){
				id = result.getInt("id");
				nombre = result.getString("nombre");
				descripcion = result.getString("descripcion");
				CategoriaProducto categoriaProducto = new CategoriaProducto(id, nombre, descripcion);
				listaCategoriasProducto.add(categoriaProducto);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listaCategoriasProducto;
	}

	public static CategoriaProducto obtenerCategoriaById(Connection cx, int idBuscar){
		CategoriaProducto categoriaProducto = null;
		try {
			String query = "SELECT * FROM CATEGORIAPRODUCTO WHERE id = "+idBuscar;
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			String nombre;
			String descripcion;
			while(result.next()){
				id = result.getInt("id");
				nombre = result.getString("nombre");
				descripcion = result.getString("descripcion");
				categoriaProducto = new CategoriaProducto(id, nombre, descripcion);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return categoriaProducto;
	}
}
