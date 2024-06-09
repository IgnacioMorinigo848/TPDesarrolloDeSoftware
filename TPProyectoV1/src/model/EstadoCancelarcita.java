package model;

public class EstadoCancelarcita implements EstadoCita {
	private CitaMedica cita;

	public EstadoCancelarcita(CitaMedica citaMedica) {
		// TODO Auto-generated constructor stub
		cita = citaMedica;
	}

	@Override
	public void programada() {
		// TODO Auto-generated method stub
		System.out.println("La cita medica ya esta cancelada");

	}

	@Override
	public void finalizada() {
		// TODO Auto-generated method stub
		System.out.println("La cita medica ya esta cancelada.");

	}

	@Override
	public void cancelada() {
		// TODO Auto-generated method stub
		cita.setEstadoCita(cita.getCancelada());
		System.out.println("Se ha cancelado la cita.");

	}

}
