//Programa lea la longitud de los catetos de un triángulo rectángulo y calcule 
//la longitud de la hipotenusa según el teorema de Pitágoras.

package EjerciciosIniciales;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		double cateto1, cateto2, hipotenusa;
		
		System.out.println("Introduce primer cateto: ");		
		cateto1 = teclado.nextDouble();
		
		System.out.println("Introduce segundo cateto: ");		
		cateto2 = teclado.nextDouble();
		
		hipotenusa = Math.hypot(cateto1, cateto2);
		
		System.out.println("La longitud de la hipotenusa es " + hipotenusa);
		
		
		teclado.close();
	}

}
