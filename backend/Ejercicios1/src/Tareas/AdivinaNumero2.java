package Tareas;

import java.util.Random;
import javax.swing.JOptionPane;

public class AdivinaNumero2 {

	public static void main(String[] args) {

		iniciar();
		jugadaConClase();
	}

	public static void iniciar() {

		JOptionPane.showMessageDialog(null, "¡BIENVENIDO! ¡VAMOS A JUGAR A UN JUEGO!", "Adivina el numero secreto", 1);

	}

	public static void jugada() {

		int cont = 10;
		var rnd = new Random();
		int random = rnd.nextInt(101);
		int num;
		num = Integer.parseInt(JOptionPane.showInputDialog(null,
				"ADIVINA EL NÚMERO SECRETO\n" + "ENTRE 0 Y 100\n" + "Tienes 10 intentos\n", "Adivina el numero secreto",
				3));
		// System.out.println(random);
		do {

			if (num > random) {
				num = Integer.parseInt(JOptionPane.showInputDialog(null,
						"El número secreto es MENOR que " + num + " ,\n" + "te quedan " + (cont - 1) + " intentos.\n",
						"Adivina el numero secreto", 3));
			} else if (num < random) {
				num = Integer.parseInt(JOptionPane.showInputDialog(null,
						"El número secreto es MAYOR que " + num + " ,\n" + "te quedan " + (cont - 1) + " intentos.\n",
						"Adivina el numero secreto", 3));
			} else {
				JOptionPane.showMessageDialog(null,
						"¡CORRECTO!" + " Solo has necesitado " + (10 - (cont - 1)) + " intentos.",
						"Adivina el numero secreto", 2);
				break;
			}
			cont--;

		} while (cont > 0);

		if (cont == 0) {
			JOptionPane.showMessageDialog(null,
					"¡HAS PERDIDO!," + " ¡ERES MÁS MALO QUE LA PESTE!. El número secreto era: " + num + "",
					"Adivina el numero secreto", 0);
		}

	}

	public static void jugadaConClase() {

		int num;
		Juego juego = new Juego();
		juego.inicializa();

		do {

			num = Integer.parseInt(JOptionPane.showInputDialog(null,
					"ADIVINA EL NÚMERO SECRETO\n" + "ENTRE 0 Y 100\n" + "Tienes 10 intentos\n",
					"Adivina el numero secreto", 3));
			juego.jugada(num);

			JOptionPane.showMessageDialog(null, juego.getMessage());

		} while (!juego.getTerminado());// mientras no terminado

	}

}
