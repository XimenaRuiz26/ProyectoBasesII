package multinivel.model;

import java.sql.Date;

public class Cliente {
	private int id;
	private Date fecha_nacimiento;
	private String telefono;
	private String correo;
	private String nombres;
	private String apellidos;
	private String direccion;
	/**
	 * @param id
	 * @param fecha_nacimiento
	 * @param telefono
	 * @param correo
	 * @param nombres
	 * @param apellidos
	 * @param direccion
	 */
	public Cliente(int id, Date fecha_nacimiento, String telefono, String correo, String nombres, String apellidos,
			String direccion) {
		super();
		this.id = id;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.correo = correo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", correo="
				+ correo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + "]";
	}
}
