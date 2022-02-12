package Ajedrez;

public class Rey extends Pieza{
	
	public Rey(Color color) {
		super(color);
	}
	
	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.esDiagonal() || movimiento.esVertical() || movimiento.deltaColumna()== 1) {
			return true;
		} else {
			return false;
		}
	}

}
