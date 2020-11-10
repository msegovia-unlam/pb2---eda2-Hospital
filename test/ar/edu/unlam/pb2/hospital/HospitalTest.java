package ar.edu.unlam.pb2.hospital;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
}
