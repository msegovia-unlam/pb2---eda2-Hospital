package ar.edu.unlam.pb2.hospital;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

import junit.framework.Assert;

public class HospitalTest {

	@Test
	public void queSePuedaRegistrarUnAdministrativoEnElHospital() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Administrativo admin = new Administrativo("Gustavo", "Ruiz", 30299991, 3, "10-03-2019", 45.000, "Recepcionista");
		hospital.registrarAdministrativo(admin);
		Integer cantidadAdministrativos = hospital.getAdministrativos().size();
		Integer cantidadEsperada = 1;
		assertEquals(cantidadEsperada, cantidadAdministrativos);
	}
	
	@Test
	public void queSePuedaObtenerUnAdministrativo() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Administrativo admin = new Administrativo("Gustavo", "Ruiz", 30299991, 3, "10-03-2019", 45.000, "Recepcionista");
		hospital.registrarAdministrativo(admin);
		Administrativo adminBuscado = hospital.buscarAdministrativo(3);
		String nombreObtenido = adminBuscado.getNombre();
		String nombreEsperado = "Gustavo";
		
		assertEquals(nombreEsperado, nombreObtenido);
	}
	
	@Test 
	public void queNoSePuedanRegistrarAdministrativosRepetidos() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Administrativo admin = new Administrativo("Gustavo", "Ruiz", 30299991, 3, "10-03-2019", 45.000, "Recepcionista");
		Administrativo admin2 = new Administrativo("Jose", "Alderete", 31299993, 3, "10-05-2019", 45.000, "Recepcionista");
		hospital.registrarAdministrativo(admin);
		hospital.registrarAdministrativo(admin2);

		Integer cantidadAdministrativos = hospital.getAdministrativos().size();
		Integer cantidadEsperada = 1;
		assertEquals(cantidadEsperada, cantidadAdministrativos);
	}
	
	@Test 
	public void queSePuedaDarUnTurnoAUnPaciente() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Especialidad kinesiologia = new Especialidad(2, "Kinesiologia");
		hospital.agregarEspecialidad(kinesiologia);
		Medico medico = new Medico("Maria", "Gimenez", 25666222, 10, "02-07-2000", 50000.0, 21222, "Kinesiologia");
		hospital.registrarMedico(medico);
		hospital.registrarMedicoEnEspecialidad(10, 2);
		Administrativo admin = new Administrativo("Gustavo", "Ruiz", 30299991, 3, "10-03-2019", 45.000, "Recepcionista");
		hospital.registrarAdministrativo(admin);
		Paciente paciente1 = new Paciente("Luis", "Gomez", 29123555, 5, "Hipertenso", 70.5, 1.75);
		hospital.registrarPaciente(paciente1);
		hospital.asignarTurnoAPaciente(5, 2, 10, 3, "6-11-2020");
		hospital.getTurnosAsignados().size();
		
		Integer cantidadTurnos = hospital.getTurnosAsignados().size();
		Integer cantidadEsperada = 1;
		
		assertEquals(cantidadEsperada, cantidadTurnos);
	}
	
	@Test
	public void testQueSePuedaAgregarUnMedico() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Medico medico = new Medico("Pablo", "Gomez", 25380657,01,"01-01-2020",60000.0,159865,"Cardiologo");
		assertTrue(hospital.registrarMedico(medico));
	}
	
	@Test
	public void testQueSePuedaAgregarUnaEspecialidad() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Especialidad especialidad = new Especialidad(01,"Cardiologia");
		assertTrue(hospital.agregarEspecialidad(especialidad));
	}
	
	@Test
	public void testQueSeBuscaUnMedico() {
		
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Medico medicoAEncontrar = new Medico("Pablo", "Gomez", 25380657,01,"01-01-2020",60000.0,159865,"Cardiologo");
		hospital.registrarMedico(medicoAEncontrar);
		Medico medico = hospital.buscarMedico(01);
		assertEquals(medicoAEncontrar, medico);
	}
	
	@Test
	public void testQueBuscaUnaEspecialidad() {
		
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Especialidad especialidadAEncontrar = new Especialidad(01,"Cardiologia");
		hospital.agregarEspecialidad(especialidadAEncontrar);
		Especialidad especialidad = hospital.buscarEspecialidad(01);
		assertEquals(especialidadAEncontrar, especialidad);
	}
	
	@Test
	public void testQueSePuedaDarDeBajaUnMedico() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Medico medicoAEncontrar = new Medico("Pablo", "Gomez", 25380657,01,"01-01-2020",60000.0,159865,"Cardiologo");
		hospital.registrarMedico(medicoAEncontrar);
		assertTrue(hospital.darDeBajaUnMedico(01));
	}
	
	@Test
	public void testQueSePuedaCambiarDeEspecialidadAUnMedico() {
		
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Medico medico = new Medico("Pablo", "Gomez", 25380657,01,"01-01-2020",60000.0,159865,"Neurologo");
		hospital.registrarMedico(medico);
		Especialidad especialidad = new Especialidad(01,"Cardiologia");
		hospital.agregarEspecialidad(especialidad);
		assertTrue(hospital.cambiarDeEspecialidadAUnMedico(01, "Cardiologia"));
		
	}
	
	@Test
	public void queSePuedaRegistrarUnPaciente() 
	{
		SistemaHospital hospital = new SistemaHospital("PAMI");
		Paciente paciente01 = new Paciente("Valeria", "Martinez", 40199299, 001, "VM-Historial", 68.50, 1.78 );
		hospital.registrarPaciente(paciente01);
		Integer cantidadPacientes = hospital.pacientes.size();
		Integer cantidadRegistrada = 1;
		assertEquals(cantidadRegistrada, cantidadPacientes);
	}


	@Test
	public void queSePuedaRegistrarUnaInternacion() 
	{
		SistemaHospital hospital2 = new SistemaHospital("PAMI");
		Paciente paciente02 = new Paciente("Mario", "Martinez", 29177188, 002, "MM-Historial", 81.5, 1.92 );
		hospital2.registrarPaciente(paciente02);
		Piso piso1= new Piso (001, 1);
		Internacion internacion01= new Internacion(0001, paciente02, 235, piso1, "11-11-2020", "A determinar","sin obs");
		hospital2.registrarInternacion(internacion01);
		Integer cantidadInternados = hospital2.internacionesIngresadas.size();
		Integer cantidadRegistrada = 1;
		assertEquals(cantidadRegistrada, cantidadInternados);
	}
	
	
	
	@Test
	public void queSePuedaBuscarUnPaciente() {
		SistemaHospital hospital = new SistemaHospital("PAMI");
		Paciente paciente01 = new Paciente("Valeria", "Martinez", 40199299, 001, "VM-Historial", 68.50, 1.78 );
		hospital.registrarPaciente(paciente01);
		Paciente buscadorPaciente = hospital.buscarPaciente(001);
		Integer idPaciente = buscadorPaciente.getId();
		Integer idEsperado = 001;
		assertEquals(idPaciente, idEsperado);
	}
	
	
	@Test
	public void queSePuedaBuscarUnaInternacion() 
	{
		SistemaHospital hospital2 = new SistemaHospital("PAMI");
		Paciente paciente02 = new Paciente("Mario", "Martinez", 29177188, 002, "MM-Historial", 81.5, 1.92 );
		hospital2.registrarPaciente(paciente02);
		Piso piso1= new Piso (001, 1);
		Internacion internacion01= new Internacion(0001, paciente02, 235, piso1, "11-11-2020", "A determinar","sin obs");
		hospital2.registrarInternacion(internacion01);
		Internacion buscadorInternacion= hospital2.buscarInternacion(0001);
		Integer idInternacion= buscadorInternacion.getId();
		Integer idEsperado=0001;
		assertEquals(idInternacion, idEsperado);
	}
	

	@Test
	public void queSePuedaDarDeAlta() 
	{
		SistemaHospital hospital2 = new SistemaHospital("PAMI");
		Paciente paciente02 = new Paciente("Mario", "Martinez", 29177188, 002, "MM-Historial", 81.5, 1.92 );
		hospital2.registrarPaciente(paciente02);
		Piso piso1= new Piso (001, 1);
		Internacion internacion01= new Internacion(0001, paciente02, 235, piso1, "11-11-2020", "A determinar","sin obs");
		hospital2.registrarInternacion(internacion01);
		Boolean statusInternacion= hospital2.darDeAltaAPaciente(0001);
		Boolean estadoInternacion= statusInternacion;
		Boolean statusEsperado=false;
		assertEquals(estadoInternacion, statusEsperado);
	}
	
	@Test
	public void queSePuedaObtenerCantidadPacientesInternados()
	{
		SistemaHospital hospital2 = new SistemaHospital("PAMI");
		Paciente paciente02 = new Paciente("Mario", "Martinez", 29177188, 002, "MM-Historial", 81.5, 1.92 );
		hospital2.registrarPaciente(paciente02);
		Piso piso1= new Piso (001, 1);
		Internacion internacion01= new Internacion(0001, paciente02, 235, piso1, "11-11-2020", "A determinar","sin obs");
		hospital2.registrarInternacion(internacion01);
		
		
		Integer cantidadInternados = hospital2.obtenerCantidadDePacientesInternados();
		Integer cantidadEsperada = 1;
		assertEquals(cantidadEsperada, cantidadInternados);
		
	}
	
	
=======
	public void testQueObtengaCantidadDeConsultasPorEspecialidad() {
		
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Medico medico = new Medico("Pablo", "Gomez", 25380657,01,"01-01-2020",60000.0,159865,"Cardiologo");
		hospital.registrarMedico(medico);
		Especialidad especialidad = new Especialidad(01,"Cardiologia");
		hospital.agregarEspecialidad(especialidad);
		Administrativo administrativo = new Administrativo("Gustavo", "Ruiz", 30299991, 01, "10-03-2019", 45.000, "Recepcionista");
		hospital.registrarAdministrativo(administrativo);
		Paciente paciente = new Paciente("Juan","Martinez",23689741,01,"Problemas cardiologicos",79.0,180.0);
		hospital.registrarPaciente(paciente);
		
		hospital.asignarTurnoAPaciente(01, 01, 01, 01, "10-11-2020");
		hospital.asignarTurnoAPaciente(01, 01, 01, 01, "20-11-2020");
		hospital.asignarTurnoAPaciente(01, 01, 01, 01, "08-12-2020");
		
		Integer cantidadDeConsultas = 3;
		
		assertEquals(cantidadDeConsultas, hospital.obtenerCantidadDeConsultasPorEspecialidad(01));
	}
	
	@Test
	public void testParaUnMedicoNoEncontrado() {
		
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Medico medicoAEncontrar = new Medico("Pablo", "Gomez", 25380657,01,"01-01-2020",60000.0,159865,"Cardiologo");
		hospital.registrarMedico(medicoAEncontrar);
		Medico medico = hospital.buscarMedico(02);
		assertNotSame(medicoAEncontrar, medico);
	}
	
	@Test
	public void testParaUnaEspecialidadInexistente() {
		
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Especialidad especialidadAEncontrar = new Especialidad(01,"Cardiologia");
		hospital.agregarEspecialidad(especialidadAEncontrar);
		Especialidad especialidad = hospital.buscarEspecialidad(02);
		assertNotSame(especialidadAEncontrar, especialidad);
	}
	
	@Test
	public void queSePuedaCancelarUnTurno() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Especialidad kinesiologia = new Especialidad(2, "Kinesiologia");
		hospital.agregarEspecialidad(kinesiologia);
		Medico medico = new Medico("Maria", "Gimenez", 25666222, 10, "02-07-2000", 50000.0, 21222, "Kinesiologia");
		hospital.registrarMedico(medico);
		hospital.registrarMedicoEnEspecialidad(10, 2);
		Administrativo admin = new Administrativo("Gustavo", "Ruiz", 30299991, 3, "10-03-2019", 45.000, "Recepcionista");
		hospital.registrarAdministrativo(admin);
		Paciente paciente1 = new Paciente("Luis", "Gomez", 29123555, 5, "Hipertenso", 70.5, 1.75);
		hospital.registrarPaciente(paciente1);
		hospital.asignarTurnoAPaciente(5, 2, 10, 3, "6-11-2020");
		hospital.cancelarTurno(1);
		Integer cantidadDeTurnos = hospital.getTurnosAsignados().size();
		Integer cantidadEsperada = 0;
		
		assertEquals(cantidadEsperada, cantidadDeTurnos);
	}
	
	@Test 
	public void queSePuedaCrearUNaConsultaSinTurno() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Especialidad kinesiologia = new Especialidad(2, "Kinesiologia");
		hospital.agregarEspecialidad(kinesiologia);
		Medico medico = new Medico("Maria", "Gimenez", 25666222, 10, "02-07-2000", 50000.0, 21222, "Kinesiologia");
		hospital.registrarMedico(medico);
		hospital.registrarMedicoEnEspecialidad(10, 2);
		Administrativo admin = new Administrativo("Gustavo", "Ruiz", 30299991, 3, "10-03-2019", 45.000, "Recepcionista");
		hospital.registrarAdministrativo(admin);
		Paciente paciente1 = new Paciente("Luis", "Gomez", 29123555, 5, "Hipertenso", 70.5, 1.75);
		hospital.registrarPaciente(paciente1);
		hospital.crearNuevaConsultaSinTurno(paciente1.getId(), kinesiologia.getId(), medico.getId(), admin.getId(), "06-11-2020", "Diabetes");
		
		Integer cantidadDeConsultasSinturno = hospital.getConsultasSinTurno().size();
		Integer cantidadEsperada = 1;
		
		assertEquals(cantidadEsperada, cantidadDeConsultasSinturno);
	}
	
	@Test//
	public void queSePuedaCambiarUnTurno() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Especialidad ginecologia = new Especialidad(2, "Ginecologia");
		hospital.agregarEspecialidad(ginecologia);
		Medico medico = new Medico("Alfredo", "Suarez", 25666222, 8, "02-07-2000", 50000.0, 21222, "Kinesiologia");
		hospital.registrarMedico(medico);
		hospital.registrarMedicoEnEspecialidad(medico.getId(), ginecologia.getId());
		Administrativo admin = new Administrativo("Gustavo", "Ruiz", 30299991, 3, "10-03-2019", 45.000, "Recepcionista");
		hospital.registrarAdministrativo(admin);
		Paciente paciente1 = new Paciente("Sara", "Mendez", 29123555, 22, "Diabetes", 65.0, 1.55);
		hospital.registrarPaciente(paciente1);
		hospital.asignarTurnoAPaciente(paciente1.getId(), ginecologia.getId(), medico.getId(), admin.getId(), "15-06-2020");
		Turno turno = hospital.buscarTurnoDeUnPaciente(paciente1.getId(), "15-06-2020");
		
		assertTrue(hospital.cambiarTurno(turno.getId(), "10-11-2020"));
	}
	
	@Test
	public void queSePuedaConsultarSiEstaDisponibilidadUnTurno() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Especialidad kinesiologia = new Especialidad(2, "Kinesiologia");
		hospital.agregarEspecialidad(kinesiologia);
		Medico medico = new Medico("Maria", "Gimenez", 25666222, 10, "02-07-2000", 50000.0, 21222, "Kinesiologia");
		hospital.registrarMedico(medico);
		hospital.registrarMedicoEnEspecialidad(10, 2);
		Administrativo admin = new Administrativo("Gustavo", "Ruiz", 30299991, 3, "10-03-2019", 45.000, "Recepcionista");
		hospital.registrarAdministrativo(admin);
		Paciente paciente1 = new Paciente("Luis", "Gomez", 29123555, 5, "Hipertenso", 70.5, 1.75);
		hospital.registrarPaciente(paciente1);
		hospital.asignarTurnoAPaciente(5, 2, 10, 3, "6-11-2020");
		Turno turno = hospital.buscarTurnoPorIDPaciente(paciente1.getId());
		
		assertFalse(hospital.consultarDisponibilidadDeUnTurno(turno.getId()));
	}
	
	@Test
	public void testQuePermitaRegistrarPisos(){
		SistemaHospital hospital1 = new SistemaHospital("nuevoHospital");
		Piso piso1 = new Piso(1, 1);		
		
		assertTrue(hospital1.registrarPiso(piso1));
	}
	
	
	@Test
	public void testQueRegistreUnMedicoEnUnaEspecialidad(){
		SistemaHospital hospital1 = new SistemaHospital("nuevoHospital");
		Medico medico1 = new Medico("Martin", "Segovia", 32830303, 20, "1deMarzo", 50000.0, 456123, "Cirujano");
		Especialidad especialidad1 = new Especialidad(11, "Cirugia");
		
		hospital1.registrarMedico(medico1);
		hospital1.agregarEspecialidad(especialidad1);		
		
		assertTrue(hospital1.registrarMedicoEnEspecialidad(20, 11));
	}
	
	@Test
	public void testQuePuedaBuscarUnPiso() {
		SistemaHospital hospital1 = new SistemaHospital("nuevoHospital");
		Piso piso2 = new Piso(2, 2);
		Piso piso3 = new Piso(3, 3);
		Piso piso4 = new Piso(4, 4);
		
		hospital1.registrarPiso(piso2);
		hospital1.registrarPiso(piso3);
		hospital1.registrarPiso(piso4);
		
		Piso pisoBuscado = hospital1.buscarPiso(3);
		 
		assertEquals(piso3, pisoBuscado);
		
	}
	
	@Test
	public void testQuePermitaConsultarDisponibilidadDeUnaHabitacion() {
		SistemaHospital hospital1 = new SistemaHospital("nuevoHospital");
		Piso piso1 = new Piso(1, 1);		
		Paciente juan = new Paciente("Juan", "Gonzales", 328884924, 1, "Sin enfermedades", 80.0, 17.5);
		Paciente andres = new Paciente("Andres", "Lopez", 328815479, 2, "Sin enfermedades", 77.0, 17.8);
		Paciente martin = new Paciente("Martin", "Garcia", 328819517, 3, "Sin enfermedades", 75.0, 17.5);
		hospital1.registrarPaciente(martin);
		hospital1.registrarPaciente(andres);
		hospital1.registrarPaciente(juan);
		hospital1.registrarPiso(piso1);
		
		Internacion internacion1 = new Internacion(1, juan, 1, piso1, "10/11/2020", null, "en observacion");
		Internacion internacion2 = new Internacion(2, andres, 2, piso1, "08/11/2020", null, "en observacion");
		Internacion internacion3 = new Internacion(3, martin, 3, piso1, "07/11/2020", null, "en observacion");
				
		hospital1.registrarInternacion(internacion1);
		hospital1.registrarInternacion(internacion2);
		hospital1.registrarInternacion(internacion3);
		
		assertFalse(hospital1.consultarDisponibilidadDeUnaHabitacion(1, 1));;
	}
	
	@Test
	public void testQuePermitaCrearUnaConsultaConTurno(){
		
		SistemaHospital hospital1 = new SistemaHospital("nuevoHospital");
		Paciente paciente1 = new Paciente("Carlos", "Gomez", 32781324, 100, "no posee nada", 80.0, 18.0);
		Medico medico1 = new Medico("Raul", "Ruth", 205467981, 100, "01/03/2010", 60000.0, 987456, "Oftalmologo");
		Especialidad esp1 = new Especialidad(20, "Oftalmologia");
		Administrativo adm1 = new Administrativo("Braulio", "Gomez", 284569831, 200, "02/11/2015", 40000.0, "Recepcionista");
		Turno turno1 = new Turno(1, "miercoles", paciente1, medico1, esp1, adm1);
		
		hospital1.registrarPaciente(paciente1);
		hospital1.registrarMedico(medico1);
		hospital1.registrarAdministrativo(adm1);
		hospital1.agregarEspecialidad(esp1);
		hospital1.registrarMedicoEnEspecialidad(medico1.getId(), esp1.getId());
		hospital1.asignarTurnoAPaciente(paciente1.getId(), esp1.getId(), medico1.getId(), adm1.getId(), "10/11/2020");
		
		String observacion = "Turno con oftalmologo Raul";
		hospital1.crearNuevaConsultaConTurno(turno1.getId(), "10/11/2020", observacion, adm1);
		Integer ve= 1;
		Integer vo= hospital1.getconsultasConTurno().size();
		
		assertEquals(ve, vo);	
	}
	
	@Test
	public void testQuePermitaObtenerUnaListaDeHabitacionesOcupadas() {
		SistemaHospital hospital1 = new SistemaHospital("nuevoHospital");
		Piso piso1 = new Piso(1, 1);
		Paciente juan = new Paciente("Juan", "Gonzales", 328884924, 1, "Sin enfermedades", 80.0, 17.5);
		Paciente andres = new Paciente("Andres", "Lopez", 328815479, 2, "Sin enfermedades", 77.0, 17.8);
		Paciente martin = new Paciente("Martin", "Garcia", 328819517, 3, "Sin enfermedades", 75.0, 17.5);		
		Internacion internacion1 = new Internacion(1, juan, 1, piso1, "10/11/2020", null, "en observacion");
		Internacion internacion2 = new Internacion(2, andres, 2, piso1, "08/11/2020", null, "en observacion");
		Internacion internacion3 = new Internacion(3, martin, 3, piso1, "07/11/2020", null, "en observacion");
		
		hospital1.registrarInternacion(internacion1);
		hospital1.registrarInternacion(internacion2);
		hospital1.registrarInternacion(internacion3);				
		HashSet<Integer> habOcupadas = new HashSet<Integer>();
		habOcupadas.add(internacion1.getHabitacion());
		habOcupadas.add(internacion2.getHabitacion());
		habOcupadas.add(internacion3.getHabitacion());		
		
		assertEquals(habOcupadas, hospital1.obtenerListaDeHabitacionesOcupadas(piso1.getNumero()));
				
	}
	
	@Test
	public void testQuePermitaobtenerCantidadDeHabitacionesOcupadas() {
		SistemaHospital hospital1 = new SistemaHospital("nuevoHospital");
		Piso piso1 = new Piso(1, 1);
		Paciente juan = new Paciente("Juan", "Gonzales", 328884924, 1, "Sin enfermedades", 80.0, 17.5);
		Paciente andres = new Paciente("Andres", "Lopez", 328815479, 2, "Sin enfermedades", 77.0, 17.8);
		Paciente martin = new Paciente("Martin", "Garcia", 328819517, 3, "Sin enfermedades", 75.0, 17.5);		
		Internacion internacion1 = new Internacion(1, juan, 1, piso1, "10/11/2020", null, "en observacion");
		Internacion internacion2 = new Internacion(2, andres, 2, piso1, "08/11/2020", null, "en observacion");
		Internacion internacion3 = new Internacion(3, martin, 3, piso1, "07/11/2020", null, "en observacion");
		
		hospital1.registrarInternacion(internacion1);
		hospital1.registrarInternacion(internacion2);
		hospital1.registrarInternacion(internacion3);		
		Integer ve = 3;
		
		assertEquals(ve, hospital1.obtenerCantidadDeHabitacionesOcupadas());
		
	}
	
	@Test //
	public void queSePuedaAsignarMasDeUnTurnoAUnPaciente() {
		SistemaHospital hospital = new SistemaHospital("Centro San Justo");
		Especialidad ginecologia = new Especialidad(2, "Ginecologia");
		Especialidad oftalmologia = new Especialidad(9, "Oftalmologia");
		Especialidad dermatologia = new Especialidad(4, "Dermatologia");
		hospital.agregarEspecialidad(ginecologia);
		hospital.agregarEspecialidad(oftalmologia);
		hospital.agregarEspecialidad(dermatologia);
		Medico medico = new Medico("Alfredo", "Suarez", 25666222, 8, "02-07-2000", 50000.0, 21222, "Oftalmologia-Dermatologia");
		hospital.registrarMedico(medico);
		hospital.registrarMedicoEnEspecialidad(medico.getId(), oftalmologia.getId());
		hospital.registrarMedicoEnEspecialidad(medico.getId(), dermatologia.getId());
		Medico medico2 = new Medico("Lucia", "Suarez", 25666222, 28, "02-07-2000", 50000.0, 21222, "Ginecologia");
		hospital.registrarMedico(medico2);
		hospital.registrarMedicoEnEspecialidad(medico2.getId(), ginecologia.getId());
		Administrativo admin = new Administrativo("Gustavo", "Ruiz", 30299991, 3, "10-03-2019", 45.000, "Recepcionista");
		hospital.registrarAdministrativo(admin);
		Paciente paciente1 = new Paciente("Sara", "Mendez", 29123555, 22, "Diabetes", 65.0, 1.55);
		hospital.registrarPaciente(paciente1);
		hospital.asignarTurnoAPaciente(paciente1.getId(), ginecologia.getId(), medico2.getId(), admin.getId(), "15-06-2020");
		hospital.asignarTurnoAPaciente(paciente1.getId(), oftalmologia.getId(), medico.getId(), admin.getId(), "10-06-2020");
		hospital.asignarTurnoAPaciente(paciente1.getId(), dermatologia.getId(), medico.getId(), admin.getId(), "02-04-2020");
		
		Integer cantidadTurnosDelPaciente = paciente1.getTurnos().size();
		Integer cantidadEsperada = 3;
		
		assertEquals(cantidadEsperada, cantidadTurnosDelPaciente);
	}
	
	
	@Test
	public void queSePuedaRegistrarUnPaciente() 
	{
		SistemaHospital hospital = new SistemaHospital("PAMI");
		Paciente paciente01 = new Paciente("Valeria", "Martinez", 40199299, 001, "VM-Historial", 68.50, 1.78 );
		hospital.registrarPaciente(paciente01);
		Integer cantidadPacientes = hospital.pacientes.size();
		Integer cantidadRegistrada = 1;
		assertEquals(cantidadRegistrada, cantidadPacientes);
	}


	@Test
	public void queSePuedaRegistrarUnaInternacion() 
	{
		SistemaHospital hospital2 = new SistemaHospital("PAMI");
		Paciente paciente02 = new Paciente("Mario", "Martinez", 29177188, 002, "MM-Historial", 81.5, 1.92 );
		hospital2.registrarPaciente(paciente02);
		Piso piso1= new Piso (001, 1);
		Internacion internacion01= new Internacion(0001, paciente02, 235, piso1, "11-11-2020", "A determinar","sin obs");
		hospital2.registrarInternacion(internacion01);
		Integer cantidadInternados = hospital2.internacionesIngresadas.size();
		Integer cantidadRegistrada = 1;
		assertEquals(cantidadRegistrada, cantidadInternados);
	}
	
	
	
	@Test
	public void queSePuedaBuscarUnPaciente() {
		SistemaHospital hospital = new SistemaHospital("PAMI");
		Paciente paciente01 = new Paciente("Valeria", "Martinez", 40199299, 001, "VM-Historial", 68.50, 1.78 );
		hospital.registrarPaciente(paciente01);
		Paciente buscadorPaciente = hospital.buscarPaciente(001);
		Integer idPaciente = buscadorPaciente.getId();
		Integer idEsperado = 001;
		assertEquals(idPaciente, idEsperado);
	}
	
	
	@Test
	public void queSePuedaBuscarUnaInternacion() 
	{
		SistemaHospital hospital2 = new SistemaHospital("PAMI");
		Paciente paciente02 = new Paciente("Mario", "Martinez", 29177188, 002, "MM-Historial", 81.5, 1.92 );
		hospital2.registrarPaciente(paciente02);
		Piso piso1= new Piso (001, 1);
		Internacion internacion01= new Internacion(0001, paciente02, 235, piso1, "11-11-2020", "A determinar","sin obs");
		hospital2.registrarInternacion(internacion01);
		Internacion buscadorInternacion= hospital2.buscarInternacion(0001);
		Integer idInternacion= buscadorInternacion.getId();
		Integer idEsperado=0001;
		assertEquals(idInternacion, idEsperado);
	}
	

	@Test
	public void queSePuedaDarDeAlta() 
	{
		SistemaHospital hospital2 = new SistemaHospital("PAMI");
		Paciente paciente02 = new Paciente("Mario", "Martinez", 29177188, 002, "MM-Historial", 81.5, 1.92 );
		hospital2.registrarPaciente(paciente02);
		Piso piso1= new Piso (001, 1);
		Internacion internacion01= new Internacion(0001, paciente02, 235, piso1, "11-11-2020", "A determinar","sin obs");
		hospital2.registrarInternacion(internacion01);
		Boolean statusInternacion= hospital2.darDeAltaAPaciente(0001);
		Boolean estadoInternacion= statusInternacion;
		Boolean statusEsperado=false;
		assertEquals(estadoInternacion, statusEsperado);
	}
	
	@Test
	public void queSePuedaObtenerCantidadPacientesInternados()
	{
		SistemaHospital hospital2 = new SistemaHospital("PAMI");
		Paciente paciente02 = new Paciente("Mario", "Martinez", 29177188, 002, "MM-Historial", 81.5, 1.92 );
		hospital2.registrarPaciente(paciente02);
		Piso piso1= new Piso (001, 1);
		Internacion internacion01= new Internacion(0001, paciente02, 235, piso1, "11-11-2020", "A determinar","sin obs");
		hospital2.registrarInternacion(internacion01);
		
		
		Integer cantidadInternados = hospital2.obtenerCantidadDePacientesInternados();
		Integer cantidadEsperada = 1;
		assertEquals(cantidadEsperada, cantidadInternados);
		
	}
	
	
	@Test
	public void queSeObtengaListaDePacientesConTurno()
	
	
	

>>>>>>> 9472d11d5cfcfbfbffad4e8fefe6de44b08b38c4
}
