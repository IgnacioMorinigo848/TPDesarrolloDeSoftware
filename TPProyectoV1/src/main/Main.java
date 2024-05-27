package main;

import java.util.ArrayList;

import model.Clinica;
import model.Especialidad;
import model.Procedimiento;

public class Main {
	
	public static void cargarEspecialidadXProcedimiento(String especialidad, String proc1, Double costoP1, String proc2, Double costoP2,
			String proc3, Double costoP3,String proc4, Double costoP4, String proc5, Double costoP5) {
		ArrayList<Procedimiento> lista = new ArrayList<Procedimiento>();
	 	Procedimiento p1 = new Procedimiento(proc1,costoP1);
        Procedimiento p2 = new Procedimiento(proc2,costoP2);
        Procedimiento p3 = new Procedimiento(proc3,costoP3);
        Procedimiento p4 = new Procedimiento(proc4,costoP4);
        Procedimiento p5 = new Procedimiento(proc5,costoP5);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        Especialidad esp = new Especialidad(especialidad,lista);
        System.out.println(esp.toString());
        esp.getProcedimientos();
		 
	}
	
	public void cargarMedicoXEspecialidad() {}
	
	public static void main(String[] args) {
		Clinica clinica = new Clinica();
		// TODO Auto-generated method stub
		cargarEspecialidadXProcedimiento("Cardiologia","Cateterismo cardíaco",2000.0,"Angioplastia coronaria"
				,3000.0,"Implante de marcapasos",60.000,"Ablación cardíaca",500.000,"Ecocardiograma",20.000);
		System.out.println();
		cargarEspecialidadXProcedimiento("Dermatología","Biopsia de piel",2000.0,"Excisiones quirúrgicas de lesiones cutáneas"
				,3000.0,"Tratamientos con láser",60.000,"Crioterapia",500.000,"Microdermoabrasión",20.000);
	}

}
