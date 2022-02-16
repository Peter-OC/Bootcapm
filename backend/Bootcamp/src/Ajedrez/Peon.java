package Ajedrez;

public class Peon extends Pieza{
	
	public Peon(Color color) {
		super(color);
	}
	
	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (movimiento.esVertical() || movimiento.deltaColumna()== 1 && !tablero.hayPiezasEntre(movimiento)) {
			return true;
		} else {
			return false;
		}
	}

}
