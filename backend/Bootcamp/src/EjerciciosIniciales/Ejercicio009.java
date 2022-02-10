package EjerciciosIniciales;

import java.util.Scanner;

public class Ejercicio009 {

	public static void main(String[] args) {

	//Programa Java que lea un nombre y muestre por pantalla: "Buenos dias nombre_introducido"
		
		String nombre;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce un nombre");
		nombre = teclado.nextLine();
		
		System.out.println("Buenos dias " + nombre);
		
		teclado.close();

	}

}
