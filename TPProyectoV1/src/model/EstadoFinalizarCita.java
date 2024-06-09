package model;

public class EstadoFinalizarCita implements EstadoCita {
	private CitaMedica cita;

	public EstadoFinalizarCita(CitaMedica citaMedica) {
		// TODO Auto-generated constructor stub
		this.cita = citaMedica;
	}

	@Override
	public void programada() {
		// TODO Auto-generated method stub
		cita.setEstadoCita(cita.getFinalizada());
		System.out.println("Se a finalizado la cita medica.");

	}

	@Override
	public void finalizada() {
		// TODO Auto-generated method stub
		System.out.println("La cita medica ya ha sido finalizada.");

	}

	@Override
	public void cancelada() {
		// TODO Auto-generated method stub
		System.out.println("La cita medica ya ha sido finalizada.");
	}

}
