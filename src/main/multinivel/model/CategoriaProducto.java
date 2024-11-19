package multinivel.model;

public class CategoriaProducto {
	private int id;
	private String nombre;
	private String descripcion;

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 */
	public CategoriaProducto(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CategoriaProducto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
}
