package ar.edu.unlam.pb2.hospital;

import java.util.HashSet;

public class SistemaHospital {

	private String nombre;
	private HashSet<Medico> medicos;
	protected HashSet<Paciente> pacientes;
	private HashSet<Especialidad> especialidades;
	private HashSet<Piso> pisos;
	private HashSet<Turno> turnosAsignados;
	private HashSet<Administrativo> administrativos;
	protected HashSet<Internacion> internacionesIngresadas;
	private HashSet<ConsultaSinTurno> consultasSinTurno;
	private HashSet<ConsultaConTurno> consultasConTurno;
	private Integer idTurno = 1;
	private Integer idConsultaSinTurno = 1;
	private Integer idconsultaCT =1;
	
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
		
		return this.medicos.add(medico);
	
	}
	// ARIAN
	public Boolean registrarPaciente(Paciente paciente) 
	
	{
		return this.pacientes.add(paciente);
	
	
	// SCARLET >>> Agrega administrativos a la lista del hospital
	public Boolean registrarAdministrativo(Administrativo administrativo) {
		
		return this.administrativos.add(administrativo);
	}
	
	// FEDERICO
	public Boolean agregarEspecialidad(Especialidad especialidad) {
		
		return this.especialidades.add(especialidad);
	}
	// MARTIN
	public Boolean registrarPiso(Piso piso) {		
		return this.pisos.add(piso);		
		
	}
	// ARIAN

	public Boolean registrarInternacion(Internacion idInternacion) 
	{
	return this.internacionesIngresadas.add(idInternacion);
	}
	
	//MARTIN
	public Boolean registrarMedicoEnEspecialidad(Integer idMedico, Integer idEspecialidad) {
		Medico medicoBuscado = buscarMedico(idMedico);
		medicoBuscado.getEspecialidad();
		
		Especialidad espBuscada = buscarEspecialidad(idEspecialidad);
		if (espBuscada.equals(medicoBuscado.getEspecialidad())) {
			espBuscada.obtenerListaDeProfesionales().add(medicoBuscado);
			return true;
		}
		return false;
	}
	// FEDERICO
	public Medico buscarMedico(Integer idMedico) {
		
		Medico medicoEncontrado = null;
		
		for(Medico medico: medicos) {
			if(medico.getId().equals(idMedico)) {
			  medicoEncontrado = medico;
			}
		}
		return medicoEncontrado;
	}
	// ARIAN
	public Paciente buscarPaciente (Integer idPaciente)
	{
		for (Paciente paciente: this.pacientes) 
		{
			if(paciente.getId().equals(idPaciente))
				return paciente;
		}
		return null;
	}
	// FEDERICO
	public Especialidad buscarEspecialidad(Integer idEspecialidad) {
		
		Especialidad especialidadEncontrada = null;
		
		for(Especialidad especialidad: especialidades) {
			if(especialidad.getId().equals(idEspecialidad)) {
				especialidadEncontrada = especialidad;
			}
		}
		return especialidadEncontrada;
	}
	
	//Scarlet >>> Busca si existe un administrativo y lo retorna
	public Administrativo buscarAdministrativo(Integer idAdministrativo) {
		Administrativo adminBuscado = null;
		for(Administrativo administrativo : this.administrativos) {
			if(administrativo.getId().equals(idAdministrativo)) {
				adminBuscado = administrativo;
			}
		}
		return adminBuscado;
	}
		
	// Scarlet >>> Busca si existe un turno y lo devuelve
	public Turno buscarTurno(Integer idTurno) {
		Turno turnoBuscado = null;
		for(Turno turno : this.turnosAsignados) {
			if(turno.getId().equals(idTurno)) {
				turnoBuscado = turno;
			}
		}
		return turnoBuscado;
	}
	
	//Scarlet >> Busca un turno a traves del id del paciente
	public Turno buscarTurnoPorIDPaciente(Integer idPaciente) {
		Turno turnoBuscado = null;
		for(Turno turno : this.turnosAsignados) {
			if(turno.getPaciente().getId().equals(idPaciente)) {
				turnoBuscado = turno;
			}
		}
		return turnoBuscado;
		
	}
	//Scarlet
	public Turno buscarTurnoDeUnPaciente(Integer idPaciente, String fecha) {
		Turno turnoBuscado = null;
		
		Paciente pacienteBuscado = buscarPaciente(idPaciente);
		
		if(pacienteBuscado!=null) {
			for(Turno turno : pacienteBuscado.getTurnos()) {
				if(turno.getDia().equals(fecha)) {
					turnoBuscado = turno;
				}
			}
		}
		return turnoBuscado;
	}
	
	// MARTIN
	public Piso buscarPiso(Integer idPiso) {
		
		for (Piso piso : this.pisos) {
		if	(piso.getId().equals(idPiso))
			return piso;
		}
		return null;		
	}
	// ARIAN
	public Internacion buscarInternacion(Integer idInternacion)
	{
		for (Internacion internacion: this.internacionesIngresadas) 
		{
			if(internacion.getId().equals(idInternacion))
				return internacion;
		}
		return null;
	}
	
	// ARIAN
	public Boolean darDeAltaAPaciente(Integer idInternacion) 
	{
		 return internacionesIngresadas.remove(idInternacion);
		
	}
	
	// Scarlet >>> Valida la existencia de todos los objetos y asigna un turno al paciente.
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
	
	// Scarlet >>Busca un turno por su ID y si existe lo remueve de la lista
	public Boolean cancelarTurno(Integer idTurno) {
		Boolean cancelacionExitosa = false;
		
		Turno turnoBuscado = buscarTurno(idTurno);
		if(turnoBuscado!=null) {
			cancelacionExitosa = this.turnosAsignados.remove(turnoBuscado); //Deberia remover de la lista de turnos del paciente tmb!! VER!!
			turnoBuscado.getPaciente().getTurnos().remove(turnoBuscado);
		}
		return cancelacionExitosa;
	}
	
	/*Scarlet >>Valida la existencia del turno por su ID y a continuacion modifica la fecha del mismo tanto en la lista
	de turnosAsignados del Hospital como en la lista de turnos del paciente*/
	public Boolean cambiarTurno(Integer idTurno, String nuevaFecha) {
		Boolean modificacionExitosa = false;
		
		Turno turnoBuscado = buscarTurno(idTurno);
		if(turnoBuscado!=null) {
			turnoBuscado.setDia(nuevaFecha);
			modificarTurnoEnLaListaDeTurnosDelPaciente(idTurno, nuevaFecha);
			
			modificacionExitosa = true;
		}
		return modificacionExitosa;
	}
	/*Scarlet >>Modifica la fecha del turno en la lista de turnos del paciente: primero se obtiene dicha lista
	y despues se le cambia la fecha por la nueva fecha. Es un metodo privado ya que solo se accede a el cuando se cambia un turno*/
	private Boolean modificarTurnoEnLaListaDeTurnosDelPaciente(Integer idTurno, String nuevaFecha){
		Boolean accionExitosa = false;
		HashSet<Turno> listaDeTurnosDelPaciente;
		
		Turno turnoBuscado = buscarTurno(idTurno);
		if(turnoBuscado!=null) {
			listaDeTurnosDelPaciente = turnoBuscado.getPaciente().getTurnos();
			for(Turno turno : listaDeTurnosDelPaciente) {
				if(turno.equals(turnoBuscado)) {
					turno.setDia(nuevaFecha);
				}
			}
			accionExitosa = true;
		}
		return accionExitosa;
	}
	
	/*TODO ECHO FEDERICO*/

	public Boolean darDeBajaUnMedico(Integer idMedico) {
		
		for(Medico medico: medicos) {
			if(medico.getId().equals(idMedico)) {
				medicos.remove(medico);
				
				return true;
			}
		}
		return false;
	}
	// FEDERICO
	public Boolean cambiarDeEspecialidadAUnMedico(Integer idMedico,  String especialidad) {
		
		for(Medico medico : medicos) {
			if(medico.getId().equals(idMedico)) {
				medico.setEspecialidad(especialidad);
				return true;
			}
		}
		return false;
	}
	
	//Scarlet >>Verifica si el turno ya fue asignado, si no fue asignado el mismo se encuentra disponible -- devuelve True
	public Boolean consultarDisponibilidadDeUnTurno(Integer idTurno) {
		Boolean turnoDisponible = false;
		if(buscarTurno(idTurno)==null) {
			turnoDisponible = true;
		}
		return turnoDisponible;
	}
	
	// MARTIN
	public Boolean consultarDisponibilidadDeUnaHabitacion(Integer numeroPiso, Integer habitacion) {
		
		for(Internacion internacion : this.internacionesIngresadas) {
			if (internacion.getPiso().getNumero().equals(numeroPiso) && internacion.getHabitacion().equals(habitacion))
				return false;
		}			
		return true;
	}
	
	/* TODO	PRESENTISMO MARTIN*/
	public Boolean crearNuevaConsultaConTurno(Integer idTurnoAsignado, String fechaCT, String observaciones, Administrativo administrativo) {
		
		Turno turno = buscarTurno(idTurnoAsignado);
		
		if(turno != null) {
			ConsultaConTurno consultaCT = new ConsultaConTurno(idconsultaCT, fechaCT, turno, administrativo, observaciones);
			consultasConTurno.add(consultaCT);
			idconsultaCT++;
			
			return true;
		}
		return false;		
	}
	
	/* SCARLET >> Valida la existencia de los diferentes objetos y ademas valida que el medico atienda en la especialidad especificada.
		Si todo es valido, se crea la consulta sin turno.*/
	public Boolean crearNuevaConsultaSinTurno(Integer idPaciente, Integer idEspecialidad, Integer idMedico, Integer idAdministrativo, String fecha, String observacion) {
		Boolean creacionExitosa = false;
		
		Paciente pacienteBuscado = buscarPaciente(idPaciente);
		Especialidad especialidadBuscada = buscarEspecialidad(idEspecialidad);
		Medico medicoBuscado = buscarMedico(idMedico);
		Administrativo adminBuscado = buscarAdministrativo(idAdministrativo);
		
		if(pacienteBuscado!=null && adminBuscado!=null && especialidadBuscada!=null) {
			if(medicoBuscado!=null && especialidadBuscada.obtenerListaDeProfesionales().contains(medicoBuscado)) {
					ConsultaSinTurno nuevaConsulta = new ConsultaSinTurno(idConsultaSinTurno, fecha, pacienteBuscado, medicoBuscado, especialidadBuscada, adminBuscado, observacion); 
					idConsultaSinTurno++;
					creacionExitosa = true;
				}
			}
		return creacionExitosa;
	}
	
	// ARIAN
	public Integer obtenerCantidadDePacientesInternados() 
	{
		return internacionesIngresadas.size();
		
	}
	/*TODO ECHO FEDERICO*/
	public Integer obtenerCantidadDeConsultasPorEspecialidad(Integer idEspecialidad) {
		
		Integer cantidadConsultasPorEspecialidad = 0;
		
		for(Turno turno: turnosAsignados) {
			if(turno.getEspecialidad().getId().equals(idEspecialidad)) {
				
				cantidadConsultasPorEspecialidad++;
			}
		}
		return cantidadConsultasPorEspecialidad;
	}

	// Martin
	public HashSet<Integer> obtenerListaDeHabitacionesOcupadas(Integer piso){
		HashSet<Integer> habOcupadas = new HashSet<Integer>();
		
		for(Internacion internacion : this.internacionesIngresadas) {
			habOcupadas.add(internacion.getHabitacion());
		}			
		return  habOcupadas;
		
	}
	// Martin
	public Integer obtenerCantidadDeHabitacionesOcupadas() {
		
		return internacionesIngresadas.size();
	}
	// MARTIN
	public Integer obtenerCantidadDePersonasQueNoAsistieronAlTurno() {
		Integer cantidadPersonas = 0;
		for (ConsultaConTurno cTurno : this.consultasConTurno) {			
			for (Turno turnAs : this.turnosAsignados) {
				if (!cTurno.getId().equals(turnAs.getId())) {
					cantidadPersonas++;
				}			
			}		
		}
		return cantidadPersonas;
	}
	
	/* Scarlet >>Compara los turnos que ya fueron asignados con las consultasConTurno (Esta consulta se genera cuando 
	un paciente que tenia un turno se presenta a la consulta). Entonces, si el turnoAsignado no coincide con ningun turno
	de una consulta el paciente de ese turnoAsignado no se presento aun */
	public HashSet<Paciente> obtenerListaDePacientesQueNoAsistieronAlTurno(){
		HashSet<Paciente> pacientesQueNOAsistieronAlTurno = new HashSet<>();
		for(Turno turno : this.turnosAsignados) {
			for(ConsultaConTurno consulta : this.consultasConTurno) {
				if(!turno.equals(consulta.getTurno())){
					pacientesQueNOAsistieronAlTurno.add(turno.getPaciente());
				}
			}
		}
		return pacientesQueNOAsistieronAlTurno;
	}
	
	// Federico
	public HashSet<Medico> obtenerListaDeMedicosDeUnaEspecialidad(Integer idEspecialidad){
		
		for(Especialidad especialidad: especialidades) {
			if(especialidad.getId().equals(idEspecialidad)) {
				especialidad.obtenerListaDeProfesionales();
			}
		}
		return null;
	}
	public HashSet<Turno> obtenerListaDeTurnosDeUnPaciente(Integer id)
	{
		HashSet<Turno> listaDeTurnosPorPaciente= new HashSet<>();
		for(Turno turnos : this.turnosAsignados)
		{
			if(turnos.getPaciente().getId().equals(id)) 
			{
				listaDeTurnosPorPaciente.add(turnos);
			}
		}
		return listaDeTurnosPorPaciente;
	}
	
	
	public HashSet<Administrativo> getAdministrativos() {
		return administrativos;
	}
	
	public void setAdministrativos(HashSet<Administrativo> administrativos) {
		this.administrativos = administrativos;
	}
	
	public HashSet<Turno> getTurnosAsignados() {
		return this.turnosAsignados;
	}
	
	public void setTurnosAsignados(HashSet<Turno> turnosAsignados) {
		this.turnosAsignados = turnosAsignados;
	}
	public HashSet<ConsultaSinTurno> getConsultasSinTurno() {
		return consultasSinTurno;
	}
	public void setConsultasSinTurno(HashSet<ConsultaSinTurno> consultasSinTurno) {
		this.consultasSinTurno = consultasSinTurno;
	}
	public HashSet<ConsultaConTurno> getconsultasConTurno() {
		
		return consultasConTurno;
	}
	
	
	
	
	
}
