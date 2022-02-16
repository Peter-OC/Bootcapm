package Ajedrez;

public class Alfil extends Pieza {

	public Alfil(Color color) {
		super(color);
		
	}

	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.esDiagonal() && !tablero.hayPiezasEntre(movimiento)) {
			return true;
		} else {
			return false;
		}
	}

}
