package ar.edu.unlam.pb2.hospital;

import java.util.HashSet;

public class Especialidad {

	private Integer id;
	private String nombre;
	private HashSet<Medico> medicos;
	
	
	public Especialidad(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.medicos = new HashSet<>();
	}


	public HashSet<Medico> obtenerListaDeProfesionales(){
		return medicos;
	}
	
	//Por id
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
		Especialidad other = (Especialidad) obj;
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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setMedicos(HashSet<Medico> medicos) {
		this.medicos = medicos;
	}
	
	
	
	
	
	
	
}
