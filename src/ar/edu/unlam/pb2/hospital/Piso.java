package ar.edu.unlam.pb2.hospital;

import java.util.HashSet;

public class Piso {

	private Integer id;
	private Integer numero;
	private HashSet<Integer> listaDeHabitaciones;
	
	
	public Piso(Integer id, Integer numero) {
		super();
		this.id = id;
		this.numero = numero;
		this.listaDeHabitaciones = listaDeHabitaciones;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public HashSet<Integer> getListaDeHabitaciones() {
		return listaDeHabitaciones;
	}


	public void setListaDeHabitaciones(HashSet<Integer> listaDeHabitaciones) {
		this.listaDeHabitaciones = listaDeHabitaciones;
	}
	
	
	
	
	
}
