package Ajedrez;


public class Movimiento {

	private Posicion posInicial;
	private Posicion posFinal;

	public Movimiento(Posicion posInicial, Posicion posFinal) throws JuegoException {

		if (posInicial == null) {
			throw new JuegoException("Movimiento no permitido");
		}
		if (posInicial.equals(posFinal)) {
			throw new JuegoException("La pieza no se ha movido");
		}

		this.posInicial = posInicial;
		this.posFinal = posFinal;
	}
	
	public Movimiento(String jugada) throws JuegoException {

		if (jugada == null || jugada.length()!= 4) {
			throw new JuegoException("Movimiento no permitido");
		}
		//Introducir jugada b1c4
		this.posInicial = new Posicion(jugada.charAt(1), jugada.charAt(0));
		this.posFinal = new Posicion(jugada.charAt(3), jugada.charAt(2));;
		
		if (posInicial.equals(posFinal)) {
			throw new JuegoException("La pieza no se ha movido");
		}

	}

	public Posicion getPosInicial() {
		return posInicial;
	}

//	public void setPosInicial(Posicion posInicial) {
//		this.posInicial = posInicial;
//	}

	public Posicion getPosFinal() {
		return posFinal;
	}

//	public void setPosFinal(Posicion posFinal) {
//		this.posFinal = posFinal;
//	}
//	
	public boolean esVertical() {

		return posInicial.getLaColumna() == posFinal.getLaColumna();
	}

	public boolean esHorizontal() {

		return posInicial.getLaFila() == posFinal.getLaFila();
	}

	public boolean esDiagonal() {

		return saltoVertical() == saltoHorizontal();
//		return posInicial.getLaColumna() != posFinal.getLaColumna() && posInicial.getLaFila() != posFinal.getLaFila();			
	}
/* ESTE CODIGO FUNCIONA, PERO JAVIER DICE QUE COMPLICA EL RESTO DE CLASES Y DE METODOS 
 * ASÍ QUE USARE EL METODO PARA EL NUMERO ABSOLUTO Math.abs*/
//	public int saltoVertical(int salto) {
//
//		return (salto < posInicial.getLaFila()) ? -salto : salto;
//	}
//
//	public int saltoHorizontal(int salto) {
//
//		return (salto < posInicial.getLaColumna()) ? -salto : salto;
//	}  
	
	public int saltoVertical() {

		return Math.abs(posFinal.getLaFila() - posInicial.getLaFila());
	}

	public int saltoHorizontal() {

		return Math.abs(posFinal.getLaColumna() - posInicial.getLaColumna());
	}  

	public int deltaFila() {
		int mover = 0;
		if (posFinal.getLaColumna() > posInicial.getLaColumna()) { 
			mover = 1;
		} else if (posFinal.getLaColumna() == posInicial.getLaColumna()) { 
			mover = 0;
		} else if (posFinal.getLaColumna() < posInicial.getLaColumna()) { 
			mover = -1;
		}
		return mover;	 	
		
	}

	public int deltaColumna() {
		int mover = 0;
		if (posFinal.getLaFila() > posInicial.getLaFila()) {
			mover = 1;
		} else if (posFinal.getLaFila() == posInicial.getLaFila()) {
			mover = 0;
		} else if (posFinal.getLaFila() < posInicial.getLaFila()) {
			mover = -1;
		}
		return mover;
		
	}

}
