package Ajedrez;

import java.util.Objects;

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
//	this.laColumna = laColumna;
//}

	@Override
	public int hashCode() {
		return Objects.hash(laColumna, laFila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return laColumna == other.laColumna && laFila == other.laFila;
	}


	
	
	
	

}
