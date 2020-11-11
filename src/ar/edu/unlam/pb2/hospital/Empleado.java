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
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


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
