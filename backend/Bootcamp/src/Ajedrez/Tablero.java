package Ajedrez;


public class Tablero implements Cloneable {

	Pieza[][] piezas = new Pieza[8][8];
	
	Tablero tablero = new Tablero();
	
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


	public Pieza getEscaque(Posicion posicion) {
		return piezas[posicion.getLaColumna()][posicion.getLaFila()];
	}

	public void setEscaque(Posicion posicion, Pieza pieza) {
		this.piezas = piezas;
	}
	
	public Pieza getEscaque(int fila, int columna) {
		return piezas[fila][columna];
	}

	public void setEscaque(int columna, int fila, Pieza pieza) throws JuegoException {
		//comprobar que la posicion es correcta, >- 0 && < 8
		if(!(esValido(columna) && esValido(fila)))
			throw new JuegoException("La posicion no es valida");
		
		if(hayPieza(columna, fila)) { //si la pieza es del otro color, la elimino y pongo la mia.
			
			if(getEscaque(columna,fila).getColor()!= pieza.getColor()) { // significa que la pieza no es mia
				quitarPieza(columna, fila);
				piezas[columna - 1][fila - 1] = pieza;
			}
			else { // //si la pieza que hay es de mi color --> no puedo hacer nada --> lanzo excepcion
				throw new JuegoException("Ya tienes una pieza en esa posicion");
				
			}
		} else {
			piezas[columna][fila] = pieza;
		}
		
	}

	public boolean hayPieza(int columna, int fila) {
		//return piezas.get(columna).get(fila) != null;
		if (piezas[columna][fila] != null) {
			return true;
		} else {
			return false;
		}
		
	}


	private boolean esValido(int valido) {
		if (valido > 0 && valido < 8)
			return true;
		else
			return false;
	}

	public boolean hayPieza(Posicion posicion) throws JuegoException {
		if (posicion == null)
			throw new NullPointerException("Posicion null");
		if (piezas[posicion.getLaColumna()][posicion.getLaFila()] != null) {
			return true;
		} else {
			return false;
		}

	}

	public void quitarPieza(int columna, int fila) {
		if (!hayPieza(columna, fila))
			throw new NullPointerException("El escaque ya estaba vacío.");
		else
			piezas[columna - 1][fila - 1] = null;
	}

	public void quitarPieza(Posicion posicion) {
		if (posicion == null)
			throw new NullPointerException("Posicion null");

			quitarPieza(posicion.getLaColumna(), posicion.getLaFila());
		
	}

	public void mover(Movimiento mover) throws JuegoException {
		if (mover == null)
			throw new NullPointerException("Movimiento null");

		if (piezas[mover.getPosFinal().getLaColumna()][mover.getPosFinal().getLaFila()] == null)
			throw new JuegoException("No hay pieza para mover");

//						posicion								pieza
		setEscaque(mover.getPosFinal(), getEscaque(mover.getPosFinal()));
		quitarPieza(mover.getPosFinal());

	}

	public Tablero clone() throws CloneNotSupportedException {
		return tablero.clone();
	}

	public Color colorEscaque(int fila, int columna) {
		if ((columna % 2) == (fila % 2)) {
			return Color.BLANCAS;
		} else {
			return Color.NEGRAS;
		}
	}

	public boolean hayPiezasEntre(Movimiento movimiento) throws JuegoException {
		if(!movimiento.esVertical() && !movimiento.esHorizontal() && !movimiento.esDiagonal())
			throw new IllegalArgumentException("Movimiento no valido");
		Posicion siguientePosicion = new Posicion(movimiento.getPosInicial().getLaFila()+movimiento.deltaFila(),
				movimiento.getPosInicial().getLaColumna()+movimiento.deltaColumna());
		while (!siguientePosicion.equals(movimiento.getPosFinal())) {
			if(hayPieza(siguientePosicion))
				return true;
			new Posicion(siguientePosicion.getLaFila()+movimiento.deltaFila(),
					siguientePosicion.getLaColumna()+movimiento.deltaColumna());
		}
		return false;
	}

}
