package Ajedrez;

public class Caballo extends Pieza {

	public Caballo(Color color) {
		super(color);

	}
	@Override
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		if ((movimiento.saltoHorizontal() == 2 * movimiento.deltaFila() && movimiento.saltoVertical() == 1 * movimiento.deltaColumna())
				|| (movimiento.saltoHorizontal() == 1 * movimiento.deltaFila() && movimiento.saltoVertical() == 2 * movimiento.deltaColumna()))
		
			if (!tablero.hayPieza(movimiento.getPosFinal())) {
				return true;
			}
		
		return false;
	}
	
}