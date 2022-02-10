package Tareas;

import java.util.Random;

public class Juego { 

	private int cont = 10;
	private Random rnd = new Random();
	private int random = rnd.nextInt(101);
	private String mensaje = "";
	private boolean terminado = false;

	public void inicializa() {
		cont = 10;
		random = rnd.nextInt(101);
		mensaje = "";
		terminado = false;
	}

	public void jugada(int num) {

		if (num > random) {
			mensaje = "El n�mero secreto es MENOR que " + num + " ,\n" + "te quedan " + (cont - 1) + " intentos.\n";
		} else if (num < random) {
			mensaje = "El n�mero secreto es MAYOR que " + num + " ,\n" + "te quedan " + (cont - 1) + " intentos.\n";
		} else {
			mensaje = "�CORRECTO!" + " Solo has necesitado " + (10 - (cont - 1)) + " intentos.";

			terminado = true;
			return;
		}
		cont--;

		if (cont == 0) {
			mensaje = "�HAS PERDIDO!," + " �ERES M�S MALO QUE LA PESTE!. El n�mero secreto era: " + num;

			terminado = true;
		}
	}

	public String getMessage() {
		return mensaje;
	}

	public boolean getTerminado() {
		return terminado;
	}
}
