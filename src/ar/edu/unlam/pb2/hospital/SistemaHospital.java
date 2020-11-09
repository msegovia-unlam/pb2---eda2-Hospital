package ar.edu.unlam.pb2.hospital;

import java.util.HashSet;

public class SistemaHospital {

	private String nombre;
	private HashSet<Medico> medicos;
	private HashSet<Paciente> pacientes;
	private HashSet<Especialidad> especialidades;
	private HashSet<Piso> pisos;
	private HashSet<Turno> turnosAsignados;
	private HashSet<Administrativo> administrativos;
	private HashSet<Internacion> internacionesIngresadas;
	private HashSet<ConsultaSinTurno> consultasSinTurno;
	private HashSet<ConsultaConTurno> consultasConTurno;
	private Integer idTurno = 1;
	private Integer idConsultaSinTurno = 1;
	
	public SistemaHospital(String nombre) {
		this.nombre = nombre;
		this.medicos = new HashSet<>();
		this.pacientes = new HashSet<>();
		this.especialidades = new HashSet<>();
		this.pisos = new HashSet<>();
		this.turnosAsignados = new HashSet<>();
		this.administrativos = new HashSet<>();
		this.internacionesIngresadas = new HashSet<>();
		this.consultasSinTurno = new HashSet<>();
		this.consultasConTurno = new HashSet<>();
	}
	// FEDERICO
	public Boolean registrarMedico(Medico medico) {
		
		return null;
	}
	// ARIAN
	public Boolean registrarPaciente(Paciente paciente) {
		
		return null;
	}
	
	// SCARLET >>Agrega administrativos a la lista del hospital
	public Boolean registrarAdministrativo(Administrativo administrativo) {
		
		return this.administrativos.add(administrativo);
	}
	
	// FEDERICO
	public Boolean agregarEspecialidad(Especialidad especialidad) {
		
		return null;
	}
	// MARTIN
	public Boolean registrarPiso(Piso piso) {
		
		return null;
	}
	// ARIAN
	public Boolean registrarInternacion(Integer dni, Piso piso, Integer habitacion) {
		
		return null;
	}
	
	//MARTIN
	public Boolean registrarMedicoEnEspecialidad(Integer dniMedico, Integer idEspecialidad) {
		return null;
	}
	// FEDERICO
	public Medico buscarMedico(Integer idMedico) {
		return null;
	}
	// ARIAN
	public Paciente buscarPaciente(Integer idPaciente) {
		return null;
	}
	// FEDERICO
	public Especialidad buscarEspecialidad(Integer idEspecialidad) {
		return null;
	}
	
	//Scarlet >> Busca si existe un administrativo y lo retorna
	public Administrativo buscarAdministrativo(Integer idAdministrativo) {
		Administrativo adminBuscado = null;
		for(Administrativo administrativo : this.administrativos) {
			if(administrativo.getId().equals(idAdministrativo)) {
				adminBuscado = administrativo;
			}
		}
		return adminBuscado;
	}
		
	// Scarlet >>Busca si existe un turno y lo devuelve
	public Turno buscarTurno(Integer idTurno) {
		Turno turnoBuscado = null;
		for(Turno turno : this.turnosAsignados) {
			if(turno.getId().equals(idTurno)) {
				turnoBuscado = turno;
			}
		}
		return turnoBuscado;
	}
	
	// MARTIN
	public Piso buscarPiso(Integer idPiso) {
		return null;
	}
	// ARIAN
	public Internacion buscarInternacion(Integer idInternacion) {
		return null;
	}
	// ARIAN
	public Boolean darDeAltaAPaciente(Integer dni) {
		return null;
	}
	
	// Scarlet >>Valida la existencia de todos los objetos y asigna un turno al paciente.
	public Boolean asignarTurnoAPaciente(Integer idPaciente, Integer idEspecialidad, Integer idMedico, Integer idAdministrativo, String fecha) {
		Boolean asignacionExitosa = false;
		
		Paciente pacienteBuscado = buscarPaciente(idPaciente);
		Especialidad especialidadBuscada = buscarEspecialidad(idEspecialidad);
		Medico medicoBuscado = buscarMedico(idMedico);
		Administrativo adminBuscado = buscarAdministrativo(idAdministrativo);
		if(adminBuscado!=null && pacienteBuscado!=null && especialidadBuscada!=null) {
			if(medicoBuscado!=null && especialidadBuscada.obtenerListaDeProfesionales().contains(medicoBuscado)) {
				Turno nuevoTurno = new Turno(idTurno, fecha, pacienteBuscado, medicoBuscado, especialidadBuscada, adminBuscado);
				idTurno++;
				
				this.turnosAsignados.add(nuevoTurno);
				pacienteBuscado.getTurnos().add(nuevoTurno);
				
				asignacionExitosa = true;
			}
		}
		return asignacionExitosa;
	}
	
	// Scarlet
	public Boolean cancelarTurno(Integer idTurno) {
		
		return null;
	}
	// Scarlet
	public Boolean cambiarTurno(Integer idTurno, String dia) {
		
		return null;
	}
	// FEDERICO
	public Boolean darDeBajaUnMedico(Integer dniMedico) {
		
		return null;
	}
	// FEDERICO
	public Boolean cambiarDeEspecialidadAUnMedico(Integer dniMedico, Integer idEspecialidad) {
		
		return null;
	}
	
	/* TODO	REVISAR Scarlet */
	public Boolean consultarDisponibilidadDeUnTurno(Integer idTurno) {
		
		return null;
	}
	
	// MARTIN
	public Boolean consultarDisponibilidadDeUnaHabitacion(Integer numeroPiso, Integer habitacion) {
		
		return null;
	}
	
	/* TODO	PRESENTISMO MARTIN*/
	public Boolean crearNuevaConsultaConTurno(Integer idTurnoAsignado) {
		
		return null;
	}
	// SCARLET
	public Boolean crearNuevaConsultaSinTurno(Paciente paciente, Especialidad especialidad, Integer idMedico) {
		
		return null;
	}
	// ARIAN
	public Integer obtenerCantidadDePacientesInternados() {
		
		return null;
	}
	// FEDERICO
	public Integer obtenerCantidadDeConsultasPorEspecialidad(Integer idEspecialidad) {
		
		return null;
	}
	// Martin
	public HashSet<String> obtenerListaDeHabitacionesOcupadas(Integer piso){
			
		return null;
	}
	// Martin
	public Integer obtenerCantidadDeHabitacionesOcupadas() {
		
		return null;
	}
	// MARTIN
	public Integer obtenerCantidadDePersonasQueNoAsistieronAlTurno() {
		
		return null;
	}
	// Scarlet
	public HashSet<Paciente> obtenerListaDePacientesQueNoAsistieronAlTurno(){
		
		return null;
	}
	// Federico
	public HashSet<Medico> obtenerListaDeMedicosDeUnaEspecialidad(Integer idEspecialidad){
		
		return null;
	}
	// Arian
	public HashSet<Turno> obtenerListaDeTurnosDeUnPaciente(Integer dni){
		
		return null;
	}
	
	
	
	
	
}
