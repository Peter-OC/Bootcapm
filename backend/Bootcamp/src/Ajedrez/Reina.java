package Ajedrez;

public class Reina extends Pieza{
	
	public Reina(Color color) {
		super(color);
	}
	
	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.esDiagonal() || movimiento.esVertical() || movimiento.esHorizontal()) {
			return true;
		} else {
			return false;
		}
	}

}
