package JuegoDeCartas2;

public class Naipe {  

	public static enum Palos {
		CORAZONES, DIAMANTES, TREBOLES, PICAS
	}

	public enum Valores {
		AS(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9), DIEZ(10), JOTA(11),
		REINA(12), REY(13);
		
		// Variable que guarda el valor entero de la enumeración
		private int numericValue;
		//CONSTRUCTOR que asigna el valor entero a la cadena de la enumeración
		Valores(int value) {
			numericValue = value;
		}
		
		public int getValue() {
			return numericValue;
		}

		public static Valores getEnum(int value) {

			switch (value) {

			case 1:
				return AS;
			case 2:
				return DOS;
			case 3:
				return TRES;
			case 4:
				return CUATRO;
			case 5:
				return CINCO;
			case 6:
				return SEIS;
			case 7:
				return SIETE;
			case 8:
				return OCHO;
			case 9:
				return NUEVE;
			case 10:
				return DIEZ;
			case 11:
				return JOTA;
			case 12:
				return REINA;
			case 13:
				return REY;

			default:
				throw new IllegalArgumentException("Carta no existente");
			}
		}
	}

	private Palos palo;
	private Valores valor;

	public Naipe(Valores valor, Palos palo) {
		super();
		this.valor = valor;
		this.palo = palo;
	}
	
	@Override
	public String toString() {
		return valor + " de " + palo;
	}

}
