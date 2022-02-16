package Ajedrez;

public class Torre extends Pieza {

	public Torre(Color color) {
		super(color);
	}

	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.esVertical() || movimiento.esHorizontal() && !tablero.hayPiezasEntre(movimiento)) {
			return true;
		} else {
			return false;
		}
	}

}
