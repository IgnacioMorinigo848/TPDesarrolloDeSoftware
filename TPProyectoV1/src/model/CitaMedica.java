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
	private String estadoCita = new Estado().Programada();
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
	}
	public void asignarTratamiento(ArrayList<Tratamiento> tratamiento) {}
	
	public void asignarDiagnostico(String Diagnostico) {}
	
	public void actualizarEstado(Estado estado) {}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Procedimiento getProcedimiento() {
		return Procedimiento;
	}
	public void setProcedimiento(Procedimiento procedimiento) {
		Procedimiento = procedimiento;
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
	public String getEstadoCita() {
		return estadoCita;
	}
	public void setEstadoCita(String estadoCita) {
		this.estadoCita = estadoCita;
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
