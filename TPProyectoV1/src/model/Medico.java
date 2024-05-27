package model;

public class Medico extends Persona{
	private int idMedico; 
	private Especialidad especialidad;
	public Medico(String nombre, String apellido, int dni, Especialidad especialidad) {
		super(nombre, apellido, dni);
		this.especialidad = especialidad;
	}
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
}
