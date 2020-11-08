package ar.edu.unlam.pb2.hospital;

public class Turno {

	private Integer id;
	private String dia;
	private Paciente paciente; //hay que agregar el turno en la lista de turnos del paciente en cuestion. Se hace desde el sistema hospital
	private Medico medico;
	private Especialidad especialidad;
	private Administrativo administrativo;
	
	
	public Turno(Integer id, String dia, Paciente paciente, Medico medico, Especialidad especialidad, Administrativo administrativo) {
		super();
		this.id = id;
		this.dia = dia;
		this.paciente = paciente;
		this.medico = medico;
		this.especialidad = especialidad;
		this.administrativo = administrativo;
	}

	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
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
		Turno other = (Turno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
