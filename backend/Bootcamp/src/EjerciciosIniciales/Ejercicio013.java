//Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por teclado.

package EjerciciosIniciales;

import java.util.Scanner;

public class Ejercicio013 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		double velocidad;
		
		System.out.println("Introduce Km/h: ");
		
		velocidad = teclado.nextDouble();
		
		System.out.println(velocidad + " Km/h es igual a " + (velocidad*1000/3600) + " m/s");
		
		teclado.close();

	}

}
