package multinivel.model;

public class DescripcionBeneficios {
	private int id_nivel;
	private String descripcion;

	public DescripcionBeneficios(int id_nivel, String descripcion) {
		super();
		this.id_nivel = id_nivel;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_nivel() {
		return id_nivel;
	}

	public void setId_nivel(int id_nivel) {
		this.id_nivel = id_nivel;
	}

	@Override
	public String toString() {
		return "DescripcionBeneficios [descripcion=" + descripcion + "]";
	}
}
