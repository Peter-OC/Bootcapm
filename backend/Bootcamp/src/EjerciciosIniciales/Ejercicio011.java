//Programa que lea una cantidad de grados cent�grados y la pase a grados Fahrenheit.
//La f�rmula correspondiente para pasar de grados cent�grados a fahrenheit es:
//F = 32 + ( 9 * C / 5)

package EjerciciosIniciales;

import java.util.Scanner;

public class Ejercicio011 {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		double centigrados, fahrenheit;
		
		System.out.println("Introduce los grados �C: ");
		
		centigrados = teclado.nextDouble();
		
		fahrenheit = 32 + (9 * centigrados / 5);
		
		System.out.println(centigrados + " grados �C es igual a " + fahrenheit + " grados �F");
		
		teclado.close();
		
	}

}
