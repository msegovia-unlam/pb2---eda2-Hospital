package ar.edu.unlam.pb2.hospital;

public abstract class Empleado extends Persona{
	
	protected Integer id;
	protected String inicioDeActividad;
	protected Double sueldo;
	

	public Empleado(String nombre, String apellido, Integer dni, Integer id, String inicioDeActividad, Double sueldo) {
		super(nombre, apellido, dni);
		this.id = id;
		this.inicioDeActividad = inicioDeActividad;
		this.sueldo = sueldo;
	}


	public abstract Integer obtenerAntiguedad();
	
	
	public abstract Integer obtenerVacaciones();
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getInicioDeActividad() {
		return inicioDeActividad;
	}


	public void setInicioDeActividad(String inicioDeActividad) {
		this.inicioDeActividad = inicioDeActividad;
	}


	public Double getSueldo() {
		return sueldo;
	}


	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	
	

	
}
