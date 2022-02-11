package Ajedrez;

public class Movimiento {

	private Posicion posInicial;
	private Posicion posFinal;

	public Movimiento(Posicion posInicial, Posicion posFinal) throws JuegoException {

		if (posInicial == null) {
			throw new JuegoException("La pieza no se ha encontrado");
		}
		if (posInicial.equals(posFinal)) {
			throw new JuegoException("La pieza no se ha movido");
		}

		this.posInicial = posInicial;
		this.posFinal = posFinal;
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
	public boolean EsVertical() {

		return posInicial.getLaColumna() == posFinal.getLaColumna();
	}

	public boolean EsHorizontal() {

		return posInicial.getLaFila() == posFinal.getLaFila();
	}

	public boolean EsDiagonal() {

		return SaltoVertical(0) == SaltoHorizontal(0);

//		return posInicial.getLaColumna() != posFinal.getLaColumna() && posInicial.getLaFila() != posFinal.getLaFila();			
	}

	public int SaltoVertical(int salto) {

		return (salto < posInicial.getLaFila()) ? -salto : salto;
	}

	public int SaltoHorizontal(int salto) {

		return (salto < posInicial.getLaColumna()) ? -salto : salto;
	}

	public int deltaFila() {
		if (posFinal.getLaColumna() > posInicial.getLaColumna()) { 
			return 1;
		} else if (posFinal.getLaColumna() == posInicial.getLaColumna()) { 
			return 0;
		} else if (posFinal.getLaColumna() < posInicial.getLaColumna()) { 
			return -1;
		}
		return 0;	 	
		
	}

	public int deltaColumna() {
		if (posFinal.getLaFila() > posInicial.getLaFila()) {
			return 1;
		} else if (posFinal.getLaFila() == posInicial.getLaFila()) {
			return 0;
		} else if (posFinal.getLaFila() < posInicial.getLaFila()) {
			return -1;
		}
		return 0;
		
	}

}
