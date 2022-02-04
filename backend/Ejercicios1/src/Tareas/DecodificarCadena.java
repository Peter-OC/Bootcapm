package Tareas;

public class DecodificarCadena {
	
	public static void main(String[] args) {

		String cadena = "3 +4 +3,4 -7 *1 =";
		String componentes[] = cadena.split("(?<=[-+*=])");

		for (int i = 0; i < componentes.length; i++) {
			System.out.println(componentes[i]);		
		}
	}
}
