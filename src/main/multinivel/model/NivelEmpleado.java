package multinivel.model;

public class NivelEmpleado {
	private int id;
	private String nombre;
	private DescripcionRequisitos descripcionRequisitos;
	private DescripcionBeneficios descripcionBeneficios;
	/**
	 * @param id
	 * @param nombre
	 * @param descripcionRequisitos
	 * @param descripcionBeneficios
	 */
	public NivelEmpleado(int id, String nombre, DescripcionRequisitos descripcionRequisitos,
			DescripcionBeneficios descripcionBeneficios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcionRequisitos = descripcionRequisitos;
		this.descripcionBeneficios = descripcionBeneficios;
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
	public DescripcionRequisitos getDescripcionRequisitos() {
		return descripcionRequisitos;
	}
	public void setDescripcionRequisitos(DescripcionRequisitos descripcionRequisitos) {
		this.descripcionRequisitos = descripcionRequisitos;
	}
	public DescripcionBeneficios getDescripcionBeneficios() {
		return descripcionBeneficios;
	}
	public void setDescripcionBeneficios(DescripcionBeneficios descripcionBeneficios) {
		this.descripcionBeneficios = descripcionBeneficios;
	}
	@Override
	public String toString() {
		return "NivelEmpleado [id=" + id + ", nombre=" + nombre + ", descripcionRequisitos=" + descripcionRequisitos
				+ ", descripcionBeneficios=" + descripcionBeneficios + "]";
	}
}
