package multinivel.dto;
import multinivel.model.Producto;

public class ProductoDTO {
	private Producto producto;
	private int id;
	private String categoria;
	private int unidades_disponibles;
	private float precio_unitario;
	private String nombre;
	private String descripcion;
	private String fabricante;

	public ProductoDTO(Producto producto) {
		super();
		this.producto = producto;
		id = producto.getId();
		categoria = producto.getCategoria().getNombre();
		unidades_disponibles = producto.getUnidades_disponibles();
		precio_unitario = producto.getPrecio_unitario();
		nombre = producto.getNombre();
		descripcion = producto.getDescripcion();
		fabricante = producto.getFabricante();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getUnidades_disponibles() {
		return unidades_disponibles;
	}

	public void setUnidades_disponibles(int unidades_disponibles) {
		this.unidades_disponibles = unidades_disponibles;
	}

	public float getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(float precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "ProductoDTO [producto=" + producto + ", id=" + id + ", categoria=" + categoria
				+ ", unidades_disponibles=" + unidades_disponibles + ", precio_unitario=" + precio_unitario
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + ", fabricante=" + fabricante + "]";
	}
}
