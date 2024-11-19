package multinivel.model;

public class Producto {
	private int id;
	private CategoriaProducto categoria;
	private int unidades_disponibles;
	private float precio_unitario;
	private String nombre;
	private String descripcion;
	private String fabricante;
	/**
	 * @param id
	 * @param categoria
	 * @param unidades_disponibles
	 * @param precio_unitario
	 * @param nombre
	 * @param descripcion
	 * @param fabricante
	 */
	public Producto(int id, CategoriaProducto categoria, int unidades_disponibles, float precio_unitario, String nombre,
			String descripcion, String fabricante) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.unidades_disponibles = unidades_disponibles;
		this.precio_unitario = precio_unitario;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fabricante = fabricante;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CategoriaProducto getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaProducto categoria) {
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
		return "Producto [id=" + id + ", categoria=" + categoria + ", unidades_disponibles=" + unidades_disponibles
				+ ", precio_unitario=" + precio_unitario + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fabricante=" + fabricante + "]";
	}
}
