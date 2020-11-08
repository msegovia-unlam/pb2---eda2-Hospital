package ar.edu.unlam.pb2.hospital;

public class ConsultaSinTurno {

	private Integer id;
	private String fecha;
	private Paciente paciente;
	private Medico medico;
	private Especialidad especialidad;
	private Administrativo administrativo;
	private String observacion;
	
	
	public ConsultaSinTurno(Integer id, String fecha, Paciente paciente, Medico medico, Especialidad especialidad, Administrativo administrativo, String observacion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.paciente = paciente;
		this.medico = medico;
		this.especialidad = especialidad;
		this.administrativo = administrativo;
		this.observacion = observacion;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public Especialidad getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}


	public Administrativo getAdministrativo() {
		return administrativo;
	}


	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	//por id
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
		ConsultaSinTurno other = (ConsultaSinTurno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
		
}
