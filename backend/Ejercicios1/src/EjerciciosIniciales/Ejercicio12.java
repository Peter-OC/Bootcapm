//Programa que lee por teclado el valor del radio de una circunferencia y calcula y 
//muestra por pantalla la longitud y el área de la circunferencia. 
//
//Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia = PI*Radio^2

package EjerciciosIniciales;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		double radio, longitud, area;
		
		System.out.println("Introduce el rádio de la circunferencia:");
		
		radio = teclado.nextDouble();
		
		longitud = 2 * Math.PI * radio;
		area = Math.PI * Math.pow(radio, 2);
		
		System.out.println("La longitud es: " + longitud);
		System.out.println("El área es: " + area);
		
		teclado.close();

	}

}
