package ar.edu.unlam.pb2.hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
	
}
