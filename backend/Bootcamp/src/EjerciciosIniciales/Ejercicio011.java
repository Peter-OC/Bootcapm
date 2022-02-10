//Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit.
//La fórmula correspondiente para pasar de grados centígrados a fahrenheit es:
//F = 32 + ( 9 * C / 5)

package EjerciciosIniciales;

import java.util.Scanner;

public class Ejercicio011 {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		double centigrados, fahrenheit;
		
		System.out.println("Introduce los grados ºC: ");
		
		centigrados = teclado.nextDouble();
		
		fahrenheit = 32 + (9 * centigrados / 5);
		
		System.out.println(centigrados + " grados ºC es igual a " + fahrenheit + " grados ºF");
		
		teclado.close();
		
	}

}
