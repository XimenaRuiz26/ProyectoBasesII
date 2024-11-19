package multinivel.model;

import java.sql.Date;

public class Envio {
	private int id;
	private Venta venta;
	private EstadoEnvio estado_envio;
	private MetodoEnvio metodo_envio;
	private float costo_envio;
	private Date fecha_envio;
	private Date fecha_entrega;
	private String direccion;
	/**
	 * @param id
	 * @param venta
	 * @param estado_envio
	 * @param metodo_envio
	 * @param costo_envio
	 * @param fecha_envio
	 * @param fecha_entrega
	 * @param direccion
	 */
	public Envio(int id, Venta venta, EstadoEnvio estado_envio, MetodoEnvio metodo_envio, float costo_envio,
			Date fecha_envio, Date fecha_entrega, String direccion) {
		super();
		this.id = id;
		this.venta = venta;
		this.estado_envio = estado_envio;
		this.metodo_envio = metodo_envio;
		this.costo_envio = costo_envio;
		this.fecha_envio = fecha_envio;
		this.fecha_entrega = fecha_entrega;
		this.direccion = direccion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public EstadoEnvio getEstado_envio() {
		return estado_envio;
	}
	public void setEstado_envio(EstadoEnvio estado_envio) {
		this.estado_envio = estado_envio;
	}
	public MetodoEnvio getMetodo_envio() {
		return metodo_envio;
	}
	public void setMetodo_envio(MetodoEnvio metodo_envio) {
		this.metodo_envio = metodo_envio;
	}
	public float getCosto_envio() {
		return costo_envio;
	}
	public void setCosto_envio(float costo_envio) {
		this.costo_envio = costo_envio;
	}
	public Date getFecha_envio() {
		return fecha_envio;
	}
	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
	}
	public Date getFecha_entrega() {
		return fecha_entrega;
	}
	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Envio [id=" + id + ", venta=" + venta + ", estado_envio=" + estado_envio + ", metodo_envio="
				+ metodo_envio + ", costo_envio=" + costo_envio + ", fecha_envio=" + fecha_envio + ", fecha_entrega="
				+ fecha_entrega + ", direccion=" + direccion + "]";
	}
}

