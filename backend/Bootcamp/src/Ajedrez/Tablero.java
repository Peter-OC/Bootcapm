package Ajedrez;

public class Tablero implements Cloneable {

	Pieza[][] piezas = new Pieza[8][8];
	
	public Tablero() {
		
		piezas[0][0] = new Torre(Color.BLANCAS);
		piezas[2][0] = new Alfil(Color.BLANCAS);
		piezas[3][0] = new Reina(Color.BLANCAS);
		piezas[4][0] = new Rey(Color.BLANCAS);
		piezas[5][0] = new Alfil(Color.BLANCAS);
		piezas[6][0] = new Caballo(Color.BLANCAS);
		piezas[7][0] = new Torre(Color.BLANCAS);
		
		piezas[0][7] = new Torre(Color.NEGRAS);
		piezas[1][7] = new Caballo(Color.NEGRAS);
		piezas[2][7] = new Alfil(Color.NEGRAS);
		piezas[3][7] = new Reina(Color.NEGRAS);
		piezas[4][7] = new Rey(Color.NEGRAS);
		piezas[5][7] = new Alfil(Color.NEGRAS);
		piezas[6][7] = new Caballo(Color.NEGRAS);
		piezas[7][7] = new Torre(Color.NEGRAS);
		
		for(int i = 0; i < 8 ; i++) {
			piezas[i][1] = new Peon(Color.BLANCAS);
			piezas[i][6] = new Peon(Color.NEGRAS);
		}	
	}


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

	private boolean esValido(int i) {
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
