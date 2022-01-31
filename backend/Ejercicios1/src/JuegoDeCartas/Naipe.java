package JuegoDeCartas;

public class Naipe {
	
	private int valor;
	private String palo;
	
	public static final String[] PALOS = {"CORAZONES", "DIAMANTES", "PICAS", "TREBOLES"};
	public static final int MAX_NAIPES_PALO=12;

	public Naipe(int valor, String palo) {
		super();
		this.valor = valor;
		this.palo = palo;
	}

	public int getNum() {
		return valor;
	}

	public void setNum(int valor) {
		this.valor = valor;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public static String[] getPalos() {
		return PALOS;
	}

	@Override
	public String toString() {
		return "El " + valor + " de " + palo;
	}
	
	

}
