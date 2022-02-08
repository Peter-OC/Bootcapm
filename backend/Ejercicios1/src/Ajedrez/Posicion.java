package Ajedrez;

public class Posicion {
	
	private int laFila;
	private int laColumna;
	
	public Posicion(int laFila, int laColumna) {
		this.laFila = laFila;
		this.laColumna = laColumna;
	}
	
	public Posicion(char laFila, char laColumna) {
		this.laFila = laFila;
		this.laColumna = laColumna;
	}

	public int getLaFila() {
		return laFila;
	}

//	public void setLaFila(int laFila) {
//		this.laFila = laFila;
//	}

	public int getLaColumna() {
		return laColumna;
	}

//	public void setLaColumna(int laColumna) {
//		this.laColumna = laColumna;
//	}
	
	@Override
	public boolean equals(Object posicion) {
		return super.equals(posicion);
	}
	
	

}
