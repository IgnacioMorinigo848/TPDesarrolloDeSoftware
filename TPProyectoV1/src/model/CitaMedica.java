package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CitaMedica {

	private Paciente paciente;
	private Medico medico;
	private Procedimiento Procedimiento;
	private String diagnostico;
	private ArrayList<Tratamiento> tratamiento;
	private LocalDateTime fechaYHora;
	private EstadoCita estadoCita;
	private final EstadoCita programada;
	private final EstadoCita finalizada;
	private final EstadoCita cancelada;
	private Especialidad motivo;
	
	
	public CitaMedica(Paciente paciente, Medico medico, Procedimiento procedimiento, LocalDateTime fechaYHora,
			Especialidad motivo) {
		this.paciente = paciente;
		this.medico = medico;
		this.Procedimiento = procedimiento;
		this.fechaYHora = fechaYHora;
		this.motivo = motivo;
		this.programada = new EstadoProgramarCita(this);
		this.finalizada = new EstadoFinalizarCita(this);
		this.cancelada = new EstadoCancelarcita(this);
		this.estadoCita = programada;
		this.tratamiento = new ArrayList<Tratamiento>();
	}
	public void setEstadoCita(EstadoCita estadoCita) {
		this.estadoCita = estadoCita;
	}
	public void asignarTratamiento(Tratamiento tratamiento) {
		this.tratamiento.add(tratamiento);
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public Medico getMedico() {
		return medico;
	}
	
	public Procedimiento getProcedimiento() {
		return Procedimiento;
	}
	
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public ArrayList<Tratamiento> getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(ArrayList<Tratamiento> tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	public EstadoCita getEstadoCita() {
		return estadoCita;
	}
	
	public void programarCita() {
		estadoCita.programada();
	} 
	
	public void finalizarCita() {
		estadoCita.finalizada();
	}
	
	public void cancelarCita() {
		estadoCita.cancelada();
	}
	
	public Especialidad getMotivo() {
		return motivo;
	}
	public void setMotivo(Especialidad motivo) {
		this.motivo = motivo;
	}
	public EstadoCita getFinalizada() {
		return finalizada;
	}
	public EstadoCita getCancelada() {
		return cancelada;
	}
	public void setProcedimiento(Procedimiento procedimiento) {
		Procedimiento = procedimiento;
	}
	
	
	
}
