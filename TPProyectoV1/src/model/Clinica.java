package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Clinica {
	private static Clinica instance;
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medico> medicos;
	private ArrayList<Especialidad> especialidades;
	private ArrayList<CitaMedica> citasMedicas;
	private FactoryMethodPaciente createPaciente;
	
private Clinica() {
	this.pacientes = new ArrayList<Paciente>();
	this.medicos = new ArrayList<Medico>();
	this.especialidades = new ArrayList<Especialidad>();
	this.citasMedicas = new ArrayList<CitaMedica>();
	this.createPaciente = new ConcreteFactoryPaciente();
	}

public static Clinica getInstance () {
	if(instance == null) {
		instance = new Clinica();
	}
	return instance;
}

public void registrarPaciente(Paciente paciente) {
	pacientes.add(paciente);
}

public void registrarCitaMedica(CitaMedica citaMedica) {
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

public void finalizarCitaMedica(CitaMedica citaMedica) {
	citaMedica.finalizarCita();
}

public void cancelarCitaMedica(CitaMedica citaMedica) {
	citaMedica.cancelarCita();
}

public void filtarCitaPorEspecialidad(String Especialidad) {
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getMedico().getEspecialidad().equals(Especialidad)) 
			System.out.println(citaMedica.toString());
	}
}

public void filtrarCitaPorMedicoAsignado(int idMedico) {
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getMedico().getIdMedico() == idMedico) 
			System.out.println(citaMedica.toString());
	}
}

public void filtrarCitaPorFecha(LocalDate fecha) {
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getFechaYHora().toLocalDate().equals(fecha)) 
			System.out.println(citaMedica.toString());
	}
}

public void cargarHistoriaAClinica(int dni, CitaMedica citaMedica) {
	int i=0;
	while (i<= pacientes.size() && pacientes.get(i).getDni() != dni) {
		i++;
	}
	if(i<=pacientes.size()) {
		pacientes.get(i).agregarCitaMedica(citaMedica);
	}
}

public void registrarTratamiento(CitaMedica citaMedica, Tratamiento tratamiento) {
	if(citaMedica.getEstadoCita().equals(Estado.FINALIZADO) && !citaMedica.getEstadoCita().equals(Estado.CANCELADO))
		citaMedica.asignarTratamiento(tratamiento);
}




}
