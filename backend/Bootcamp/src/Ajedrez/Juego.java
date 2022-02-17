package Ajedrez;

public class Juego {

	public static void main(String[] args) {
		
		var juego = new Juego();

		try {
			juego.Inicializar();
			juego.Juagada("A2A4");
			juego.Juagada("A7A5");
		} catch (JuegoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Tablero elTablero;
	private Color elTurno;
	private boolean partidaActiva = false;
	
	public void Inicializar() throws JuegoException {
		
		elTablero = new Tablero();
		
		elTablero.setEscaque(1, 1, new Torre(Color.BLANCAS));
		elTablero.setEscaque(2, 1, new Caballo(Color.BLANCAS));
		elTablero.setEscaque(3, 1, new Alfil(Color.BLANCAS));
		elTablero.setEscaque(4, 1, new Reina(Color.BLANCAS));
		elTablero.setEscaque(5, 1, new Rey(Color.BLANCAS));
		elTablero.setEscaque(6, 1, new Alfil(Color.BLANCAS));
		elTablero.setEscaque(7, 1, new Caballo(Color.BLANCAS));
		elTablero.setEscaque(8, 1, new Torre(Color.BLANCAS));
		
		elTablero.setEscaque(1, 8, new Torre(Color.NEGRAS));
		elTablero.setEscaque(2, 8, new Caballo(Color.NEGRAS));
		elTablero.setEscaque(3, 8, new Alfil(Color.NEGRAS));
		elTablero.setEscaque(4, 8, new Reina(Color.NEGRAS));
		elTablero.setEscaque(5, 8, new Rey(Color.NEGRAS));
		elTablero.setEscaque(6, 8, new Alfil(Color.NEGRAS));
		elTablero.setEscaque(7, 8, new Caballo(Color.NEGRAS));
		elTablero.setEscaque(8, 8, new Torre(Color.NEGRAS));
		
		for(int i = 0; i < 8 ; i++) {
			elTablero.setEscaque(i, 2, new Peon(Color.BLANCAS));
			elTablero.setEscaque(i, 7, new Peon(Color.NEGRAS));
		}	

		partidaActiva = true;
		elTurno = Color.BLANCAS;

	}

	public Tablero getElTablero() throws JuegoException, CloneNotSupportedException {
		if (!partidaActiva)
			throw new JuegoException("No hay partida");
		return (Tablero) elTablero.clone();
	}

	public Color getElTurno() throws JuegoException {
		if (!partidaActiva)
			throw new JuegoException("No hay partida");
		return elTurno;
	}

	public void Juagada(String jugada) throws JuegoException {
		
		if (!partidaActiva)
			throw new JuegoException("No hay partida");

		Movimiento movimiento = new Movimiento(jugada);
		if (!elTablero.hayPieza(movimiento.getPosInicial())) {
			throw new JuegoException("No hay pieza que mover");
		}
		
		if (elTablero.getEscaque(movimiento.getPosInicial()).getColor() != elTurno) {// no mover piezas del otro
			throw new JuegoException("La pieza no es tuya");
		}

		if (elTablero.hayPieza(movimiento.getPosFinal())
				&& elTablero.getEscaque(movimiento.getPosFinal()).getColor() == elTurno) {// No te puedes comer las tuya
			throw new JuegoException("No te puedes comer a ti mismo");
		}
		
		var piezaAMover = elTablero.getEscaque(movimiento.getPosInicial());//saco la pieza
		piezaAMover.Mover(movimiento, elTablero);//y la muevo

		CambiarTurno();
	}

	private void CambiarTurno() {
		if (elTurno == Color.BLANCAS) {
			elTurno = Color.NEGRAS;
		} else {
			elTurno = Color.BLANCAS;
		}

	}

}
