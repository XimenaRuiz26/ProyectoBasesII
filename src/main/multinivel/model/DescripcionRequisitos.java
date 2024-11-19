package multinivel.model;

public class DescripcionRequisitos {
	private int id_nivel;
	private String descripcion;

	/**
	 * @param idNivel
	 * @param descripcion
	 */
	public DescripcionRequisitos(int idNivel, String descripcion) {
		super();
		this.id_nivel = idNivel;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdNivel() {
		return id_nivel;
	}

	public void setIdNivel(int idNivel) {
		this.id_nivel = idNivel;
	}

	@Override
	public String toString() {
		return "DescripcionRequisitos [descripcion=" + descripcion + "]";
	}
}
