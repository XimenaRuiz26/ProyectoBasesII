package multinivel.dto;

import java.sql.Date;

import multinivel.model.Empleado;

public class EmpleadoDTO {
	private Empleado empleado;
	private int id;
	private String nivel_empleado;
	private Date fecha_nacimiento;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String correo;
	private String telefono;
	private int afiliador;

	public EmpleadoDTO(Empleado empleado) {
		super();
		this.empleado = empleado;
		this.id = empleado.getId();
		this.nivel_empleado = empleado.getNivel_empleado().getNombre();
		this.fecha_nacimiento = empleado.getFecha_nacimiento();
		this.nombres = empleado.getNombres();
		this.apellidos = empleado.getApellidos();
		this.direccion = empleado.getDireccion();
		this.correo = empleado.getCorreo();
		this.telefono = empleado.getTelefono();
		if (empleado.getAfiliador()!=null) {
			this.afiliador = empleado.getAfiliador().getId();
		}else{
			this.afiliador = -1;
		}
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNivel_empleado() {
		return nivel_empleado;
	}

	public void setNivel_empleado(String nivel_empleado) {
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

	public int getAfiliador() {
		return afiliador;
	}

	public void setAfiliador(int afiliador) {
		this.afiliador = afiliador;
	}

}
