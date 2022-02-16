package Ajedrez;

public class Reina extends Pieza{
	
	public Reina(Color color) {
		super(color);
	}
	
	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.esDiagonal() || movimiento.esVertical() || movimiento.esHorizontal() && !tablero.hayPiezasEntre(movimiento)) {
			return true;
		} else {
			return false;
		}
	}

}
