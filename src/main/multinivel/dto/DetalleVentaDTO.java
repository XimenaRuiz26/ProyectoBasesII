package multinivel.dto;

import multinivel.model.Producto;

public class DetalleVentaDTO {
	private Producto producto;
	private int unidades;
	private float subtotal;

	public DetalleVentaDTO(Producto producto, int unidades, float subtotal) {
		super();
		this.producto = producto;
		this.unidades = unidades;
		this.subtotal = subtotal;
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

}
