//Escribe un programa java que declare una variable A de tipo entero y as�gnale un valor. 
//A continuaci�n muestra un mensaje indicando si A es par o impar. 
//Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.
//	Si por ejemplo A = 14 la salida ser�
//	14 es par
//	Si fuese por ejemplo A = 15 la salida ser�:
//	15 es impar

package EjerciciosIniciales;

public class Ejercicio005 {

	public static void main(String[] args) {

		int A = 14;
		
		System.out.println(A + (A%2==0 ? " es numero par" : " es numero impar"));

	}

}
