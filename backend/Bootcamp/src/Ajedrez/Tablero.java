package Ajedrez;

public class Tablero implements Cloneable {

	Pieza[][] piezas = new Pieza[8][8]; // casillas del tablero


	public Pieza[][] getPieza(Posicion posicion, Pieza pieza) {
		return piezas;
	}

	public void setPieza(Posicion posicion, Pieza pieza) {
		this.piezas = piezas;
	}
	
	public Pieza getPieza(int fila, int columna) {
		return piezas[fila][columna];
	}

	public void setPiezas(int fila, int columna) {
		this.piezas = piezas;
	}

	private boolean esValido(int i) { // comprobar si la i est� entre el 1 y el 8
		return (i >= 1 && i <= 8);
	}

	public boolean hayPieza(Posicion posicion) {
		if (piezas[posicion.getLaColumna()][posicion.getLaFila()] != null) {
			return true;
		} else {
			return false;
		}
	}

	public void QuitaPieza(int columna, int fila) {
		piezas[columna][fila] = null;
	}

	public void QuitaPieza(Posicion posicion) {
		piezas[posicion.getLaColumna()][posicion.getLaFila()] = null;
	}

	public void mover(Movimiento movimiento) throws JuegoException {

		Color colorPiezaInicio = piezas[movimiento.getPosInicial().getLaColumna()][movimiento.getPosInicial()
				.getLaFila()].getColor();
		Color colorPiezaDestino = piezas[movimiento.getPosFinal().getLaColumna()][movimiento.getPosFinal().getLaFila()]
				.getColor();
		Posicion posicionInicio = movimiento.getPosInicial();
		Posicion posicionFinal = movimiento.getPosFinal();

		if (hayPieza(posicionInicio)) {
			if (hayPieza(posicionFinal) && colorPiezaInicio != colorPiezaDestino) {
				QuitaPieza(posicionFinal); // Quitamos la pieza que hemos comido
			} else {
				throw new JuegoException("No puedes comer una pieza del mismo color");
			}
			piezas[posicionFinal.getLaColumna()][posicionFinal
					.getLaFila()] = piezas[posicionInicio.getLaColumna()][posicionInicio.getLaFila()];
			QuitaPieza(posicionInicio); // Quitamos la pieza del color que mueve de la posici�n inicial
		} else {
			throw new JuegoException("No hay en la posici�n inicial");
		}

	}

	public Object clone(Tablero tablero) throws CloneNotSupportedException {
		return tablero.clone();
	}

	public Color colorEscaque(int fila, int columna) {
		return null;
	}

	public boolean hayPiezasEntre(Movimiento movimiento) {
		return true;
	}

}
