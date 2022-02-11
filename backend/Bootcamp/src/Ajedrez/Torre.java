package Ajedrez;

public class Torre extends Pieza {

	public Torre(Color color) {
		super(color);
	}

	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.esVertical() || movimiento.esHorizontal()) {
			return true;
		} else {
			return false;
		}
	}

}
