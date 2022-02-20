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
		
		if((laColumna < 1 || laColumna > 8) || (laFila < 1 || laFila > 8)) {
			throw new IllegalArgumentException("La fila y la columna deben estar entre 1 y 8");
 		}else {
	 		this.laFila = laFila;
	 		this.laColumna= laColumna;
 		}
		
	}
	
	public Posicion(char fila, char columna) throws JuegoException {
        if ('A' <= columna && columna <= 'H') {
            this.laColumna = columna - 'A' + 1;
        } else {
            throw new JuegoException("La columna debe estar entra la A y la H");
        }
        if ('1' <= fila && fila <= '8') {
            this.laFila = fila - '0' + 1;
        } else {
            throw new JuegoException("La fila debe estar entra el 1 y el 8");
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
