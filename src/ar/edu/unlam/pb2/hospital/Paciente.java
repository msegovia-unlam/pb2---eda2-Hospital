package ar.edu.unlam.pb2.hospital;

import java.util.HashSet;

public class Paciente extends Persona{
	
	private Integer id;
	private String historiaClinica;
	private Double peso;
	private Double altura;
	private HashSet<Turno> turnos;
	
	
	public Paciente(String nombre, String apellido, Integer dni, Integer id, String historiaClinica, Double peso, Double altura) {
		super(nombre, apellido, dni);
		this.id = id;
		this.historiaClinica = historiaClinica;
		this.peso = peso;
		this.altura = altura;
		this.turnos= new HashSet<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Internacion)
		{
			Paciente otro=(Paciente)obj;
			if(this.id==otro.id)
			{
				return true;
			}
			else
			{
				return false;
			}	
		}
		else
		{
			return false;
		}
	}

	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getHistoriaClinica() {
		return historiaClinica;
	}


	public void setHistoriaClinica(String historiaClinica) {
		this.historiaClinica = historiaClinica;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public Double getAltura() {
		return altura;
	}


	public void setAltura(Double altura) {
		this.altura = altura;
	}


	public HashSet<Turno> getTurnos() {
		return turnos;
	}


	public void setTurnos(HashSet<Turno> turnos) {
		this.turnos = turnos;
	}


	
	
	
	
	
	
	
	
	
}
