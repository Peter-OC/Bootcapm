package Ajedrez;


public class Tablero implements Cloneable {

	Pieza[][] piezas = new Pieza[8][8];
	
	public Tablero() {
		
		
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
		return this.clone();
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
