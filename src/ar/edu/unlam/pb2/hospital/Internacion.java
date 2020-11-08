package ar.edu.unlam.pb2.hospital;

public class Internacion {

	private Integer id;
	private Paciente paciente;
	private Integer habitacion;
	private Piso piso;
	private String ingreso;	
	private String observacion;
	
	
	public Internacion(Integer id, Paciente paciente, Integer habitacion, Piso piso, String ingreso, String alta, String observacion) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.habitacion = habitacion;
		this.piso = piso;
		this.ingreso = ingreso;		
		this.observacion = observacion;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public Integer getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(Integer habitacion) {
		this.habitacion = habitacion;
	}


	public Piso getPiso() {
		return piso;
	}


	public void setPiso(Piso piso) {
		this.piso = piso;
	}


	public String getIngreso() {
		return ingreso;
	}


	public void setIngreso(String ingreso) {
		this.ingreso = ingreso;
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
		Internacion other = (Internacion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
