package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Clinica {
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medico> medicos;
	private ArrayList<Especialidad> especialidades;
	private ArrayList<CitaMedica> citasMedicas;
	
public void registrarPaciente(String nombre, String apellido, int dni, boolean jubilado, String seguroSocial,
LocalDate fechaNacimiento, int telefono, HistoriaClinica historiaClinica) {
	Paciente paciente = new Paciente(nombre, apellido, dni, jubilado, seguroSocial, fechaNacimiento, telefono, historiaClinica);
	pacientes.add(paciente);
}

public void registrarCitaMedica(Paciente paciente, Medico medico, Procedimiento procedimiento, LocalDateTime fechaYHora, String motivo) {
	CitaMedica citaMedica = new CitaMedica(paciente, medico, procedimiento, fechaYHora, motivo);
	citasMedicas.add(citaMedica);
}

public Paciente getPaciente(int dni) {
	int index = 0;
	Paciente p = null;
	while(index < pacientes.size() && pacientes.get(index).getDni() != dni) 
		index++;
	if(index >= pacientes.size())
		p = pacientes.get(index);
	return p;
}

public Medico getMedico(int idMedico) {
	int index = 0;
	Medico m = null;
	while(index < medicos.size() && medicos.get(index).getIdMedico() !=  idMedico) 
		index++;
	if(index >= medicos.size())
		m = medicos.get(index);
	return m;
}

public CitaMedica getCitaMedica(LocalDateTime fechaYHora, int dni) {
	int index = 0;
	CitaMedica cm = null;
	while(index < citasMedicas.size() && (citasMedicas.get(index).getFechaYHora() !=  fechaYHora && citasMedicas.get(index).getPaciente().getDni() != dni )) 
		index++;
	if(index >= medicos.size())
		cm = citasMedicas.get(index);
	return cm;
}

public void finalizarCita(CitaMedica cita) {
	cita.finalizada();
}

public void cancelarCita(CitaMedica cita){
	cita.cancelada();
}

public ArrayList<CitaMedica> filtarCitaPorEspecialidad(String Especialidad) {
	ArrayList<CitaMedica> citasFiltradas = new ArrayList<CitaMedica>();
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getMedico().getEspecialidad().equals(Especialidad)) 
			citasFiltradas.add(citaMedica);
	}
	return citasFiltradas;
}


public ArrayList<CitaMedica> filtrarCitaPorMedicoAsignado(int idMedico) {
	ArrayList<CitaMedica> citasFiltradas = new ArrayList<CitaMedica>();
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getMedico().getIdMedico() == idMedico) 
			citasFiltradas.add(citaMedica);
	}
	return citasFiltradas;
}

public void filtrarCitaPorFecha(LocalDate fecha) {
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getFechaYHora().toLocalDate().equals(fecha)) 
			System.out.println(citaMedica.toString());
	}
}

public void cargarHistoriaAClinica(Paciente paciente, CitaMedica citaMedica) {
	
}

}
