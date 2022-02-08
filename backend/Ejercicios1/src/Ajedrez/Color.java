package Ajedrez;

public enum Color {
	BLANCAS(1), NEGRAS(2);
	
	int colorValue;
	void Colores(int value) {
		colorValue = value;
	}
	
	public int getValue() {
		return colorValue;
	}
	
	public static Color getEnum(int value) {
		
		switch (value) {
		case 1: return BLANCAS;
		case 2: return NEGRAS;
		default: throw new IllegalArgumentException("Ese color no esta disponible");
		}			
	}

	private int color;
	
	Color(int i) {
		this.color = i;
	}
}

