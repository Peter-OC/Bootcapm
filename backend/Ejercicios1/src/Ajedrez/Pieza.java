package Ajedrez;

public class Pieza {
	
	private Color color;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	protected boolean esValido(Movimiento movimiento, Tablero tablero) {
		return false;
		
	}
	
	public void Mover(Movimiento movimiento, Tablero tablero) {
		
	}

}
