package multinivel.model;

import java.sql.Date;

public class Empleado {
	private int id;
	private NivelEmpleado nivel_empleado;
	private Date fecha_nacimiento;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String correo;
	private String telefono;
	private Empleado afiliador;
	/**
	 * @param id
	 * @param nivel_empleado
	 * @param fecha_nacimiento
	 * @param nombres
	 * @param apellidos
	 * @param direccion
	 * @param correo
	 * @param telefono
	 * @param afiliador
	 */
	public Empleado(int id, NivelEmpleado nivel_empleado, Date fecha_nacimiento, String nombres, String apellidos,
			String direccion, String correo, String telefono, Empleado afiliador) {
		super();
		this.id = id;
		this.nivel_empleado = nivel_empleado;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.afiliador = afiliador;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public NivelEmpleado getNivel_empleado() {
		return nivel_empleado;
	}
	public void setNivel_empleado(NivelEmpleado nivel_empleado) {
		this.nivel_empleado = nivel_empleado;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Empleado getAfiliador() {
		return afiliador;
	}
	public void setAfiliador(Empleado afiliador) {
		this.afiliador = afiliador;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nivel_empleado=" + nivel_empleado + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", correo="
				+ correo + ", telefono=" + telefono + ", afiliador=" + afiliador + "]";
	}
}
