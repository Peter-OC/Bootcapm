//	Programa java que declare cuatro variables enteras A, B, C y D y asígnale un valor a cada una. 
//	A continuación realiza las instrucciones necesarias para que:
//	B tome el valor de C
//	C tome el valor de A
//	A tome el valor de D
//	D tome el valor de B
//	Si por ejemplo A = 1, B = 2, C = 3 y D = 4 el programa debe mostrar:
//	Valores iniciales
//	A = 1
//	B = 2
//	C = 3
//	D = 4
//		Valores finales
//		B toma el valor de C -> B = 3                                                                                     
//		C toma el valor de A -> C = 1
//		A toma el valor de D -> A = 4
//		D toma el valor de B -> D = 2   

package EjerciciosIniciales;

public class Ejercicio004 {

	public static void main(String[] args) {

		int A = 1, B = 2, C = 3, D = 4;
		int num = B;

		System.out.println("Valores finales");
		
		B = C;
		System.out.println("B toma el valor de C -> B = " + B);
		C = A;
		System.out.println("B toma el valor de C -> B = " + C);
		A = D;
		System.out.println("B toma el valor de C -> B = " + A);
		D = num;
		System.out.println("B toma el valor de C -> B = " + D);

	}

}
