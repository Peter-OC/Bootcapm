package Ajedrez;

public abstract class Pieza { 
	
	private Color color;

	public Pieza(Color color) {
		super();
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected abstract boolean esValido(Movimiento movimiento, Tablero tablero) throws JuegoException;
	
	public void Mover(Movimiento movimiento, Tablero tablero) throws JuegoException {
		if (esValido(movimiento, tablero)) {
			tablero.mover(movimiento);
		}
		
	}

}
