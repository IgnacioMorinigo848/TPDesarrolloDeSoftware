package model;

public class EstadoProgramarCita implements EstadoCita {
	CitaMedica cita;
	public EstadoProgramarCita(CitaMedica cita ) {
		this.cita = cita;
	}
	@Override
	public void programada() {
		// TODO Auto-generated method stub
		System.out.println("La cita medica ya fue programada.");

	}

	@Override
	public void finalizada() {
		// TODO Auto-generated method stub
		cita.setEstadoCita(cita.getFinalizada());;
		System.out.println("Se ha finalizado la cita medica.");
		
	}

	@Override
	public void cancelada() {
		// TODO Auto-generated method stub
		cita.setEstadoCita(cita.getCancelada());;
		System.out.println("Se ha cancelado la cita medica.");

	}

}
