package Tareas;

public class Calculadora {

	public static void main(String[] args) {

		String cadena = "3+4+3,4-7*1=";
		String componentes[] = cadena.split("(?<=[-+*=])");
		int num1, num2, operador;
	//	System.out.println("hola mundo");

		for (int i = 0; i < componentes.length; i++) {
			
			for(int j = 0; j>componentes[i].length(); j++) {
				
			} 
		System.out.println(componentes[i]);
		} 
	}
	
	public void calcular() {
		int i;
		String cadena = "3+4+3,4-7*1=";
		char[] subCadenas = cadena.toCharArray();
		String num = "";
		
		System.out.println("3+4+3,4-7*1=");
		
		for(i = 0; i<subCadenas.length; i++) {
			if(Character.isDigit(subCadenas[i]))
				num += subCadenas[i];
			else {
				System.out.println(num + " " + subCadenas[i]);
				num ="";
			}
		}
	}

}
