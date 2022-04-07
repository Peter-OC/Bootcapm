package Bootcamp.Naipes;

import java.util.Random;
import java.util.Scanner;

import Ajedrez.JuegoException;
import Bootcamp.JuegoDelNumero.JuegoDelNumero;
  
public class MainJuegoNaipes {

	public static void main(String[] args) throws Bootcamp.JuegoDelNumero.JuegoException, JuegoException {
		MainJuegoNaipes app = new MainJuegoNaipes();
		app.run();

		 app.juego();
		 app.juegoConClase();
	}

	public void run() throws Bootcamp.JuegoDelNumero.JuegoException, JuegoException {
		naipes();
	}

	public void juego() {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);

		int numeroBuscado = (new Random()).nextInt(100) + 1;
		int numeroIntroducido;
		int intentos = 0;
		boolean encontrado = false;
		do {
			try {
				intentos += 1;
				System.out.print("Dame tu n�mero del 1 al 100 (" + intentos + " de 10): ");
				System.out.print("[" + numeroBuscado + "]: ");
				numeroIntroducido = Integer.parseInt(teclado.nextLine());
				if (numeroBuscado == numeroIntroducido) {
					encontrado = true;
				} else if (numeroBuscado > numeroIntroducido) {
					System.out.println("Mi n�mero es mayor.");
				} else {
					System.out.println("Mi n�mero es menor.");
				}

			} catch (NumberFormatException e) {
				System.out.println("No es un n�mero.");
			}
		} while (intentos < 10 && !encontrado);
		if (encontrado) {
			System.out.println("Bieeen!!! Acertaste.");
		} else {
			System.out.println("Upsss! Se acabaron los intentos, el n�mero era el " + numeroBuscado);
		}

		teclado.close();
	}

	public void juegoConClase() throws Bootcamp.JuegoDelNumero.JuegoException, JuegoException {
		Scanner teclado = new Scanner(System.in);

		JuegoDelNumero juego = new JuegoDelNumero();
		juego.inicializar();
		for (int intentos = 1; intentos <= 10; intentos++) {
			System.out.print("Dame tu n�mero del 1 al 100 (" + (juego.getJugada() + 1) + " de 10): ");
			juego.jugada(teclado.nextLine());
			System.out.println(juego.getResultado());
			if (juego.getFinalizado())
				break;
		}

		teclado.close();
	}


	private void naipes() throws Bootcamp.JuegoDelNumero.JuegoException, JuegoException {
		var b = new BarajaFrancesa();

		System.out.println("Baraja\n-------------------------------");
		for (var c : b.getCartas())
			System.out.println(c);
		System.out.println("\nMazo\n-------------------------------");
		b.barajar();
		b.getMazo().forEach(System.out::println);
		b.reparte(4, 5).forEach(item -> {
			System.out.println("\nJugador\n-------------------------------");
			item.forEach(System.out::println);
		});
		System.out.println("\nQuedan " + b.getMazo().size());
		var mano = b.reparte(1, 2);
		System.out.println("\nQuedan " + b.getMazo().size());
		b.reparte(4, 5).forEach(item -> {
			System.out.println("\nJugador\n-------------------------------");
			item.forEach(System.out::println);
		});
		System.out.println("\nQuedan " + b.getMazo().size());
		mano.forEach(item -> {
			System.out.println("\nJugador\n-------------------------------");
			item.forEach(System.out::println);
		});
		System.out.println("\nQuedan " + b.getMazo().size());
		b.apilar(mano.get(0));
		b.getMazo().forEach(System.out::println);
		// b.apilar(mano.get(0));
		// b.apilar(List.of(new NaipeFrances(NaipeFrances.Palos.CORAZONES, (byte)1)));
		System.out.println("\nQuedan " + b.getMazo().size());
		System.out.println(ValorNaipe.REINA.valorNumerico);
		System.out.println(ValorNaipe.toEnum(12));
	}

}