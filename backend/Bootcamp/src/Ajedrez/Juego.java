package Ajedrez;

public class Juego { 
	
	public static void main(String[] args) {
		
		Inicializar();
		
	}
	
	private Tablero elTablero;
	private static Color elTurno;
	private static boolean partidaActiva =false;
	
	public Tablero getElTablero() throws JuegoException, CloneNotSupportedException{
		if(!partidaActiva)
			throw new JuegoException("No hay partida");
		return (Tablero) elTablero.clone();
	}
	public void setElTablero(Tablero elTablero) {
		this.elTablero = elTablero;
	}
	public Color getElTurno() throws JuegoException {
		if(!partidaActiva)
			throw new JuegoException("No hay partida");
		return elTurno;
	}
	public void setElTurno(Color elTurno) {
		this.elTurno = elTurno;
	}
	
	public static void Inicializar() {
		
		partidaActiva = true;
		elTurno = Color.BLANCAS;
		
	}
	
	public void Juagada(String jugada) throws JuegoException {
		
		Movimiento movimiento = new Movimiento(jugada);
		if (!elTablero.hayPieza(movimiento.getPosInicial())) {
			throw new JuegoException("No hay pieza que mover");	
		}
		
	}
	
	public void Mover() {
		
	}
	
	public void CambiarTurno() {
		
	}
	
	

}
