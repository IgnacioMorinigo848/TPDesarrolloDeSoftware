package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ClinicaFacade {
	private Clinica clinica;
	private AbstractFactoryPersona factory;
	
	public ClinicaFacade() {
		clinica = Clinica.getInstance();
		factory = new ConcreteAbstractFactoryPersona();
	}
	public String registrarPaciente(String nombre, String apellido, int dni,boolean jubilado,String seguroSocial,
			LocalDate fechaNacimiento,int telefono) {
		return clinica.registrarPaciente(factory.crearPaciente(nombre,apellido,dni,jubilado,seguroSocial,fechaNacimiento,telefono));
	}
	
	public String registrarCitaMedica(int dniPaciente,int idMedico,Procedimiento procedimiento,LocalDateTime fechaYHora ) {
		return clinica.registrarCitaMedica(dniPaciente, idMedico, procedimiento, fechaYHora);
	}
	
	public String finalizarCitaMedica(int dniPaciente,LocalDateTime fechaYHora, String tratamiento, String diagnostico,LocalDate fechaInicio,LocalDate fechaFin) {
		return clinica.finalizarCitaMedica(dniPaciente, fechaYHora, tratamiento, diagnostico,fechaInicio,fechaFin);
	}
	
	public String cancelarCitaMedica(int dniPaciente, LocalDateTime fechaYHora) {
		return clinica.cancelarCitaMedica(dniPaciente, fechaYHora);
	}
	
	public ArrayList<CitaMedica> filtarCitaPorEspecialidad(String especilidad) {
		return clinica.filtarCitaPorEspecialidad(especilidad);
	}
	
	public ArrayList<CitaMedica> filtrarCitaPorMedicoAsignado(int idMedico) {
		return clinica.filtrarCitaPorMedicoAsignado(idMedico);
	}
	
	public ArrayList<CitaMedica> filtrarCitaPorFecha(LocalDate fecha) {
		return clinica.filtrarCitaPorFecha(fecha);
	}
	
	
}
