package ar.edu.unlam.pb2.hospital;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HospitalTest {

	@Test
	public void testQuePermitaRegistrarPisos(){
		Piso piso1 = new Piso(1, 1);		
		
		SistemaHospital hospital1 = new SistemaHospital("nuevoHospital");		
		
		assertTrue(hospital1.registrarPiso(piso1));
	}
	
	/*
	@Test
	public void testQueRegistreUnMedicoEnUnaEspecialidad(){
		SistemaHospital hospital1 = new SistemaHospital("nuevoHospital");
		Medico medico1 = new Medico("Martin", "Segovia", 32830303, 20, "1deMarzo", 50000.0, 456123, "Cirujano");
		Especialidad especialidad1 = new Especialidad(11, "Cirugia");
		
		hospital1.registrarMedico(medico1);
		hospital1.agregarEspecialidad(especialidad1);		
		
		assertTrue(hospital1.registrarMedicoEnEspecialidad(20, 11));
	}*/
	
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
	
	
	
	
}
