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
	private Estado estadoCita;
	private Factura factura;
	private Especialidad motivo;
	public CitaMedica(Paciente paciente, Medico medico, Procedimiento procedimiento, LocalDateTime fechaYHora,
			Especialidad motivo) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.Procedimiento = procedimiento;
		this.fechaYHora = fechaYHora;
		this.motivo = motivo;
		this.estadoCita = Estado.PROGRAMADA;
		this.tratamiento = new ArrayList<Tratamiento>();
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
	public Estado getEstadoCita() {
		return estadoCita;
	}
	
	public void finalizarCita() {
		this.estadoCita = Estado.FINALIZADO;
	}
	
	public void cancelarCita() {
		this.estadoCita = Estado.CANCELADO;
	}
	
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Especialidad getMotivo() {
		return motivo;
	}
	public void setMotivo(Especialidad motivo) {
		this.motivo = motivo;
	}
	
	
}
