package Ajedrez;

import java.util.Objects;



/**
 * @author: Pedro Olmos
 * @see <a href = "https://github.com/Peter-OC/Bootcapm/tree/main/backend/Bootcamp/src/Ajedrez" /> Repositorio con todos los archivos </a>
 */

public class Posicion {
	
	private int laFila;
	private int laColumna;
	
	
	/**
	 * @param: Métodos que validan si un movimiento es valido en la fila y en la columna
	 * @throws: Devuelve una excepción de la clase JuegoException
	 */
	
	public Posicion(int laFila, int laColumna) throws JuegoException {
		
		if(laFila <= 0 && laFila >= 9) {
			throw new JuegoException("No es un movimiento valido");		
			} else {
				throw new JuegoException("No es un movimiento valido");
			}
		
	}
	
	public Posicion(char laFila, char laColumna) throws JuegoException {
		
		if(laFila <= 'A' && laFila >= 'H') {
			throw new JuegoException("No es un movimiento valido");		
			} else {
				throw new JuegoException("No es un movimiento valido");	
			}
		
	}
	
	/**
	 * 
	 * @return: getLaFila y getLaColumna devuelven la fila y la columna, indispensable para las clases de movimiento y de pieza
	 */

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
