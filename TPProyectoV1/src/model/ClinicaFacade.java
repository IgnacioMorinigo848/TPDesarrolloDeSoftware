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
	public void registrarPaciente(String nombre, String apellido, int dni,boolean jubilado,String seguroSocial,
			LocalDate fechaNacimiento,int telefono) {
		
		clinica.registrarPaciente(factory.crearPaciente(nombre,apellido,dni,jubilado,seguroSocial,fechaNacimiento,telefono));
	}
	
	public void registrarCitaMedica(int dniPaciente,int idMedico,Procedimiento procedimiento,LocalDateTime fechaYHora ) {
		System.out.println(clinica.registrarCitaMedica(dniPaciente, idMedico, procedimiento, fechaYHora));
	}
	
	public void finalizarCitaMedica(int dniPaciente,LocalDateTime fechaYHora, String tratamiento, String diagnostico,LocalDate fechaInicio,LocalDate fechaFin) {
		System.out.println(clinica.finalizarCitaMedica(dniPaciente, fechaYHora, tratamiento, diagnostico,fechaInicio,fechaFin));
	}
	
	public void cancelarCitaMedica(int dniPaciente, LocalDateTime fechaYHora) {
		System.out.println(clinica.cancelarCitaMedica(dniPaciente, fechaYHora));
	}
	
	public void filtarCitaPorEspecialidad(String especilidad) {
		ArrayList<CitaMedica> cita = clinica.filtarCitaPorEspecialidad(especilidad);
		for (CitaMedica citaMedica : cita) {
			System.out.println(citaMedica);
		}
	}
	
	public void filtrarCitaPorMedicoAsignado(int idMedico) {
		ArrayList<CitaMedica> cita = clinica.filtrarCitaPorMedicoAsignado(idMedico);
		for (CitaMedica citaMedica : cita) {
			System.out.println(citaMedica);
		}
	}
	
	public void filtrarCitaPorFecha(LocalDate fecha) {
		ArrayList<CitaMedica> cita = clinica.filtrarCitaPorFecha(fecha);
		for (CitaMedica citaMedica : cita) {
			System.out.println(citaMedica);
		}
	}
	
	
}
