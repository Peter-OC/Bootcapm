/**
 * 
 */
package com.example;

/**
 * @author polmosca
 *
 */
public class Principal {
	/**
	 * METODO PRINCIPAL
	 * 
	 *@param args Lista de argumentos
	 *@return 0 si termina bien
	 */

	public static void main(String[] args) {
		
		Dias dia = Dias.DOMINGO;

		String s = "Hola";
		s += " mundo";
		System.out.println(dia);
		
		Calculadora c = Calculadora.getCurrent();//new Calculadora();
		//System.out.println(c.avg());
		System.out.println(c.avg(5));
		System.out.println(c.avg(1,2,3,4,5));
		double i = c.suma(0,  0.0);
		CalculadoraCientifica cc = new CalculadoraCientifica();
		System.out.println(cc.suma(2,2));
		System.out.println("Elimino");
		cc = null;
		System.runFinalization();
		cc = new CalculadoraCientifica();
		System.out.println(cc.suma(1, 1));
		
	}

//	public static void main(String[] args) {
//		
//		int i = 0, b;
//		b = i;
//		
//		var x = 'a'; //variable de tipo char
//		var s = "a"; //variable de tipo String
//		
//		if(i== b) {
//			
//		}
//
//	}

}
