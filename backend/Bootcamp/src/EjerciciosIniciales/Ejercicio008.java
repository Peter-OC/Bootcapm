package EjerciciosIniciales;

import java.util.Scanner;

public class Ejercicio008 {

	public static void main(String[] args) {
	
	//Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
		
		int num1, num2;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Escribe un numero");
		num1 = teclado.nextInt();
		
		System.out.println("Escribe otro numero");
		num2 = teclado.nextInt();
		
		System.out.println("Los números son: " + num1 + " y " + num2);
		
		teclado.close();
	}

}
