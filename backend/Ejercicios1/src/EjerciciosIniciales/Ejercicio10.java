package EjerciciosIniciales;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {

	//Escribe un programa Java que lee un número entero por teclado y obtiene y muestra por pantalla
	//el doble y el triple de ese número.
		
		int num;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Escribe un numero");
		num = teclado.nextInt();
		
		System.out.println("El numero es " + num + " el doble es " + (num*2) + " y el triple es " + (num*3));
		
		teclado.close();

	}

}
