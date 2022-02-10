package Capgemini.PersonaAlumno;

public class AlumnoServiceImpl {
	AlumnoRepository dao;
	
	public AlumnoServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void ponNota(int id, double nota) {
		var a = dao.getOne(id);
		a.ponNotas(nota);
		dao.modify(a);
	}

}