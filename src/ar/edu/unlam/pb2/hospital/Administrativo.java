package ar.edu.unlam.pb2.hospital;

public class Administrativo extends Empleado{
	
	private String funcionLaboral;
	
	
	public Administrativo(String nombre, String apellido, Integer dni, Integer id, String inicioDeActividad, Double sueldo, String funcionLaboral) {
		super(nombre, apellido, dni, id, inicioDeActividad, sueldo);
		this.funcionLaboral = funcionLaboral;
	}
	
	
	public String getFuncionLaboral() {
		return funcionLaboral;
	}
	
	
	public void setFuncionLaboral(String funcionLaboral) {
		this.funcionLaboral = funcionLaboral;
	}
	
	//HASCODE / EQUALS 
	
	@Override
	public Integer obtenerAntiguedad() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public Integer obtenerVacaciones() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
