package multinivel.model;

public class DetalleVenta {
	private Venta venta;
	private Producto producto;
	private int unidades;
	private float subtotal;
	/**
	 * @param venta
	 * @param producto
	 * @param unidades
	 * @param subtotal
	 */
	public DetalleVenta(Venta venta, Producto producto, int unidades, float subtotal) {
		super();
		this.venta = venta;
		this.producto = producto;
		this.unidades = unidades;
		this.subtotal = subtotal;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "DetalleVenta [venta=" + venta + ", producto=" + producto + ", unidades=" + unidades + ", subtotal="
				+ subtotal + "]";
	}
}
