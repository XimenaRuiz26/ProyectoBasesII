package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Envio;
import model.EstadoEnvio;
import model.MetodoEnvio;
import model.Venta;

public class EnvioService {
	public static ArrayList<Envio> obtenerListaEnvios(Connection cx){
		ArrayList<Envio> listaEnvios = new ArrayList<>();
		try {
			String query = "SELECT * FROM ENVIO";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			Venta venta;
			EstadoEnvio estado_envio;
			MetodoEnvio metodo_envio;
			float costo_envio;
			Date fecha_envio;
			Date fecha_entrega;
			String direccion;

			while(result.next()){
				id = result.getInt("id");
				venta = VentaService.obtenerVentaById(cx, result.getInt("id_venta"));
				estado_envio = EstadoEnvioService.obtenerEstadoEnvioById(cx, result.getInt("id_estado"));
				metodo_envio = MetodoEnvioService.obtenerMetodoEnvioById(cx, result.getInt("id_metodo"));
				costo_envio = result.getFloat("costo_envio");
				fecha_envio = result.getDate("fecha_envio");
				fecha_entrega = result.getDate("fecha_entrega");
				direccion = result.getString("direccion");

				Envio envio = new Envio(id, venta, estado_envio, metodo_envio, costo_envio,
						fecha_envio, fecha_entrega, direccion);
				listaEnvios.add(envio);
			}
			result.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return listaEnvios;
	}

	public static Envio obtenerVentaById(Connection cx, int idBuscar){
		Envio envio = null;
		try {
			String query = "SELECT * FROM ENVIO";
		    Statement statement;
			statement = cx.createStatement();
			ResultSet result = statement.executeQuery(query);

			int id;
			Venta venta;
			EstadoEnvio estado_envio;
			MetodoEnvio metodo_envio;
			float costo_envio;
			Date fecha_envio;
			Date fecha_entrega;
			String direccion;

			while(result.next()){
				id = result.getInt("id");
				venta = VentaService.obtenerVentaById(cx, result.getInt("id_venta"));
				estado_envio = EstadoEnvioService.obtenerEstadoEnvioById(cx, result.getInt("id_estado"));
				metodo_envio = MetodoEnvioService.obtenerMetodoEnvioById(cx, result.getInt("id_metodo"));
				costo_envio = result.getFloat("costo_envio");
				fecha_envio = result.getDate("fecha_envio");
				fecha_entrega = result.getDate("fecha_entrega");
				direccion = result.getString("direccion");

				envio = new Envio(id, venta, estado_envio, metodo_envio, costo_envio, fecha_envio, fecha_entrega, direccion);
			}
			result.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return envio;
	}
}
