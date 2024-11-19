package multinivel.model;

import java.sql.Date;

public class Venta {
	private int id;
	private MetodoPago metodo_pago;
	private EstadoVenta estado_venta;
	private Cliente cliente;
	private Empleado empleado;
	private float valor_venta;
	private Date fecha_venta;
	/**
	 * @param id
	 * @param metodo_pago
	 * @param estado_venta
	 * @param cliente
	 * @param empleado
	 * @param valor_venta
	 * @param fecha_venta
	 */
	public Venta(int id, MetodoPago metodo_pago, EstadoVenta estado_venta, Cliente cliente, Empleado empleado,
			float valor_venta, Date fecha_venta) {
		super();
		this.id = id;
		this.metodo_pago = metodo_pago;
		this.estado_venta = estado_venta;
		this.cliente = cliente;
		this.empleado = empleado;
		this.valor_venta = valor_venta;
		this.fecha_venta = fecha_venta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MetodoPago getMetodo_pago() {
		return metodo_pago;
	}
	public void setMetodo_pago(MetodoPago metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	public EstadoVenta getEstado_venta() {
		return estado_venta;
	}
	public void setEstado_venta(EstadoVenta estado_venta) {
		this.estado_venta = estado_venta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public float getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(float valor_venta) {
		this.valor_venta = valor_venta;
	}
	public Date getFecha_venta() {
		return fecha_venta;
	}
	public void setFecha_venta(Date fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
	@Override
	public String toString() {
		return "Venta [id=" + id + ", metodo_pago=" + metodo_pago + ", estado_venta=" + estado_venta + ", cliente="
				+ cliente + ", empleado=" + empleado + ", valor_venta=" + valor_venta + ", fecha_venta=" + fecha_venta
				+ "]";
	}
}
