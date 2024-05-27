package model;

import java.time.LocalDate;

public class Paciente extends Persona {
	private boolean jubilado;
	private String seguroSocial;
	private LocalDate fechaNacimiento;
	private int telefono;
	private HistoriaClinica historiaClinica;
	public Paciente(String nombre, String apellido, int dni, boolean jubilado, String seguroSocial,
			LocalDate fechaNacimiento, int telefono, HistoriaClinica historiaClinica) {
		super(nombre, apellido, dni);
		this.jubilado = jubilado;
		this.seguroSocial = seguroSocial;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.historiaClinica = historiaClinica;
	}
	
	public void getHistoriaClinica() {}

	public boolean isJubilado() {
		return jubilado;
	}

	public void setJubilado(boolean jubilado) {
		this.jubilado = jubilado;
	}

	public String getSeguroSocial() {
		return seguroSocial;
	}

	public void setSeguroSocial(String seguroSocial) {
		this.seguroSocial = seguroSocial;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}
	
	
	
}
