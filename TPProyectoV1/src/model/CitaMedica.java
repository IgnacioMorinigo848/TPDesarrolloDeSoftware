package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CitaMedica {

	private Paciente paciente;
	private Medico medico;
	private Procedimiento Procedimiento;
	private String diagnostico;
	private ArrayList<Tratamiento> tratamientos;
	private LocalDateTime fechaYHora;
	private Estado estadoCita;
	private Factura factura;
	private String motivo;

	public CitaMedica(Paciente paciente, Medico medico, Procedimiento procedimiento, LocalDateTime fechaYHora, String motivo) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.Procedimiento = procedimiento;
		this.fechaYHora = fechaYHora;
		this.motivo = motivo;
		this.estadoCita = Estado.PROGRAMADA;
	}

	public void agregarTratamiento(Tratamiento tratamiento) {

		this.tratamientos.add(tratamiento);
	}
	
	public void asignarDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public void finalizada() {
		this.estadoCita = Estado.FINALIZADA;;
	}

	public void cancelada(){
		this.estadoCita = Estado.FINALIZADA;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Procedimiento getProcedimiento() {
		return this.Procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.Procedimiento = procedimiento;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public ArrayList<Tratamiento> getTratamiento() {
		return this.tratamientos;
	}

	public LocalDateTime getFechaYHora() {
		return this.fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public Estado getEstadoCita() {
		return this.estadoCita;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	
}
