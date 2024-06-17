package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Clinica {
    private static final Clinica instance = new Clinica();
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medico> medicos;
	private ArrayList<Especialidad> especialidades;
	private ArrayList<CitaMedica> citasMedicas;
	
private Clinica() {
	this.pacientes = new ArrayList<Paciente>();
	this.medicos = new ArrayList<Medico>();
	this.especialidades = new ArrayList<Especialidad>();
	this.citasMedicas = new ArrayList<CitaMedica>();
}

public static Clinica getInstance () {
	return instance;
}

public void registrarPaciente(Paciente paciente) {
	if(this.getPaciente(paciente.dni) == null) {
		pacientes.add(paciente);
	}
}

public String registrarCitaMedica(int dniPaciente, int idMedico, Procedimiento procedimiento, LocalDateTime fechaYHora) {
    String respuesta = "Error: Existe una cita programada.";
    Medico medico = this.getMedico(idMedico);
    Paciente paciente = this.getPaciente(dniPaciente);
    
    if (medico != null && paciente != null && !this.existeCita(idMedico, fechaYHora, dniPaciente)) {
        CitaMedica cita = new CitaMedica(paciente, medico, procedimiento, fechaYHora, medico.getEspecialidad());
        citasMedicas.add(cita);
        respuesta = "Cita programada exitosamente.";
    }
    return respuesta;
}


private Paciente getPaciente(int dni) {
	int index = 0;
	Paciente p = null;
	while(index < pacientes.size() && pacientes.get(index).getDni() != dni) 
		index++;
	if(index < pacientes.size())
		p = pacientes.get(index);
	return p;
}

public Medico getMedico(int idMedico) {
	int index = 0;
	Medico m = null;
	while(index < medicos.size() && medicos.get(index).getIdMedico() !=  idMedico) 
		index++;
	if(index < medicos.size())
		m = medicos.get(index);
	return m;
}

private CitaMedica getCitaMedica(LocalDateTime fechaYHora, int dni) {
	int index = 0;
	CitaMedica cm = null;
	while(index <= citasMedicas.size() && (!citasMedicas.get(index).getFechaYHora().equals(fechaYHora) && citasMedicas.get(index).getPaciente().getDni() != dni )) 
		index++;
	if(index <= medicos.size())
		cm = citasMedicas.get(index);
	return cm;
}

public String finalizarCitaMedica(int dniPaciente, LocalDateTime fechaYHora, String tratamiento,
		String diagnostico,LocalDate fechaInicio,LocalDate fechaFin) {
	
	String mensaje ="No se encuentra la cita Medica.";
	
	CitaMedica cita = this.getCitaMedica(fechaYHora, dniPaciente);
	
	 if(cita != null){
		this.asignarTratamientoYDiagnostico(cita, diagnostico, tratamiento, fechaInicio, fechaFin);
		mensaje = cita.finalizarCita();
		this.agregarCitaAPacienteYClinica(cita,dniPaciente);
	}
	return mensaje;
}

public String cancelarCitaMedica(int dniPaciente, LocalDateTime fechaYHora) {
	String mensaje ="No se encuentra la cita Medica.";
	CitaMedica cita = this.getCitaMedica(fechaYHora, dniPaciente);
	if(cita != null)
		mensaje = cita.cancelarCita();
	
	return mensaje;
}

public ArrayList<CitaMedica> filtarCitaPorEspecialidad(String Especialidad) {
	ArrayList<CitaMedica> cita = new ArrayList<CitaMedica>();
	
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getMedico().getEspecialidad().getNombre().equals(Especialidad)) 
			cita.add(citaMedica);
	}
	return cita;
}

public ArrayList<CitaMedica> filtrarCitaPorMedicoAsignado(int idMedico) {
	ArrayList<CitaMedica> cita = new ArrayList<CitaMedica>();
	
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getMedico().getIdMedico() == idMedico) 
			cita.add(citaMedica);
	}
	return cita;
}

public ArrayList<CitaMedica> filtrarCitaPorFecha(LocalDate fecha) {
	ArrayList<CitaMedica> cita = new ArrayList<CitaMedica>();
	
	for (CitaMedica citaMedica : citasMedicas) {
		if(citaMedica.getFechaYHora().toLocalDate().equals(fecha)) 
			cita.add(citaMedica);
	}
	return cita;
}

private boolean existeCita(int idMedico, LocalDateTime fechaYHora, int dniPaciente) {
    for (CitaMedica cita : citasMedicas) {
        if (cita.getMedico().getIdMedico() == idMedico &&
            cita.getPaciente().getDni() == dniPaciente &&
            cita.getFechaYHora().equals(fechaYHora)) {
            return true; 
        }
    }
    return false; 
}


private void agregarCitaAPacienteYClinica(CitaMedica cita,int dniPaciente) {
	citasMedicas.add(cita);
	Paciente paciente = this.getPaciente(dniPaciente);
	paciente.agregarCitaMedica(cita);
}

private void asignarTratamientoYDiagnostico(CitaMedica cita, String diagnostico, String tratamiento, LocalDate fechaInicio, LocalDate fechaFin) {
	cita.setDiagnostico(diagnostico);
	cita.setTratamiento(new Tratamiento(tratamiento,fechaInicio,fechaFin));
}

public ArrayList<Paciente> getPacientes() {
	return pacientes;
}

public ArrayList<Medico> getMedicos() {
	return medicos;
}


public ArrayList<Especialidad> getEspecialidades() {
	return especialidades;
}

}
