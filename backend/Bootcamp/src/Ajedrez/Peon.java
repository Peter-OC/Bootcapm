package Ajedrez;

public class Peon extends Pieza{
	
	public Peon(Color color) {
		super(color);
	}
	
	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if (movimiento.esVertical() || movimiento.deltaColumna()== 1) {
			return true;
		} else {
			return false;
		}
	}

}
