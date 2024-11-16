package model;

public class MetodoPago {
	private int id;
	private String nombre;
	/**
	 * @param id
	 * @param nombre
	 */
	public MetodoPago(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
	@Override
	public String toString() {
		return "MetodoPago [id=" + id + ", nombre=" + nombre + "]";
	}
}
