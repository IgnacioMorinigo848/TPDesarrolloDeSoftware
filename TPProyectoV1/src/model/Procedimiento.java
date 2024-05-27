package model;

public class Procedimiento {
	private String nombre;
	private Double costo;
	public Procedimiento(String nombre, Double costo) {
		this.nombre = nombre;
		this.costo = costo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	@Override
	public String toString() {
		return "Procedimiento [nombre=" + nombre + ", costo=" + costo + "]";
	}
	
	
}
