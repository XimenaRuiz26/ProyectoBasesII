package multinivel.model;

public class EstadoEnvio {
	private int id;
	private String estado;
	/**
	 * @param id
	 * @param estado
	 */
	public EstadoEnvio(int id, String estado) {
		super();
		this.id = id;
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "EstadoEnvio [id=" + id + ", estado=" + estado + "]";
	}
}
