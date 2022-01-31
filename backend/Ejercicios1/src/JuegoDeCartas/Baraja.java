package JuegoDeCartas;

public class Baraja {

	private Naipe naipes[];
	private int posNuevoNaipe;

	public static final int NUM_NAIPES = 56;

	public Baraja() {

		this.naipes = new Naipe[NUM_NAIPES];
		this.posNuevoNaipe = 0;

		nuevaBaraja();
		barajar();

	}

	private void nuevaBaraja() {

		String[] palos = Naipe.PALOS;

		for (int i = 0; i < palos.length; i++) {

			for (int j = 0; j < Naipe.MAX_NAIPES_PALO; j++) {

				if (j >= 14) {
					naipes[((i * (Naipe.MAX_NAIPES_PALO )) + j)] = new Naipe(j + 1, palos[i]);
				} else {
					naipes[((i * (Naipe.MAX_NAIPES_PALO)) + j)] = new Naipe(j + 2, palos[i]);
				}

			}

		}

	}

	public static int generaNumeroAleatorio(int minimo, int maximo) {
		int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
		return num;
	}

	public void barajar() {

		int posRandom = 0;
		Naipe n;

		for (int i = 0; i < naipes.length; i++) {

			posRandom = generaNumeroAleatorio(0, NUM_NAIPES - 1);

			n = naipes[i];
			naipes[i] = naipes[posRandom];
			naipes[posRandom] = n;
		}

		this.posNuevoNaipe = 0;

	}

	public Naipe nuevoNaipe() {

		Naipe n = null;

		if (posNuevoNaipe == NUM_NAIPES) {
			System.out.println("No quedan más cartas");
		} else {
			n = naipes[posNuevoNaipe++];
//			posNuevoNaipe++;
		}
		return n;

	}

	public Naipe[] repartirNaipes(int numNaipes) {

		if (numNaipes > NUM_NAIPES) {
			System.out.println("Lo siento, el máximo de cartas de la baraja es 52");
		} else {

			if (naipesRestantes() < numNaipes) {
				System.out.println("No quedan tantas cartas en la baraja");
			} else {
				Naipe[] darNaipes = new Naipe[numNaipes];

				for (int i = 0; i < darNaipes.length; i++) {
					darNaipes[i] = nuevoNaipe();
				}

				return darNaipes;
			}
		}

		return null;

	}

	public int naipesRestantes() {
		return NUM_NAIPES - posNuevoNaipe;
	}

	public void naipesEnMano() {

		if (naipesRestantes() == NUM_NAIPES) {
			System.out.println("No se han repartido cartas");
		} else {
			for (int i = 0; i < posNuevoNaipe; i++) {
				System.out.println(naipes[i]);

			}
		}
	}

	public void naipesEnMazo() {

		if (naipesRestantes() == 0) {
			System.out.println("No quedan cartas en el mazo");
		} else {
			for (int i = posNuevoNaipe; i < naipes.length; i++) {
				System.out.println(naipes[i]);

			}
		}
	}

}
