package ar.edu.unlam.pb2.hospital;

public class Medico extends Empleado{
	
	private Integer matricula;
	private String especialidad;
	
	public Medico(String nombre, String apellido, Integer dni, Integer id, String inicioDeActividad, Double sueldo, Integer matricula, String especialidad) {
		super(nombre, apellido, dni, id, inicioDeActividad, sueldo);
		this.matricula = matricula;
		this.especialidad = especialidad;
	}

	
	//HASCODE / EQUALS 
	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	@Override
	public Integer obtenerAntiguedad() {
		// TODO (dia actual con dia ingreso)/365
		return null;
	}

	@Override
	public Integer obtenerVacaciones() {
		// TODO  (antiguedad/5)+ 6
		return null;
	}


	public Integer getMatricula() {
		return matricula;
	}


	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	
	
	
}
