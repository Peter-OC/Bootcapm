package Tareas;

import java.util.Scanner;

public class AdivinaNumero1 { 

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
	    int num;
	    int intento;
	    int cont = 10;
	    
	    // N�mero aleatorio
	    num = (int) (Math.random() * 100 + 1);
	    System.out.println(   "*******************************\n"
	    					+ "** ADIVINA EL N�MERO SECRETO **\n"
	    					+ "**       ENTRE 0 Y 100.      **\n"
	    					+ "*******************************\n"
	    					+ "      Tienes 10 intentos.      \n");
	    
	    // Ciclo de 10 intentos
	    do {
	      System.out.println("Introduce un n�mero: ");
	      intento = scanner.nextInt();
	      
	      if (intento > num) {
	        System.out.println("El n�mero secreto es MENOR,\n" 
	        				 + "te quedan "
	        				 + (cont-1) 
	        				 + " intentos.\n");
	      } else if (intento < num){
	        System.out.println("El n�mero secreto es MAYOR,\n" 
	        				 + "te quedan "
	        				 + (cont-1) 
	        				 + " intentos.\n");
	      } else {
	        System.out.print("�CORRECTO!" + " Solo has necesitado " + (10 - (cont-1)) + " intentos.");
	      }
	      cont--;
	      
	    } while (intento != num && cont > 0);
	    
	    if (cont == 0) {
	      System.out.println("�HAS PERDIDO!,"
	    		  		   + " �ERES M�S MALO QUE LA PESTE!. El n�mero secreto era: " + num);
	    }
	  }
	}
